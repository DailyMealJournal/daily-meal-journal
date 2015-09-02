package project.controller.meal_journal;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.repackaged.org.json.JSONObject;
import org.slim3.util.RequestMap;

import project.dto.JournalDto;
import project.service.ProjectService;

public class DeleteController extends Controller {

    @Override
    public Navigation run() throws Exception {
    	ProjectService service = new ProjectService();
    	
    	JSONObject input = new JSONObject(new RequestMap(this.request));
        JournalDto journalDto = new JournalDto();
        journalDto.setId(Long.valueOf(input.getString("journal_id")));
        service.journal(journalDto, "delete_meal");
        return null;
    }
}
