package us.bigfatnoob.sort;

import java.util.Comparator;

/**
 * Created by @bigfatnoob on 3/25/17.
 * Insertion version of Sort.
 */
public class InsertionSort extends Sort{

    /***
     * Sort an array using insertion sort and a compartor.
     * @param array: Array to be sorted.
     * @param comparator: Instance of Comparator used for sort.
     * @param order: Can be in ASCENDING or DESCENDING order {@link us.bigfatnoob.sort.Sort.Order}
     */
    public static void sort(Object[] array, Comparator comparator, Order order) {
        int size = array.length;
        for (int i = 1; i < size; i++) {
            int j = i;
            while (j > 0 && compare(array[j], array[j - 1], order, comparator)) {
                exch(array, j, j - 1);
                j--;
            }
        }
    }

    /***
     * Sort an array in ascending order using insertion sort and a comparator.
     * @param array: Array to be sorted.
     * @param comparator: Instance of Comparator used for sort.
     */
    public static void sort(Object[] array, Comparator comparator) {
        sort(array, comparator, Order.ASCENDING);
    }

    /***
     * Sort an array using insertion sort.
     * @param array: Array to be sorted.
     * @param order: Can be in ASCENDING or DESCENDING order {@link us.bigfatnoob.sort.Sort.Order}
     */
    public static void sort(Comparable[] array, Order order) {
        sort(array, null, order);
    }

    /***
     * Sort an array in ascending order using insertion sort.
     * @param array: Array to be sorted.
     */
    public static void sort(Comparable[] array) {
        sort(array, Order.ASCENDING);
    }

}
