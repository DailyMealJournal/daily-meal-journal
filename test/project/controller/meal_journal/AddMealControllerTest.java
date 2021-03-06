package project.controller.meal_journal;

import org.slim3.tester.ControllerTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class AddMealControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        tester.start("/meal_journal.AddMeal");
        AddMealController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is("/meal_journal.AddMeal.jsp"));
    }
}
