package project.controller.meal_management;

import java.util.Map;

import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;
import org.slim3.util.RequestMap;

import project.dto.MealDto;
import project.service.ProjectService;
import api.controller.APIController;

/**
 * Main Screen Add controller.
 * @author <name here>
 *
 */
public class CreateController extends APIController {
    
    private ProjectService service = new ProjectService();
    
    @Override
    protected Navigation run() throws Exception {
        //Validators
        Validators v = new Validators(this.request);
        v.add("meal_name", v.required("Meal name required"));
        v.add("meal_category", v.required("Meal category required"));
        v.add("meal_defQuantity", v.required("Default quantity required"), v.minlength(1, "At least 1 required"));
        v.add("meal_unit", v.required("Unit required"));
        v.add("meal_calories", v.required("Calories required"), v.minlength(0));
        v.add("meal_description", v.maxlength(300, "Only 300 characters allowed"));
        v.add("meal_picture");
        
        if (v.validate()) {
            this.requestScope("errors", "");
            Map<String,Object> input = new RequestMap(this.request);
            System.out.println(input.keySet());
            MealDto mealDto = new MealDto();
            
            mealDto.setName(input.get("meal_name").toString());
            mealDto.setCategory(input.get("meal_category").toString());
            mealDto.setDef_quantity(Integer.valueOf(input.get("meal_defQuantity").toString()));
            mealDto.setUnit(input.get("meal_unit").toString());
            mealDto.setCalories(Integer.valueOf(input.get("meal_calories").toString()));
            mealDto.setDescription(input.get("meal_description").toString());
            mealDto.setPicture(input.get("meal_picture").toString());
            
            service.meal(mealDto, "create_meal");
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
        return null;
    }

}
