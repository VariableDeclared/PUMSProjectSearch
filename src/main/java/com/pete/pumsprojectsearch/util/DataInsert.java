/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pete.pumsprojectsearch.util;

import com.pete.pumsprojectsearch.persistence.entities.Project;
import com.pete.pumsprojectsearch.persistence.entities.PUMSUser;
import com.pete.pumsprojectsearch.persistence.entities.ProjectAttribute;
import com.pete.pumsprojectsearch.persistence.facades.ProjectAttributeFacade;
import com.pete.pumsprojectsearch.persistence.facades.ProjectFacade;
import com.pete.pumsprojectsearch.persistence.facades.UserFacade;
import com.pete.pumsprojectsearch.util.objects.PasswordHashPayload;
import java.util.ArrayList;
import java.util.Iterator;
/**
 *
 * @author Peter J De Sousa
 * 
 * This software is released solely for the assessment of myself
 * any other unauthorized use goes beyond the intended purpose of
 * this application and it's licensed use.
*/
public class DataInsert {


    public static void insertData(
            ProjectFacade projectEjb,
            UserFacade userEjb,
            ProjectAttributeFacade attributeEjb) throws Exception {

        PasswordHashPayload pl = AccountUtils.hashPassword("hello123", null);
        String [] names = { "Peter", "Joe", "Margaret", "Thresa", "Patrick" };
        ArrayList<PUMSUser> users = new ArrayList<PUMSUser>();
        for (int i = 0; i < names.length; i++) {
            PUMSUser user = new PUMSUser(
                names[i],
                "De Sousa",
                String.format("%s@live.com", names[i]),
                pl.getPasswordSalt(),
                pl.getPasswordHash()
            );
            userEjb.create(user);
            System.out.println("Persisted. User...");
            users.add(user);
        }
        final ArrayList<Project> projects = new ArrayList<Project>();
        
        
        Iterator<PUMSUser> it = users.iterator();
        
        ArrayList<ProjectAttribute> attributes = new ArrayList<>();
        attributes.add(
                new ProjectAttribute(
                        "http://port.ac.uk"
                )
        );
        attributes.add(
                new ProjectAttribute(
                        "http://github.com/variabledeclared"
                )
        );
        
        attributeEjb.create(attributes.get(0));
        attributeEjb.create(attributes.get(1));
        
        while(it.hasNext()) {
            PUMSUser user = it.next();
            Project proj = new Project(
                     String.format("PUMS_Project %s", user.getFirstName()),
                     "It's about searching and searching well!",
                     users,
                    attributes
                    );
                projects.add(proj);
                projectEjb.create(proj);
                System.out.println("Inserting data... with " + user.getFirstName());
        }
        
        
        
        
        
 
        
    }
}
