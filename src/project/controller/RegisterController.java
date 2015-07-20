package project.controller;

import java.util.List;
import java.util.Map;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;
import org.slim3.util.BeanUtil;
import org.slim3.util.RequestMap;

import project.dto.UserDto;
import project.model.User;
import project.service.ProjectService;


public class RegisterController extends Controller {
    
    private ProjectService service = new ProjectService();

    @Override
    protected Navigation run() throws Exception {        
      //Validators
        Validators v = new Validators(this.request);
        v.add("username", v.required(), v.minlength(8), v.maxlength(64));
        v.add("password", v.required(), v.minlength(8), v.maxlength(64));
        v.add("conf_password", v.required(), v.minlength(8), v.maxlength(64));
        v.add("firstname", v.required());
        v.add("lastname", v.required());
        
        //IF inputs are valid
        if (v.validate()) {
            this.requestScope("errors", "");
            Map<String,Object> input = new RequestMap(this.request);
            UserDto userDto = new UserDto();
            BeanUtil.copy(input, userDto);
            service.user(userDto, "create");
            return redirect(this.basePath);
        }else {
            StringBuffer errors = new StringBuffer("Errors: ");
            for (int i = 0; i < v.getErrors().size(); i++) {
                if(i > 0) {
                    errors.append(", ");
                }
                errors.append(v.getErrors().get(i));
            }
            this.requestScope("errors", errors.toString());
            //reload tweets
            List<User> userList = service.getUserList();
            requestScope("UserList", userList);
            return forward("meal_management/index.jsp");
        }
    }

}
