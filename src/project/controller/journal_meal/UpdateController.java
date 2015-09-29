package project.controller.journal_meal;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;
import org.slim3.repackaged.org.json.JSONObject;
import org.slim3.util.RequestMap;

import project.dto.JournalMealDto;
import project.service.ProjectService;

public class UpdateController extends Controller {

    @Override
    public Navigation run() throws Exception {
        ProjectService service = new ProjectService();
        JournalMealDto journalVal = null;
        JournalMealDto journalMealDto = new JournalMealDto();
        JSONObject input = new JSONObject(new RequestMap(this.request));
        JSONObject json = new JSONObject();
        Validators v = new Validators(this.request);
        v.add("id", v.required("Journal Meal id Required"));
        v.add("quantity", v.required("Quantity is required"), v.maxlength(10), v.minlength(1));
        v.add("journal_id", v.required("Journal Id Required"));
        if (v.validate()) {
            journalMealDto.setId(Long.valueOf(input.getString("id")));
            journalMealDto.setJournal_id(Long.valueOf(input.getString("journal_id")));
            journalMealDto.setQuantity(Integer.parseInt(input.getString("quantity")));
            journalVal = service.journalMeal(journalMealDto, "update_journal_meal");

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
