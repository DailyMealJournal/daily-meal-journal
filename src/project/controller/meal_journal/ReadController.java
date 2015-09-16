package project.controller.meal_journal;

import java.util.ArrayList;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.repackaged.org.json.JSONObject;
import org.slim3.util.RequestMap;

import project.dto.JournalDto;
import project.dto.MealDto;
import project.model.Meal;
import project.service.ProjectService;

public class ReadController extends Controller {
	private ProjectService service = new ProjectService();
	
    @Override
    public Navigation run() throws Exception {	
        JSONObject json = new JSONObject();
        JournalDto journalDto = new JournalDto();

        try{
    		JSONObject jsonMap = new JSONObject(new RequestMap(this.request));
            journalDto.setJournal_date(jsonMap.getString("journal_date"));
            journalDto.setUserKey(jsonMap.getString("user_id"));
            
            JournalDto journalVal = service.journal(journalDto, "read_journal");
            
            if(journalVal.getErrorList().isEmpty())
            {
            	json.put("success", "true");
            }
            else
            {
            	json.put("errors", journalVal.getErrorList());
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        
        response.setContentType("application/json");
        response.getWriter().write(json.toString());
        return null;
    }
}

