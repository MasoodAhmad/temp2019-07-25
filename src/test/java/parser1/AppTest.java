package parser1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class AppTest {

    @Test
    public void test() throws Exception {
        assertEquals(Parse.parseCsv().get("1").getNumberOfOrders(), 4);
        assertEquals(Parse.parseCsv().get("5").getNumberOfPendingTypes().getManagerTask(), 1);
        //similar tests can be added.
    }

}
