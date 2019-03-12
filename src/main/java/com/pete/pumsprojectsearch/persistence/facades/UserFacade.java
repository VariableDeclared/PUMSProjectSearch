/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pete.pumsprojectsearch.persistence.facades;

import com.pete.pumsprojectsearch.persistence.entities.PUMSUser;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Peted
 */
@Stateless
public class UserFacade extends AbstractFacade<PUMSUser> {

    @PersistenceContext(unitName = "com.pete_PUMProjectSearch_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserFacade() {
        super(PUMSUser.class);
    }
    
}
