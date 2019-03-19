/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pete.pumsprojectsearch.session;

import com.pete.pumsprojectsearch.persistence.entities.Project;
import com.pete.pumsprojectsearch.persistence.facades.ProjectFacade;
import com.pete.pumsprojectsearch.persistence.facades.UserFacade;
import com.pete.pumsprojectsearch.util.DataInsert;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author UP732011 UP732011@myport.ac.uk
 */
@Named(value = "homeController")
@SessionScoped
public class HomeController implements Serializable
{

    List<Project> projects;

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    @EJB
    ProjectFacade projectEjb;
    @EJB
    UserFacade userEjb;
    /**
     * Creates a new instance of HomeController
     */
    public HomeController()
    {
     
        
    }
    public List<Project> getAllProjects() {
        return projectEjb.findAll();
    }
    public String insertData() {
        System.out.println("Insert data called");
        try {
            
            DataInsert.insertData(projectEjb, userEjb);
            System.out.println("Inserted data");
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        return "/";
    }
    public String prepareCreateProject() {

        return "projects/Create";
    }
    
    public String prepareProjectDetail(int projectId) {
        return String.format("views/projects/%s", projectId);
    }
    
    public String prepareProjectSearch() {
        /* 
         This should be handled by the page...
        */
       return "/";
    }
}
