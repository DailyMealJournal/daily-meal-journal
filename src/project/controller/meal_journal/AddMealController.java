package project.controller.meal_journal;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class AddMealController extends Controller {

    @Override
    public Navigation run() throws Exception {
        return forward("meal_journal.AddMeal.jsp");
    }
}
