import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayDequeTest {

    @Test
    public void addTest() {
        ArrayDeque<Integer> itemTest = new ArrayDeque<>();

        // isEmpty()
        assertTrue(itemTest.isEmpty());

        // size()
        itemTest.addLast(2);
        itemTest.addFirst(1);
        itemTest.addLast(2);
        itemTest.addLast(3);
        itemTest.addFirst(4);

        itemTest.addLast(5);
        itemTest.addLast(6);
        itemTest.addFirst(7);
        itemTest.addLast(8);
        itemTest.addLast(9);
        for (int i = 0; i < 8; i++) {
            itemTest.removeFirst();
        }
        /**
        System.out.println(itemTest.get(3));
        System.out.println(itemTest.get(5));
         */
    }



}
