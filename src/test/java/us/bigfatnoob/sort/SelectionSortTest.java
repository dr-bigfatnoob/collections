package us.bigfatnoob.sort;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by @bigfatnoob on 3/25/17.
 * Test for SelectionSort
 */
public class SelectionSortTest extends SortTest{

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        SelectionSort.sort(emptyArray);
        SelectionSort.sort(ascendingItems);
        SelectionSort.sort(descendingItems);
    }

    @Test(expected = NullPointerException.class)
    public void sortNullArray() {
        SelectionSort.sort(null);
    }

}