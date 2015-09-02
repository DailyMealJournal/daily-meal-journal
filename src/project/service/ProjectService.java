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
import project.dto.MealDto;
import project.dto.UserDto;
import project.model.Journal;
import project.model.Meal;
import project.model.User;

import com.google.appengine.api.datastore.Entity;

public class ProjectService {
    ProjectDao dao = new ProjectDao();
    
    public UserDto user(UserDto input, String action){
        User user = new User();
        if(action.equals("create")){
            user.setUsername(input.getUsername());
            user.setPassword(input.getPassword());
            user.setFirstName(input.getFirstname());
            user.setLastName(input.getLastname());
            
            if(!this.dao.createUser(user)){
                input.setErrorList(new ArrayList<String>());
                input.getErrorList().add("Username has already been taken.");
            }
        } 
        
        return input;
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
                    input.getErrorList().add("An error occurred while adding the meal to Datastore");
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
                
                System.out.println("\n\nProjectService, updateMeal" + meal.toString());
                
                if(!this.dao.updateMeal(meal)){
                    input.setErrorList(new ArrayList<String>());
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
            if(!this.dao.createJournal(journal)){
                input.setErrorList(new ArrayList<String>());
                input.getErrorList().add("An error occurred while creating a new Journal Entry.");
            }
        }else if(action.equals("delete_meal")){
            journal.setId(input.getId());
            
            if(!this.dao.deleteJournal(journal)){
                input.setErrorList(new ArrayList<String>());
                input.getErrorList().add("Journal");
            }
        } 
		return input;
		
	}
    
}
