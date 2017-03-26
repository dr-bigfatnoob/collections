package us.bigfatnoob.sort;

import java.util.Comparator;

/**
 * Created by @bigfatnoob on 3/25/17.
 * Merge based implementation of sort
 */
public class MergeSort extends Sort{

    /***
     * Merge low to mid of array and mid+1 to high of array into aux
     * @param array: Array to be merged
     * @param aux: Auxiliary array used for storage
     * @param low: Low of sort
     * @param mid: Mid of sort
     * @param high: High of sort
     * @param order: Order of sort
     */
    private static void merge(Object[] array, Object[] aux, int low, int mid, int high, Comparator c, Order order) {
        int i = low, j = mid + 1;
        System.arraycopy(array, low, aux, low, high - low + 1);
        for (int k = low; k <= high; k++) {
            if (i > mid)
                array[k] = aux[j++];
            else if (j > high)
                array[k] = aux[i++];
            else if (compare(aux[j], aux[i], order, c))
                array[k] = aux[j++];
            else
                array[k] = aux[i++];
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
    private static void sort(Object[] array, Object[] aux,  int low, int high, Comparator c, Order order) {
        if (high <= low) return;
        int mid = low + (high - low) / 2;
        sort(array, aux, low, mid, c, order);
        sort(array, aux, mid + 1, high, c, order);
        merge(array, aux, low, mid, high, c, order);
    }

    /***
     * Sort an array using merge sort.
     * @param array: Array to be sorted.
     * @param order: Can be ASCENDING or DESCENDING order {@link us.bigfatnoob.sort.Sort.Order}
     */
    public static void sort(Comparable[] array, Order order) {
        if (array == null)
            throw new NullPointerException("Array cannot be null.");
        Comparable[] aux = new Comparable[array.length];
        sort(array, aux, 0, array.length - 1, null, order);
    }

    /***
     * Sort an array using merge sort.
     * @param array: Array to be sort.
     */
    public static void sort(Comparable[] array) {
        sort(array, Order.ASCENDING);
    }

    /***
     * Sort an array using merge sort.
     * @param array: Array to be sorted.
     * @param order: Can be ASCENDING or DESCENDING order {@link us.bigfatnoob.sort.Sort.Order}
     */
    public static void sort(Object[] array, Comparator comparator, Order order) {
        if (array == null)
            throw new NullPointerException("Array cannot be null.");
        Object[] aux = new Comparable[array.length];
        sort(array, aux, 0, array.length - 1, comparator, order);
    }

    /***
     * Sort an array using merge sort.
     * @param array: Array to be sort.
     */
    public static void sort(Object[] array, Comparator comparator) {
        sort(array, comparator, Order.ASCENDING);
    }

}
