package project.controller.meal_journal;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;
import org.slim3.repackaged.org.json.JSONObject;
import org.slim3.util.RequestMap;

import project.dto.JournalDto;
import project.service.ProjectService;

public class DeleteController extends Controller {

    @Override
    public Navigation run() throws Exception {
    	ProjectService service = new ProjectService();
  
    	JournalDto journalVal = null;
        JournalDto journalDto = new JournalDto();
    	JSONObject input = new JSONObject(new RequestMap(this.request));
        JSONObject json = new JSONObject();
        Validators v = new Validators(this.request);
        v.add("journal_id", v.required("Journal ID required"));
        if (v.validate()) {
	        journalDto.setId(Long.valueOf(input.getString("journal_id")));
	        journalVal = service.journal(journalDto, "delete_journal");

			if(journalVal.getErrorList().isEmpty())
	        {
	        	json.put("success", "true");
	        	json.put("journal_id", journalVal.getId());
	        }
	        else
	        {
	        	json.put("errors", journalVal.getErrorList());
	        }
        } else {
            for (int i = 0; i < v.getErrors().size(); i++) {
            	  journalDto.getErrorList().add(v.getErrors().get(i));
            }
            if(journalDto.getErrorList().size() > 0) {
            	json.put("errors", journalDto.getErrorList());
            }
        }

        response.setContentType("application/json");
        response.getWriter().write(json.toString());
        
        return null;
    }
}
