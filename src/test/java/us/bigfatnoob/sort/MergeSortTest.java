package us.bigfatnoob.sort;

import org.junit.Test;

/**
 * Created by @bigfatnoob on 3/26/17.
 * Test for MergeSort
 */
public class MergeSortTest extends SortTest{

    @Override
    protected void sortEmpty() {
        MergeSort.sort(emptyArray);
    }

    @Override
    protected void ascendingSort() {
        MergeSort.sort(ascendingItems);
    }

    @Override
    protected void descendingSort() {
        MergeSort.sort(descendingItems, Sort.Order.DESCENDING);
    }

    @Override
    protected void ascendingSignedSort() {
        MergeSort.sort(ascendingSignedItems, absComparator);
    }

    @Override
    protected void descendingSignedSort() {
        MergeSort.sort(descendingSignedItems, absComparator, Sort.Order.DESCENDING);
    }

    @Test(expected = NullPointerException.class)
    public void testNullPointerException(){
        MergeSort.sort(null);
    }

}