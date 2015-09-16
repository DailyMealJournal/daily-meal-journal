package project.controller;

import org.slim3.tester.ControllerTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class Accout_managementControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        tester.start("/accout_management");
        Accout_managementController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is("/accout_management.jsp"));
    }
}
