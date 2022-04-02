import static org.junit.Assert.*;
import org.junit.Test;

public class SLList {
	public class IntNode {
		public int item;
		public IntNode next;
		public IntNode(int i, IntNode n) {
			item = i;
			next = n;
		}
	}

	private IntNode sentinel;
	private int size;



	public SLList() {
		sentinel = new IntNode(666, null);
		size = 0;
	}

	public SLList(int x) {
		sentinel = new IntNode(666, null);
		sentinel.next = new IntNode(x, null);
		size = 1;
	}

	/** Adds an item to the front of the list. */
	public void addFirst(int x) {
		sentinel.next = new IntNode(x, sentinel.next);
		size += 1;
	}

	/** Retrieves the front item from the list. */
	public int getFirst() {
		return sentinel.next.item;
	}

	/** Returns the number of items in the list. */
	public int size() {
		return size;
	}

	/** Adds an item to the end of the list. */
	public void addLast(int x) {
		size += 1;
		IntNode p = sentinel;
		/* Advance p to the end of the list. */
		while (p.next != null) {
			p = p.next;
		}
		p.next = new IntNode(x, null);
	}

	// disc03 Q1.1
	public void insert(int item, int position) {
		size += 1;
		IntNode p = sentinel;
		// find the pointer when p.next is the place we insert item
		while (position > 0) {
			p = p.next;
			position--;
		}
		IntNode insertNode = new IntNode(item, p.next);
		p.next = insertNode;
	}

	//disc03 Q2.1
	public void reverse() {

		//make a pointer point to first.next (namely next part)
		//change the first item of the list's next into null
		//to do it recursively, the next part should be reverse
		//make the reversed one's next point to the first item (using addLast??)

		//IntNode FirstItem = sentinel.next;
		//IntNode NextPart = FirstItem.next;

		// FirstItem.next = null;
		sentinel.next = reverseRecursiveHelper(sentinel.next);
		// addLast(FirstItem.item);

		/**
		IntNode frontOfReversed = null;
		IntNode nextNodeToAdd = sentinel.next;
		while (nextNodeToAdd != null) {
			IntNode remainderOfOriginal = nextNodeToAdd.next;
			nextNodeToAdd.next = frontOfReversed;
			frontOfReversed = nextNodeToAdd;
			nextNodeToAdd = remainderOfOriginal;
		}
		sentinel.next = frontOfReversed;
		*/


	}



	private IntNode reversehelper(IntNode RemainList) {
		if (RemainList.next == null || RemainList == null) {
			return RemainList;
		} else {
			/** int first = RemainList.item;
			IntNode NextPart = RemainList.next;
			IntNode ReversedNextPart = reversehelper(NextPart);

			addLast(FirstItem.item); */
			// suppose 5 2 10
			// we have 5 as our first item, 2 10 is the list next part
			// reverse the next part got us list 10 2
			//
			return null;
		}
	}


	private IntNode reverseRecursiveHelper(IntNode front) {
		if (front == null || front.next == null) {
			return front;
		} else {
			IntNode reversed = reverseRecursiveHelper(front.next);
			front.next.next = front;
			front.next = null;
			return reversed;
		}
	}








/** Crashes when you call addLast on an empty SLList. Fix it. */
	public static void main(String[] args) {
		SLList x = new SLList();
		x.addLast(5);
		x.addLast(10);
		x.insert(12,0);
		x.insert(2,2);
		x.reverse();
		//assertEquals(sm, xx)

	}

}






/** An SLList is a list of integers, which hides the terrible truth
   * of the nakedness within. *//**
public class SLList {
	private static class IntNode {
		public int item;
		public IntNode next;

		public IntNode(int i, IntNode n) {
			item = i;
			next = n;
			System.out.println(size);
		}
	} 

	/* The first item (if it exists) is at sentinel.next. */ /**
	private IntNode sentinel;
	private int size;

	private static void lectureQuestion() {
		SLList L = new SLList();
		IntNode n = IntNode(5, null);
	}

	/** Creates an empty SLList. */ /**
	public SLList() {
		sentinel = new IntNode(63, null);
		size = 0;
	}

	public SLList(int x) {
		sentinel = new IntNode(63, null);
		sentinel.next = new IntNode(x, null);
		size = 1;
	}

 	/** Adds x to the front of the list. *//**
 	public void addFirst(int x) {
 		sentinel.next = new IntNode(x, sentinel.next);
 		size = size + 1;
 	}

 	/** Returns the first item in the list. *//**
 	public int getFirst() {
 		return sentinel.next.item;
 	}

 	/** Adds x to the end of the list. *//**
 	public void addLast(int x) {
 		size = size + 1; 		

 		IntNode p = sentinel;

 		/* Advance p to the end of the list. *//**
 		while (p.next != null) {
 			p = p.next;
 		}

 		p.next = new IntNode(x, null);
 	}
 	
 	/** Returns the size of the list. *//**
 	public int size() {
 		return size;
 	}

	public static void main(String[] args) {
 		/* Creates a list of one integer, namely 10 *//**
 		SLList L = new SLList();
 		L.addLast(20);
 		System.out.println(L.size());
 	}
}

 */