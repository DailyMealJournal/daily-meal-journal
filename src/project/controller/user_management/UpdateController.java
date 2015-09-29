package project.controller.user_management;

import java.util.Map;

import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;
import org.slim3.repackaged.org.json.JSONObject;
import org.slim3.util.BeanUtil;
import org.slim3.util.RequestMap;

import project.dto.MealDto;
import project.dto.UserDto;
import project.service.ProjectService;
import api.controller.APIController;

public class UpdateController extends APIController {

    private ProjectService service = new ProjectService();
    
    @Override
    protected Navigation run() throws Exception {
      //Validators
        Validators v = new Validators(this.request);
        v.add("username", v.required("Username Required"), v.minlength(6, "Username must contain at least 6 characters"), v.maxlength(64));
        v.add("password", v.required("Password Required"), v.minlength(8, "Password must contain at least 8 characters"), v.maxlength(64));
        v.add("firstname", v.required("First Name Required"));
        v.add("lastname", v.required("Last Name Required"));

        System.out.println("User_Management, Update Controller enter");
        
        JSONObject json = new JSONObject();
        StringBuffer errors = new StringBuffer("");
        
        if (v.validate()) {
            Map<String,Object> input = new RequestMap(this.request);
            
            UserDto userDto = new UserDto();

            userDto.setId(Long.valueOf(input.get("id").toString()));
            userDto.setUsername(input.get("username").toString());
            userDto.setFirstName(input.get("firstname").toString());
            userDto.setLastName(input.get("lastname").toString());
            userDto.setPassword(input.get("password").toString());
            

            if(service.user(userDto, "update_user") != null) {
                json = new JSONObject(service.getEntity(userDto));
                sessionScope("user", setSession(json));
            }
            
        } else {
            errors.append("Errors: ");
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
