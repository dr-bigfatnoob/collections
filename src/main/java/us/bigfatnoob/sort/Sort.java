package us.bigfatnoob.sort;

import java.util.Comparator;

/**
 * Created by @bigfatnoob on 3/25/17.
 * Basic Sort template
 */
public abstract class Sort {


    public enum Order {
        ASCENDING(0, "ascending"),
        DESCENDING(1, "descending");

        private int index;

        private String name;

        Order(int index, String name) {
            this.index = index;
            this.name = name;
        }

        public int getIndex() {
            return index;
        }

        public String getName() {
            return name;
        }
    }

    /***
     * Check if one is less than two.
     * @param c: Instance of comparator
     * @param one: Instance of Object
     * @param two: Instance of Object.
     * @return True if c.compare(one, two) < 0 else False
     */
    private static boolean less(Object one, Object two, Comparator c) {
        if (c != null)
            return c.compare(one, two) < 0;
        else if (one instanceof Comparable && two instanceof Comparable)
            return ((Comparable) one).compareTo((two)) < 0;
        else{
            throw new IllegalArgumentException("Either comparator has to be not null " +
                    "or objects should extend Comparable");
        }
    }


    /***
     * Check if one is more than two.
     * @param c: Instance of comparator
     * @param one: Instance of Object
     * @param two: Instance of Object.
     * @return True if c.compare(one, two) > 0 else False
     */
    private static boolean more(Object one, Object two, Comparator c) {
        if (c != null)
            return c.compare(one, two) > 0;
        else if (one instanceof Comparable && two instanceof Comparable)
            return ((Comparable) one).compareTo(two) > 0;
        else
            throw new IllegalArgumentException("Either comparator has to be not null " +
                    "or objects should extend Comparable");
    }

    /***
     * Compare one to two
     * @param one : Instance of comparator
     * @param two: Instance of comparator
     * @param order: Order of sort
     * @return Call less if order is ASCENDING else call more.
     */
    protected static boolean compare(Comparable one, Comparable two, Order order) {
        if (order.equals(Order.ASCENDING))
            return less(one, two, null);
        else
            return more(one, two, null);

    }

    protected static boolean compare(Object one, Object two, Order order, Comparator c) {
        if (order.equals(Order.ASCENDING))
            return less(one, two, c);
        else
            return more(one, two, c);
    }

    /***
     * Swap array[i] with array[j]
     * @param array - Array that needs values to be swapped
     * @param i - Index of first element
     * @param j - Index of second element
     */
    protected static void exch(Object[] array, int i, int j) {
        Object swap = array[i];
        array[i] = array[j];
        array[j] = swap;
    }



}
