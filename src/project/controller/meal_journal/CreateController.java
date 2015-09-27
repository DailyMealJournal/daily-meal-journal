package project.controller.meal_journal;


import java.util.Map;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;
import org.slim3.repackaged.org.json.JSONObject;
import org.slim3.util.RequestMap;

import project.dto.JournalDto;
import project.service.ProjectService;

public class CreateController extends Controller {
	private ProjectService service = new ProjectService();
    @Override
    public Navigation run() throws Exception {
        JournalDto journalDto = new JournalDto();
        JSONObject json = new JSONObject();
        Validators v = new Validators(this.request);
        v.add("journal_date", v.required("Journal Date required"));
        v.add("user_id", v.required("User Id required"));
        if (v.validate()) {
        	try {
        		JSONObject jsonMap = new JSONObject(new RequestMap(this.request));
	            journalDto.setJournal_date(jsonMap.getString("journal_date"));
	            journalDto.setUserKey(jsonMap.getString("user_id"));
	            journalDto = this.service.journal(journalDto, "create_journal");
	            
	            json.put("success", journalDto.getErrorList());
        	} catch(Exception e) {
        		System.out.print(e);
        	}
        } else {
            for (int i = 0; i < v.getErrors().size(); i++) {
            	  journalDto.getErrorList().add(v.getErrors().get(i));
            }
        }
        if(journalDto.getErrorList().size() > 0) {
        	json.put("errors", journalDto.getErrorList());
        }
        response.setContentType("application/json");
        response.getWriter().write(json.toString());
        return null;
    }
}
