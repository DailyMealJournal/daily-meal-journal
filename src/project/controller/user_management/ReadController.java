package project.controller.user_management;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slim3.controller.Navigation;
import org.slim3.repackaged.org.json.JSONObject;
import org.slim3.util.RequestMap;

import com.google.appengine.api.datastore.Entity;

import project.dto.MealDto;
import project.dto.UserDto;
import project.model.User;
import project.service.ProjectService;
import api.controller.APIController;

public class ReadController extends APIController {
	
    
    private ProjectService service = new ProjectService();
    User set = null;    
    protected Navigation run() throws Exception {
        UserDto user= new UserDto();
    	JSONObject json = new JSONObject();

        try{

            Map<String,Object> input = new RequestMap(this.request);

            
            UserDto userDto = new UserDto();

            userDto.setId(Long.valueOf(input.get("id").toString()));

            Entity userEntity;   
            userEntity = service.readEntity(userDto);  
            if(userEntity != null)
            {
                
                json = new JSONObject(userEntity);
                
                sessionScope("user", setSession(json));
            }
            else
            {
                json.put("errors", "User does not exist");
            }
                           

        } catch(Exception e){
            e.printStackTrace();
        }        
        response.setContentType("application/json");
        response.getWriter().write(json.toString());
    
        return null;
    }
}
