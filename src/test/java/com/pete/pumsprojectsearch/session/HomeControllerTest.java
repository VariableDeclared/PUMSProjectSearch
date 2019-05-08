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
import java.util.List;
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
public class HomeControllerTest {
    
    ArrayList<Project> projects;
    public HomeControllerTest() {
        this.projects = new ArrayList<>();
        this.projects.add(
                new Project(
                        "ProjectName",
                        "This is a project",
                        new ArrayList<PUMSUser>(),
                        new ArrayList<ProjectAttribute>()
                )
        );
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
     * Test of getProjects method, of class HomeController.
     */
    @Test
    public void testGetProjects() {
        System.out.println("getProjects");
        HomeController instance = new HomeController();
        instance.setProjects(this.projects);
        List<Project> result = instance.getProjects();
        assertEquals(this.projects, result);
    }

    /**
     * Test of setProjects method, of class HomeController.
     */
    @Test
    public void testSetProjects() {
        System.out.println("setProjects");
        HomeController instance = new HomeController();
        instance.setProjects(this.projects);
        assertEquals(this.projects, instance.getProjects());
    }

//    /**
//     * Test of getLoggedInUser method, of class HomeController.
//     */
//    @Test
//    public void testGetLoggedInUser() {
//        System.out.println("getLoggedInUser");
//        HomeController instance = new HomeController();
//        String expResult = "";
//        String result = instance.getLoggedInUser();
//        assertEquals(expResult, result);
//    }



    /**
     * Test of prepareCreateProject method, of class HomeController.
     */
    @Test
    public void testPrepareCreateProject() {
        System.out.println("prepareCreateProject");
        HomeController instance = new HomeController();
        String expResult = "projects/create.xhtml";
        String result = instance.prepareCreateProject();
        assertEquals(expResult, result);
    }

    /**
     * Test of prepareProjectSearch method, of class HomeController.
     */
    @Test
    public void testPrepareProjectSearch() {
        System.out.println("prepareProjectSearch");
        HomeController instance = new HomeController();
        String expResult = "/projects.xhtml";
        String result = instance.prepareProjectSearch();
        assertEquals(expResult, result);
    }
    
}
