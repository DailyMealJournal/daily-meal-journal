/* ------------------------------------------------------------------------------
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Copyright (C) Rococo Global Technologies, Inc - All Rights Reserved 2015
 * --------------------------------------------------------------------------- */
package project.controller.meal_journal;

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
