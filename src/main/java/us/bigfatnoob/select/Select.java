package us.bigfatnoob.select;

import us.bigfatnoob.sort.QuickSort;
import us.bigfatnoob.sort.Sort.Order;
import us.bigfatnoob.utils.StdRandom;
import java.util.Comparator;

/**
 * Created by @bigfatnoob on 3/30/17.
 * Select item from Array
 */
public class Select {

    /***
     * Select the kth largest or smallest item from the array.
     * @param array: Array to be selected from.
     * @param k: Id of the item to be selected.
     * @param comparator: Instance of comparator
     * @param order: Can be ASCENDING or DESCENDING order {@link us.bigfatnoob.sort.Sort.Order}
     * @return - kth largest or smallest item.
     */
    public static Object select(Object[] array, int k, Comparator comparator, Order order) {
        if (array == null)
            throw new NullPointerException("Array cannot be null.");
        if (k < 0 || k >= array.length)
            throw new IllegalArgumentException("k has to be greater than or equal to 0 and less than array.length");
        StdRandom.shuffle(array);
        int low = 0, high = array.length - 1;
        while (high > low) {
            int j = QuickSort.partition(array, low, high, comparator, order);
            if (j < k)
                low = j + 1;
            else if (j > k)
                high = j - 1;
            else
                return array[k];
        }
        return array[k];
    }

    /***
     * Select the kth largest or smallest item from the array.
     * @param array: Array to be selected from.
     * @param k: Id of the item to be selected.
     * @param comparator: Instance of comparator
     * @return - kth largest or smallest item.
     */
    public static Object select(Object[] array, int k, Comparator comparator) {
        return select(array, k, comparator, Order.ASCENDING);
    }

    /***
     * Select the kth largest or smallest item from the array.
     * @param array: Array to be selected from.
     * @param k: Id of the item to be selected.
     * @param order: Can be ASCENDING or DESCENDING order {@link us.bigfatnoob.sort.Sort.Order}
     * @return - kth largest or smallest item.
     */
    public static Object select(Object[] array, int k, Order order) {
        return select(array, k, null, order);
    }

    /***
     * Select the kth largest or smallest item from the array.
     * @param array: Array to be selected from.
     * @param k: Id of the item to be selected.
     * @return - kth largest or smallest item.
     */
    public static Object select(Object[] array, int k) {
        return select(array, k, null, Order.ASCENDING);
    }

}
