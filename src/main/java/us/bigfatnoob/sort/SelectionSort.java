package us.bigfatnoob.sort;


/**
 * Created by @bigfatnoob on 3/25/17.
 * Selection version of Sort
 */
public class SelectionSort extends Sort{

    /**
     * Sort an array using selection sort.
     * @param array: Array to be sorted.
     * @param order: Can be ASCENDING or DESCENDING order {@link us.bigfatnoob.sort.Sort.Order}
     */
    public static void sort(Comparable[] array, Order order) {
        if (array == null)
            throw new NullPointerException("Array cannot be null.");
        int size = array.length;
        for (int i = 0; i < size; i++) {
            int better = i;
            for (int j=i+1; j < size; j++)
                if (compare(array[j], array[better], order))
                    better = j;
            exch(array, i, better);
        }
    }

    /***
     * Sort an array in ascending order using selection sort.
     * @param array: Array to be sorted.
     */
    public static void sort(Comparable[] array) {
        sort(array, Order.ASCENDING);
    }

}
