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
import javax.ejb.embeddable.EJBContainer;
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
public class ProjectEditControllerTest {
//    private EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
    private static String DEFAULT = "/projects/detail.xhtml";
    public ProjectEditControllerTest() {
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
    public void testGetAttributes()  throws Exception {
        System.out.println("getAttributes");
       
        ProjectEditController instance = new ProjectEditController();
        ArrayList<ProjectAttribute> expResult = null;
        ArrayList<ProjectAttribute> result = instance.getAttributes();
        assertEquals(expResult, result);

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
        assertEquals(instance.getAttributes(), attributes);

    }

    /**
     * Test of getAttributeString method, of class ProjectEditController.
     */
    @Test
    public void testGetAttributeString() {
        System.out.println("getAttributeString");
        ProjectEditController instance = new ProjectEditController();
        String expResult = "TEST";
        instance.setAttributeString(expResult);
        String result = instance.getAttributeString();
        assertEquals(expResult, result);

    }

    /**
     * Test of setAttributeString method, of class ProjectEditController.
     */
    @Test
    public void testSetAttributeString() {
        System.out.println("setAttributeString");
        String attributeString = "";
        String expResult = "";
        ProjectEditController instance = new ProjectEditController();
        instance.setAttributeString(attributeString);
        assertEquals(instance.getAttributeString(), expResult);

    }

    /**
     * Test of getSelectedProject method, of class ProjectEditController.
     */
    @Test
    public void testGetSelectedProject() {
        System.out.println("getSelectedProject");
        ProjectEditController instance = new ProjectEditController();
        Project expResult = new Project();
        instance.prepareEditProject(expResult);
        Project result = instance.getSelectedProject();
        assertEquals(expResult, result);

    }



  
}
