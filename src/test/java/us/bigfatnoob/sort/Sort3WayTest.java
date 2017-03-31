package us.bigfatnoob.sort;

import org.junit.Test;

/**
 * Created by @bigfatnoob on 3/31/17.
 * Test for 3 Way Sort
 */
public class Sort3WayTest extends SortTest {

    @Override
    protected void sortEmpty() {
        Sort3Way.sort(emptyArray);
    }

    @Override
    protected void ascendingSort() {
        Sort3Way.sort(ascendingItems);
    }

    @Override
    protected void descendingSort() {
        Sort3Way.sort(descendingItems, Sort.Order.DESCENDING);
    }

    @Override
    protected void ascendingSignedSort() {
        Sort3Way.sort(ascendingSignedItems, absComparator);
    }

    @Override
    protected void descendingSignedSort() {
        Sort3Way.sort(descendingSignedItems, absComparator, Sort.Order.DESCENDING);
    }

    @Test(expected = NullPointerException.class)
    public void testNullPointerException(){
        Sort3Way.sort(null);
    }

}