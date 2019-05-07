/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pete.pumsprojectsearch.session;

import com.pete.pumsprojectsearch.persistence.entities.PUMSUser;
import com.pete.pumsprojectsearch.persistence.entities.Project;
import com.pete.pumsprojectsearch.persistence.entities.ProjectAttribute;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Peted
 */
public class ProjectDetailControllerTest {
    
    public ProjectDetailControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getSelectedProject method, of class ProjectDetailController.
     */
    @Test
    public void testGetSelectedProject() {
        System.out.println("getSelectedProject");
        ProjectDetailController instance = new ProjectDetailController();
        Project expResult = new Project();
        instance.prepareProjectDetail(expResult);
        Project result = instance.getSelectedProject();
        assertEquals(expResult, result);
    }


    /**
     * Test of getProjectOwners method, of class ProjectDetailController.
     */
    @Test
    public void testGetProjectOwners() {
        System.out.println("getProjectOwners");
        ProjectDetailController instance = new ProjectDetailController();
        ArrayList<PUMSUser> expResult = new ArrayList<>();
        expResult.add(new PUMSUser());
        Project proj = new Project(
                "bal",
                "blah",
                expResult,
                new ArrayList<ProjectAttribute>()
        );
        instance.prepareProjectDetail(proj);
        ArrayList<PUMSUser> result = instance.getProjectOwners();
        assertEquals(expResult, result);
    }


    /**
     * Test of setSelectedProject method, of class ProjectDetailController.
     */
    @Test
    public void testSetSelectedProject() {
        System.out.println("setSelectedProject");
        Project selectedProject = new Project();
        ProjectDetailController instance = new ProjectDetailController();
        instance.setSelectedProject(selectedProject);
        assertEquals(selectedProject, instance.getSelectedProject());
    }

    /**
     * Test of prepareProjectDetail method, of class ProjectDetailController.
     */
    @Test
    public void testPrepareProjectDetail() {
        System.out.println("prepareProjectDetail");
        Project proj = null;
        ProjectDetailController instance = new ProjectDetailController();
        String expResult = "/projects/detail.xhtml";
        String result = instance.prepareProjectDetail(proj);
        assertEquals(expResult, result);
    }

  
}
