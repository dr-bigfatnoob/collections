package us.bigfatnoob.sort;

/**
 * Created by @bigfatnoob on 3/25/17.
 * Basic Sort template
 */
public abstract class Sort {

    /***
     * Check if one is less than two.
     * @param one: Instance of comparator
     * @param two: Instance of comparator
     * @return True if one < two else False
     */
    protected static boolean less(Comparable one, Comparable two) {
        return one.compareTo(two) < 0;
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
