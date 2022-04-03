import org.junit.Test;

public class LLDTestUltra {

    @Test
    public void getRecursive() {
        LinkedListDeque<Integer> itemTest = new LinkedListDeque<>();
        itemTest.addLast(0);
        int out1 = itemTest.removeFirst();
        itemTest.addFirst(2);
        itemTest.addFirst(4);
        itemTest.addLast(3);
        int out2 = itemTest.getRecursive(1); // 4 2 3
    }
}
