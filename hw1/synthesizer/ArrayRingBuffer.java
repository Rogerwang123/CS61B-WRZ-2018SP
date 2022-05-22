// TODO: Make sure to make this class a part of the synthesizer package
// package <package name>;
package synthesizer;

import java.util.Iterator;

//TODO: Make sure to make this class and all of its methods public
//TODO: Make sure to make this class extend AbstractBoundedQueue<t>
public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        // TODO: Create new array with capacity elements.
        //       first, last, and fillCount should all be set to 0.
        //       this.capacity should be set appropriately. Note that the local variable
        //       here shadows the field we inherit from AbstractBoundedQueue, so
        //       you'll need to use this.capacity to set the capacity.
        rb = (T[]) new Object[capacity];
        int first = 0;
        int last = 0;
        int fillCount = 0;
        this.capacity = capacity;


    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     * @param x
     */


    //In Java, it is compulsory to override abstract methods of the parent class in its child class
    //because the derived class extends the abstract methods of the base class.
    //
    //If we do not override the abstract methods in the subclasses then there will be a compilation error.
    //Therefore, it is necessary for a subclass to override the abstract methods of its base class.

    @Override
    public void enqueue(T x) {
        // TODO: Enqueue the item. Don't forget to increase fillCount and update last.
        if (isFull()) {
            throw new RuntimeException("Ring buffer overflow");
        }
        rb[last] = x;
        last = (last + 1) % capacity;
        fillCount += 1;
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    //Better just peek and return the T peeked, exception is included in peek.
    @Override
    public T dequeue() {
        // TODO: Dequeue the first item. Don't forget to decrease fillCount and update
        if (isEmpty()){
            throw new RuntimeException("Ring buffer underflow");
        }
        T output = rb[first];
        first = (first + 1) % capacity;
        fillCount -= 1;
        return output;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    @Override
    public T peek() {
        // TODO: Return the first item. None of your instance variables should change.
        if (isEmpty()){
            throw new RuntimeException("Ring buffer underflow");
        }
        T output = rb[first];
        return output;

    }

    // TODO: When you get to part 5, implement the needed code to support iteration.

    public class ArrayRingBufferIterator implements Iterator<T> {
        private int pos;
        private int num;
        public ArrayRingBufferIterator() {
            pos = first;
            num = 0; // How many items have been counted
        }

        public boolean hasNext(){
            return num < fillCount;
        }

        public T next() {
            T output = rb[pos];
            pos = (pos + 1) % capacity;
            num += 1;
            return output;
        }
    }


    @Override
    public Iterator<T> iterator() {
        return new ArrayRingBufferIterator();
    }
}
