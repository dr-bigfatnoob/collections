package us.bigfatnoob.sort;

import org.junit.Test;
import us.bigfatnoob.utils.Compare;

/**
 * Created by @bigfatnoob on 3/25/17.
 * Test for InsertionSort
 */
public class InsertionSortTest extends SortTest{

    @Override
    protected void sortEmpty() {
        InsertionSort.sort(emptyArray);
    }

    @Override
    protected void ascendingSort() {
        InsertionSort.sort(ascendingItems);
    }

    @Override
    protected void descendingSort() {
        InsertionSort.sort(descendingItems, Compare.Order.DESCENDING);
    }

    @Override
    protected void ascendingSignedSort() {
        InsertionSort.sort(ascendingSignedItems, absComparator);
    }

    @Override
    protected void descendingSignedSort() {
        InsertionSort.sort(descendingSignedItems, absComparator, Compare.Order.DESCENDING);
    }

    @Test(expected = NullPointerException.class)
    public void testNullPointerException(){
        InsertionSort.sort(null);
    }

}