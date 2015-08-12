/* ------------------------------------------------------------------------------
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Copyright (C) Rococo Global Technologies, Inc - All Rights Reserved 2015
 * --------------------------------------------------------------------------- */
package project.controller.meal_management;

import java.util.Map;

import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;
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

        if (v.validate()) {
            this.requestScope("errors", "");
            Map<String,Object> input = new RequestMap(this.request);
            
            MealDto mealDto = new MealDto();
            
            mealDto.setId(Long.valueOf(input.get("meal_id").toString()));
            mealDto.setName(input.get("meal_name").toString());
            mealDto.setCategory(input.get("meal_category").toString());
            mealDto.setDef_quantity(Integer.valueOf(input.get("meal_defQuantity").toString()));
            mealDto.setUnit(input.get("meal_unit").toString());
            mealDto.setCalories(Integer.valueOf(input.get("meal_calories").toString()));
            mealDto.setDescription(input.get("meal_description").toString());
            mealDto.setPicture(input.get("meal_picture").toString());
            
            service.meal(mealDto, "update_meal");
        } else {
            StringBuffer errors = new StringBuffer("Errors: ");
            for (int i = 0; i < v.getErrors().size(); i++) {
                if(i > 0) {
                    errors.append(", ");
                }
                errors.append(v.getErrors().get(i));
            }
            this.requestScope("errors", errors.toString());
            
        }
        return proceedTo("index.jsp");
    }

}
