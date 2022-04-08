import static org.junit.Assert.*;
import org.junit.Test;


public class TestArrayDequeGold {

    @Test
    public void test1() {
        StudentArrayDeque<Integer> sad = new StudentArrayDeque();
        ArrayDequeSolution<Integer> ads = new ArrayDequeSolution();
        String log = "";
        int i = 0;
        // define what we add
        while (i < 500) {
            i += 1;
            int index = 0; // the pointer to the next place we add number, add itself after when checking
            Integer addedNum = StdRandom.uniform(500);

            // to addFirst: 0, to addLast: 1
            // to removeFirst: 2, to removeLast: 3
            int numberBetweenZeroAndOne = StdRandom.uniform(4);
            // as only the 4 methods above occur mistakes, get method works entirely
            // for each remove case, the size should not 0
            switch (numberBetweenZeroAndOne) {
                case (0):
                    sad.addFirst(addedNum);
                    ads.addFirst(addedNum);
                    log = log + "addFirst(" + addedNum + ")\n";
                    assertEquals(log, ads.get(index), sad.get(index));
                    index += 1;
                    break;
                case (1):
                    sad.addLast(addedNum);
                    ads.addLast(addedNum);
                    log = log + "addLast(" + addedNum + ")\n";
                    assertEquals(log, ads.get(index), sad.get(index));
                    index += 1;
                    break;
                case (2):
                    if (sad.isEmpty()) {
                        break;
                    }
                    Integer sadRemove = sad.removeFirst();
                    Integer adsRemove = ads.removeFirst();
                    log = log + "removeFirst()\n";
                    assertEquals(log, adsRemove, sadRemove);
                    index -= 1;
                    break;
                case (3):
                    if (sad.isEmpty()) {
                        break;
                    }
                    Integer sadRemove2 = sad.removeFirst();
                    Integer adsRemove2 = ads.removeFirst();
                    log = log + "removeFirst()\n";
                    assertEquals(log, adsRemove2, sadRemove2);
                    index -= 1;
                    break;
            }

        }
    }
}
