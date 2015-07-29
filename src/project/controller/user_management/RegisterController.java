package project.controller.user_management;

import java.util.Map;

import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;
import org.slim3.util.BeanUtil;
import org.slim3.util.RequestMap;

import project.dto.UserDto;
import project.service.ProjectService;
import api.controller.APIController;


public class RegisterController extends APIController {
    
    private ProjectService service = new ProjectService();
    
    @Override
    protected Navigation run() throws Exception { 
        
        //Validators
        Validators v = new Validators(this.request);
        v.add("username", v.required("Field required"), v.minlength(8, "Must contain at least 8 characters"), v.maxlength(64));
        v.add("password", v.required("Field required"), v.minlength(8, "Must contain at least 8 characters"), v.maxlength(64));
        v.add("conf_password", v.required("Field required"), v.maxlength(64));
        v.add("firstname", v.required("Field required"));
        v.add("lastname", v.required("Field required"));
        
        
        //IF inputs are valid
        if (v.validate()) {
            this.requestScope("errors", "");
            Map<String,Object> input = new RequestMap(this.request);
            UserDto userDto = new UserDto();
            BeanUtil.copy(input, userDto);
            String firstName = service.user(userDto, "create").getFirstname();
            sessionScope("user", firstName);
            return redirect(getBaseUrl() + "meal_journal");
        } else {
            StringBuffer errors = new StringBuffer("Errors: ");
            for (int i = 0; i < v.getErrors().size(); i++) {
                if(i > 0) {
                    errors.append(", ");
                }
                errors.append(v.getErrors().get(i));
            }
            this.requestScope("errors", errors.toString());
            
            return forward("http://localhost:8888/");
        }
    }

}
