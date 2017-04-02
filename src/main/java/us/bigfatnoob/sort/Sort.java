package us.bigfatnoob.sort;

import java.util.Comparator;
import us.bigfatnoob.utils.Compare;

/**
 * Created by @bigfatnoob on 3/25/17.
 * Basic Sort template
 */
public abstract class Sort {

    /***
     * Sort array between indices using insertion sort
     * @param array: Array that needs to be sorted.
     * @param start: Start of sort.
     * @param end: End of sort.
     * @param order: Order of sorting
     * @param c: Instance of comparator
     */
    protected static void insertionSort(Object[] array, int start, int end, Compare.Order order, Comparator c) {
        for (int i = start+1; i <= end; i++) {
            int j = i;
            while (j > start && Compare.compare(array[j], array[j-1], order, c)) {
                Compare.exch(array, j, j - 1);
                j--;
            }
        }
    }

}
