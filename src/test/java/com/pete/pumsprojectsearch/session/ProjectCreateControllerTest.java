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
public class ProjectCreateControllerTest {
    private ArrayList<PUMSUser> owners;
    private Project proj;
    public ProjectCreateControllerTest() {
        owners = new ArrayList<>();
        PUMSUser user = new PUMSUser(
                "Joe",
                "Bloggs",
                "blogs@email.com",
                "gsggr",
                "gsgrrer",
                new ArrayList<Project>()
        );
        user.setId(1L);
        owners.add(new PUMSUser());
        proj = new Project(
                "blah",
                "blah",
                owners,
                new ArrayList<ProjectAttribute>()
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
     * Test of getAttributeString method, of class ProjectCreateController.
     */
    @Test
    public void testGetAttributeString() {
        System.out.println("getAttributeString");
        ProjectCreateController instance = new ProjectCreateController();
        String expResult = "fewgee";
        instance.setAttributeString(expResult);
        String result = instance.getAttributeString();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAttributeString method, of class ProjectCreateController.
     */
    @Test
    public void testSetAttributeString() {
        System.out.println("setAttributeString");
        String attributeString = "";
        ProjectCreateController instance = new ProjectCreateController();
        instance.setAttributeString(attributeString);
        String result = instance.getAttributeString();
        assertEquals(attributeString, result);
    }

    /**
     * Test of getSelectedProject method, of class ProjectCreateController.
     */
    @Test
    public void testGetSelectedProject() {
        System.out.println("getSelectedProject");
        ProjectCreateController instance = new ProjectCreateController();
        Project expResult = new Project();
        instance.prepareProjectsHome(proj);
        Project result = instance.getSelectedProject();
        assertEquals(expResult, result);
    }

    /**
     * Test of getProjectTitle method, of class ProjectCreateController.
     */
    @Test
    public void testGetProjectTitle() {
        System.out.println("getProjectTitle");
        ProjectCreateController instance = new ProjectCreateController();
        String expResult = this.proj.getProjectName();
        String result = instance.getProjectTitle();
        assertEquals(expResult, result);
    }

    /**
     * Test of setProjectTitle method, of class ProjectCreateController.
     */
    @Test
    public void testSetProjectTitle() {
        System.out.println("setProjectTitle");
        String projectTitle = "TEST";
        ProjectCreateController instance = new ProjectCreateController();
        instance.prepareProjectsHome(proj);
        instance.setProjectTitle(projectTitle);
        assertEquals(instance.getProjectTitle(), projectTitle);
    }

    /**
     * Test of getProjectDescription method, of class ProjectCreateController.
     */
    @Test
    public void testGetProjectDescription() {
        System.out.println("getProjectDescription");
        ProjectCreateController instance = new ProjectCreateController();
        String expResult = this.proj.getProjectDescription();
        instance.prepareProjectsHome(this.proj);
        String result = instance.getProjectDescription();
        assertEquals(expResult, result);
    }






    /**
     * Test of prepareProjectsHome method, of class ProjectCreateController.
     */
    @Test
    public void testPrepareProjectsHome() {
        System.out.println("prepareProjectsHome");
        Project proj = this.proj;
        ProjectCreateController instance = new ProjectCreateController();
        String expResult = "/projects/create.xhtml";
        String result = instance.prepareProjectsHome(proj);
        assertEquals(expResult, result);
    }
    
}
