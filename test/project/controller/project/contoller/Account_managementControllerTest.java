package project.controller.project.contoller;

import org.slim3.tester.ControllerTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class Account_managementControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        tester.start("/project.contoller.account_management");
        Account_managementController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is(nullValue()));
    }
}
