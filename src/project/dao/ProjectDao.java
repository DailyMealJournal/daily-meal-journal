/* ------------------------------------------------------------------------------
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Copyright (C) Rococo Global Technologies, Inc - All Rights Reserved 2015
 * --------------------------------------------------------------------------- */
package project.dao;

import java.util.List;

import org.slim3.datastore.Datastore;
import org.slim3.datastore.EntityQuery;
import org.slim3.datastore.ModelQuery;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Transaction;
import com.google.appengine.api.datastore.Query.FilterOperator;

import project.dto.UserDto;
import project.meta.UserMeta;
import project.model.User;

public class ProjectDao {

    public boolean createUser(User userModel){
        boolean result = true;
        try{
            Transaction tx = Datastore.beginTransaction();
            Key key = Datastore.allocateId(User.KIND_NAME);
            userModel.setKey(key);
            
            Datastore.put(userModel);
            tx.commit();
            
        } catch(Exception e){
            result = false;
        }
        
        return result;
    }

    public Entity getUser(UserDto user){
        UserMeta m = new UserMeta();
        EntityQuery query = Datastore.query("USER");
        query.filter("username",FilterOperator.EQUAL, user.getUsername());
        query.filter("password",FilterOperator.EQUAL, user.getPassword());
        return query.asSingleEntity();
    }
    
    public List<User> getAllUsers() {
        UserMeta m = new UserMeta();
        return Datastore.query(m).asList();
    }
}
