/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pete.pumsprojectsearch.session;

import com.pete.pumsprojectsearch.persistence.entities.PUMSUser;
import com.pete.pumsprojectsearch.persistence.entities.Project;
import com.pete.pumsprojectsearch.persistence.entities.ProjectAttribute;
import com.pete.pumsprojectsearch.util.AppConstants;
import java.io.Serializable;
import java.util.ArrayList;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Peter J De Sousa
 * 
 * This software is released solely for the assessment of myself
 * any other unauthorized use goes beyond the intended purpose of
 * this application and it's licensed use.
*/
@Named(value = "projectSearchController")
@SessionScoped
public class ProjectSearchController implements Serializable
{

    private ArrayList<Project> projects;
    private String searchTerm;
    private String userNameTerm;
    
    
    private transient EntityManagerFactory emFactory;
    private transient EntityManager em;
    private transient TypedQuery titleSearchQuery;
    private transient Query userSearchQuery;

    public String getUserNameTerm()
    {
        return userNameTerm;
    }

    public void setUserNameTerm(String userNameTerm)
    {
        this.userNameTerm = userNameTerm;
    }

    public String getSearchTerm()
    {
        return searchTerm;
    }

    public void setSearchTerm(String searchTerm)
    {
        this.searchTerm = searchTerm;
    }

    public ArrayList<Project> getProjects()
    {
        return projects;
    }

    
    /**
     * Creates a new instance of SearchController
     */
    public ProjectSearchController()
    {
        this.projects = new ArrayList<Project>();
        this.projects.add(new Project(
                "No Results...",
                "Could not get any results for this query",
                new ArrayList<PUMSUser>(),
                new ArrayList<ProjectAttribute>()
        ));
        this.emFactory = Persistence.createEntityManagerFactory(AppConstants.PERSISTENCE_UNIT);
        this.em  = emFactory.createEntityManager();
        
        this.titleSearchQuery = this.em.createQuery(
            "SELECT proj FROM Project proj WHERE proj.projectName LIKE CONCAT('%',:queryString,'%')",
            Project.class
        );

        this.userSearchQuery = this.em.createQuery(
                "SELECT DISTINCT p FROM Project p JOIN p.projectOwner u "
                    + "WHERE u.familyName LIKE CONCAT('%', :queryName, '%')"
        );
    }
    
    
    private String returnDefault() {
        return "/search/search.xhtml";
    }
    
    private String returnResults() {
        return "/search/projects.xhtml";
    }
    
    public String prepareProjectSearch() {
        return this.returnDefault();
    }
    
    
    public String performProjectUserSearch() {
        this.projects = new ArrayList<Project>(
                this.userSearchQuery.setParameter("queryName", this.userNameTerm)
                .getResultList()
        );
        
        return this.returnResults();
    }
    public String performProjectSearch()
    {
        this.projects = new ArrayList<Project>(this.titleSearchQuery.setParameter(
                        "queryString",
                        this.searchTerm
                ).getResultList()
        );
        
        
        return this.returnResults();
        
    }
    
}
