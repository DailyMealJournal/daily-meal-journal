package project.controller.meal_management;

import java.util.List;

import org.slim3.controller.Navigation;
import org.slim3.repackaged.org.json.JSONObject;

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
            }
            
        } catch(Exception e){
            
        }
        
        /*for(Meal meal : mealList){
            System.out.println("ReadController (Key): " + meal.getKey().toString());
        }*/
        
        json.put("mealList", mealList);
        
        response.setContentType("application/json");
        response.getWriter().write(json.toString());
        return null;
    }
}




