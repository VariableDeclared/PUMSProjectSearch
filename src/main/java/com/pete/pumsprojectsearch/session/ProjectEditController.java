/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pete.pumsprojectsearch.session;

import com.pete.pumsprojectsearch.persistence.entities.PUMSUser;
import com.pete.pumsprojectsearch.persistence.entities.Project;
import com.pete.pumsprojectsearch.persistence.entities.ProjectAttribute;
import com.pete.pumsprojectsearch.persistence.facades.ProjectAttributeFacade;
import com.pete.pumsprojectsearch.persistence.facades.ProjectFacade;
import com.pete.pumsprojectsearch.persistence.facades.UserFacade;
import com.pete.pumsprojectsearch.util.LoginUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author Peter J De Sousa
 * 
 * This software is released solely for the assessment of myself
 * any other unauthorized use goes beyond the intended purpose of
 * this application and it's licensed use.
*/
@Named(value = "projectEditController")
@SessionScoped
public class ProjectEditController implements Serializable
{
    private Project selectedProject;
    
    @EJB
    private transient ProjectFacade projEjb;
    
    @EJB
    private transient UserFacade userEjb;
    
    @EJB
    private transient ProjectAttributeFacade attributeEjb;
    
    private String attributeString;
    private ArrayList<ProjectAttribute> attributes;


    public ArrayList<ProjectAttribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(ArrayList<ProjectAttribute> attributes) {
        this.attributes = attributes;
    }

    public String getAttributeString() {
        return attributeString;
    }

    public void setAttributeString(String attributeString) {
        this.attributeString = attributeString;
    }
    
    

    
    public Project getSelectedProject() {
        return this.selectedProject;
    }
    /**
     * Creates a new instance of EditProjectController
     */
    public ProjectEditController()
    {
    }
    
    public String addAttribute() {
        ProjectAttribute attrib = new ProjectAttribute(
            this.attributeString
        );
        this.attributeEjb.create(attrib);
        this.attributes.add(attrib);

        
        return returnDefault();
    }
    
    /***
     * Get projects owners in a string format
     * @return The owners in string format
     */
    public String getProjectOwners() {
        
        Iterator<PUMSUser> usrIt = this.selectedProject.getProjectOwners().iterator();
        StringBuilder blr = new StringBuilder();
        while(usrIt.hasNext()) {
            PUMSUser usr = usrIt.next();
            blr.append(
                    String.format("%s %s", usr.getFirstName(), usr.getFamilyName())
            );
        }
        
        return blr.toString();
    }
    
    public String prepareEditProject(Project proj) {
        this.selectedProject = proj;
        this.attributes = (ArrayList<ProjectAttribute>) proj.getAttributes();
        return this.returnDefault();
    }
    
    private String returnDefault () {
        return "/projects/edit.xhtml";
    }
    
    /***
     * Save project edits
     * @return The path to go to after saving.
     */
    public String saveChanges() {
        if (
                this.selectedProject
                .getProjectOwners()
                .contains(
                    LoginUtils.getUser()
               )
            ) {
            this.projEjb.edit(this.selectedProject);
        }
        return "/projects/detail.xhtml";
    }
    
        
    public List<PUMSUser> getUsers() {
        return this.userEjb.findAll();
    }
    
    public String removeAttribute(long id) {
        this.attributes.remove(attributeEjb.find(id));
        return this.returnDefault();
    }
    
    /***
     * Take a list of comma separated Ids and fetch users
     * @param commaIds User ids in n1,n2,n3 format
     * @return An array list of users.
     */
    public ArrayList<PUMSUser> commaIdsToArrayList(String commaIds) {
        ArrayList<PUMSUser> users = new ArrayList<>();
        
        for (String userId : commaIds.split(",")) {
            users.add(this.userEjb.find(new Long(userId)));
        }
        return users;
    }
    
    /***
     * Set project owners by passing a list of comma separated ids.
     * @param commaSeparatedUserIds Ids in n1, n2, n3 format.
     */
    public void setProjectOwners(String commaSeparatedUserIds) {
        if (commaSeparatedUserIds.isEmpty())
            return;
   
        ArrayList<PUMSUser> users =  this.commaIdsToArrayList(
                commaSeparatedUserIds
        );
        
        this.selectedProject.setProjectOwners(users);
    } 
   
}
