package us.bigfatnoob.sort;

import java.util.Comparator;
import us.bigfatnoob.utils.Compare;

/**
 * Created by @bigfatnoob on 3/25/17.
 * Insertion version of Sort.
 */
public class InsertionSort extends Sort{

    /***
     * Sort an array using insertion sort and a compartor.
     * @param array: Array to be sorted.
     * @param comparator: Instance of Comparator used for sort.
     * @param order: Can be in ASCENDING or DESCENDING order {@link us.bigfatnoob.utils.Compare.Order}
     */
    public static void sort(Object[] array, Comparator comparator, Compare.Order order) {
        int size = array.length;
        for (int i = 1; i < size; i++) {
            int j = i;
            while (j > 0 && Compare.compare(array[j], array[j - 1], order, comparator)) {
                Compare.exch(array, j, j - 1);
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
        sort(array, comparator, Compare.Order.ASCENDING);
    }

    /***
     * Sort an array using insertion sort.
     * @param array: Array to be sorted.
     * @param order: Can be in ASCENDING or DESCENDING order {@link us.bigfatnoob.utils.Compare}
     */
    public static void sort(Comparable[] array, Compare.Order order) {
        sort(array, null, order);
    }

    /***
     * Sort an array in ascending order using insertion sort.
     * @param array: Array to be sorted.
     */
    public static void sort(Comparable[] array) {
        sort(array, Compare.Order.ASCENDING);
    }

}
