/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pete.pumsprojectsearch.session;

import com.pete.pumsprojectsearch.persistence.entities.Project;
import com.pete.pumsprojectsearch.persistence.facades.ProjectFacade;
import java.util.List;
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

    List<Project> projects;
    ProjectFacade projectEjb;
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
