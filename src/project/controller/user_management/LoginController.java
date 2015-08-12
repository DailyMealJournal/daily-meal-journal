package project.controller.user_management;


import java.util.Map;

import org.slim3.controller.Navigation;
import org.slim3.repackaged.org.json.JSONObject;
import org.slim3.util.BeanUtil;
import org.slim3.util.RequestMap;

import project.dto.UserDto;
import project.service.ProjectService;
import api.controller.APIController;

import com.google.appengine.api.datastore.Entity;


public class LoginController extends APIController {
    private ProjectService service = new ProjectService();
    
    @Override
    protected Navigation run() throws Exception {
        UserDto userDto = new UserDto();
        sessionScope("user", null);
        JSONObject json = null;
        JSONObject error = null;
        try {
                Map<String,Object> input = new RequestMap(this.request);
                BeanUtil.copy(input, userDto);
                Entity user = service.getEntity(userDto);
                json = new JSONObject(user);
                if(user == null) {
                    error = new JSONObject();
                    error.put("message","Invalid Username and/or Password");
                    error.put("code", "1001");
                }
        } catch (Exception e) {
            error = new JSONObject();
            error.put("message","Invalid Username and/or Password");
            error.put("code", "1001");
            if(json == null) {
                json = new JSONObject();
            }
        }
        
        response.setContentType("application/json");
        if(error != null) {
            response.setStatus(response.SC_NOT_ACCEPTABLE);
            response.getWriter().print(error);
        } else {
            response.getWriter().print(json);
<<<<<<< HEAD
<<<<<<< HEAD
            sessionScope("user", "duh");
            System.out.println("LoginController");
=======
            sessionScope("user", setSession(json));
>>>>>>> 4aab2f354e80f792f32ac5dfeef6b18a7db51131
=======
            sessionScope("user", setSession(json));
>>>>>>> 4aab2f354e80f792f32ac5dfeef6b18a7db51131
        }
        
        return null;
    }

}
