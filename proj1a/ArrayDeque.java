public class ArrayDeque<T> {

    private T[] items;
    private int size;

    private int length; // concerning the usage
    private int start; //make the AListDeque circular
    private int end;


    public ArrayDeque() {

        items = (T[]) new Object[8];
        // At first the array's length is 8
        length = 8;
        size = 0;
        // Whatever the start number counts, it's just a pointer(both start and end)
        // Suppose we start from (5-1) -- (4+1), actually next start and next end
        start = 4;
        end = 3;
    }

    // Help minus the index so that when start is under 0, return it circularly to the end
    private int minusOne(int index) {
        if (index == 0) {
            return length - 1;
        }
        return index - 1;
    }

    // remember call it after the length change
    private int plusOne(int index) {
        if (index == length - 1) {
            return 0;
        }
        return index + 1;
    }

    // resize didn't change the size of the Array
    private void resizeLarger() {
        T[] newItems = (T[]) new Object[length * 2];
        // simply start from 0 in the new array
        // use iteration to catch the start and end.
        int index = start;
        for (int i = 0; i < size; i++) {
            newItems[i] = items[index];
            index = plusOne(index);
        }
        start = 0;
        end = size - 1;
        items = newItems;
        length *= 2;
    }

    private void resizeSmaller() {
        T[] newItems = (T[]) new Object[length / 2];
        int index = start;
        for (int i = 0; i < size; i++) {
            newItems[i] = items[index];
            index = plusOne(index);
        }
        start = 0;
        end = size - 1;
        items = newItems;
        length /= 2;
    }

    // Before we add, we should check whether we should resize the array to a larger one
    // resize before we fulfill all the array because it would cause the start and end merge
    public void addFirst(T item) {
        if (size == length - 1) {
            resizeLarger();
        }
        start = minusOne(start);
        items[start] = item;
        size++;
    }

    public void addLast(T item) {
        if (size == length - 1) {
            resizeLarger();
        }

        end = plusOne(end);
        items[end] = item;
        size++;
    }

    public T removeFirst() {
        if (length >= 16 && length / size >= 4) {
            resizeSmaller();
        }
        if (size == 0) {
            return null;
        }
        T returnValue = items[start];
        items[start] = null;
        start = plusOne(start);
        size--;
        return returnValue;
    }

    public T removeLast() {
        if (length >= 16 && length / size >= 4) {
            resizeSmaller();
        }
        if (size == 0) {
            return null;
        }
        T returnValue = items[end];
        items[end] = null; //??? whether the beginning value is null??
        end = minusOne(end);
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
        int position = start;
        for (int i = 0; i < index; i++) {
            position = plusOne(position);
        }
        return items[position];
    }

}
