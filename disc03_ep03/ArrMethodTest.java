import static org.junit.Assert.*;

import org.junit.Test;


public class ArrMethodTest {

    @Test
    public void reverseTest() {
        int[] A = new int[]{2, 3, 4, 22, 43, 5};
        int[] exp = new int[]{5, 43, 22, 4, 3, 2};
        ArrMethod.reverseArr(A);
        assertArrayEquals(exp, A);
    }

    @Test
    public void insertTest() {
        int[] x = new int[]{2, 4, 2, 2};
        int[] y = ArrMethod.insertarr(x, 33, 2);
        int[] yExp = new int[]{2, 4, 33, 2, 2};
        int[] z = ArrMethod.insertarr(x, 33, 6);
        int[] zExp = new int[]{2, 4, 2, 2, 33};
        assertArrayEquals(yExp, y);
        assertArrayEquals(zExp, z);
    }

    @Test
    public void replicateTest() {
        int[] x = new int[]{2, 4, 1};
        int[] xExp = new int[]{2, 2, 4, 4, 4, 4, 1};
        int[] y = new int[]{3, 2};
        int[] yExp = new int[]{3, 3, 3, 2, 2};
        assertArrayEquals(xExp, ArrMethod.replicate(x));
        assertArrayEquals(yExp, ArrMethod.replicate(y));
    }

    @Test
    public void flattenTest() {
        int[][] x = new int[][]{{1, 2, 3}, {}, {7, 8}};
        int[] xExp = new int[]{1, 2, 3, 7, 8};
        int[][] y = new int[][]{{3, 4, 3, 5}, {1, 2, 4}, {}, {}, {5, 13}};
        int[] yExp = new int[]{3, 4, 3, 5, 1, 2, 4, 5, 13};
        assertArrayEquals(xExp, ArrMethod.flatten(x));
        assertArrayEquals(yExp, ArrMethod.flatten(y));
    }
}

