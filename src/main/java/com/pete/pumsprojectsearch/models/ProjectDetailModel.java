/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pete.pumsprojectsearch.models;

import com.pete.pumsprojectsearch.persistence.entities.Project;
import javax.enterprise.inject.Model;

/**
 *
 * @author Peted
 */
@Model 
public class ProjectDetailModel {
    
    
    private Project project;

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
