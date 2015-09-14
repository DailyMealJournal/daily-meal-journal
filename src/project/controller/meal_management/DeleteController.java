/* ------------------------------------------------------------------------------
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Copyright (C) Rococo Global Technologies, Inc - All Rights Reserved 2015
 * --------------------------------------------------------------------------- */
package project.controller.meal_management;

import org.slim3.controller.Navigation;
import org.slim3.repackaged.org.json.JSONObject;
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
        JSONObject json = null;
        
        try{
            json = new JSONObject(new RequestMap(this.request));
            
            if(json.has("id")){
                MealDto mealDto = new MealDto();
                mealDto.setId(json.getLong("id"));
                service.meal(mealDto, "delete_meal");
            }               
            
        } catch(Exception e){
            e.printStackTrace();
        }
        
        return null;
    }
}
