
public class ArrayDeque<T> {
    private int size;
    private T[] items;
    private int nextFirst;
    private int nextLast;


    public ArrayDeque() {
        // Java does not allow to create new generic array directly. So need cast.
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }

    public T get(int i) {
        if (i >= size) {
            return null;
        }
        int start = plusOne(nextFirst);
        return items[(start + i) % items.length];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Return true if deque is full, false otherwise.
     */
    private boolean isFull() {
        return size == items.length;
    }

    /**
     * Whether to downsize the deque.
     */
    private boolean isSparse() {
        return items.length >= 16 && size < (items.length / 4);
    }

    public void printDeque() {
        int start = plusOne(nextFirst);
        for (int i = start; i != nextLast; i = plusOne(i)) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

    private int plusOne(int index) {
        return (index + 1) % items.length;
    }

    private int minusOne(int index) {
        // unlike Python, in Java, the % symbol represents "remainder" rather than "modulus",
        // therefore, it may give negative value, so + items.length is necessary,
        // or to use Math.floorMod(x, y)
        return (index - 1 + items.length) % items.length;
    }

    private void resize(int capacity) {
        T[] tem = (T[]) new Object[capacity];
        int start = plusOne(nextFirst);

        for (int i = 0; i < size; i++) {
            tem[i] = items[start];
            start = plusOne(start);
        }
        items = tem;
        nextFirst = capacity - 1;
        nextLast = size;

    }

    private void upSize() {
        resize(size * 2);
    }

    private void downSize() {
        resize(items.length / 2);
    }

    public void addFirst(T item) {
        if (isFull()) {
            upSize();
        }
        items[nextFirst] = item;
        nextFirst = minusOne(nextFirst);
        size++;
    }

    public void addLast(T item) {
        if (isFull()) {
            upSize();
        }
        items[nextLast] = item;
        nextLast = plusOne(nextLast);
        size++;
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }

        nextFirst = plusOne(nextFirst);
        T res = items[nextFirst];
        items[nextFirst] = null;

        size--;
        if (isSparse()) {
            downSize();
        }
        return res;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        nextLast = minusOne(nextLast);
        T res = items[nextLast];
        items[nextLast] = null;
        size--;
        if (isSparse()) {
            downSize();
        }
        return res;
    }
    // for 2018's grader commit it.
//    public ArrayDeque(ArrayDeque other) {
//        items = (T[]) new Object[other.size];
//        nextFirst = other.nextFirst;
//        nextLast = other.nextLast;
//        size = other.size;
//        int start = plusOne(nextFirst);
//        System.arraycopy(other.items, 0, items, 0, other.size);
//    }
}

