/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pete.pumsprojectsearch.session;

import com.pete.pumsprojectsearch.mvc.ProjectDetailModel;
import com.pete.pumsprojectsearch.persistence.entities.Project;
import com.pete.pumsprojectsearch.persistence.facades.ProjectFacade;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.PathParam;

/**
 *
 * @author UP732011 UP732011@myport.ac.uk
 */
@Stateless
public class ProjectDetailService
{

    @EJB
    ProjectFacade projectEjb;
    
    @Inject
    ProjectDetailModel model;
    
    Project selectedProject;

    public Project getProjectDetail(@PathParam("id") int projectId) {
        this.selectedProject = projectEjb.find(projectId);
        return model.getProject(projectId);
    }
    
    public Project getProject() {
        return this.selectedProject;
    }
    /**
     * Creates a new instance of ProjectDetail
     */
    public ProjectDetailService()
    {
        
    }
    
    public String prepareProjectsHome() {
        return "/";
    }
    
    public String prepareEditProject() {
        return "projects/edit";
    }
    
}
