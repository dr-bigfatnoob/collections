package us.bigfatnoob.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;

/**
 * Created by @bigfatnoob on 3/25/17.
 * Generic Test Skeleton for Sort
 */
public abstract class SortTest {

    Integer[] ascendingItems;
    Integer[] descendingItems;
    Integer[] emptyArray;

    public void setUp() throws Exception {
        ascendingItems = new Integer[]{1,3,2,4,5,5,7,6,8,0,9};
        descendingItems = new Integer[]{1,3,2,4,5,5,7,6,8,0,9};
        emptyArray = new Integer[]{};
    }

    @Test
    public void sortEmptyArray() {
        assertEquals("Array size has to be empty.", 0, emptyArray.length);
    }

    @Test
    public void sortAscending() {
        int lengthBefore = ascendingItems.length;
        assertEquals("Array size has to be empty.", lengthBefore, ascendingItems.length);
        assertEquals("Smallest element has to be the first.", Collections.min(Arrays.asList(ascendingItems)), ascendingItems[0]);
        assertEquals("Largest element has to be the large.", Collections.max(Arrays.asList(ascendingItems)), ascendingItems[ascendingItems.length - 1]);
    }

    @Test
    public void sortDescending() {
        int lengthBefore = descendingItems.length;
        assertEquals("Array size has to be empty.", lengthBefore, descendingItems.length);
        assertEquals("Smallest element has to be the first.", Collections.min(Arrays.asList(descendingItems)), descendingItems[0]);
        assertEquals("Largest element has to be the large.", Collections.max(Arrays.asList(descendingItems)), descendingItems[descendingItems.length - 1]);
    }

}