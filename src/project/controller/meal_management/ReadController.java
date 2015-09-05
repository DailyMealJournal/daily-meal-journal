package project.controller.meal_management;

import java.util.ArrayList;
import java.util.List;

import org.slim3.controller.Navigation;
import org.slim3.repackaged.org.json.JSONObject;
import org.slim3.util.RequestMap;

import project.dto.MealDto;
import project.model.Meal;
import project.service.ProjectService;
import api.controller.APIController;

public class ReadController extends APIController {
    
    private ProjectService service = new ProjectService();
    private List<Meal> mealList = null;
    
    protected Navigation run() throws Exception {
        JSONObject json = new JSONObject();

        try{
            json = new JSONObject(new RequestMap(this.request));
            System.out.println(json.toString());
            
            if(json.getString("selection").equals("all")){
                mealList = service.readAllMeals();
                System.out.println("mealList size: " + mealList.size());
                
                json.put("mealList", mealList);
            } else if(json.getString("selection").equals("single")){
                MealDto input = new MealDto();
                input.setId(json.getLong("id"));
                
                input = service.meal(input, "read_meal_single"); 
                
                mealList = new ArrayList<Meal>();
                
                Meal set = new Meal();

                set.setId(input.getId());
                set.setName(input.getName());
                set.setCategory(input.getCategory());
                set.setUnit(input.getUnit());
                set.setDef_quantity(input.getDef_quantity());
                set.setCalories(input.getCalories());
                set.setDescription(input.getDescription());
                set.setPicture(input.getPicture());
                
                mealList.add(set);                
                
                json.put("meal", mealList);
            }
            
        } catch(Exception e){
            e.printStackTrace();
        }
        
        response.setContentType("application/json");
        response.getWriter().write(json.toString());
        return null;
    }
}




