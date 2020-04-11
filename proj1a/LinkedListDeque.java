
public class LinkedListDeque<T> {
    private class Node {
        private T item;
        private Node prev;
        private Node next;

        private Node(T i, Node p, Node n) {
            item = i;
            prev = p;
            next = n;
        }
    }

    private Node sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    /**
     * Create a deep copy of other, for 2018's grader
     */
//    public LinkedListDeque(LinkedListDeque other) {
//        sentinel = new Node(null, null, null);
//        sentinel.next = sentinel;
//        sentinel.prev = sentinel;
//        size = 0;
//        for (int i = 0; i < other.size(); i++) {
//            addLast((T) other.get(i)); // (T) is cast, since type of other is unknown
//        }
//    }

    public void addFirst(T item) {
        Node f = new Node(item, sentinel, sentinel.next);
        sentinel.next.prev = f;
        sentinel.next = f;
        size++;
    }

    /**
     * Remove and return the item at the back of the deque
     * If no such item exists, return null
     */
    public void addLast(T item) {
        Node l = new Node(item, sentinel.prev, sentinel);
        sentinel.prev.next = l;
        sentinel.prev = l;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Print the items in the deque from first to last, separated by a space
     * Once all the items have been printed, print out a new line
     */
    public void printDeque() {
        Node p = sentinel.next;
        while (p != sentinel) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println();
    }

    public T removeFirst() {
        T res = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        if (!isEmpty()) {
            size -= 1;
        }
        return res;
    }

    public T removeLast() {
        T res = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        if (!isEmpty()) {
            size -= 1;
        }
        return res;
    }

    public T get(int i) {
        Node p = sentinel.next;
        while (i != 0 && p != sentinel) {
            p = p.next;
            i--;
        }
        return p.item;
    }

    public int size() {
        return size;
    }

    public T getRecursive(int index) {
        return recHelper(sentinel.next, index);
    }

    private T recHelper(Node p, int index) {
        if (index == 0 || p == sentinel) {
            return p.item;
        }
        return recHelper(p.next, --index);
    }
}
