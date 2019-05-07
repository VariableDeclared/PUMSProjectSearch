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
public class LoginControllerTest {
    
    public LoginControllerTest() {
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
     * Test of getEmail method, of class LoginController.
     */
    @Test
    public void testGetEmail() throws Exception {
        System.out.println("getEmail");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        LoginController instance = (LoginController)container.getContext().lookup("java:global/classes/LoginController");
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);
        container.close();
    }

    /**
     * Test of setEmail method, of class LoginController.
     */
    @Test
    public void testSetEmail() throws Exception {
        System.out.println("setEmail");
        String email = "";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        LoginController instance = (LoginController)container.getContext().lookup("java:global/classes/LoginController");
        instance.setEmail(email);
        container.close();
    }

    /**
     * Test of getPassword method, of class LoginController.
     */
    @Test
    public void testGetPassword() throws Exception {
        System.out.println("getPassword");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        LoginController instance = (LoginController)container.getContext().lookup("java:global/classes/LoginController");
        String expResult = "";
        String result = instance.getPassword();
        assertEquals(expResult, result);
        container.close();
    }

    /**
     * Test of setPassword method, of class LoginController.
     */
    @Test
    public void testSetPassword() throws Exception {
        System.out.println("setPassword");
        String password = "";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        LoginController instance = (LoginController)container.getContext().lookup("java:global/classes/LoginController");
        instance.setPassword(password);
        container.close();
    }

    /**
     * Test of prepareUserCreateAccount method, of class LoginController.
     */
    @Test
    public void testPrepareUserCreateAccount() throws Exception {
        System.out.println("prepareUserCreateAccount");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        LoginController instance = (LoginController)container.getContext().lookup("java:global/classes/LoginController");
        String expResult = "";
        String result = instance.prepareUserCreateAccount();
        assertEquals(expResult, result);
        container.close();
    }

    /**
     * Test of performLogin method, of class LoginController.
     */
    @Test
    public void testPerformLogin() throws Exception {
        System.out.println("performLogin");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        LoginController instance = (LoginController)container.getContext().lookup("java:global/classes/LoginController");
        String expResult = "";
        String result = instance.performLogin();
        assertEquals(expResult, result);
        container.close();
    }
    
}
