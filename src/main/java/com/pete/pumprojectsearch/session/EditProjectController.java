/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pete.pumprojectsearch.session;

import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author UP732011 UP732011@myport.ac.uk
 */
@Named(value = "editProjectController")
@Dependent
public class EditProjectController
{

    /**
     * Creates a new instance of EditProjectController
     */
    public EditProjectController()
    {
    }
    
    
    public String prepareProjectDetail() {
        return "/projects/detail";
    }
    
    
}