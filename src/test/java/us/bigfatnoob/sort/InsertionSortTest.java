package us.bigfatnoob.sort;

import org.junit.Test;

/**
 * Created by @bigfatnoob on 3/25/17.
 * Test for InsertionTest
 */
public class InsertionSortTest extends SortTest{

    @Override
    protected void sortEmpty() {
        SelectionSort.sort(emptyArray);
    }

    @Override
    protected void ascendingSort() {
        InsertionSort.sort(ascendingItems);
    }

    @Override
    protected void descendingSort() {
        InsertionSort.sort(descendingItems, Sort.Order.DESCENDING);
    }

    @Override
    protected void ascendingSignedSort() {
        InsertionSort.sort(ascendingSignedItems, absComparator);
    }

    @Override
    protected void descendingSignedSort() {
        InsertionSort.sort(descendingSignedItems, absComparator, Sort.Order.DESCENDING);
    }


    @Test(expected = NullPointerException.class)
    public void testNullPointerException(){
        InsertionSort.sort(null);
    }

}