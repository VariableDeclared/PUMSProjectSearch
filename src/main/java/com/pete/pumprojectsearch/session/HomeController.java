/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pete.pumprojectsearch.session;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author UP732011 UP732011@myport.ac.uk
 */
@Named(value = "homeController")
@SessionScoped
public class HomeController implements Serializable
{

    /**
     * Creates a new instance of HomeController
     */
    public HomeController()
    {
        

    }

    public String prepareCreateProject() {

        return "projects/Create";
    }
    
    public String prepareProjectDetail() {
        return "projects/detail";
    }
    
    public String prepareProjectSearch() {
        /* 
         This should be handled by the page...
        */
        return "/";
    }
}
