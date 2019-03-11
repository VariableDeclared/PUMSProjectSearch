/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pete.pumsprojectsearch.util;

import com.pete.pumsprojectsearch.persistence.entities.Project;
import com.pete.pumsprojectsearch.persistence.entities.User;
import com.pete.pumsprojectsearch.persistence.facades.ProjectFacade;
import com.pete.pumsprojectsearch.persistence.facades.UserFacade;
import com.pete.pumsprojectsearch.util.objects.PasswordHashPayload;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Peted
 */
public class DataInsert {


    public static void insertData(ProjectFacade projectEjb, UserFacade userEjb) throws Exception {

        PasswordHashPayload pl = AccountUtils.hashPassword("hello123", null);
        String [] names = { "Peter", "Joe", "Margaret", "Thresa", "Patrick" };
        ArrayList<User> users = new ArrayList<User>();
        for (int i = 0; i < names.length; i++) {
            User user = new User(
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
        
        
        Iterator<User> it = users.iterator();
        
        while(it.hasNext()) {
            User user = it.next();
            Project proj = new Project(
                     String.format("PUMS_Project %s", user.getFirstName()),
                     "It's about searching and searching well!",
                     user
                    );
                projects.add(proj);
                projectEjb.create(proj);
                System.out.println("Inserting data... with " + user.getFirstName());
        }
        
        
        
        
        
 
        
    }
}
