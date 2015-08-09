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

        JSONObject json = null;
        JSONObject error = null;
        try {
                Map<String,Object> input = new RequestMap(this.request);
                BeanUtil.copy(input, userDto);
                json = new JSONObject(userDto);
                Entity user = service.getEntity(userDto);
                if(user == null) {
                    error = new JSONObject();
                    error.put("message","Invalid Username and/or Password");
                    error.put("code", "1001");
                }
        } catch (Exception e) {
            error = new JSONObject();
            error.put("message","Error");
            error.put("code", "1002");
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
            sessionScope("user", "duh");
            System.out.println("LoginController");
        }
        
        return null;
    }

}
