public class drawTri_n {

  public static void drawTriangle (int N){
     int col = 1;
     while(col <= N){
         int cur = 1;
         while (cur < col){
             System.out.print("*");
             cur += 1;
         }
         System.out.println("*");
         col += 1;
      }
   }
   public static void main(String[] args) {
      drawTriangle(10);
   }
}
