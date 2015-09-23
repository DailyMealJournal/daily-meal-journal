package project.model;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class JournalMealTest extends AppEngineTestCase {

    private JournalMeal model = new JournalMeal();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
