/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pete.pumsprojectsearch.session;

import com.pete.pumsprojectsearch.models.ProjectDetailModel;
import com.pete.pumsprojectsearch.persistence.entities.Project;
import com.pete.pumsprojectsearch.persistence.facades.ProjectFacade;
import javax.ejb.EJB;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.ws.rs.Path;
import javax.mvc.annotation.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;

/**
 *
 * @author UP732011 UP732011@myport.ac.uk
 */
@Dependent
@Controller
@Path("projects")
public class ProjectDetailController
{

    @EJB
    ProjectFacade projectEjb;
    
    @Inject
    ProjectDetailModel model;
    
    Project selectedProject;
    
    @GET
    @Path("/projects/{id}")
    public String getProjectDetail(@PathParam("id") int projectId) {
        this.selectedProject = projectEjb.find(projectId);
        return "projects/detail.xhtml";
    }
    
    public Project getProject() {
        return this.selectedProject;
    }
    /**
     * Creates a new instance of ProjectDetail
     */
    public ProjectDetailController()
    {
        
    }
    
    public String prepareProjectsHome() {
        return "/";
    }
    
    public String prepareEditProject() {
        return "projects/edit";
    }
    
}
