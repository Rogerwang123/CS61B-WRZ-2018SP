public class DrawTri {
    public static void main(String[] args) {
        int col = 1;
        while(col <= 5){
            int cur = 1;
            while (cur < col){
                System.out.print("*");
                cur += 1;
            }
            System.out.println("*");
            col += 1;
        }
    }
}
