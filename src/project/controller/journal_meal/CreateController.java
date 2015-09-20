package project.controller.journal_meal;

import java.util.Map;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;
import org.slim3.repackaged.org.json.JSONObject;
import org.slim3.util.RequestMap;

import project.dto.JournalMealDto;
import project.dto.MealDto;
import project.service.ProjectService;

public class CreateController extends Controller {

    @Override
    public Navigation run() throws Exception {
        ProjectService service = new ProjectService();
    	JSONObject json = new JSONObject();
        JournalMealDto journalMeal = new JournalMealDto();
        //Validators
        Validators v = new Validators(this.request);
        v.add("meal_id", v.required("Please choose a meal"));
        v.add("journal_id", v.required("An Entry is required"));
        
        
        if (v.validate()) {
           json = new JSONObject(new RequestMap(this.request));
           

            
            journalMeal.setMeal_id(json.getLong("meal_id"));
            journalMeal.setJournal_id(json.getLong("journal_id"));
            
            journalMeal = service.journalMeal(journalMeal, "create_journal_meal");
            
            if(journalMeal.getErrorList().isEmpty())
            {
                json.put("success", true);
            }
                
        } else {
            for (int i = 0; i < v.getErrors().size(); i++) {
                journalMeal.getErrorList().add(v.getErrors().get(i));
          }
        }
        
        if(!journalMeal.getErrorList().isEmpty())
        {
            json.put("errors", journalMeal.getErrorList());
        }
        response.setContentType("application/json");
        response.getWriter().write(json.toString());
        return null;
    }
}
