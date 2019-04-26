/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pete.pumsprojectsearch.session;

import com.pete.pumsprojectsearch.persistence.entities.PUMSUser;
import com.pete.pumsprojectsearch.persistence.entities.Project;
import com.pete.pumsprojectsearch.persistence.facades.ProjectAttributeFacade;
import com.pete.pumsprojectsearch.persistence.facades.ProjectFacade;
import com.pete.pumsprojectsearch.persistence.facades.UserFacade;
import com.pete.pumsprojectsearch.util.DataInsert;
import com.pete.pumsprojectsearch.util.LoginUtils;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Inject;

/**
 *
 * @author Peter J De Sousa
 * 
 * This software is released solely for the assessment of myself
 * any other unauthorized use goes beyond the intended purpose of
 * this application and it's licensed use.
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
    private ProjectFacade projectEjb;
    @EJB
    private UserFacade userEjb;
    @EJB
    private ProjectAttributeFacade attributeEjb;
    
    private String loggedInUser;

    public String getLoggedInUser() {
        
        Object user = LoginUtils.getSession().getAttribute("currentUser");
        if (user != null)
            loggedInUser = ((PUMSUser) user).getFirstName();
        if (loggedInUser == null || loggedInUser.isEmpty()) {
            return "Not logged in";
        }
        return loggedInUser;
    }

    public void setLoggedInUser(String loggedInUser) {
        this.loggedInUser = loggedInUser;
    }
    
    @Inject
    transient private ProjectDetailController projectDetailController;
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
            
            DataInsert.insertData(projectEjb, userEjb, attributeEjb);
            System.out.println("Inserted data");
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        return "/";
    }
    public String prepareCreateProject() {

        return "projects/create.xhtml";
    }

    public String prepareProjectDetail(long projectId) {
        return projectDetailController.prepareProjectDetail(
                projectEjb.find(projectId)
        );
    }
    public String prepareUserLogin() {
        return "/login.xhtml";
    }

    public String prepareProjectSearch() {
        /* 
         This should be handled by the page...
        */
       return "/projects.xhtml";
    }
}
