public class max_array {
    /** Returns the maximum value from m. */
    public static int max(int[] m) {
        int length = m.length;
        int index = 0;
        int maximum = 0;
        while (index < length) {
            if (maximum < m[index]) {
                maximum = m[index];
            }
            index += 1;
        }
        return maximum;
    }
    public static void main(String[] args) {
       int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};
       System.out.println(max(numbers));
    }
}
