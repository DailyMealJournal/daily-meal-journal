package project.controller.journal_meal;

import java.util.Map;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;
import org.slim3.repackaged.org.json.JSONObject;
import org.slim3.util.RequestMap;

import project.dto.MealDto;

public class CreateController extends Controller {

    @Override
    public Navigation run() throws Exception {
    	
    	JSONObject json = new JSONObject();
        //Validators
        Validators v = new Validators(this.request);
        v.add("meal_key", v.required("Please choose a meal"));
        v.add("journal_key", v.required("An Entry is required"));

        
        if (v.validate()) {
            this.requestScope("errors", "");
           json = new JSONObject(new RequestMap(this.request));
           
            MealDto mealDto = new MealDto();
            
            mealDto.setName(input.get("meal_name").toString());

            
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
