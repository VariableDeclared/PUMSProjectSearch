/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pete.pumsprojectsearch.util;

import com.pete.pumsprojectsearch.persistence.entities.PUMSUser;
import javax.faces.context.FacesContext;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Peter J De Sousa
 * 
 * This software is released solely for the assessment of myself
 * any other unauthorized use goes beyond the intended purpose of
 * this application and it's licensed use.
*/
public class LoginUtils {
    
    
    public static HttpSession getSession () {
        HttpSession session = (HttpSession) FacesContext
                        .getCurrentInstance()
                        .getExternalContext()
                        .getSession(true);
        return session;
    }
    public static boolean loginUser(PUMSUser user) {
        HttpSession session = getSession();
        session.setAttribute("authenticated", true);
        session.setAttribute("currentUser", user);
        
        return true;
    }
    
    public static PUMSUser getUser() {
        if (LoginUtils.checkLogin()) {
            return (PUMSUser) getSession().getAttribute("currentUser");
        }
        
        return null;
    }
    public static boolean checkLogin() {
        HttpSession session = getSession();
        return (
                session.getAttribute("authenticated") != null &&
                session.getAttribute("currentUser") != null
            );
    }
 }

