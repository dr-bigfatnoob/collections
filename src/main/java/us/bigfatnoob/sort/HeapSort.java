package us.bigfatnoob.sort;

import us.bigfatnoob.pq.Heap;
import us.bigfatnoob.utils.Compare;
import java.util.Comparator;

/**
 * Created by @bigfatnoob on 4/2/17.
 * Heap based sort implementation of sort.
 */
public class HeapSort extends Sort {

    /***
     * Sort the array using HeapSort using a comparator.
     * @param array - Instance of Array
     * @param comparator - Instance of Comparator
     * @param order - Order of sort
     */
    public static void sort(Object[] array, Comparator comparator, Compare.Order order) {
        Heap heap = new Heap(array, comparator, order);
        heap.heapify();
        int index = 0;
        while (heap.size() > 0) {
            array[index++] = heap.delRoot();
        }
    }

    /***
     * Sort the array using HeapSort in Ascending order.
     * @param array - Instance of Array
     */
    public static void sort(Object[] array) {
        HeapSort.sort(array, null, Compare.Order.ASCENDING);
    }

    /***
     * Sort the array using HeapSort using a comparator in Ascending order.
     * @param array - Instance of Array
     * @param comparator - Instance of Comparator
     */
    public static void sort(Object[] array, Comparator comparator) {
        HeapSort.sort(array, comparator, Compare.Order.ASCENDING);
    }

    /***
     * Sort the array using HeapSort using a comparator in Ascending order.
     * @param array - Instance of Array
     * @param order - Order of sort.
     */
    public static void sort(Object[] array, Compare.Order order) {
        HeapSort.sort(array, null, order);
    }

}
