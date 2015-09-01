package project.controller.user_management;

import org.slim3.controller.Navigation;

import project.service.ProjectService;
import api.controller.APIController;


public class LogoutController extends APIController {
    private ProjectService service = new ProjectService();
    
    @Override
    protected Navigation run() throws Exception {
        sessionScope("user", null);
        return redirect(getBaseUrl());
    }

}
