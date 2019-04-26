/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pete.pumsprojectsearch.persistence.entities;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Peted
 */
@Entity
public class Project implements Serializable {
    public Project() {}
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; 
    
    @OneToMany
    private ArrayList<ProjectHistory> projectHistory;
    
    @NotNull
    private String projectName, projectDescription;
    
    @ManyToMany(fetch=FetchType.EAGER)
    private ArrayList<PUMSUser> projectOwner;
  
    @OneToMany(fetch=FetchType.EAGER)
    private ArrayList<ProjectAttribute> attributes;

    public Project(
            String projectName,
            String projectDescription, 
            ArrayList<PUMSUser> projectOwner,
            ArrayList<ProjectAttribute> attributes
    ) {
        this.projectName = projectName;
        this.projectDescription = projectDescription;
        this.projectOwner = projectOwner;
        this.attributes = attributes;
    }

    public ArrayList<ProjectAttribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(ArrayList<ProjectAttribute> attributes) {
        this.attributes = attributes;
    }
    
    public ArrayList<PUMSUser> getProjectOwners() {
        if (this.projectOwner == null) {
            this.projectOwner = new ArrayList<>();
        }
        return projectOwner;
    }

    public void setProjectOwners(ArrayList<PUMSUser> projectOwner) {
        this.projectOwner = projectOwner;
    }
    

    

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof Project)) {
            return false;
        }
        Project other = (Project) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pete.pumprojectsearch.persistence.entities.Project[ id=" + id + " ]";
    }
    
}
