package project.controller.meal_management;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slim3.controller.Navigation;
import org.slim3.repackaged.org.json.JSONArray;
import org.slim3.repackaged.org.json.JSONObject;
import org.slim3.util.BeanUtil;

import project.dto.MealDto;
import project.model.Meal;
import project.service.ProjectService;
import api.controller.APIController;

public class ReadController extends APIController {
    
    private ProjectService service = new ProjectService();
    private List<Meal> mealList = null;
    
    protected Navigation run() throws Exception {
        JSONObject json = null;

        try{
            json = new JSONObject((String)this.requestScope("data"));
            
            if(json.getString("selection").equals("all")){
                mealList = service.readAllMeals();
                json.put("mealList", mealList);
            }
            else if(json.getString("selection").equals("single")){
//                System.out.println("1) ReadController, single");
                
                MealDto input = new MealDto();
                input.setId(json.getLong("id"));
                
//                System.out.println("2) " + input.getId());
                
                input = service.meal(input, "read_meal_single"); 
                
                mealList = new ArrayList<Meal>();
                
//                System.out.println("9) MealDto input status: ");
                
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
                
//                System.out.println("10) ReadController, Meal set values OK");
                
                
                json.put("meal", mealList);
                
//                System.out.println("11) JSON object: " + json.toString(3));
            }
            
        } catch(Exception e){
            
        }
        
        response.setContentType("application/json");
        response.getWriter().write(json.toString());
        return null;
    }
}




