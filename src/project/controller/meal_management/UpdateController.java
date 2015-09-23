/* ------------------------------------------------------------------------------
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Copyright (C) Rococo Global Technologies, Inc - All Rights Reserved 2015
 * --------------------------------------------------------------------------- */
package project.controller.meal_management;

import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;
import org.slim3.repackaged.org.json.JSONObject;
import org.slim3.util.RequestMap;

import project.dto.MealDto;
import project.service.ProjectService;
import api.controller.APIController;

/**
 * Main Screen Update controller.
 * @author <name here>
 *
 */
public class UpdateController extends APIController {

    private ProjectService service = new ProjectService();
    
    @Override
    protected Navigation run() throws Exception {
      //Validators
        Validators v = new Validators(this.request);
        v.add("name", v.required("Meal name required"));
        v.add("category", v.required("Meal category required"));
        v.add("def_quantity", v.required("Default quantity required"), v.minlength(1, "At least 1 required"));
        v.add("unit", v.required("Unit required"));
        v.add("calories", v.required("Calories required"), v.minlength(0));
        v.add("description", v.maxlength(300, "Only 300 characters allowed"));
        
        JSONObject json = null;

        if (v.validate()) {
            System.out.println("Update valid");
            
            try{
                json = new JSONObject(new RequestMap(this.request));
                
                MealDto mealDto = new MealDto();
                
                mealDto.setId(json.getLong("id"));
                mealDto.setName(json.getString("name"));
                mealDto.setCategory(json.getString("category"));
                mealDto.setDef_quantity(json.getInt("def_quantity"));
                mealDto.setUnit(json.getString("unit"));
                mealDto.setCalories(json.getInt("calories"));
                mealDto.setDescription(json.getString("description"));
                mealDto.setPicture(json.getString("picture"));
                
                service.meal(mealDto, "update_meal");
                
                json.put("errors","");

            } catch(Exception e){
                e.printStackTrace();
            }
            
//            this.requestScope("errors", "");
//            Map<String,Object> input = new RequestMap(this.request);
//            
//            MealDto mealDto = new MealDto();
//            
//            mealDto.setId(Long.valueOf(input.get("meal_id").toString()));
//            mealDto.setName(input.get("meal_name").toString());
//            mealDto.setCategory(input.get("meal_category").toString());
//            mealDto.setDef_quantity(Integer.valueOf(input.get("meal_defQuantity").toString()));
//            mealDto.setUnit(input.get("meal_unit").toString());
//            mealDto.setCalories(Integer.valueOf(input.get("meal_calories").toString()));
//            mealDto.setDescription(input.get("meal_description").toString());
//            mealDto.setPicture(input.get("meal_picture").toString());
//            
//            service.meal(mealDto, "update_meal");
        } else {
            System.out.println("Update invalid");
            
            StringBuffer errors = new StringBuffer("Errors: ");
            for (int i = 0; i < v.getErrors().size(); i++) {
                if(i > 0) {
                    errors.append(", ");
                }
                errors.append(v.getErrors().get(i));
            }
            
            json = new JSONObject();
            json.put("errors", errors.toString());    
        }
        
        response.setContentType("application/json");
        response.getWriter().write(json.toString());
        
        return null;
    }

}
