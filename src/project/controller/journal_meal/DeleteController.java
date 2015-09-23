package project.controller.journal_meal;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;
import org.slim3.repackaged.org.json.JSONObject;
import org.slim3.util.RequestMap;

import project.dto.JournalMealDto;
import project.service.ProjectService;

public class DeleteController extends Controller {

    @Override
    public Navigation run() throws Exception {
        ProjectService service = new ProjectService();
        
        JournalMealDto journalVal = null;
        JournalMealDto journalMealDto = new JournalMealDto();
        JSONObject input = new JSONObject(new RequestMap(this.request));
        JSONObject json = new JSONObject();
        Validators v = new Validators(this.request);
        v.add("id", v.required("Journal Meal id Required"));
        if (v.validate()) {
            journalMealDto.setId(Long.valueOf(input.getString("id")));
            journalVal = service.journalMeal(journalMealDto, "delete_journal_meal");

            if(journalVal.getErrorList().isEmpty())
            {
                json.put("success", "true");
                json.put("id", journalVal.getId());
            }
            else
            {
                json.put("errors", journalVal.getErrorList());
            }
        } else {
            for (int i = 0; i < v.getErrors().size(); i++) {
                  journalMealDto.getErrorList().add(v.getErrors().get(i));
            }
            if(journalMealDto.getErrorList().size() > 0) {
                json.put("errors", journalMealDto.getErrorList());
            }
        }

        response.setContentType("application/json");
        response.getWriter().write(json.toString());
        return null;
    }
}
