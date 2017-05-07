package us.bigfatnoob.set;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Test for Set.
 * Created by @bigfatnoob on 5/7/17.
 */
public class SetTest {
    private Integer[] items = new Integer[]{0,-1,1,-2,2,-3,3,-4,4,-5,5,-6,6};

    private Integer[] others = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    private List<Integer> itemList = shuffle(Arrays.asList(items));

    private List<Integer> otherList = shuffle(Arrays.asList(others));

    private List<Integer> shuffle(List<Integer> lst) {
        Collections.shuffle(lst);
        return lst;
    }


    @Test
    public void testSet() {
        Set<Integer> set = new Set<>();
        Set<Integer> other = new Set<>();
        for (Integer item: itemList)
            set.add(item);
        for (Integer item: otherList)
            other.add(item);
        assertEquals(itemList.size(), set.size());
        assertEquals(true, set.contains(0));
        assertEquals(false, set.contains(-10));
        assertEquals(set.union(other).size(), 17);
        assertEquals(set.intersection(other).size(), 6);
        assertEquals(set.difference(other).size(), 7);
        set.remove(0);
        assertEquals(itemList.size() - 1, set.size());
        set.remove(10);
        assertEquals(itemList.size() - 1, set.size());
    }

}