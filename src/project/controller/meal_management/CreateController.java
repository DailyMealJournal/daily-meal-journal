package project.controller.meal_management;

import java.util.Map;

import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;
import org.slim3.util.BeanUtil;
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

        if (v.validate()) {
            this.requestScope("errors", "");
            Map<String,Object> input = new RequestMap(this.request);
            MealDto mealDto = new MealDto();
            BeanUtil.copy(input, mealDto);
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
