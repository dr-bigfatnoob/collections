package us.bigfatnoob.sort;

import us.bigfatnoob.utils.StdRandom;
import java.util.Comparator;

/**
 * Created by @bigfatnoob on 3/30/17.
 * Quick based implementation of sort
 * Optimizations:
 * 1) Add a CUTOFF to resort to insertion sort if too small.
 * 2) Use a median of 3 random numbers as pivot
 */
public class OptimizedQuickSort extends QuickSort {

    private final static int CUTOFF = 10;

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
        if (high <= low + CUTOFF - 1){
            insertionSort(array, low, high, order, c);
            return;
        }
        int m = medianOf3(array, low, high, c);
        exch(array, low, m);
        int j = partition(array, low, high, c, order);
        sort(array, low, j - 1, c, order);
        sort(array, j + 1, high, c, order);
    }

    /***
     * Return index of median of three random elements.
     * @param array: Array to find median.
     * @param low: Start index to search from.
     * @param high: End index to search.
     * @param c: Instance fo comparator.
     * @return median index from 3 random elements.
     */
    private static int medianOf3(Object[] array, int low, int high, Comparator c) {
        int one = StdRandom.uniform(low, high + 1);
        int two = StdRandom.uniform(low, high + 1);
        int three = StdRandom.uniform(low, high + 1);
        Object[] shortArray = new Object[]{array[one], array[two], array[three]};
        insertionSort(shortArray, 0, 2, Order.ASCENDING, c);
        Object median = shortArray[1];
        if (median.equals(array[one]))
            return one;
        else if (median.equals(array[two]))
            return two;
        else
            return three;
    }


}
