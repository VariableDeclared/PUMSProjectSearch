/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pete.pumsprojectsearch.session.controllers;

import javax.mvc.annotation.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author Peted
 */
@Controller
@Path("projects")
public class ProjectDetailController {
    
    @GET
    @Path("projects/{id}")
    public String projectDetailView(int id) {
        return "projects/detail.xhtml";
    }
}
