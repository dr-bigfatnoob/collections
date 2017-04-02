package us.bigfatnoob.sort;

import org.junit.Test;
import us.bigfatnoob.utils.Compare;

/**
 * Created by @bigfatnoob on 3/30/17.
 * Test for QuickSort
 */
public class QuickSortTest extends SortTest {

    @Override
    protected void sortEmpty() {
        QuickSort.sort(emptyArray);
    }

    @Override
    protected void ascendingSort() {
        QuickSort.sort(ascendingItems);
    }

    @Override
    protected void descendingSort() {
        QuickSort.sort(descendingItems, Compare.Order.DESCENDING);
    }

    @Override
    protected void ascendingSignedSort() {
        QuickSort.sort(ascendingSignedItems, absComparator);
    }

    @Override
    protected void descendingSignedSort() {
        QuickSort.sort(descendingSignedItems, absComparator, Compare.Order.DESCENDING);
    }

    @Test(expected = NullPointerException.class)
    public void testNullPointerException(){
        QuickSort.sort(null);
    }

}