/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pete.pumsprojectsearch.session;

import com.pete.pumsprojectsearch.persistence.entities.Project;
import com.pete.pumsprojectsearch.persistence.facades.ProjectFacade;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


/**
 *
 * @author UP732011 UP732011@myport.ac.uk
 */
@Named(value = "projectDetailController")
@RequestScoped
public class ProjectDetailController
{
    @EJB
    private ProjectFacade projectEjb;
    
    private Project selectedProject;

    public Project getSelectedProject() {
        return selectedProject;
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
    

}
