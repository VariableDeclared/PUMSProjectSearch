/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pete.pumsprojectsearch.session;

import com.pete.pumsprojectsearch.persistence.entities.PUMSUser;
import com.pete.pumsprojectsearch.persistence.facades.PUMSUserFacade;
import com.pete.pumsprojectsearch.util.AccountUtils;
import com.pete.pumsprojectsearch.util.AppConstants;
import com.pete.pumsprojectsearch.util.LoginUtils;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
@Named(value="loginController")
public class LoginController {
    @EJB
    PUMSUserFacade ejb;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    private String email, password;
    
    private static final EntityManagerFactory factory = 
            Persistence.createEntityManagerFactory(
                    AppConstants.PERSISTENCE_UNIT
            );
    
    private EntityManager em;
    private TypedQuery<PUMSUser> searchByEmail;
    
    public LoginController() {
        this.em = factory.createEntityManager();
        this.searchByEmail = this.em.createQuery(
                "SELECT u FROM PUMSUser as u WHERE u.email = :email", 
                PUMSUser.class
        );
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
    
    public String prepareUserCreateAccount() {
        return "/create.xhtml";
    }
    public String performLogin() {
         
         
        
        PUMSUser candidate = (PUMSUser) this.searchByEmail.setParameter(
                "email", 
                this.email
        ).getSingleResult();
        try {
            String saltedPassword = AccountUtils.hashPassword(
                    this.password,
                    candidate.getRandomSalt()
              ).getPasswordHash();
            if (saltedPassword.equals(candidate.getPasswordHash())) {
                if (LoginUtils.loginUser(candidate))
                    return "/projects.xhtml";

                FacesContext.getCurrentInstance().addMessage(
                        null, 
                        new FacesMessage(
                                "An error occured logging user in, loginUser returned false."
                        )
                );
            } else {
                FacesContext.getCurrentInstance().addMessage(
                        null, 
                        new FacesMessage(
                                "Username and password do not match."
                                        + candidate.getPasswordHash()
                                        + " Entered hashed password: " +
                                        saltedPassword
                        )
                );
            }

        } catch (Exception ex) {
            System.out.println("Something went wrong authenticating");
            return "/login.xhtml";
        }
         
         
         return "/login.xhtml";
    }
}
