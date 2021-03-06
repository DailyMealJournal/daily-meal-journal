/* ------------------------------------------------------------------------------
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Copyright (C) Rococo Global Technologies, Inc - All Rights Reserved 2015
 * --------------------------------------------------------------------------- */
package project.service;

import java.util.ArrayList;
import java.util.List;

import project.dao.ProjectDao;
import project.dto.JournalDto;
import project.dto.JournalMealDto;
import project.dto.MealDto;
import project.dto.UserDto;
import project.model.Journal;
import project.model.JournalMeal;
import project.model.Meal;
import project.model.User;

import com.google.appengine.api.datastore.Entity;

public class ProjectService {
    ProjectDao dao = new ProjectDao();
    
    public UserDto user(UserDto input, String action){
        User user = new User();
        if(action.equals("create")){
//          user.setId(input.getId());
            user.setUsername(input.getUsername());
            user.setPassword(input.getPassword());
            user.setFirstName(input.getFirstName());
            user.setLastName(input.getFirstName());
            
            if(!this.dao.createUser(user)){
                input.setErrorList(new ArrayList<String>());
                input.getErrorList().add("Username has already been taken.");
            } 
        } else if(action.equals("update_user")){            
            user.setId(input.getId());
            user.setUsername(input.getUsername());
            user.setPassword(input.getPassword());
            user.setFirstName(input.getFirstName());
            user.setLastName(input.getLastName());
            
            
            System.out.println("\n\nProjectService, updateUser " + user.getLastName());
            
            if(!this.dao.updateUser(user)){
                input.setErrorList(new ArrayList<String>());
                input.getErrorList().add("An occurred while updating the meal in Datastore");
            }
            
        }        
        return input;
    }
    public Entity readEntity(UserDto input) {
        return this.dao.readUser(input);
    } 
    
    public Entity getEntity(UserDto input) {
        return this.dao.getUser(input);
    }
    public List<User> getUserList() {
        return this.dao.getAllUsers();
    }
    
    public MealDto meal(MealDto input, String action){
        Meal meal = new Meal();
        
            if(action.equals("create_meal")){
                meal.setName(input.getName());
                meal.setCategory(input.getCategory());
                meal.setDef_quantity(input.getDef_quantity());
                meal.setUnit(input.getUnit());
                meal.setCalories(input.getCalories());
                meal.setDescription(input.getDescription());
                meal.setPicture(input.getPicture());
                
                if(!this.dao.createMeal(meal)){
                    input.setErrorList(new ArrayList<String>());
                    input.getErrorList().add("This meal name already exists.");
                }
                
            } else if(action.equals("read_meal_single")){                
                meal.setId(input.getId());
                
                List<Meal> mealList = this.dao.readMeal(meal, "single");
                
                if(mealList.isEmpty()){
                    input.setErrorList(new ArrayList<String>());
                    input.getErrorList().add("That meal does not exist");
                } else {
                    
                    meal = mealList.get(0);

                    input.setKey(meal.getKey());
                    input.setName(meal.getName());
                    input.setCategory(meal.getCategory());
                    input.setDef_quantity(meal.getDef_quantity());
                    input.setUnit(meal.getUnit());
                    input.setCalories(meal.getCalories());
                    input.setDescription(meal.getDescription());
                    input.setPicture(meal.getPicture());
                }          
                
            } else if(action.equals("update_meal")){
                meal.setId(input.getId());
                meal.setName(input.getName());
                meal.setCategory(input.getCategory());
                meal.setDef_quantity(input.getDef_quantity());
                meal.setUnit(input.getUnit());
                meal.setCalories(input.getCalories());
                meal.setDescription(input.getDescription());
                meal.setPicture(input.getPicture());
                
                input.setErrorList(new ArrayList<String>());
                if(!this.dao.updateMeal(meal)){
                    input.getErrorList().add("An occurred while updating the meal in Datastore");
                }
                
            } else if(action.equals("delete_meal")){
                meal.setId(input.getId());
                
                if(!this.dao.deleteMeal(meal)){
                    input.setErrorList(new ArrayList<String>());
                    input.getErrorList().add("That meal does not exist");
                }
            } 

        return input;
    }
    
    public List<Meal> readAllMeals(){
        List<Meal> mealList = dao.readMeal(null, "all");
                
        return mealList;   
    }

	public JournalDto journal(JournalDto input, String action) {
        Journal journal = new Journal();
        
        if(action.equals("create_journal")) {
        	journal.setJournal_date(input.getJournal_date());
        	journal.setUserKey(input.getUserKey());
        	Journal createJournal = this.dao.createJournal(journal); 
            if(createJournal == null){
                input.setErrorList(new ArrayList<String>());
                input.getErrorList().add("An error occurred while creating a new Journal Entry.");
            } else {
            	input.setId((long) createJournal.getId());
            }
        }else if(action.equals("delete_journal")){
            journal.setId(input.getId());
            
            if(!this.dao.deleteJournal(journal)){
                input.setErrorList(new ArrayList<String>());
                input.getErrorList().add("Journal");
            }
        }else if(action.equals("read_journal")) {
        	journal.setJournal_date(input.getJournal_date());
        	journal.setUserKey(input.getUserKey());
        	Entity readJournal = this.dao.readJournal(journal); 
        	if(readJournal == null) {
                input.setErrorList(new ArrayList<String>());
                input.getErrorList().add("No Records Found.");
        	} else {
        		input.setId((Long) readJournal.getProperty("id"));
        	}
        	
        	
        } 
		return input;
		
	}
	

	   public JournalMealDto journalMeal(JournalMealDto input, String action) {
	        JournalMeal journalMeal = new JournalMeal();
	        if(action.equals("create_journal_meal")) {
	            int checkResult = this.dao.checkJournalTotalCalories(input);
	            boolean checkQuantity = this.dao.checkJournalMealLimit(input.getJournal_id(), input.getQuantity());
	            journalMeal.setJournal_id(input.getJournal_id());
	            journalMeal.setMeal_id(input.getMeal_id());
	            journalMeal.setQuantity(input.getQuantity());
	            if(checkResult >= 0 && checkQuantity) {
    	            JournalMeal createJournalMeal = this.dao.createJournalMeal(journalMeal); 
    	            if(createJournalMeal == null){
    	                input.setErrorList(new ArrayList<String>());
    	                input.getErrorList().add("An error occurred while adding a new meal to journal.");
    	            } else {
    	                input.setId((long) createJournalMeal.getId());
    	            }
	            } else {
	              ArrayList<String> errorList = new ArrayList<String>();
	              if(checkResult <= 0)
	              {
	                  errorList.add("Meal cannot be added. You have reached the daily intake limit of 2000 calories per day.");
	              }
	              
	              if(!checkQuantity)
	              {
	                  errorList.add("You have reached the daily limit of 10 meals, you cannot add anymore meals for today.");
	              }
	              input.setErrorList(errorList);
	            }
	        } else if(action.equals("delete_journal_meal")){
	            journalMeal.setId(input.getId());
	            
	            if(!this.dao.deleteJournalMeal(journalMeal)){
	                input.setErrorList(new ArrayList<String>());
	                input.getErrorList().add("Journal Meal cannot be deleted");
	            }
           } else if(action.equals("update_journal_meal")){
               int checkResult = this.dao.checkUpdateJournalTotalCalories(input);
               boolean checkQuantity = this.dao.checkUpdateJournalMealLimit(input.getJournal_id(), input.getQuantity());
               if(checkResult >= 0 && checkQuantity) {
                    journalMeal.setId(input.getId());
                    journalMeal.setQuantity(input.getQuantity());
                    if(!this.dao.updateJournalMeal(journalMeal)){
                        input.setErrorList(new ArrayList<String>());
                        input.getErrorList().add("Journal Meal cannot be update");
                    }
               } else {
                   ArrayList<String> errorList = new ArrayList<String>();
                   if(checkResult <= 0)
                   {
                       errorList.add("Meal cannot be updated. You will have reached the daily intake limit of 2000 calories per day.");
                   }
                   
                   if(!checkQuantity)
                   {
                       errorList.add("You have reached the daily limit of 10 meals, you cannot update anymore of this meal for today.");
                   }
                   input.setErrorList(errorList);
                 }
            }
	        
	        return input;
	        
	    }
	   
	   public List<Object> scopeJournalMeals(JournalMealDto input) 
	   {   
	       JournalMeal journalMeal = new JournalMeal();
	       journalMeal.setJournal_id(input.getJournal_id());
	       return this.dao.scopeJournalMeal(journalMeal);
	   }
	
    
}
