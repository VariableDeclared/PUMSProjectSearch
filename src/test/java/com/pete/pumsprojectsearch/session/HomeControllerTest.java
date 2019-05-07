/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pete.pumsprojectsearch.session;

import com.pete.pumsprojectsearch.persistence.entities.Project;
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
    
    public HomeControllerTest() {
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
        List<Project> expResult = null;
        List<Project> result = instance.getProjects();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProjects method, of class HomeController.
     */
    @Test
    public void testSetProjects() {
        System.out.println("setProjects");
        List<Project> projects = null;
        HomeController instance = new HomeController();
        instance.setProjects(projects);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLoggedInUser method, of class HomeController.
     */
    @Test
    public void testGetLoggedInUser() {
        System.out.println("getLoggedInUser");
        HomeController instance = new HomeController();
        String expResult = "";
        String result = instance.getLoggedInUser();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLoggedInUser method, of class HomeController.
     */
    @Test
    public void testSetLoggedInUser() {
        System.out.println("setLoggedInUser");
        String loggedInUser = "";
        HomeController instance = new HomeController();
        instance.setLoggedInUser(loggedInUser);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeFavourite method, of class HomeController.
     */
    @Test
    public void testRemoveFavourite() {
        System.out.println("removeFavourite");
        long projectId = 0L;
        HomeController instance = new HomeController();
        instance.removeFavourite(projectId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllProjects method, of class HomeController.
     */
    @Test
    public void testGetAllProjects() {
        System.out.println("getAllProjects");
        HomeController instance = new HomeController();
        List<Project> expResult = null;
        List<Project> result = instance.getAllProjects();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertData method, of class HomeController.
     */
    @Test
    public void testInsertData() {
        System.out.println("insertData");
        HomeController instance = new HomeController();
        String expResult = "";
        String result = instance.insertData();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of prepareCreateProject method, of class HomeController.
     */
    @Test
    public void testPrepareCreateProject() {
        System.out.println("prepareCreateProject");
        HomeController instance = new HomeController();
        String expResult = "";
        String result = instance.prepareCreateProject();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of prepareProjectDetail method, of class HomeController.
     */
    @Test
    public void testPrepareProjectDetail() {
        System.out.println("prepareProjectDetail");
        long projectId = 0L;
        HomeController instance = new HomeController();
        String expResult = "";
        String result = instance.prepareProjectDetail(projectId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserFaviourites method, of class HomeController.
     */
    @Test
    public void testGetUserFaviourites() {
        System.out.println("getUserFaviourites");
        HomeController instance = new HomeController();
        ArrayList<Project> expResult = null;
        ArrayList<Project> result = instance.getUserFaviourites();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of prepareUserLogin method, of class HomeController.
     */
    @Test
    public void testPrepareUserLogin() {
        System.out.println("prepareUserLogin");
        HomeController instance = new HomeController();
        String expResult = "";
        String result = instance.prepareUserLogin();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of prepareProjectSearch method, of class HomeController.
     */
    @Test
    public void testPrepareProjectSearch() {
        System.out.println("prepareProjectSearch");
        HomeController instance = new HomeController();
        String expResult = "";
        String result = instance.prepareProjectSearch();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
