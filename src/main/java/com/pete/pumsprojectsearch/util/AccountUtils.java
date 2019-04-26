/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pete.pumsprojectsearch.util;

import com.pete.pumsprojectsearch.util.objects.PasswordHashPayload;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import static java.time.Clock.fixed;

/**
 *
 * @author Peted
 */
public class AccountUtils {
    
    public static final String FIXED_SALT = "FWJ25%^%^&£^%??\\.¬#";
    // Hashing from: https://howtodoinjava.com/security/how-to-generate-secure-password-hash-md5-sha-pbkdf2-bcrypt-examples/
    public static String getSecurePassword(
            String passwordToHash,
            byte[] salt,
            String fixedHash
    )
    {
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
     
    //Add salt
    private static byte[] getSalt() throws NoSuchAlgorithmException, NoSuchProviderException
    {
        //Always use a SecureRandom generator
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG", "SUN");
        //Create array for salt
        byte[] salt = new byte[16];
        //Get a random salt
        sr.nextBytes(salt);
        //return salt
        return salt;
    }
    
    public static PasswordHashPayload hashPassword(
            String passwordToHash, 
            String providedSalt
    ) throws NoSuchAlgorithmException,
            NoSuchProviderException 
    {
        byte[] salt;
        if (providedSalt != null) {
            salt = providedSalt.getBytes();
        } else {
            salt = getSalt();
        }
         
         
        String regeneratedPassowrdToVerify = getSecurePassword(
                passwordToHash,
                salt, 
                AccountUtils.FIXED_SALT
        );
        return new PasswordHashPayload(
                regeneratedPassowrdToVerify,
                new String(salt),
                AccountUtils.FIXED_SALT
        );
    }
}
