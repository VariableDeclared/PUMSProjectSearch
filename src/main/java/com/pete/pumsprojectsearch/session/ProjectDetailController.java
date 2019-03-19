/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pete.pumsprojectsearch.session;

import com.pete.pumsprojectsearch.persistence.entities.Project;
import com.pete.pumsprojectsearch.persistence.facades.ProjectFacade;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;


/**
 *
 * @author UP732011 UP732011@myport.ac.uk
 */
@Named(value = "projectDetailController")
@Dependent
public class ProjectDetailController
{
    @EJB
    private ProjectFacade projectEjb;
    
    private Project selectedProject;
    /**
     * Creates a new instance of ProjectDetail
     */
    public ProjectDetailController()
    {

    }
    
    public String prepareProjectDetail(Project proj) {
        this.selectedProject = proj;
        return "/projects/detial.xhtml";
    }
    

}
