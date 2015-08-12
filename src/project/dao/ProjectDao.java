/* ------------------------------------------------------------------------------
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Copyright (C) Rococo Global Technologies, Inc - All Rights Reserved 2015
 * --------------------------------------------------------------------------- */
package project.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slim3.datastore.Datastore;
import org.slim3.datastore.EntityQuery;
import org.slim3.datastore.ModelQuery;
import org.slim3.util.BeanUtil;

import project.dto.UserDto;
import project.meta.MealMeta;
import project.meta.UserMeta;
import project.model.Meal;
import project.model.User;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.SortDirection;
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
        Meal temp = null;
        MealMeta m = new MealMeta();
        
        try{
            Transaction tx = Datastore.beginTransaction();
            
            temp = Datastore.query(m).filter(m.name.equal(mealModel.getName())).asSingle();
            if(temp == null){
                Key mealKey = Datastore.allocateId(Meal.KIND_NAME);
                
                mealModel.setKey(mealKey);
                mealModel.setId(mealKey.getId());
                
                Datastore.put(mealModel);
                
                tx.commit();
            } else{
                result = false;
            }
        } catch(Exception e){
            result = false;
        }
        
        return result;
    }
    
    public List<Meal> readMeal(Meal mealModel, String selection){
        List<Entity> list = null;
        List<Meal> mealList = new ArrayList<Meal>();
        Meal meal = null;
        
        try{            
            if(selection.equals("all")){
                list = Datastore.query(Meal.KIND_NAME).asList();
                
                Map<String,Object> properties;
                
                for(Entity e : list){
                    properties = e.getProperties();
                    meal = new Meal();
                    
                    BeanUtil.copy(properties, meal);
                    
                    mealList.add(meal);
                }                                
            } else if(mealModel != null & selection.equals("single")){
//                System.out.println("5) ProjectDao, single, mealModel ID: " + mealModel.getId());
                
                Entity e = Datastore.query(Meal.KIND_NAME).filter("id", FilterOperator.EQUAL, mealModel.getId()).asSingleEntity();
                
//                System.out.println(e.getProperty("name"));
                
                
                
                if(e != null){
                    Map<String,Object> properties;
                    properties = e.getProperties();
                    meal = new Meal();
                    BeanUtil.copy(properties, meal);
                }
                
//                System.out.println("6) ProjectDao, single, Meal temp name : " + meal.getName());
                
                if(meal != null){
                    mealList.add(meal);
                }
            }
            
        } catch(Exception e){
            
            
        }
        
        return mealList;
    }
    
    public boolean updateMeal(Meal mealModel){
        boolean result = true;
        MealMeta m = null;
        Meal update = new Meal();
        
        System.out.println("ProjectDao, updateMeal() enter, " + mealModel.toString());
        
        try{
            Transaction tx = Datastore.beginTransaction();
            m = new MealMeta();
            
            Entity e = Datastore.query(Meal.KIND_NAME).filter("id", FilterOperator.EQUAL, mealModel.getId()).asSingleEntity();

            if(e != null){
                System.out.println("\n variable e not null");
                
                e.setProperty("name", mealModel.getName());
                e.setProperty("category", mealModel.getCategory());
                e.setProperty("def_quantity", mealModel.getDef_quantity());
                e.setProperty("unit", mealModel.getUnit());
                e.setProperty("description", mealModel.getDescription());
                e.setProperty("calories", mealModel.getCalories());
                e.setProperty("picture", mealModel.getPicture());
                
                Datastore.put(e);
                tx.commit();
            }
            
        } catch(Exception e){
            result = false;
        }
        
        
        return result;
    }
    
    public boolean deleteMeal(Meal mealModel){
        boolean result = true;
        
        try{
            Transaction tx = Datastore.beginTransaction();
            
            Datastore.delete(Datastore.query(Meal.KIND_NAME).filter("id", FilterOperator.EQUAL, mealModel.getId()).asSingleEntity().getKey());
                        
            tx.commit();
            
        } catch(Exception e){
            result = false;
        }
        
        return result;
    }
   
}
