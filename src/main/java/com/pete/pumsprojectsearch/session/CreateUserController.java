/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pete.pumsprojectsearch.session;

import com.pete.pumsprojectsearch.persistence.entities.PUMSUser;
import com.pete.pumsprojectsearch.persistence.facades.PUMSUserFacade;
import com.pete.pumsprojectsearch.util.AccountUtils;
import com.pete.pumsprojectsearch.util.LoginUtils;
import com.pete.pumsprojectsearch.util.objects.PasswordHashPayload;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Named;

/**
 *
 * @author Peted
 */
@Stateless
@Named(value="createUserController")
public class CreateUserController {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    private String firstName, familyName, email, password;
    @EJB
    private PUMSUserFacade ejb;
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String performCreateUser() {
        PasswordHashPayload passwd = null;
        try {
            passwd = AccountUtils.hashPassword(
                this.password,
                null // generate salt for user.
            );
        } catch (NoSuchAlgorithmException ex) {
            System.out.println("Nosuch algorithm exception");
        } catch (NoSuchProviderException ex) {
            System.out.println("No such provider exception");
        }
        if (passwd == null) {
            return "create.xhtml";
        }
        PUMSUser newUser = new PUMSUser(
            this.firstName,
            this.familyName,
            this.email,
            passwd.getPasswordSalt(),
            passwd.getPasswordHash()
        );
        
        ejb.create(newUser);
        LoginUtils.loginUser(newUser);
        return "/projects.xhtml";
    }
}
