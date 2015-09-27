package project.controller.user_management;

import java.util.ArrayList;
import java.util.List;

import org.slim3.controller.Navigation;
import org.slim3.repackaged.org.json.JSONObject;
import org.slim3.util.RequestMap;

import project.dto.MealDto;
import project.dto.UserDto;
import project.model.User;
import project.service.ProjectService;
import api.controller.APIController;

public class ReadController extends APIController {
    private ProjectService service = new ProjectService();
    User set = null;    
    protected Navigation run() throws Exception {
        JSONObject json = new JSONObject();

        try{
            json = new JSONObject(new RequestMap(this.request));
            System.out.println("json: " + json);
            
            UserDto userDto = new UserDto();
            
            userDto.setId(json.getLong("id"));
                
            userDto = service.user(userDto, "read_user"); 
            set = new User();

                set.setId(userDto.getId());
                set.setUsername(userDto.getUsername());
                set.setFirstName(userDto.getFirstname());
                set.setLastName(userDto.getLastname());
                set.setPassword(userDto.getPassword());
                             
                json.put("user", set);
        } catch(Exception e){
            e.printStackTrace();
        }
        
        response.setContentType("application/json");
        response.getWriter().write(json.toString());
        return null;
    }
}
