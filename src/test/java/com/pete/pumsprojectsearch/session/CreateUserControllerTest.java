/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pete.pumsprojectsearch.session;

import com.pete.pumsprojectsearch.persistence.entities.PUMSUser;
import static com.pete.pumsprojectsearch.persistence.entities.PUMSUser_.savedProjects;
import com.pete.pumsprojectsearch.persistence.entities.Project;
import java.util.ArrayList;
import javax.ejb.embeddable.EJBContainer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

///**
// *
// * @author Peted
// */
//public class CreateUserControllerTest {
//    private PUMSUser user;
//    public CreateUserControllerTest() {
//        this.user = new PUMSUser(
//                "Josh",
//                "bloogs",
//                "josh@bloggs.com",
//                "gjigergnji",
//                "geujiognegerujigenjoignjuoer",
//                new ArrayList<Project>()
//        );
//    }
//    
//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }
//    
//    @Before
//    public void setUp() {
//    }
//    
//    @After
//    public void tearDown() {
//    }
//
//    /**
//     * Test of getFirstName method, of class CreateUserController.
//     */
//    @Test
//    public void testGetFirstName() throws Exception {
//        System.out.println("getFirstName");
//        CreateUserController instance = new CreateUserController();
//        String expResult = this.user.getFamilyName();
//        instance.setFamilyName(this.user.getFamilyName());
//        String result = instance.getFirstName();
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of setFirstName method, of class CreateUserController.
//     */
//    @Test
//    public void testSetFirstName() throws Exception {
//        System.out.println("setFirstName");
//        String firstName = "Joe";
//        CreateUserController instance = new CreateUserController();
//        instance.setFirstName(firstName);
//        assertEquals(instance.getFirstName(), firstName);
//    }
//
//    /**
//     * Test of getFamilyName method, of class CreateUserController.
//     */
//    @Test
//    public void testGetFamilyName() throws Exception {
//        System.out.println("getFamilyName");
//        CreateUserController instance = new CreateUserController();
//        String expResult = this.user.getFamilyName();
//        instance.setFamilyName(expResult);
//        String result = instance.getFamilyName();
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of setFamilyName method, of class CreateUserController.
//     */
//    @Test
//    public void testSetFamilyName() throws Exception {
//        System.out.println("setFamilyName");
//        String familyName = this.user.getFamilyName();
//        CreateUserController instance = new CreateUserController();
//        instance.setFamilyName(familyName);
//        assertEquals(instance.getFamilyName(), familyName);
//    }
//
//    /**
//     * Test of getEmail method, of class CreateUserController.
//     */
//    @Test
//    public void testGetEmail() throws Exception {
//        System.out.println("getEmail");
//        CreateUserController instance = new CreateUserController();
//        String expResult = this.user.getEmail();
//        instance.setEmail(expResult);
//        String result = instance.getEmail();
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of setEmail method, of class CreateUserController.
//     */
//    @Test
//    public void testSetEmail() throws Exception {
//        System.out.println("setEmail");
//        String email = this.user.getEmail();
//        CreateUserController instance = new CreateUserController();
//        instance.setEmail(email);
//        assertEquals(instance.getEmail(), email);
//    }
//
//    /**
//     * Test of getPassword method, of class CreateUserController.
//     */
//    @Test
//    public void testGetPassword() throws Exception {
//        System.out.println("getPassword");
//        CreateUserController instance =  new CreateUserController();
//        String expResult = this.user.getPasswordHash();
//        instance.setPassword(expResult);
//        String result = instance.getPassword();
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of setPassword method, of class CreateUserController.
//     */
//    @Test
//    public void testSetPassword() throws Exception {
//        System.out.println("setPassword");
//        String password = this.user.getPasswordHash();
//        CreateUserController instance = new CreateUserController();
//        instance.setPassword(password);
//        assertEquals(instance.getPassword(), password);
//    }

    /**
     * Test of performCreateUser method, of class CreateUserController.
//     */
//    @Test
//    public void testPerformCreateUser() throws Exception {
//        System.out.println("performCreateUser");
//        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
//        CreateUserController instance = (CreateUserController)container.getContext().lookup("java:global/classes/CreateUserController");
//        String expResult = "/projects.xhtml";
//        String result = instance.performCreateUser();
//        assertEquals(expResult, result);
//        container.close();
//    }
    
//}
