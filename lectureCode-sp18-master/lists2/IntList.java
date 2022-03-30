public class IntList {
	public int first;
	public IntList rest;

	public IntList(int f, IntList r) {
		first = f;
		rest = r;
	}

	/** Return the size of the list using... recursion! */
	public int size() {
		if (rest == null) {
			return 1;
		}
		return 1 + this.rest.size();
	}

	/** Return the size of the list using no recursion! */
	public int iterativeSize() {
		IntList p = this;
		int totalSize = 0;
		while (p != null) {
			totalSize += 1;
			p = p.rest;
		}
		return totalSize;
	}

	/** Returns the ith item of this IntList. */
	public int get(int i) {
		if (i == 0) {
			return first;
		}
		return rest.get(i - 1);
	}

	//disc02-Q4
	public static IntList square(IntList L) {

		if (L == null) {
			return null;
		} else {
			IntList rest = square(L.rest);
			IntList M = new IntList(L.first * L.first, rest);
			return M;
		}
	}

	public static IntList squareMutative(IntList L) {
		if (L == null) {
			return null;
		} else {
			L.first = L.first * L.first;
			squareMutative(L.rest);

		}
		return L;
	}

	public static IntList squareIter(IntList L) {
		if (L == null) {
			return L;
		}
		
	}


		public static void main(String[] args) {
		IntList L = new IntList(15, null);
		L = new IntList(10, L);
		L = new IntList(5, L);
		IntList N = squareMutative(L);
		IntList M = square(L);
		System.out.println(L.get(100));
	}
} 