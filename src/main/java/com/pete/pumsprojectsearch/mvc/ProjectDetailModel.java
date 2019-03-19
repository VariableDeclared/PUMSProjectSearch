/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pete.pumsprojectsearch.mvc;

import com.pete.pumsprojectsearch.persistence.entities.Project;
import com.pete.pumsprojectsearch.session.ProjectDetailService;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

/**
 *
 * @author Peted
 */
@Model
public class ProjectDetailModel {
    @Inject
    ProjectDetailService clr;
    
    public Project getProject(int id) {
        return clr.getProjectDetail(id);
    }
}
