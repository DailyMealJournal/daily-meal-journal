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
import org.slim3.repackaged.org.json.JSONObject;
import org.slim3.util.BeanUtil;

import project.dto.UserDto;
import project.meta.JournalMeta;
import project.meta.MealMeta;
import project.meta.UserMeta;
import project.model.Journal;
import project.model.Meal;
import project.model.User;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.CompositeFilterOperator;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;
import com.google.appengine.api.datastore.Transaction;

public class ProjectDao {
	DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
    public boolean createUser(User userModel){
        boolean result = true;
        try{
        	Query query = new Query(User.KIND_NAME);
            Filter username =  new FilterPredicate("username", FilterOperator.EQUAL, userModel.getUsername());
            query.setFilter(username);
            if(datastore.prepare(query).asSingleEntity() == null)
            {
	            Transaction tx = Datastore.beginTransaction();
	            Key key = Datastore.allocateId(User.KIND_NAME);
	            userModel.setKey(key);
	            
	            Datastore.put(userModel);
	            tx.commit();
            }
            else
            {
            	result = false;
            }
        } catch(Exception e){
            result = false;
        }

        
        return result;
    }

    public Entity getUser(UserDto user){
        Query query = new Query(User.KIND_NAME);
        Filter username =  new FilterPredicate("username", FilterOperator.EQUAL, user.getUsername());
        Filter password =  new FilterPredicate("password",FilterOperator.EQUAL, user.getPassword());
        query.setFilter(CompositeFilterOperator.and(username, password));

        return datastore.prepare(query).asSingleEntity();
    }
    
    public List<User> getAllUsers() {
        UserMeta m = new UserMeta();
        return Datastore.query(m).asList();
    }
    
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
                Entity e = Datastore.query(Meal.KIND_NAME).filter("id", FilterOperator.EQUAL, mealModel.getId()).asSingleEntity();
                
                if(e != null){
                    Map<String,Object> properties;
                    properties = e.getProperties();
                    meal = new Meal();
                    BeanUtil.copy(properties, meal);
                }
                
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
        
        try{
            Transaction tx = Datastore.beginTransaction();
            Entity e = Datastore.query(Meal.KIND_NAME).filter("id", FilterOperator.EQUAL, mealModel.getId()).asSingleEntity();

            if(e != null){                
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


	public boolean createJournal(Journal journalModel) {
        boolean result = true;
        Entity temp = null;
        JournalMeta m = new JournalMeta();
        
        try{
            Transaction tx = Datastore.beginTransaction();
            
            Filter journal_date =  new FilterPredicate(m.journal_date.toString(), FilterOperator.EQUAL, journalModel.getJournal_date());
            Filter user_id =  new FilterPredicate(m.UserKey.toString() ,FilterOperator.EQUAL, journalModel.getUserKey());
            temp = Datastore.query(Journal.KIND_NAME).filter(CompositeFilterOperator.and(journal_date, user_id)).asSingleEntity();

            if(temp == null){
                Key journalKey = Datastore.allocateId(Journal.KIND_NAME);
                
                journalModel.setKey(journalKey);
                journalModel.setId(journalKey.getId());
                
                Datastore.put(journalModel);
               
            }
            tx.commit();
        } catch(Exception e){
            result = false;
        }
        
        return result;
	}
	
	public boolean deleteJournal(Journal journalModel) {
        boolean result = true;

        try{
            Transaction tx = Datastore.beginTransaction();
            
            Datastore.delete(Datastore.query(Journal.KIND_NAME).filter("id", FilterOperator.EQUAL, journalModel.getId()).asSingleEntity().getKey());
                        
            tx.commit();
            
        } catch(Exception e){
            result = false;
        }
        
        
        return result;
	}
   
}
