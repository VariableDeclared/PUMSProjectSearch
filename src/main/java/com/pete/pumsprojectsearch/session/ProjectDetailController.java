/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pete.pumsprojectsearch.session;

import com.pete.pumsprojectsearch.persistence.entities.PUMSUser;
import com.pete.pumsprojectsearch.persistence.entities.Project;
import com.pete.pumsprojectsearch.persistence.facades.PUMSUserFacade;
import com.pete.pumsprojectsearch.persistence.facades.ProjectFacade;
import com.pete.pumsprojectsearch.util.LoginUtils;
import java.io.Serializable;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;


/**
 *
 * @author Peter J De Sousa
 * 
 * This software is released solely for the assessment of myself
 * any other unauthorized use goes beyond the intended purpose of
 * this application and it's licensed use.
*/
@Named(value = "projectDetailController")
@SessionScoped
public class ProjectDetailController implements Serializable
{
    @EJB
    private transient ProjectFacade projectEjb;
    @EJB
    private transient PUMSUserFacade userEjb;

    
    private Project selectedProject;

    
    @Inject
    private transient ProjectEditController projectEditCtrl;
    
    public Project getSelectedProject() {
        return selectedProject;
    }
    
    public boolean isOwner() {
        if(!LoginUtils.checkLogin())
            return false;
        PUMSUser user = LoginUtils.getUser();
        
        ArrayList<PUMSUser> owners =  this.selectedProject.getProjectOwners();
       
        return owners.contains(user);
    }
    
    public ArrayList<PUMSUser> getProjectOwners() {
     
        
        return this.selectedProject.getProjectOwners();
        
    }
    
    public String delete() {
        if (this.isOwner()) {
            this.projectEjb.remove(this.selectedProject);
        }
        
        return this.prepareProjectHome();
    }
    
    public String addToFavourites() {
        PUMSUser user = LoginUtils.getUser();
        
        if (user == null)
            return this.prepareProjectHome();
        
        user.addSavedProject(this.selectedProject);
        
        this.userEjb.edit(user);
        
        return this.prepareProjectHome();
    }
    
    public void setSelectedProject(Project selectedProject) {
        this.selectedProject = selectedProject;
    }
    /**
     * Creates a new instance of ProjectDetail
     */
    public ProjectDetailController()
    {
        
    }
    
    private String prepareProjectHome() {
        return "/projects.xhtml";
    }
    private String prepareProjectDetail() {
        return "/projects/detail.xhtml"; 
    }
    public String prepareProjectDetail(Project proj) {
        this.selectedProject = proj;
        return this.prepareProjectDetail();
    }
    
    public String prepareEditProject() {
        System.out.println("Preparing edit controller, in ProjectDetailController");
        System.out.println("Project:== " + this.selectedProject.toString());
        return projectEditCtrl.prepareEditProject(this.selectedProject);

    }

}
