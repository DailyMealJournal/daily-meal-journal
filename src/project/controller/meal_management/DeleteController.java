/* ------------------------------------------------------------------------------
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Copyright (C) Rococo Global Technologies, Inc - All Rights Reserved 2015
 * --------------------------------------------------------------------------- */
package project.controller.meal_management;

import java.util.Map;

import org.slim3.controller.Navigation;
import org.slim3.util.RequestMap;

import project.dto.MealDto;
import project.service.ProjectService;
import api.controller.APIController;

/**
 * Main Screen Delete controller.
 * @author <name here>
 *
 */
public class DeleteController extends APIController {

    private ProjectService service = new ProjectService();
    
    
    @Override
    protected Navigation run() throws Exception {
        Map<String,Object> input = new RequestMap(this.request);
        MealDto mealDto = new MealDto();
        mealDto.setId(Long.valueOf(input.get("meal_id").toString()));
        service.meal(mealDto, "delete_meal");
        
        this.requestScope("","");
        
        return proceedTo("index.jsp");
    }

}
