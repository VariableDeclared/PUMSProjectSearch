/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pete.pumsprojectsearch.session;

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
public class CreateUserControllerTest {
    
    public CreateUserControllerTest() {
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
     * Test of getFirstName method, of class CreateUserController.
     */
    @Test
    public void testGetFirstName() throws Exception {
        System.out.println("getFirstName");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CreateUserController instance = (CreateUserController)container.getContext().lookup("java:global/classes/CreateUserController");
        String expResult = "";
        String result = instance.getFirstName();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFirstName method, of class CreateUserController.
     */
    @Test
    public void testSetFirstName() throws Exception {
        System.out.println("setFirstName");
        String firstName = "";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CreateUserController instance = (CreateUserController)container.getContext().lookup("java:global/classes/CreateUserController");
        instance.setFirstName(firstName);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFamilyName method, of class CreateUserController.
     */
    @Test
    public void testGetFamilyName() throws Exception {
        System.out.println("getFamilyName");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CreateUserController instance = (CreateUserController)container.getContext().lookup("java:global/classes/CreateUserController");
        String expResult = "";
        String result = instance.getFamilyName();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFamilyName method, of class CreateUserController.
     */
    @Test
    public void testSetFamilyName() throws Exception {
        System.out.println("setFamilyName");
        String familyName = "";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CreateUserController instance = (CreateUserController)container.getContext().lookup("java:global/classes/CreateUserController");
        instance.setFamilyName(familyName);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmail method, of class CreateUserController.
     */
    @Test
    public void testGetEmail() throws Exception {
        System.out.println("getEmail");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CreateUserController instance = (CreateUserController)container.getContext().lookup("java:global/classes/CreateUserController");
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmail method, of class CreateUserController.
     */
    @Test
    public void testSetEmail() throws Exception {
        System.out.println("setEmail");
        String email = "";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CreateUserController instance = (CreateUserController)container.getContext().lookup("java:global/classes/CreateUserController");
        instance.setEmail(email);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPassword method, of class CreateUserController.
     */
    @Test
    public void testGetPassword() throws Exception {
        System.out.println("getPassword");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CreateUserController instance = (CreateUserController)container.getContext().lookup("java:global/classes/CreateUserController");
        String expResult = "";
        String result = instance.getPassword();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPassword method, of class CreateUserController.
     */
    @Test
    public void testSetPassword() throws Exception {
        System.out.println("setPassword");
        String password = "";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CreateUserController instance = (CreateUserController)container.getContext().lookup("java:global/classes/CreateUserController");
        instance.setPassword(password);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of performCreateUser method, of class CreateUserController.
     */
    @Test
    public void testPerformCreateUser() throws Exception {
        System.out.println("performCreateUser");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CreateUserController instance = (CreateUserController)container.getContext().lookup("java:global/classes/CreateUserController");
        String expResult = "";
        String result = instance.performCreateUser();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
