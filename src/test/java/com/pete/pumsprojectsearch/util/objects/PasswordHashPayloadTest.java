/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pete.pumsprojectsearch.util.objects;

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
public class PasswordHashPayloadTest {
    private static String passwordHash = "gekgogenkjog";
    private static String passwordSalt = "@{R}RT£$";
    private static String fixedSalt = "Gdfgdgrer2333!";
    
//    private static PasswordHashPayload inst;
    public PasswordHashPayloadTest() {
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
     * Test of getPasswordHash method, of class PasswordHashPayload.
     */
    @Test
    public void testGetPasswordHash() {
        System.out.println("getPasswordHash");
        PasswordHashPayload instance = new PasswordHashPayload(
                PasswordHashPayloadTest.passwordHash,
                PasswordHashPayloadTest.passwordSalt,
                PasswordHashPayloadTest.fixedSalt
        );
        String expResult = PasswordHashPayloadTest.passwordHash;
        String result = instance.getPasswordHash();
        assertEquals(expResult, result);

    }

    /**
     * Test of setPasswordHash method, of class PasswordHashPayload.
     */
//    @Test
//    public void testSetPasswordHash() {
//        System.out.println("setPasswordHash");
//        String passwordHash = PasswordHashPayloadTest.passwordHash;
//        PasswordHashPayload instance = new PasswordHashPayload(
//                PasswordHashPayloadTest.passwordHash,
//                PasswordHashPayloadTest.passwordSalt,
//                PasswordHashPayloadTest.fixedSalt
//        );
//        assertEqual(instance.setPasswordHash(passwordHash), void);
//    }

    /**
     * Test of getPasswordSalt method, of class PasswordHashPayload.
     */
    @Test
    public void testGetPasswordSalt() {
        System.out.println("getPasswordSalt");
        PasswordHashPayload instance = new PasswordHashPayload(
                PasswordHashPayloadTest.passwordHash,
                PasswordHashPayloadTest.passwordSalt,
                PasswordHashPayloadTest.fixedSalt
        );
        String expResult = PasswordHashPayloadTest.passwordSalt;
        String result = instance.getPasswordSalt();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPasswordSalt method, of class PasswordHashPayload.
     */
//    @Test
//    public void testSetPasswordSalt() {
//        System.out.println("setPasswordSalt");
//        String passwordSalt = PasswordPayloadTest.passwordSalt;
//        PasswordHashPayload instance = new PasswordHashPayload(
//                PasswordHashPayloadTest.passwordHash,
//                PasswordHashPayloadTest.passwordSalt,
//                PasswordHashPayloadTest.fixedSalt
//        );
//        instance.setPasswordSalt(passwordSalt);
//
//    }

    /**
     * Test of getFixedSalt method, of class PasswordHashPayload.
     */
    @Test
    public void testGetFixedSalt() {
        System.out.println("getFixedSalt");
        PasswordHashPayload instance =  new PasswordHashPayload(
                PasswordHashPayloadTest.passwordHash,
                PasswordHashPayloadTest.passwordSalt,
                PasswordHashPayloadTest.fixedSalt
        );;
        String expResult = PasswordHashPayloadTest.fixedSalt;
        String result = instance.getFixedSalt();
        assertEquals(expResult, result);

    }

    /**
     * Test of setFixedSalt method, of class PasswordHashPayload.
     */

    
}
