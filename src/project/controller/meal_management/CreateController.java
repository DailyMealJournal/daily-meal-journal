package project.controller.meal_management;

import java.util.List;

import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;
import org.slim3.repackaged.org.json.JSONObject;
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
        v.add("name", v.required("Meal name required"));
        v.add("category", v.required("Meal category required"));
        v.add("def_quantity", v.required("Default quantity required"), v.minlength(1, "At least 1 required"));
        v.add("unit", v.required("Unit required"));
        v.add("calories", v.required("Calories required"), v.minlength(0));
        v.add("description", v.maxlength(300, "Only 300 characters allowed"));
        
        JSONObject json = new JSONObject();
        MealDto mealDto = new MealDto();
        
        if(v.validate()){
            
            try{
                json = new JSONObject(new RequestMap(this.request));
                
                
                
                mealDto.setName(json.getString("name"));
                mealDto.setCategory(json.getString("category"));
                mealDto.setDef_quantity(json.getInt("def_quantity"));
                mealDto.setUnit(json.getString("unit"));
                mealDto.setCalories(json.getInt("calories"));
                mealDto.setDescription(json.getString("description"));
                mealDto.setPicture(json.getString("picture"));
                
                service.meal(mealDto, "create_meal");
                
                StringBuilder sb = new StringBuilder("");
                List<String> errorList = mealDto.getErrorList();
                if(!errorList.isEmpty()){
                    for(int i = 0; i < errorList.size(); i++){
                        sb.append(errorList.get(i) + " ");
                    }
                }
                
                json.put("errors", sb.toString());
                
            } catch(Exception e){
                e.printStackTrace();
            }
        } else{
            System.out.println("Create invalid");
            
            StringBuffer errors = new StringBuffer("Errors: ");
            for (int i = 0; i < v.getErrors().size(); i++) {
                if(i > 0) {
                    errors.append(", ");  
                }
                errors.append(v.getErrors().get(i));
            }
            
            json.put("errors", errors.toString());    
        }

        response.setContentType("application/json");
        response.getWriter().write(json.toString());
        
        return null;
    }

}
