package us.bigfatnoob.sort;

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
     * @param one: Instance of comparator
     * @param two: Instance of comparator
     * @return True if one < two else False
     */
    private static boolean less(Comparable one, Comparable two) {
        return one.compareTo(two) < 0;
    }

    /***
     * Check if one is less than two.
     * @param one: Instance of comparator
     * @param two: Instance of comparator
     * @return True if one > two else False
     */
    private static boolean more(Comparable one, Comparable two) {
        return one.compareTo(two) > 0;
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
            return less(one, two);
        else
            return more(one, two);

    }

    /***
     * Swap array[i] with array[j]
     * @param array - Array that needs values to be swapped
     * @param i - Index of first element
     * @param j - Index of second element
     */
    protected static void exch(Comparable[] array, int i, int j) {
        Comparable swap = array[i];
        array[i] = array[j];
        array[j] = swap;
    }

}
