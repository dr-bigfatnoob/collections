package us.bigfatnoob.symboltable;

import org.junit.Test;
import us.bigfatnoob.queue.Queue;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Test functions for BSTSymbolTable
 * Created by @bigfatnoob on 4/30/17.
 */
public class BSTSymbolTableTest {

    private SymbolTable<Integer, Integer> st;

    private Integer[] items = new Integer[]{0,-1,1,-2,2,-3,3,-4,4,-5,5,-6,6};

    private List<Integer> itemList = shuffle(Arrays.asList(items));

    private Comparator<Integer> absComparator = (Integer o1, Integer o2) ->
            ((Integer) Math.abs(o1)).compareTo(Math.abs(o2));

    private List<Integer> shuffle(List<Integer> lst) {
        Collections.shuffle(lst);
        return lst;
    }

    @Test
    public void testSymbolTable() {
        st = new BSTSymbolTable<>();
        for (Integer item: itemList) {
            st.put(item, item);
        }
        assertEquals(st.select(4), new Integer(-2));
        assertEquals(((Queue<Integer>) st.keys(-2, 2)).size(), 5);
        assertEquals(st.size(-2, 2), 5);
    }

    @Test
    public void testSymbolTableComparator() {
        st = new BSTSymbolTable<>(absComparator);
        for (Integer item: itemList) {
            st.put(item, item);
        }
        assertEquals(Math.abs(st.select(4)), Math.abs(4));
    }

}