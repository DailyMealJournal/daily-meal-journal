package project.controller.user_management;

import api.controller.*;
import org.slim3.controller.Navigation;

/**
 * Main Screen Home controller.
 * @author <name here>
 *
 */
public class IndexController extends APIController {
    
    
    @Override
    protected Navigation run() throws Exception {
        
    	requestScope("base_url", getBaseUrl());
        return proceedTo("index.jsp");
    }
}
