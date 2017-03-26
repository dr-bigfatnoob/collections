package us.bigfatnoob.sort;


import org.junit.Test;

/**
 * Created by @bigfatnoob on 3/25/17.
 * Test for SelectionSort
 */
public class SelectionSortTest extends SortTest{

    @Override
    protected void sortEmpty() {
        SelectionSort.sort(emptyArray);
    }

    @Override
    protected void ascendingSort() {
        SelectionSort.sort(ascendingItems);
    }

    @Override
    protected void descendingSort() {
        SelectionSort.sort(descendingItems, Sort.Order.DESCENDING);
    }

    @Override
    protected void ascendingSignedSort() {
        SelectionSort.sort(ascendingSignedItems, absComparator);
    }

    @Override
    protected void descendingSignedSort() {
        SelectionSort.sort(descendingSignedItems, absComparator, Sort.Order.DESCENDING);
    }

    @Test(expected = NullPointerException.class)
    public void testNullPointerException(){
        SelectionSort.sort(null);
    }

}