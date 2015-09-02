package project.controller.meal_journal;

import java.util.Map;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;
import org.slim3.util.RequestMap;

import project.dto.JournalDto;
import project.service.ProjectService;

public class CreateController extends Controller {
	private ProjectService service = new ProjectService();
    @Override
    public Navigation run() throws Exception {
        Validators v = new Validators(this.request);
        v.add("journal_date", v.required("Journal Date required"));
        
        if (v.validate()) {
            this.requestScope("errors", "");
            Map<String,Object> input = new RequestMap(this.request);
            System.out.println(input.keySet());
            JournalDto journalDto = new JournalDto();
            
            service.journal(journalDto, "create_journal");
        } else {
            StringBuffer errors = new StringBuffer("Errors: ");
            for (int i = 0; i < v.getErrors().size(); i++) {
                if(i > 0) {
                    errors.append(", ");
                }
                errors.append(v.getErrors().get(i));
            }
            this.requestScope("errors", errors.toString());
            
        }
        
        
        return null;
    }
}
