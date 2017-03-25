package us.bigfatnoob.sort;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by @bigfatnoob on 3/25/17.
 * Test for InsertionTest
 */
public class InsertionSortTest extends SortTest{

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        InsertionSort.sort(emptyArray);
        InsertionSort.sort(ascendingItems);
        InsertionSort.sort(descendingItems);
    }

    @Test(expected = NullPointerException.class)
    public void sortNullArray() {
        InsertionSort.sort(null);
    }

}