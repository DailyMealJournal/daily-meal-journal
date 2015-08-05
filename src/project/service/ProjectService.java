/* ------------------------------------------------------------------------------
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Copyright (C) Rococo Global Technologies, Inc - All Rights Reserved 2015
 * --------------------------------------------------------------------------- */
package project.service;

import java.util.ArrayList;
import java.util.List;

import com.google.appengine.api.datastore.Entity;

import project.dao.ProjectDao;
import project.dto.FoodDto;
import project.dto.MealDto;
import project.dto.UserDto;
import project.model.Food;
import project.model.FoodInfo;
import project.model.Meal;
import project.model.User;

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
                input.getErrorList().add("error!");
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
    
    /*public FoodDto food(FoodDto input, String action){
        Food food = new Food();
        FoodInfo foodInfo = new FoodInfo();
        
        if(action.equals("create_food")){
            food.setName(input.getName());
            food.setCategory(input.getCategory());
            food.setDescription(input.getDescription());
            food.setPicture(input.getPicture());
                        
            if(!this.dao.createFood(food)){
                input.setErrorList(new ArrayList<String>());
                input.getErrorList().add("error!");
            }
        } else if(action.equals("create_info")){
            food.setName(input.getName());
            food.setCategory(input.getCategory());
            foodInfo.setCalories(input.getCalorie());
            foodInfo.setUnit(input.getUnit());
           
            
            if(!this.dao.createFoodInfo(food, foodInfo)){
                input.setErrorList(new ArrayList<String>());
                input.getErrorList().add("error!");
            }
        }
        
        return input;
    }*/
    
    public MealDto meal(MealDto input, String action){
        Meal meal = new Meal();
        
            if(action.equals("create_meal")){
                meal.setName(input.getName());
                meal.setDef_quantity(input.getDef_quantity());
                meal.setUnit(input.getUnit());
                meal.setCalories(input.getCalories());
                meal.setDescription(input.getDescription());
                meal.setPicture(input.getPicture());
                
                if(!this.dao.createMeal(meal)){
                    input.setErrorList(new ArrayList<String>());
                    input.getErrorList().add("error!");
                }
                
            } else if(action.equals("delete_meal")){
                meal.setName(input.getName());
                meal.setDef_quantity(input.getDef_quantity());
                meal.setUnit(input.getUnit());
                meal.setCalories(input.getCalories());
                meal.setDescription(input.getDescription());
                meal.setPicture(input.getPicture());
                
                if(!this.dao.deleteMeal(meal)){
                    input.setErrorList(new ArrayList<String>());
                    input.getErrorList().add("error!");
                }
                
            } else if(action.equals("update_meal")){
                meal.setName(input.getName());
                meal.setDef_quantity(input.getDef_quantity());
                meal.setUnit(input.getUnit());
                meal.setCalories(input.getCalories());
                meal.setDescription(input.getDescription());
                meal.setPicture(input.getPicture());
                
                if(!this.dao.updateMeal(meal)){
                    input.setErrorList(new ArrayList<String>());
                    input.getErrorList().add("error!");
                }
                
            }
            
            
        
        return input;
    }
    
}
