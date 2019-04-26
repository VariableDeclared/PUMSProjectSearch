/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pete.pumsprojectsearch.persistence.entities;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Peter J De Sousa
 * 
 * This software is released solely for the assessment of myself
 * any other unauthorized use goes beyond the intended purpose of
 * this application and it's licensed use.
*/
@Entity
public class PUMSUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String firstName, familyName, email, randomSalt, passwordHash;

    private ArrayList<Project> savedProjects;


    public PUMSUser() { }
    public PUMSUser(
            String firstName,
            String familyName,
            String email,
            String randomSalt,
            String passwordHash,
            ArrayList<Project> savedProjects
    ) {
        this.firstName = firstName;
        this.familyName = familyName;
        this.email = email;
        this.randomSalt = randomSalt;
        this.passwordHash = passwordHash;
        this.savedProjects =  savedProjects == null ? 
                new ArrayList<Project>() : savedProjects;
    }

    public String getRandomSalt() {
        return randomSalt;
    }

    public void setRandomSalt(String randomSalt) {
        this.randomSalt = randomSalt;
    }
    public ArrayList<Project> getSavedProjects() {
    return savedProjects;
    }

    public void setSavedProjects(ArrayList<Project> savedProjects) {
        this.savedProjects = savedProjects;
    }
    
    public void addSavedProject(Project proj) {
        if(this.savedProjects.contains(proj))
            return;

        this.savedProjects.add(proj);
    }
    
    public void removeSavedProject(Project proj) {
        this.savedProjects.remove(proj);
    }
    
    public String getName() {
        return String.format("%s %s", this.firstName, this.familyName);
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getIdString() {
        return this.id.toString();
    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PUMSUser)) {
            return false;
        }
        PUMSUser other = (PUMSUser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pete.pumprojectsearch.persistence.entities.User[ id=" + id + " ]";
    }
    
}
