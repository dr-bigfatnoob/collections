package us.bigfatnoob.sort;

import us.bigfatnoob.utils.Compare;

import java.util.Comparator;

/**
 * Created by @bigfatnoob on 3/25/17.
 * Merge based implementation of sort
 * Optimizations:
 * 1) Not copying Main array into auxiliary array each time during merge.
 * 2) Before merge(for ascending), array[mid + 1] > array[mid] then do not merge. Just copy and return
 * 3) Add a cutoff of 7, below which insertion sort is performed.
 */
public class OptimizedMergeSort extends Sort{


    private final static int CUTOFF = 7;

    /***
     * Merge low to mid of array and mid+1 to high of array into aux
     * @param array: Array to be merged
     * @param aux: Auxiliary array used for storage
     * @param low: Low of sort
     * @param mid: Mid of sort
     * @param high: High of sort
     * @param order: Order of sort
     */
    private static void merge(Object[] array, Object[] aux, int low, int mid, int high, Comparator c, Compare.Order order) {
        int i = low, j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (i > mid) {
                aux[k] = array[j++];
            } else if (j > high) {
                aux[k] = array[i++];
            } else if (Compare.compare(array[j], array[i], order, c)) {
                aux[k] = array[j++];
            } else {
                aux[k] = array[i++];
            }
        }
    }

    /***
     * Sort array using an auxiliary
     * @param array: Array to sort
     * @param aux: Array to use an auxiliary
     * @param low: Low of sort
     * @param high: High of sort
     * @param order: Order of sort
     */
    private static void sort(Object[] array, Object[] aux,  int low, int high, Comparator c, Compare.Order order) {
        if (high <= low + CUTOFF) {
            insertionSort(aux, low, high, order, c);
            return;
        }
        int mid = low + (high - low) / 2;
        sort(aux, array, low, mid, c, order);
        sort(aux, array, mid + 1, high, c, order);
        if (!Compare.compare(array[mid+1], array[mid], order, c)) {
            System.arraycopy(array, low, aux, low, high - low + 1);
            return;
        }
        merge(array, aux, low, mid, high, c, order);
    }

    /***
     * Sort an array using merge sort.
     * @param array: Array to be sorted.
     * @param order: Can be ASCENDING or DESCENDING order {@link us.bigfatnoob.utils.Compare.Order}
     */
    public static void sort(Comparable[] array, Compare.Order order) {
        if (array == null)
            throw new NullPointerException("Array cannot be null.");
        Comparable[] aux = array.clone();
        sort(aux, array, 0, array.length - 1, null, order);
    }

    /***
     * Sort an array using merge sort.
     * @param array: Array to be sort.
     */
    public static void sort(Comparable[] array) {
        sort(array, Compare.Order.ASCENDING);
    }

    /***
     * Sort an array using merge sort.
     * @param array: Array to be sorted.
     * @param order: Can be ASCENDING or DESCENDING order {@link us.bigfatnoob.utils.Compare.Order}
     */
    public static void sort(Object[] array, Comparator comparator, Compare.Order order) {
        if (array == null)
            throw new NullPointerException("Array cannot be null.");
        Object[] aux = array.clone();
        sort(aux, array, 0, array.length - 1, comparator, order);
    }

    /***
     * Sort an array using merge sort.
     * @param array: Array to be sort.
     */
    public static void sort(Object[] array, Comparator comparator) {
        sort(array, comparator, Compare.Order.ASCENDING);
    }

}
