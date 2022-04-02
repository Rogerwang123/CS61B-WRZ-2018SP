import java.util.Arrays;

/** The questions on discussion 3
 *  There is another file used to test the method compiled in this file.
 */
public class ArrMethod {
    //disc03 Q2.1
    public static int[] insertarr(int[] arr, int item, int position) {
        int[] NewArr = new int[arr.length + 1];
        position = Math.min(position, arr.length);
        System.arraycopy(arr, 0, NewArr, 0, position);
        NewArr[position] = item;
        System.arraycopy(arr, position, NewArr, position + 1, arr.length - position);
        return NewArr;
    }

    //disc03 Q2.2
    public static void reverseArr(int[] arr) {
        for (int n = 0; n < Math.round(arr.length / 2); n++) {
            int temp = arr[n];
            arr[n] = arr[arr.length - n - 1];
            arr[arr.length - n - 1] = temp;
        }
    }

    //disc03 Q2.3
    public static  int[] replicate(int[] arr) {
        int total = Arrays.stream(arr).sum();
        int index = 0;
        int[] arrNew = new int[total];
        for (int i : arr) {
            for (int n = 0; n < i; index++, n++) {
                arrNew[index] = i;
            }
        }
        return arrNew;
    }

    public static int[] flatten(int[][] arr2D) {
        int total = 0;
        for (int[] arr : arr2D) {
            total += arr.length;
        }
        // add the stuff of arr into arrNew
        int index = 0;
        int[] arrNew = new int[total];
        for (int[] arr : arr2D) {
            // should consider if arr is null
            for (int x :arr) {
                    arrNew[index] = x;
                    index++;
                }
        }
        return arrNew;
    }



    }
