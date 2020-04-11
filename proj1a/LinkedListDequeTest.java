/** Performs some basic linked list tests. */
public class LinkedListDequeTest {

    /* Utility method for printing out empty checks. */
    public static boolean checkEmpty(boolean expected, boolean actual) {
        if (expected != actual) {
            System.out.println("isEmpty() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    /* Utility method for printing out empty checks. */
    public static boolean checkSize(int expected, int actual) {
        if (expected != actual) {
            System.out.println("size() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    /* Utility method for check equal. */
    public static boolean checkEqual(int expected, int actual) {
        if (expected != actual) {
            System.out.println("get() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    /* Prints a nice message based on whether a test passed.
     * The \n means newline. */
    public static void printTestStatus(boolean passed) {
        if (passed) {
            System.out.println("Test passed!\n");
        } else {
            System.out.println("Test failed!\n");
        }
    }

    /** Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     *
     * && is the "and" operation. */
    public static void addIsEmptySizeTest() {
        System.out.println("Running add/isEmpty/Size test.");

        LinkedListDeque<String> lld1 = new LinkedListDeque<String>();

        boolean passed = checkEmpty(true, lld1.isEmpty());

        lld1.addFirst("front");

        // The && operator is the same as "and" in Python.
        // It's a binary operator that returns true if both arguments true, and false otherwise.
        passed = checkSize(1, lld1.size()) && passed;
        passed = checkEmpty(false, lld1.isEmpty()) && passed;

        lld1.addLast("middle");
        passed = checkSize(2, lld1.size()) && passed;

        lld1.addLast("back");
        passed = checkSize(3, lld1.size()) && passed;

        System.out.println("Printing out deque: ");
        lld1.printDeque();

        printTestStatus(passed);

        LinkedListDeque<Integer> l = new LinkedListDeque<Integer>();

        boolean passed2 = checkEmpty(true, l.isEmpty());

        l.addFirst(1);

        // The && operator is the same as "and" in Python.
        // It's a binary operator that returns true if both arguments true, and false otherwise.
        passed2 = checkSize(1, l.size()) && passed2;
        passed2 = checkEmpty(false, l.isEmpty()) && passed2;

        l.addLast(2);
        passed2 = checkSize(2, l.size()) && passed2;

        l.addLast(3);
        passed2 = checkSize(3, l.size()) && passed2;

        System.out.println("Printing out deque: ");
        l.printDeque();

        printTestStatus(passed2);
    }

    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public static void addRemoveTest() {

        System.out.println("Running add/remove test.");


        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
        // should be empty
        boolean passed = checkEmpty(true, lld1.isEmpty());

        lld1.addFirst(10);
        // should not be empty
        passed = checkEmpty(false, lld1.isEmpty()) && passed;

        lld1.removeFirst();
        // should be empty
        passed = checkEmpty(true, lld1.isEmpty()) && passed;

        printTestStatus(passed);


        LinkedListDeque<String> l = new LinkedListDeque<String>();
        // should be empty
        boolean passed2 = checkEmpty(true, l.isEmpty());

        l.addFirst("front");
        // should not be empty
        passed2 = checkEmpty(false, l.isEmpty()) && passed2;

        l.removeLast();
        // should be empty
        passed2 = checkEmpty(true, l.isEmpty()) && passed2;

        printTestStatus(passed2);

    }

    public static void getTest() {
        System.out.println("Running get test.");
        LinkedListDeque<Integer> l = new LinkedListDeque<Integer>();

        boolean passed = checkEmpty(true, l.isEmpty());
        l.addFirst(2);
        l.addFirst(1);
        l.addLast(3);

//        LinkedListDeque<Integer> l2 = new LinkedListDeque<Integer>(l);

        passed = checkEqual(2, l.get(1)) && passed;
        passed = checkEqual(2, l.getRecursive(1)) && passed;
        System.out.println(l.get(3));
        System.out.println(l.getRecursive(3));

        l.printDeque();
//        l2.printDeque();
//        System.out.println(l == l2);

        printTestStatus(passed);

    }

    public static void main(String[] args) {
        System.out.println("Running tests.\n");
        addIsEmptySizeTest();
        addRemoveTest();
        getTest();
    }
}
