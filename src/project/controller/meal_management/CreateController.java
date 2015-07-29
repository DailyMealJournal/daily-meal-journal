package project.controller.meal_management;

import api.controller.*;
import project.dto.MealDto;
import project.dto.UserDto;
import project.service.ProjectService;

import java.util.Map;

import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;
import org.slim3.util.BeanUtil;
import org.slim3.util.RequestMap;

/**
 * Main Screen Add controller.
 * @author <name here>
 *
 */
public class CreateController extends APIController {
    
    private ProjectService service = new ProjectService();
    @Override
    protected Navigation run() throws Exception {
        // TODO Auto-generated method stub
        //Validators
        Validators v = new Validators(this.request);
        


        if (v.validate()) {
            this.requestScope("errors", "");
            Map<String,Object> input = new RequestMap(this.request);
            MealDto mealDto = new MealDto();
            BeanUtil.copy(input, mealDto);
            System.out.println("BOOO");
            service.meal(mealDto, "create");
            System.out.println(input);
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
