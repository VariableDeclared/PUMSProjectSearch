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
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Peter J De Sousa
 * 
 * This software is released solely for the assessment of myself
 * any other unauthorized use goes beyond the intended purpose of
 * this application and it's licensed use.
*/
@Stateless
@Named(value="createUserController")
public class CreateUserController {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    private String firstName, familyName, email, password;
    @EJB
    private PUMSUserFacade ejb;
    
    EntityManager em = LoginController.factory.createEntityManager();
    TypedQuery<PUMSUser> searchByEmail = em.createQuery(
            "SELECT u FROM PUMSUser u WHERE u.email = :email", 
            PUMSUser.class
    );
    
    
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
        
        try {
            this.searchByEmail.setParameter("email", this.email).getSingleResult();
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage("Account exists with this email")
                );
            
            return "/login.xhtml";
        } catch (Exception ex) { } 
        
        
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
            passwd.getPasswordHash(),
            null
        );
        
        ejb.create(newUser);
        LoginUtils.loginUser(newUser);
        return "/projects.xhtml";
    }
}
