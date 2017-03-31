package us.bigfatnoob.select;

import org.junit.Before;
import org.junit.Test;
import us.bigfatnoob.utils.StdRandom;

import java.util.Arrays;
import java.util.Comparator;
import static org.junit.Assert.*;

/**
 * Created by @bigfatnoob on 3/30/17.
 * Test for selection.
 */
public class SelectTest {

    Integer[] items;

    static Comparator<Integer> absComparator = (Integer o1, Integer o2) ->
            ((Integer) Math.abs(o1)).compareTo(Math.abs(o2));

    @Before
    public void setUp() {
        items = new Integer[]{-1,-2,-5,3,0,4,-2,5,6,-4};
    }


    @Test(expected = NullPointerException.class)
    public void testNullPointerException() {
        Select.select(null, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalArgumentException() {
        Select.select(new Object[]{}, 0);
    }

    @Test
    public void testMinima() {
        Object minima = Select.select(items, 0);
        Arrays.sort(items);
        assertEquals(minima, items[0]);
    }

    @Test
    public void testMaxima() {
        Object maxima = Select.select(items, items.length - 1);
        Arrays.sort(items);
        assertEquals(maxima, items[items.length - 1]);
    }

    @Test
    public void testK() {
        int k = StdRandom.uniform(0, items.length);
        Object selected = Select.select(items, k);
        Arrays.sort(items);
        assertEquals(selected, items[k]);
    }

    @Test
    public void testComparator() {
        Object selected = Select.select(items, 0, absComparator);
        assertEquals(selected, 0);
    }

}