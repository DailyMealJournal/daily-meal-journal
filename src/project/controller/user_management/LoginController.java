package project.controller.user_management;

import java.util.Map;

import org.slim3.controller.Navigation;
import org.slim3.util.BeanUtil;
import org.slim3.util.RequestMap;

import com.google.appengine.api.datastore.Entity;

import api.controller.APIController;
import project.dto.UserDto;
import project.service.ProjectService;


public class LoginController extends APIController {
    private ProjectService service = new ProjectService();
    
    @Override
    protected Navigation run() throws Exception {
        UserDto userDto = new UserDto();
        Map<String,Object> input = new RequestMap(this.request);
        BeanUtil.copy(input, userDto);
        Entity user = service.getEntity(userDto);
        if(user != null) {
            sessionScope("user", user);
        }
        return redirect(getBaseUrl() + "meal_journal");
    }

}
