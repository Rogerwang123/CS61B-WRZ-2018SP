public class LinkedListDeque<T> {

    // A Node class including the circular sentinel
    public class Node {
        private T item;
        private Node next;
        private Node previous;

        // The method to create a Node
        public Node(T itm, Node pre, Node ne) {
            item = itm;
            previous = pre;
            next = ne;
        }

        // The method for sentinel Node
        public Node(Node pre, Node ne) {
            previous = pre;
            next = ne;
        }
    }

    // Announce size
    private int size;

    // A sentinel Node, it's next is the first item in LinkedList,
    // and it's previous is the end of the LinkedList
    private Node sentinel;

    // Creates an empty linked list deque.
    public LinkedListDeque() {
        size = 0;
        sentinel = new Node(null, null);
        sentinel.previous = sentinel;
        sentinel.next = sentinel;
    }

    // A normal LinkedList include first with item T and rest with the Node(and so on)
    public void addFirst(T item) {
        size += 1;
        Node addedNode = new Node(item, sentinel, sentinel.next);
        // formal first item's previous is the added one
        sentinel.next.previous = addedNode;
        sentinel.next = addedNode;
    }

    public void addLast(T item) {
        size += 1;
        Node addedNode = new Node(item, sentinel.previous, sentinel);
        sentinel.previous.next = addedNode;
        sentinel.previous = addedNode;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Node p = sentinel.next;
        while (p.next != sentinel) {
            System.out.print(p.item + " ");
            p = p.next;
        }
    }

    public T removeFirst() {
        if (this.isEmpty()) {
            return null;
        } else {
            T outT = sentinel.next.item;
            sentinel.next.next.previous = sentinel;
            sentinel.next = sentinel.next.next;
            size--;
            return outT;
        }

    }

    public T removeLast() {
        if (this.isEmpty()) {
            return null;
        } else {
            T outT = sentinel.previous.item;
            sentinel.previous.previous.next = sentinel;
            sentinel.previous = sentinel.previous.previous;
            size--;
            return outT;
        }
    }

    public T get(int index) {
        if (index >= size) {
            return null;
        } else {
            Node p = sentinel.next;
            // for index = 0, just return p.item
            for (int n = 0; n < index; n++) {
                p = p.next;
            }
            return p.item;
        }
    }

    public T getRecursivHelper(Node curNode, int index) {
        // the basic case
        if (index == 0) {
            return curNode.item;
        } else {
            return getRecursivHelper(curNode.next, index - 1);
        }
    }

    public T getRecursive(int index) {
        // To do it Recursively
        // May be getRecursive(int index - 1) ???
        if (index >= size) {
            return null;
        } else {
            return null;
        }
    }
}

