import static org.junit.Assert.*;
import org.junit.Test;


public class FlikTest {
    @Test
    public void FlikTest() {
        assertEquals(128,128);
        assertFalse(Flik.isSameNumber(128, 128));
        assertTrue(128 == 128);
    }



}
