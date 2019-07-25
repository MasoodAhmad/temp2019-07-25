package parser1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */


    @Test
    public void test() throws Exception {
        assertEquals(Parse.parseCsv().get("1").getNumberOfOrders(), 4);
    }

}
