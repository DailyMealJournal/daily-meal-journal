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
        System.out.println("1");    
        System.out.println(Long.valueOf(input.get("id").toString()));
            userDto.setId(Long.valueOf(input.get("id").toString()));

            System.out.println("2");
            Entity userEntity;   
            System.out.println("3");
            userEntity = service.readEntity(userDto);
            System.out.println("4");            
            set = new User();
           
                set.setId((long)userEntity.getProperty("id"));
                System.out.println(set.getId());
                set.setUsername((String) userEntity.getProperty("username"));
                System.out.println(set.getUsername());
                set.setFirstName((String) userEntity.getProperty("firstName"));
                set.setLastName((String) userEntity.getProperty("lastName"));
                set.setPassword((String) userEntity.getProperty("password"));
                           

        } catch(Exception e){
            e.printStackTrace();
        }
        json.put("id", set.getId());        
        json.put("username", set.getUsername());
        json.put("firstName", set.getFirstName());        
        json.put("lastName", set.getLastName());
        json.put("password", set.getPassword());        
        response.setContentType("application/json");
        response.getWriter().write(json.toString());
        sessionScope("user", setSession(json));
        return null;
    }
}
