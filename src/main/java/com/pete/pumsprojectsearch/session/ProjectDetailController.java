/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pete.pumsprojectsearch.session;

import com.pete.pumsprojectsearch.persistence.entities.PUMSUser;
import com.pete.pumsprojectsearch.persistence.entities.Project;
import com.pete.pumsprojectsearch.persistence.facades.ProjectFacade;
import java.io.Serializable;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;


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
    private transient EntityManager em;
    private Project selectedProject;

    
    @Inject
    private transient ProjectEditController projectEditCtrl;
    
    public Project getSelectedProject() {
        return selectedProject;
    }
    
    public String getProjectOwnerName() {
        ArrayList<PUMSUser> usrs = this.selectedProject.getProjectOwners();
        PUMSUser usr = usrs.get(0);
        return String.format("%s %s", usr.getFamilyName(), usr.getFirstName());
        
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
