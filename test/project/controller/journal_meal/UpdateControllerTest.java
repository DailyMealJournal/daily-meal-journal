package project.controller.journal_meal;

import org.slim3.tester.ControllerTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class UpdateControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        tester.start("/journal_meal.Update");
        UpdateController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is(nullValue()));
    }
}
