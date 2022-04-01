public class Disc3 {
   public class InNode {
       public int item;
       public InNode next;
       public InNode(int i, InNode n) {
            item = i;
            next = n;
       }
   }
    private InNode first;
    public void addFirst(int x) {
        first = new InNode(x, first);
    }



    }
