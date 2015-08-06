package project.controller.user_management;

import org.slim3.controller.Navigation;

import api.controller.APIController;

import project.service.ProjectService;


public class LogoutController extends APIController {
    private ProjectService service = new ProjectService();
    
    @Override
    protected Navigation run() throws Exception {
        sessionScope("user", null);
        return redirect(getBaseUrl());
    }

}
