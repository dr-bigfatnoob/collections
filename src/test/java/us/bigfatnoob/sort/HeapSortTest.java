package us.bigfatnoob.sort;

import org.junit.Test;
import us.bigfatnoob.utils.Compare;

/**
 * Created by @bigfatnoob on 4/2/17.
 * Test for HeapSort
 */
public class HeapSortTest extends SortTest {

    @Override
    protected void sortEmpty() {
        HeapSort.sort(emptyArray);
    }

    @Override
    @Test(expected = NullPointerException.class)
    public void sortEmptyArray() {
        super.sortEmptyArray();
    }

    @Override
    protected void ascendingSort() {
        HeapSort.sort(ascendingItems);
    }

    @Override
    protected void descendingSort() {
        HeapSort.sort(descendingItems, Compare.Order.DESCENDING);
    }

    @Override
    protected void ascendingSignedSort() {
        HeapSort.sort(ascendingSignedItems, absComparator);
    }

    @Override
    protected void descendingSignedSort() {
        HeapSort.sort(descendingSignedItems, absComparator, Compare.Order.DESCENDING);
    }

    @Test(expected = NullPointerException.class)
    public void testNullPointerException(){
        HeapSort.sort(null);
    }


}