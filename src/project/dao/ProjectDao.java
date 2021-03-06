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

import project.dto.JournalMealDto;
import project.dto.UserDto;
import project.meta.JournalMealMeta;
import project.meta.JournalMeta;
import project.meta.MealMeta;
import project.meta.UserMeta;
import project.model.Journal;
import project.model.JournalMeal;
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
	            userModel.setId(key.getId());
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
    
    public boolean updateUser(User userModel){
        boolean result = true;
        
        System.out.println("UpdateUser enter, user id: " + userModel.getId());
        
        try{
            Transaction tx = Datastore.beginTransaction();
            Entity e = Datastore.query(User.KIND_NAME).filter("id", FilterOperator.EQUAL, userModel.getId()).asSingleEntity();
            System.out.println(e);
            if(e != null){ 
                e.setProperty("username", userModel.getUsername());
                e.setProperty("firstName", userModel.getFirstName());
                e.setProperty("lastName", userModel.getLastName());
                e.setProperty("password", userModel.getPassword());
                
                Datastore.put(e);
                tx.commit();
                
            }
            
        } catch(Exception e){
            result = false;
        }
       
        return result;
    }

    public Entity readUser(UserDto user){
        return Datastore.query(User.KIND_NAME).filter("id", FilterOperator.EQUAL, user.getId()).asSingleEntity();
    }
    
    public boolean createMeal(Meal mealModel){
        boolean result = true;
        
        try{
            Transaction tx = Datastore.beginTransaction();
            Entity meal = Datastore.query(Meal.KIND_NAME).filter("name", FilterOperator.EQUAL, mealModel.getName()).asSingleEntity();
            
            if(meal == null){
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
            Entity e = Datastore.query(Meal.KIND_NAME).filter("id", FilterOperator.EQUAL, mealModel.getId()).asSingleEntity();
            int total_calories = 0;
            boolean can_add = true;
            if(e != null){
                List<Entity> journalMeal = Datastore.query(JournalMeal.KIND_NAME).filter("meal_id",  FilterOperator.EQUAL, mealModel.getId()).asList();
                
                for(Entity item: journalMeal ) {
                    List<Entity> journalMealQuery = Datastore.query(JournalMeal.KIND_NAME).filter("journal_id",  FilterOperator.EQUAL, Long.parseLong(item.getProperty("journal_id").toString())).asList();
                    if(total_calories <= 2000) {
                        for(Entity item2 : journalMealQuery) {
                            if(Long.parseLong(item2.getProperty("meal_id").toString()) != mealModel.getId()) {
                                total_calories += Integer.parseInt(item2.getProperty("total_calories").toString());
                            } else {
                                total_calories += Integer.parseInt(item2.getProperty("quantity").toString()) * mealModel.getCalories();
                            }
                        }
                    }
                    
                    if(total_calories > 2000) {
                        can_add = false;
                    } else {
                        total_calories = 0;
                    }
                }
                
                if(can_add)
                {
                    for(Entity item: journalMeal ) {
                        Transaction tz = Datastore.beginTransaction();
                        item.setProperty("total_calories", (int) Integer.parseInt(item.getProperty("quantity").toString()) * mealModel.getCalories());
                        Datastore.put(item);
                        tz.commit();
                    }
                    Transaction tx = Datastore.beginTransaction();
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
                else
                {
                    result = false;
                }

                
            }
            

        } catch(Exception e){
            result = false;
        }
        
        
        return result;
    }
    
    public boolean deleteMeal(Meal mealModel){
        boolean result = true;
        
        try{
            System.out.println("deleteMeal try enter");
            Transaction tx = Datastore.beginTransaction();
            
            Datastore.delete(Datastore.query(JournalMeal.KIND_NAME).filter("meal_id", FilterOperator.EQUAL, mealModel.getId()).asKeyList());
            System.out.println("delete from journal meal");
            
            tx.commit();
            
            Datastore.delete(Datastore.query(Meal.KIND_NAME).filter("id", FilterOperator.EQUAL, mealModel.getId()).asSingleEntity().getKey());
            System.out.println("delete from meal");
                        
            tx.commit();
            
        } catch(Exception e){
            result = false;
        }
        
        return result;
    }


	public Journal createJournal(Journal journalModel) {
        Journal result = null;
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
                result = journalModel;
                Datastore.put(journalModel);
               
            }
            tx.commit();
        } catch(Exception e){
            result = null;
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
	
	public Entity readJournal(Journal journalModel) {
        Entity result = null;
        Entity temp = null;
        JournalMeta m = new JournalMeta();
        
        try{
            Filter journal_date =  new FilterPredicate(m.journal_date.toString(), FilterOperator.EQUAL, journalModel.getJournal_date());
            Filter user_id =  new FilterPredicate(m.UserKey.toString() ,FilterOperator.EQUAL, journalModel.getUserKey());
            temp = Datastore.query(Journal.KIND_NAME).filter(CompositeFilterOperator.and(journal_date, user_id)).asSingleEntity();
            result = temp;
        } catch(Exception e){

        }
        
        return result;
            
	}

    public JournalMeal createJournalMeal(JournalMeal journalMeal) {
        JournalMeal result = null;
        Entity temp = null;
        JournalMealMeta m = new JournalMealMeta();
        
        try{
            Transaction tx = Datastore.beginTransaction();
            

            Entity meal = Datastore.query(Meal.KIND_NAME).filter("id", FilterOperator.EQUAL, journalMeal.getMeal_id()).asSingleEntity();
            Entity journal = Datastore.query(Journal.KIND_NAME).filter("id", FilterOperator.EQUAL, journalMeal.getJournal_id()).asSingleEntity();
            if(journal != null && meal != null){
                Filter journal_id =  new FilterPredicate(m.journal_id.toString(), FilterOperator.EQUAL, journalMeal.getJournal_id());
                Filter meal_id =  new FilterPredicate(m.meal_id.toString() ,FilterOperator.EQUAL, journalMeal.getMeal_id());
                temp = Datastore.query(JournalMeal.KIND_NAME).filter(CompositeFilterOperator.and(journal_id, meal_id)).asSingleEntity();
                int calories = Integer.parseInt(meal.getProperty("calories").toString());
                int quantity =journalMeal.getQuantity();
                if(temp == null) {
                    Key journalKey = Datastore.allocateId(JournalMeal.KIND_NAME);
                    
                    journalMeal.setKey(journalKey);
                    journalMeal.setId(journalKey.getId());
                    journalMeal.setQuantity(quantity);
                    journalMeal.setTotal_calories(calories * quantity);
                    result = journalMeal;
                    Datastore.put(journalMeal);
                } else {
                   
                    int i_quantity = Integer.parseInt(temp.getProperty("quantity").toString()) + quantity;
                    temp.setProperty("quantity", i_quantity);
                    temp.setProperty("total_calories", calories * i_quantity);
                    journalMeal.setId(Long.parseLong(temp.getProperty("id").toString()));
                    journalMeal.setQuantity(i_quantity);
                    result = journalMeal;
                    Datastore.put(temp);
                }
               
            }
            tx.commit();
        } catch(Exception e){
            result = null;
        }
        
        return result;
        
    }
   
    public List<Object> scopeJournalMeal(JournalMeal journalMeal) {
        List<Object> journalMealList = new ArrayList<Object>();
        List<Object> joinedTable;
        Map<String, Object> MealResult;
        List<Entity> list = Datastore.query(JournalMeal.KIND_NAME).filter("journal_id", FilterOperator.EQUAL, journalMeal.getJournal_id()).asList();
        int meal_id;
        for(Entity e : list){
            joinedTable = new ArrayList<Object>();
            meal_id = Integer.parseInt(e.getProperties().get("meal_id").toString());
            
            MealResult = Datastore.query(Meal.KIND_NAME).filter("id", FilterOperator.EQUAL, meal_id).asSingleEntity().getProperties();
            joinedTable.add(MealResult);
            joinedTable.add(e.getProperties());

            journalMealList.add(joinedTable);
        } 
        
        return journalMealList;
    }
    
    public int checkJournalTotalCalories(JournalMealDto journalMealDto) {
        List<Entity> list = Datastore.query(JournalMeal.KIND_NAME).filter("journal_id", FilterOperator.EQUAL, journalMealDto.getJournal_id()).asList();
        int total_calories = 0;
        int originalQuantity = 0;
        for(Entity e: list) {
           if( Long.parseLong(e.getProperty("meal_id").toString()) != journalMealDto.getMeal_id()) {
               total_calories += Integer.parseInt(e.getProperty("total_calories").toString());
           } else {
               originalQuantity = Integer.parseInt(e.getProperty("quantity").toString());
           }
        }
        Entity meal =  Datastore.query(Meal.KIND_NAME).filter("id", FilterOperator.EQUAL, journalMealDto.getMeal_id()).asSingleEntity();
        if(meal != null) 
        {
            total_calories += Integer.parseInt(meal.getProperty("calories").toString()) * (journalMealDto.getQuantity() + originalQuantity);
        }
        return (total_calories <= 2000) ? total_calories: -1;
    }
    
    public boolean checkJournalMealLimit(Long journalId, int addedQuantity) {
        List<Entity> list = Datastore.query(JournalMeal.KIND_NAME).filter("journal_id", FilterOperator.EQUAL, journalId).asList();
        int total_quantity = addedQuantity;
        for(Entity e: list) {
            total_quantity += Integer.parseInt(e.getProperties().get("quantity").toString());
         }
        
        return (total_quantity > 0 && total_quantity <= 10);
    }
    public boolean deleteJournalMeal(JournalMeal journalMeal) {
        boolean result = true;
        try{
            Transaction tx = Datastore.beginTransaction();
            Datastore.delete(Datastore.query(JournalMeal.KIND_NAME).filter("id", FilterOperator.EQUAL, journalMeal.getId()).asSingleEntity().getKey());
                        
            tx.commit();
            
        } catch(Exception e){
            result = false;
        }
        
        
        return result;
    }
    
    public boolean updateJournalMeal(JournalMeal journalMeal) {
        boolean result = false;
        try{
            Transaction tx = Datastore.beginTransaction();
            Entity temp = Datastore.query(JournalMeal.KIND_NAME).filter("id", FilterOperator.EQUAL, journalMeal.getId()).asSingleEntity();
            if(temp != null)
            {
                Entity temp_meal = Datastore.query(Meal.KIND_NAME).filter("id", FilterOperator.EQUAL, Long.parseLong(temp.getProperty("meal_id").toString())).asSingleEntity();
                temp.setProperty("quantity", journalMeal.getQuantity());
                temp.setProperty("total_calories", journalMeal.getQuantity() * Integer.parseInt(temp_meal.getProperty("calories").toString()));
                Datastore.put(temp);
                result = true;
            }
                        
            tx.commit();
            
        } catch(Exception e){

        } 
        
        return result;
    }

    public boolean checkUpdateJournalMealLimit(Long id, int addedQuantity) {
        Entity journalMeal = Datastore.query(JournalMeal.KIND_NAME).filter("id", FilterOperator.EQUAL, id).asSingleEntity();
        int total_quantity = addedQuantity;
        if(total_quantity > 0 && journalMeal != null) {
            List<Entity> list = Datastore.query(JournalMeal.KIND_NAME).filter("journal_id", FilterOperator.EQUAL, Long.parseLong(journalMeal.getProperty("journal_id").toString())).asList();
            for(Entity e: list) {
                if(Long.parseLong(journalMeal.getProperty("id").toString()) != id) {
                    total_quantity += Integer.parseInt(e.getProperties().get("quantity").toString());
                }
             }
        }
        return (total_quantity > 0 && total_quantity <= 10);
    }
    
    public int checkUpdateJournalTotalCalories(JournalMealDto journalMealDto) {
        Entity journalMeal = Datastore.query(JournalMeal.KIND_NAME).filter("id", FilterOperator.EQUAL, journalMealDto.getId()).asSingleEntity();
        List<Entity> list = Datastore.query(JournalMeal.KIND_NAME).filter("journal_id", FilterOperator.EQUAL, Long.parseLong(journalMeal.getProperty("journal_id").toString())).asList();
        int total_calories = 0;
        for(Entity e: list) {
           if( Long.parseLong(e.getProperty("meal_id").toString()) != Long.parseLong(journalMeal.getProperty("meal_id").toString())) {
               total_calories += Integer.parseInt(e.getProperty("total_calories").toString());
           }
        }
        Entity meal =  Datastore.query(Meal.KIND_NAME).filter("id", FilterOperator.EQUAL, Long.parseLong(journalMeal.getProperty("meal_id").toString())).asSingleEntity();
        if(meal != null) 
        {
            total_calories += Integer.parseInt(meal.getProperty("calories").toString()) * journalMealDto.getQuantity();
        }
        return (total_calories <= 2000) ? total_calories: -1;
    }
}
