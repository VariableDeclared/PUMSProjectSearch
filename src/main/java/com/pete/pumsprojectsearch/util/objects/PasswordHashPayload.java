/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pete.pumsprojectsearch.util.objects;

/**
 *
 * @author Peted
 */
public class PasswordHashPayload {
    private String passwordHash, passwordSalt, fixedSalt; 

    public PasswordHashPayload(String passwordHash, String passwordSalt, String fixedSalt) {
        this.passwordHash = passwordHash;
        this.passwordSalt = passwordSalt;
        this.fixedSalt = fixedSalt;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getPasswordSalt() {
        return passwordSalt;
    }

    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }

    public String getFixedSalt() {
        return fixedSalt;
    }

    public void setFixedSalt(String fixedSalt) {
        this.fixedSalt = fixedSalt;
    }
}
