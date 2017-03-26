package us.bigfatnoob.sort;

import org.junit.Test;

/**
 * Created by @bigfatnoob on 3/26/17.
 * Test for OptimizedMergeSort
 */
public class OptimizedMergeSortTest extends SortTest{

    @Override
    protected void sortEmpty() {
        OptimizedMergeSort.sort(emptyArray);
    }

    @Override
    protected void ascendingSort() {
        OptimizedMergeSort.sort(ascendingItems);
    }

    @Override
    protected void descendingSort() {
        OptimizedMergeSort.sort(descendingItems, Sort.Order.DESCENDING);
    }

    @Override
    protected void ascendingSignedSort() {
        OptimizedMergeSort.sort(ascendingSignedItems, absComparator);
    }

    @Override
    protected void descendingSignedSort() {
        OptimizedMergeSort.sort(descendingSignedItems, absComparator, Sort.Order.DESCENDING);
    }


    @Test(expected = NullPointerException.class)
    public void testNullPointerException(){
        OptimizedMergeSort.sort(null);
    }

}