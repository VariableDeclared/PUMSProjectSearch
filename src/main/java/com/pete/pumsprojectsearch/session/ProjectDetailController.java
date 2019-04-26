/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pete.pumsprojectsearch.session;

import com.pete.pumsprojectsearch.persistence.entities.PUMSUser;
import com.pete.pumsprojectsearch.persistence.entities.Project;
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
 * @author UP732011 UP732011@myport.ac.uk
 */
@Named(value = "projectDetailController")
@SessionScoped
public class ProjectDetailController implements Serializable
{
    @EJB
    private transient ProjectFacade projectEjb;

    
    private Project selectedProject;

    
    @Inject
    private transient ProjectEditController projectEditCtrl;
    
    public Project getSelectedProject() {
        return selectedProject;
    }
    
    public boolean isOwner() {
        if(!LoginUtils.checkLogin())
            return false;
        PUMSUser user = (PUMSUser) LoginUtils.getSession().getAttribute(
                "currentUser"
        );
        
        System.out.println("OWNER: " + user.getEmail());
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
        
        return "/projects.xhtml";
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
    
    public String prepareProjectDetail(Project proj) {
        this.selectedProject = proj;
        return "/projects/detail.xhtml";
    }
    
    public String prepareEditProject() {
        System.out.println("Preparing edit controller, in ProjectDetailController");
        System.out.println("Project:== " + this.selectedProject.toString());
        return projectEditCtrl.prepareEditProject(this.selectedProject);

    }

}
