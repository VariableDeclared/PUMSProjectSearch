/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pete.pumsprojectsearch.util;

import com.pete.pumsprojectsearch.util.objects.PasswordHashPayload;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
public class AccountUtilsTest {
    
    public AccountUtilsTest() {
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
    public String getHash (
            String passwordToHash,
            byte[] salt,
            String fixedHash
    ) {
        
        String newPassword = passwordToHash + fixedHash;
        String generatedPassword = null;
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(salt);
            //Get the hash's bytes
            byte[] bytes = md.digest(newPassword.getBytes());
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }
    /**
     * Test of getSecurePassword method, of class AccountUtils.
     */
    @Test
    public void testGetSecurePassword() {
        System.out.println("getSecurePassword");
        String passwordToHash = "hrhrhrh";
        byte[] salt = "gfgrtg3t4".getBytes();
        String fixedHash = "fgffffff";
        String expResult = getHash(
                passwordToHash,
                salt,
                fixedHash
            );
        String result = AccountUtils.getSecurePassword(passwordToHash, salt, fixedHash);
        assertEquals(expResult, result);

    }

    /**
     * Test of hashPassword method, of class AccountUtils.
     */
    @Test
    public void testHashPassword() throws Exception {
        System.out.println("hashPassword");
        String passwordToHash = "g4g4gh4h";
        String providedSalt = "h4h4h4h4h4s";
        String expResult = getHash(
                passwordToHash,
                providedSalt.getBytes(),
                AccountUtils.FIXED_SALT
        );
        PasswordHashPayload res = new PasswordHashPayload(
                expResult,
                providedSalt,
                AccountUtils.FIXED_SALT
        );
        System.out.println(expResult);
        
        PasswordHashPayload result = AccountUtils.hashPassword(
                passwordToHash, 
                providedSalt
        );
        System.out.println(result.getPasswordHash());
        assertEquals(res.getPasswordHash(), result.getPasswordHash());
        assertEquals(res.getFixedSalt(), result.getFixedSalt());
        assertEquals(res.getPasswordSalt(), result.getPasswordSalt());

    }
    
}
