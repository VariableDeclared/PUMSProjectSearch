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
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

/**
 *
 * @author UP732011 UP732011@myport.ac.uk
 */
@Named(value = "projectCreateController")
@SessionScoped
public class ProjectCreateController implements Serializable
{
    @Inject
    private transient ProjectDetailController projectDetailController;
    @EJB
    private transient ProjectFacade projEjb;
    
    @EJB
    private transient ProjectAttributeFacade attributeEjb;
    
    @Inject
    private ProjectEditController projectEditController;
    
    private Project project;
    
    private ArrayList<PUMSUser> projectOwners;

    public String getProjectOwners() {
        return this.projectEditController.getUsers().toString();
    }

    public void setProjectOwners(String commaSeparatedIds) {
        if (commaSeparatedIds.isEmpty()) 
            return;
        
        ArrayList<PUMSUser> users = 
                projectEditController.commaIdsToArrayList(commaSeparatedIds);
        System.out.println("SETTING PROJECT OWNERS: "+ users.toString());
        
        this.project.setProjectOwners(users);
    }

    public ArrayList<ProjectAttribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(ArrayList<ProjectAttribute> attributes) {
        this.attributes = attributes;
    }
    
    private String attributeString;

    public String getAttributeString() {
        return attributeString;
    }

    public void setAttributeString(String attributeString) {
        this.attributeString = attributeString;
    }
    private ArrayList<ProjectAttribute> attributes;
    
    private Project selectedProject;

    public Project getSelectedProject() {
        return selectedProject;
    }
    private String projectTitle, projectDescription;


    public String getProjectTitle() {
        return this.project.getProjectName();
    }

    public void setProjectTitle(String projectTitle) {
        this.project.setProjectName(projectTitle);
    }

    public String getProjectDescription() {
        return this.project.getProjectDescription();
    }

    public void setProjectDescription(String projectDescription) {
        this.project.setProjectDescription(projectDescription);
    }
    
    private String returnDefault() {
        return "/projects/create.xhtml";
    }
    
    public String removeAttribute(long id) {
        this.attributes.remove(attributeEjb.find(id));
        return this.returnDefault();
    }
    
    public String addAttribute() {
        ProjectAttribute attrib = new ProjectAttribute(
                this.attributeString
        );
        
        attributeEjb.create(attrib);
        this.attributes.add(attrib);
        return this.returnDefault();
    }
    public String createProject() {
        System.out.println("CREATING PROJECT: "+ this.project.getProjectName());
        projEjb.create(this.project);
        
        
        return "/projects.xhtml";
    }
    /**
     * Creates a new instance of CreateProjectController
     */
    public ProjectCreateController()
    {
        
       this.project = new Project();
    }
    
    
    
    public String prepareProjectsHome(Project proj) {
        this.selectedProject = proj;
        return "/projects/create.xhtml";
    }
    
}
