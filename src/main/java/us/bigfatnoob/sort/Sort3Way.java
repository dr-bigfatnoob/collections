package us.bigfatnoob.sort;

import us.bigfatnoob.utils.StdRandom;
import java.util.Comparator;

/**
 * Created by @bigfatnoob on 3/30/17.
 * 3 Way Sort implementation of Sort.
 */
public class Sort3Way extends Sort {

    /***
     * Sort an array using 3 way sort
     * @param array: Array to be sorted
     * @param comparator: Instance of comparator used for comparing.
     * @param order: Can be ASCENDING or DESCENDING order {@link us.bigfatnoob.sort.Sort.Order}
     */
    public static void sort(Object[] array, Comparator comparator, Order order) {
        if (array == null)
            throw new NullPointerException("Array cannot be null.");
        StdRandom.shuffle(array);
        sort(array, 0, array.length-1, comparator, order);
    }

    /***
     * Sort an array using 3 way sort.
     * @param array: Array to be sort.
     * @param comparator: Instance of comparator used for comparing.
     */
    public static void sort(Object[] array, Comparator comparator) {
        if (array == null)
            throw new NullPointerException("Array cannot be null.");
        StdRandom.shuffle(array);
        sort(array, 0, array.length-1, comparator, Order.ASCENDING);
    }

    /***
     * Sort an array using 3 way sort.
     * @param array: Array to be sorted.
     * @param order: Can be ASCENDING or DESCENDING order {@link us.bigfatnoob.sort.Sort.Order}
     */
    public static void sort(Object[] array, Order order) {
        if (array == null)
            throw new NullPointerException("Array cannot be null.");
        StdRandom.shuffle(array);
        sort(array, 0, array.length-1, null, order);
    }

    /***
     * Sort an array using 3 way sort.
     * @param array: Array to be sort.
     */
    public static void sort(Object[] array) {
        if (array == null)
            throw new NullPointerException("Array cannot be null.");
        StdRandom.shuffle(array);
        sort(array, 0, array.length-1, null, Order.ASCENDING);
    }


    /***
     * Sort an array between 2 indices using 3 way sort.
     * @param array: Array to be sorted
     * @param low: Start index of sort
     * @param high: End index of sort
     * @param c: Instance of comparator used for sort
     * @param order: Can be ASCENDING or DESCENDING order {@link us.bigfatnoob.sort.Sort.Order}
     */
    private static void sort(Object[] array, int low, int high, Comparator c, Order order) {
        if (high <= low)
            return;
        int lt = low, gt = high, i =low;
        Object pivot = array[low];
        while (i <= gt) {
            int status = compare(array[i], pivot, c);
            if ((order.equals(Order.ASCENDING) && status < 0) || (order.equals(Order.DESCENDING) && status > 0))
                exch(array, lt++, i++);
            else if ((order.equals(Order.ASCENDING) && status > 0) || (order.equals(Order.DESCENDING) && status < 0))
                exch(array, i, gt--);
            else
                i++;
        }
        sort(array, low, lt - 1, c, order);
        sort(array, gt + 1, high, c, order);
    }
}
