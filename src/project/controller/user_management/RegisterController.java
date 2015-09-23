package project.controller.user_management;

import java.util.Map;

import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;
import org.slim3.repackaged.org.json.JSONObject;
import org.slim3.util.BeanUtil;
import org.slim3.util.RequestMap;

import project.dto.UserDto;
import project.service.ProjectService;
import api.controller.APIController;


public class RegisterController extends APIController {
    
    private ProjectService service = new ProjectService();
    
    @Override
    protected Navigation run() throws Exception { 
        
        JSONObject json = new JSONObject();
        response.setContentType("application/json");
        //Validators
        Validators v = new Validators(this.request);
        v.add("username", v.required("Username Required"), v.minlength(6, "Username must contain at least 6 characters"), v.maxlength(64));
        v.add("password", v.required("Password Required"), v.minlength(8, "Password must contain at least 8 characters"), v.maxlength(64));
        v.add("conf_password", v.required("Confirmation Password Required"), v.maxlength(64));
        v.add("firstname", v.required("First Name Required"));
        v.add("lastname", v.required("Last Name Required"));

        //IF inputs are valid
        if (v.validate()) {
            this.requestScope("errors", "");
            Map<String,Object> input = new RequestMap(this.request);
            UserDto userDto = new UserDto();
            BeanUtil.copy(input, userDto);
            UserDto userResult = service.user(userDto, "create");
            if(userResult.getErrorList() != null)
            {
            	json.put("errors", userResult.getErrorList());
            }
        } else {
            JSONObject errors = new JSONObject();
            for (int i = 0; i < v.getErrors().size(); i++) {
                errors.put(v.getErrors().getKey(i), v.getErrors().get(i));
            }
            json.put("errors", errors);
        }
        
        response.getWriter().print(json);
        return null;

    }

}
