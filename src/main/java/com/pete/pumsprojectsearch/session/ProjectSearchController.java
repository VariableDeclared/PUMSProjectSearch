/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pete.pumsprojectsearch.session;

import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author Peter J De Sousa
 * 
 * This software is released solely for the assessment of myself
 * any other unauthorized use goes beyond the intended purpose of
 * this application and it's licensed use.
*/
@Named(value = "projectSearchController")
@Dependent
public class ProjectSearchController
{

    /**
     * Creates a new instance of SearchController
     */
    public ProjectSearchController()
    {
    }
    
}
