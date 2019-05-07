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
public class ProjectEditControllerIT {
    
    public ProjectEditControllerIT() {
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
     * Test of getAttributes method, of class ProjectEditController.
     */
    @Test
    public void testGetAttributes() {
        System.out.println("getAttributes");
        ProjectEditController instance = new ProjectEditController();
        ArrayList<ProjectAttribute> expResult = null;
        ArrayList<ProjectAttribute> result = instance.getAttributes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAttributes method, of class ProjectEditController.
     */
    @Test
    public void testSetAttributes() {
        System.out.println("setAttributes");
        ArrayList<ProjectAttribute> attributes = null;
        ProjectEditController instance = new ProjectEditController();
        instance.setAttributes(attributes);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAttributeString method, of class ProjectEditController.
     */
    @Test
    public void testGetAttributeString() {
        System.out.println("getAttributeString");
        ProjectEditController instance = new ProjectEditController();
        String expResult = "";
        String result = instance.getAttributeString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAttributeString method, of class ProjectEditController.
     */
    @Test
    public void testSetAttributeString() {
        System.out.println("setAttributeString");
        String attributeString = "";
        ProjectEditController instance = new ProjectEditController();
        instance.setAttributeString(attributeString);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSelectedProject method, of class ProjectEditController.
     */
    @Test
    public void testGetSelectedProject() {
        System.out.println("getSelectedProject");
        ProjectEditController instance = new ProjectEditController();
        Project expResult = null;
        Project result = instance.getSelectedProject();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addAttribute method, of class ProjectEditController.
     */
    @Test
    public void testAddAttribute() {
        System.out.println("addAttribute");
        ProjectEditController instance = new ProjectEditController();
        String expResult = "";
        String result = instance.addAttribute();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProjectOwners method, of class ProjectEditController.
     */
    @Test
    public void testGetProjectOwners() {
        System.out.println("getProjectOwners");
        ProjectEditController instance = new ProjectEditController();
        String expResult = "";
        String result = instance.getProjectOwners();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of prepareEditProject method, of class ProjectEditController.
     */
    @Test
    public void testPrepareEditProject() {
        System.out.println("prepareEditProject");
        Project proj = null;
        ProjectEditController instance = new ProjectEditController();
        String expResult = "";
        String result = instance.prepareEditProject(proj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveChanges method, of class ProjectEditController.
     */
    @Test
    public void testSaveChanges() {
        System.out.println("saveChanges");
        ProjectEditController instance = new ProjectEditController();
        String expResult = "";
        String result = instance.saveChanges();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsers method, of class ProjectEditController.
     */
    @Test
    public void testGetUsers() {
        System.out.println("getUsers");
        ProjectEditController instance = new ProjectEditController();
        List<PUMSUser> expResult = null;
        List<PUMSUser> result = instance.getUsers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeAttribute method, of class ProjectEditController.
     */
    @Test
    public void testRemoveAttribute() {
        System.out.println("removeAttribute");
        long id = 0L;
        ProjectEditController instance = new ProjectEditController();
        String expResult = "";
        String result = instance.removeAttribute(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of commaIdsToArrayList method, of class ProjectEditController.
     */
    @Test
    public void testCommaIdsToArrayList() {
        System.out.println("commaIdsToArrayList");
        String commaIds = "";
        ProjectEditController instance = new ProjectEditController();
        ArrayList<PUMSUser> expResult = null;
        ArrayList<PUMSUser> result = instance.commaIdsToArrayList(commaIds);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProjectOwners method, of class ProjectEditController.
     */
    @Test
    public void testSetProjectOwners() {
        System.out.println("setProjectOwners");
        String commaSeparatedUserIds = "";
        ProjectEditController instance = new ProjectEditController();
        instance.setProjectOwners(commaSeparatedUserIds);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
