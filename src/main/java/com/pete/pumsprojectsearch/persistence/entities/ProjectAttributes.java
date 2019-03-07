/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pete.pumsprojectsearch.persistence.entities;

import com.pete.pumsprojectsearch.persistence.entities.enumerations.ProjectChangeType;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


/**
 *
 * @author Peted
 */
@Entity
public class ProjectAttributes implements Serializable {
    public ProjectAttributes () {}
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    // ForeignKey
    @OneToOne
    private User projectOwner;
    // ForeignKey
    @OneToMany
    private List<ProjectHistory> history;
    private ProjectChangeType changes;
    @OneToMany
    private List<Attachment> attachments;

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
        if (!(object instanceof ProjectAttributes)) {
            return false;
        }
        ProjectAttributes other = (ProjectAttributes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pete.pumprojectsearch.persistence.entities.ProjectAttributes[ id=" + id + " ]";
    }
    
}
