package project.controller.journal_meal;

import java.util.List;

import org.slim3.controller.Navigation;
import org.slim3.repackaged.org.json.JSONObject;
import org.slim3.util.RequestMap;

import api.controller.APIController;
import project.dto.JournalMealDto;
import project.model.JournalMeal;
import project.model.Meal;
import project.service.ProjectService;


public class ScopeJournalController extends APIController {
    private ProjectService service = new ProjectService();
    public Navigation run() throws Exception {
    	
        JSONObject json = new JSONObject();
        JournalMealDto journalMealDto = new JournalMealDto();

        try{
            JSONObject jsonMap = new JSONObject(new RequestMap(this.request));
            journalMealDto.setJournal_id(Long.parseLong(jsonMap.getString("journal_id")));
            
            List<Object> journalMealList = service.scopeJournalMeals(journalMealDto);
            
            if(!journalMealList.isEmpty())
            {
                json.put("success", "true");
                json.put("journalMealList", journalMealList);
            }
            else
            {
                json.put("errors", "No record   s found.");
            }
        } catch(Exception e){
            e.printStackTrace();
        }
            
        response.setContentType("application/json");
        response.getWriter().write(json.toString());
        return null;
    }
}
