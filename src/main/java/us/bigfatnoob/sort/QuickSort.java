package us.bigfatnoob.sort;

import us.bigfatnoob.utils.StdRandom;
import java.util.Comparator;

/**
 * Created by @bigfatnoob on 3/30/17.
 * Quick sort implementation of sort
 */
public class QuickSort extends Sort{

    /***
     * Partition method for quick sort
     * @param array: Instance of array to be partitioned.
     * @param low: Start index which is used as a pivot
     * @param high: End index
     * @param comparator: Instance of comparator
     * @param order: Can be ASCENDING or DESCENDING order {@link us.bigfatnoob.sort.Sort.Order}
     * @return - Index of pivot in the array
     */
    public static int partition(Object[] array, int low, int high, Comparator comparator, Order order) {
        int i = low, j = high + 1;
        Object pivot = array[low];
        while (true) {
            while (compare(array[++i], pivot, order, comparator))
                if (i == high)
                    break;
            while (compare(pivot, array[--j], order, comparator))
                if (j == low)
                    break;
            if (i >= j)
                break;
            exch(array, i, j);
        }
        exch(array, low, j);
        return j;
    }


    /***
     * Sort an array using quick sort
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
     * Sort an array using quick sort.
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
     * Sort an array using quick sort.
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
     * Sort an array using quick sort.
     * @param array: Array to be sort.
     */
    public static void sort(Object[] array) {
        if (array == null)
            throw new NullPointerException("Array cannot be null.");
        StdRandom.shuffle(array);
        sort(array, 0, array.length-1, null, Order.ASCENDING);
    }

    /***
     * Sort an array between 2 indices using quick sort.
     * @param array: Array to be sorted
     * @param low: Start index of sort
     * @param high: End index of sort
     * @param c: Instance of comparator used for sort
     * @param order: Can be ASCENDING or DESCENDING order {@link us.bigfatnoob.sort.Sort.Order}
     */
    private static void sort(Object[]array, int low, int high, Comparator c, Order order) {
        if (high <= low)
            return;
        int j = partition(array, low, high, c, order);
        sort(array, low, j - 1, c, order);
        sort(array, j + 1, high, c, order);
    }

}
