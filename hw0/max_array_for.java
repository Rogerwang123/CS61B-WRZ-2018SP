public class max_array_for {
    /** Returns the maximum value from m. */
    public static int forMax(int[] m) {
        int maximum = 0;
        for (int index = 0; index < m.length; index += 1) {
            if (maximum < m[index]) {
                maximum = m[index];
            }
        }
        return maximum;
    }
    public static void main(String[] args) {
       int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};
       System.out.println(forMax(numbers));
    }
}
