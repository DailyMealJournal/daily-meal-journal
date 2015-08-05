/* ------------------------------------------------------------------------------
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Copyright (C) Rococo Global Technologies, Inc - All Rights Reserved 2015
 * --------------------------------------------------------------------------- */
package project.dao;

import java.util.List;

import org.slim3.datastore.Datastore;
import org.slim3.datastore.EntityQuery;

import project.dto.UserDto;
import project.meta.UserMeta;
import project.model.Meal;
import project.model.User;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Transaction;

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
        EntityQuery query = Datastore.query(User.KIND_NAME);
        query.filter("username",FilterOperator.EQUAL, user.getUsername());
        query.filter("password",FilterOperator.EQUAL, user.getPassword());
        System.out.print(user.getPassword());
        return query.asSingleEntity();
    }
    
    public List<User> getAllUsers() {
        UserMeta m = new UserMeta();
        return Datastore.query(m).asList();
    }
    
    /*public boolean createFood(Food foodModel){
        boolean result = true;
        try{
            Transaction tx = Datastore.beginTransaction();
            Key foodKey = Datastore.allocateId(Food.KIND_NAME);
            
            foodModel.setKey(foodKey);
            
            Datastore.put(foodModel);
            
            tx.commit();
            
        } catch(Exception e){
            result = false;
        }
        
        return result;
    }*/
    
    /*public boolean createFoodInfo(Food foodModel, FoodInfo foodInfoModel){
        boolean result = true;
        try{
            Entity entity;
            Transaction tx = Datastore.beginTransaction();
            
            EntityQuery query = Datastore.query(Food.KIND_NAME);
            query.filter("name",FilterOperator.EQUAL, foodModel.getName());
            entity = query.asSingleEntity();
            
            Key foodInfoKey = Datastore.allocateId(entity.getKey(), FoodInfo.KIND_NAME);
            
            foodInfoModel.setKey(foodInfoKey);
            foodInfoModel.setFoodKey(entity.getKey());
            
            Datastore.put(foodInfoModel);
            
            tx.commit();
        
        } catch(Exception e){
            result = false;
        }
        
        return result;
    }*/
    
    public boolean createMeal(Meal mealModel){
        boolean result = true;
        
        try{
            Transaction tx = Datastore.beginTransaction();
            Key mealKey = Datastore.allocateId(Meal.KIND_NAME);
            
            mealModel.setKey(mealKey);
            
            Datastore.put(mealModel);
            
            tx.commit();
            
        } catch(Exception e){
            result = false;
        }
        
        return result;
    }
    
    public boolean updateMeal(Meal mealModel){
        boolean result = true;
        
        try{
            Transaction tx = Datastore.beginTransaction();
            
            
            
            tx.commit();
            
        } catch(Exception e){
            
            
        }
        
        
        return result;
    }
    
    public boolean deleteMeal(Meal mealModel){
        boolean result = true;
        
        try{
            Transaction tx = Datastore.beginTransaction();
            
            Datastore.delete(mealModel.getKey());
                        
            tx.commit();
            
        } catch(Exception e){
            
            
        }
        
        
        return result;
    }
   
}
