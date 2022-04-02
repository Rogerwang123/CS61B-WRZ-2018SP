public class ArrayDeque<T> {

    private T[] items;
    private int size;

    private int length; // concerning the usage
    private int start; //make the AListDeque circular
    private int end;


    public ArrayDeque() {

        items =(T[]) new Object[8];
        // At first the array's length is 8
        length = 8;
        size = 0;
        // Whatever the start number counts, it's just a pointer(both start and end)
        // Suppose we start from (5-1) -- (4+1), actually next start and next end
        start = 5;
        end = 4;
    }

    // Help minus the index so that when start is under 0, return it circularly to the end
    private int minusOne(int index) {
        if (index == 0) {
            return length - 1;
        }
        return index - 1;
    }

    private int plusOne(int index) {
        // the situation that resize???
        if (index == length - 1) {
            return 0;
        }
        return index + 1;
    }

    public void resizeLarger() {
        // At this moment, the items are from 0 to end, start to length - 1
        // start = end + 1 or start = 0 end = length - 1
        T[] newItems =(T[]) new Object[length * 2];
        System.arraycopy(items, start, newItems, length * 2 - 1 - end, length - 1 - end);
        System.arraycopy(items, 0, newItems, 0, end + 1); // from 0 to end
        items = newItems;
        length *= 2;
        for (int i = 0; i < length; i++) {
            plusOne(start);
        }
        // end won't change because I copied 0 to end to the front
    }

    public void resizeSmaller() {
        T[] newItems =(T[]) new Object[length / 2];
        System.arraycopy(items, start, newItems, length / 2 - start, length - start);
        System.arraycopy(items, 0, newItems, 0, end + 1); // from 0 to end
        items = newItems;
        length /= 2;
        for (int i = 0; i < length / 2; i++) {
            minusOne(start);
        }
    }

    // Before we add, we should check whether we should resize the array to a larger one
    public void addFirst(T item) {
        if (size == length - 1) {
            resizeLarger();
        }
        minusOne(start);
        items[start] = item;
        size++;
    }

    public void addLast(T item) {
        if (size == length - 1) {
            resizeLarger();
        }
        plusOne(end);
        items[end] = item;
        size++;
    }

    public T removeFirst() {
        if (length >= 16 && length / size > 4) {
            resizeSmaller();
        }
        T returnValue = items[start];
        items[start] = null; //??? whether the beginning value is null??
        plusOne(start);
        size--;
        return returnValue;
    }

    public T removeLast() {
        if (length >= 16 && length / size > 4) {
            resizeSmaller();
        }
        T returnValue = items[end];
        items[end] = null; //??? whether the beginning value is null??
        minusOne(end);
        size--;
        return returnValue;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        int n = start;
        for (int i = 0; i < size; i++) {
            System.out.print(items[n] + " ");
            plusOne(n);
        }
    }

    public T get(int index) {
        return items[index];
    }

}
