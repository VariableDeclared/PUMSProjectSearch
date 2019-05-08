/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pete.pumsprojectsearch.session;

import static com.gargoylesoftware.htmlunit.html.UnknownElementFactory.instance;
import javax.ejb.EJB;
import static net.bootsfaces.component.ComponentsEnum.container;
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

        LoginController instance = new LoginController();
        String expResult = "email@email.com";
        instance.setEmail(expResult);
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEmail method, of class LoginController.
     */
    @Test
    public void testSetEmail() throws Exception {
        System.out.println("setEmail");
        String email = "";
        LoginController instance = new LoginController();
        instance.setEmail(email);
    }

    /**
     * Test of getPassword method, of class LoginController.
     */
    @Test
    public void testGetPassword() throws Exception {
        System.out.println("getPassword");
        LoginController instance = new LoginController();
        String expResult = "gegege";
        instance.setPassword(expResult);
        String result = instance.getPassword();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPassword method, of class LoginController.
     */
    @Test
    public void testSetPassword() throws Exception {
        System.out.println("setPassword");
        String password = "grjgiri";
        LoginController instance = new LoginController();
        instance.setPassword(password);
        assertEquals(instance.getPassword(), password);
    }

    /**
     * Test of prepareUserCreateAccount method, of class LoginController.
     */
    @Test
    public void testPrepareUserCreateAccount() throws Exception {
        System.out.println("prepareUserCreateAccount");
        LoginController instance = new LoginController();
        String expResult = "/create.xhtml";
        String result = instance.prepareUserCreateAccount();
        assertEquals(expResult, result);
    }

//    /**
//     * Test of performLogin method, of class LoginController.
//     */
//    @Test
//    public void testPerformLogin() throws Exception {
//        System.out.println("performLogin");
//        LoginController instance = new LoginController();
//        String expResult = "";
//        String result = instance.performLogin();
//        assertEquals(expResult, result);
//    }
//    
}
