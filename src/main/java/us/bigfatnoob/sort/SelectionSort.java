package us.bigfatnoob.sort;

/**
 * Created by @bigfatnoob on 3/25/17.
 * Selection version of Sort
 */
public class SelectionSort extends Sort{

    /**
     * Sort an array using selection sort.
     * @param array: Array to be sorted
     */
    public static void sort(Comparable[] array) {
        int size = array.length;
        for (int i = 0; i < size; i++) {
            int min = i;
            for (int j=i+1; j < size; j++)
                if (less(array[j], array[min]))
                    min = j;
            exch(array, i, min);
        }
    }

}
