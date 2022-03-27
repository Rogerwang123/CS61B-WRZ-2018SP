public class BreakContinue {
  public static void windowPosSum(int[] a, int n) {
    /** your code here */
      for (int index = 0; index < a.length; index += 1) {
          if (a[index] < 0){
              continue;
          }
          int sum = 0;
          for (int adder = 0; adder <= n; adder += 1) {
              if (index + adder == a.length) {
                  break;
              }
              sum += a[index + adder];
          }
          a[index] = sum;
      }
  }

  public static void main(String[] args) {
    int[] a = {1, 2, -3, 4, 5, 4};
    int n = 3;
    windowPosSum(a, n);

    // Should print 4, 8, -3, 13, 9, 4
    System.out.println(java.util.Arrays.toString(a));
  }
}
