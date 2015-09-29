package project.model;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class User_testTest extends AppEngineTestCase {

    private User_test model = new User_test();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
