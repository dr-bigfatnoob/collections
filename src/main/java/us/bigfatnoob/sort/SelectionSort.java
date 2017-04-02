package us.bigfatnoob.sort;


import us.bigfatnoob.utils.Compare;

import java.util.Comparator;

/**
 * Created by @bigfatnoob on 3/25/17.
 * Selection version of Sort
 */
public class SelectionSort extends Sort{

    /***
     * Sort an array using selection sort and a comparator
     * @param array: Array to be sorted
     * @param comparator: Instance of Comparator used for sort
     * @param order: Order of sort
     */
    public static void sort(Object[] array, Comparator comparator, Compare.Order order) {
        if (array == null)
            throw new NullPointerException("Array cannot be null.");
        int size = array.length;
        for (int i = 0; i < size; i++) {
            int better = i;
            for (int j=i+1; j < size; j++)
                if (Compare.compare(array[j], array[better], order, comparator))
                    better = j;
            Compare.exch(array, i, better);
        }
    }

    /***
     * Sort an array in ascending order using selection sort and a comparator.
     * @param array: Array to be sorted.
     * @param comparator: Instance of Comparator used for sort.
     */
    public static void sort(Object[] array, Comparator comparator) {
        sort(array, comparator, Compare.Order.ASCENDING);
    }

    /**
     * Sort an array using selection sort.
     * @param array: Array to be sorted.
     * @param order: Can be ASCENDING or DESCENDING order {@link us.bigfatnoob.utils.Compare}
     */
    public static void sort(Comparable[] array, Compare.Order order) {
        sort(array, null, order);
    }

    /***
     * Sort an array in ascending order using selection sort.
     * @param array: Array to be sorted.
     */
    public static void sort(Comparable[] array) {
        sort(array, Compare.Order.ASCENDING);
    }

}
