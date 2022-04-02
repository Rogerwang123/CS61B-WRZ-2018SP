import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayDequeTest {

    @Test
    public void addTest() {
        ArrayDeque<String> itemTest = new ArrayDeque<>();

        // isEmpty()
        assertTrue(itemTest.isEmpty());

        // size()
        itemTest.addFirst("1");
        assertEquals(1, itemTest.size());


        itemTest.addLast("4");


    }



}
