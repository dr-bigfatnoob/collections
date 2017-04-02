package us.bigfatnoob.sort;

import org.junit.Test;
import us.bigfatnoob.utils.Compare;

/**
 * Created by @bigfatnoob on 3/30/17.
 * Test for OptimizedQuickSort
 */
public class OptimizedQuickSortTest extends SortTest {
    @Override
    protected void sortEmpty() {
        OptimizedQuickSort.sort(emptyArray);
    }

    @Override
    protected void ascendingSort() {
        OptimizedQuickSort.sort(ascendingItems);
    }

    @Override
    protected void descendingSort() {
        OptimizedQuickSort.sort(descendingItems, Compare.Order.DESCENDING);
    }

    @Override
    protected void ascendingSignedSort() {
        OptimizedQuickSort.sort(ascendingSignedItems, absComparator);
    }

    @Override
    protected void descendingSignedSort() {
        QuickSort.sort(descendingSignedItems, absComparator, Compare.Order.DESCENDING);
    }

    @Test(expected = NullPointerException.class)
    public void testNullPointerException(){
        OptimizedQuickSort.sort(null);
    }
}