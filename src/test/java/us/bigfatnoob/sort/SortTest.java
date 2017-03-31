package us.bigfatnoob.sort;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by @bigfatnoob on 3/25/17.
 * Generic Test Skeleton for Sort
 */
public abstract class SortTest {

    protected void sortEmpty() {
        throw new UnsupportedOperationException("Implement this is in sub class");
    }

    protected void ascendingSort() {
        throw new UnsupportedOperationException("Implement this is in sub class");
    }

    protected void descendingSort() {
        throw new UnsupportedOperationException("Implement this is in sub class");
    }

    protected void ascendingSignedSort() {
        throw new UnsupportedOperationException("Implement this is in sub class");
    }

    protected void descendingSignedSort() {
        throw new UnsupportedOperationException("Implement this is in sub class");
    }


    static Integer[] ascendingItems, descendingItems, emptyArray, ascendingSignedItems, descendingSignedItems;
    private static Integer aiLength, aiMin, aiMax,
            diLength, diMin, diMax,
            asiLength, asiMin, asiMax,
            dsiLength, dsiMin, dsiMax;
    static Comparator<Integer> absComparator = (Integer o1, Integer o2) ->
            ((Integer) Math.abs(o1)).compareTo(Math.abs(o2));

    @BeforeClass
    public static void beforeClass() throws Exception {
        List<Integer> asList;
        ascendingItems = new Integer[]{1,3,2,4,5,5,7,6,8,0,9};
        asList = Arrays.asList(ascendingItems);
        aiLength = ascendingItems.length;
        aiMin = Collections.min(asList);
        aiMax = Collections.max(asList);
        descendingItems = new Integer[]{1,3,2,4,5,5,7,6,8,0,9};
        asList = Arrays.asList(descendingItems);
        diLength = descendingItems.length;
        diMin = Collections.min(asList);
        diMax = Collections.max(asList);
        ascendingSignedItems = new Integer[]{-1,-2,-5,3,0,4,-2,5,6,-4};
        asList = Arrays.asList(ascendingSignedItems);
        asiLength = ascendingSignedItems.length;
        asiMin = Collections.min(asList, absComparator);
        asiMax = Collections.max(asList, absComparator);
        descendingSignedItems = new Integer[]{-1,-2,-5,3,0,4,-2,5,6,-4};
        asList = Arrays.asList(descendingSignedItems);
        dsiLength = descendingSignedItems.length;
        dsiMin = Collections.min(asList, absComparator);
        dsiMax = Collections.max(asList, absComparator);
        emptyArray = new Integer[]{};
    }

    @Test
    public void sortEmptyArray() {
        sortEmpty();
        assertEquals("Array size has to be empty.", 0, emptyArray.length);
    }

    @Test
    public void sortAscending() {
        ascendingSort();
        assertEquals("Array size has to be empty.", aiLength, (Integer) ascendingItems.length);
        assertEquals("Smallest element has to be the first.", aiMin, ascendingItems[0]);
        assertEquals("Largest element has to be the last.", aiMax, ascendingItems[ascendingItems.length - 1]);
    }

    @Test
    public void sortDescending() {
        descendingSort();
        assertEquals("Array size has to be empty.", diLength, (Integer) descendingItems.length);
        assertEquals("Smallest element has to be the last.", diMin, descendingItems[descendingItems.length - 1]);
        assertEquals("Largest element has to be the first.", diMax, descendingItems[0]);
    }

    @Test
    public void sortAscendingComparator() {
        ascendingSignedSort();
        assertEquals("Array size has to be empty.", asiLength, (Integer) ascendingSignedItems.length);
        assertEquals("Smallest element has to be the first.", asiMin, ascendingSignedItems[0]);
        assertEquals("Largest element has to be the last.", asiMax, ascendingSignedItems[ascendingSignedItems.length - 1]);
    }

    @Test
    public void sortDescendingComparator() {
        descendingSignedSort();
        assertEquals("Array size has to be empty.", dsiLength, (Integer) descendingSignedItems.length);
        assertEquals("Smallest element has to be the last.", dsiMin, descendingSignedItems[descendingSignedItems.length - 1]);
        assertEquals("Largest element has to be the first.", dsiMax, descendingSignedItems[0]);
    }

}