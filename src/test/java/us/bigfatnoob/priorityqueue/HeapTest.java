package us.bigfatnoob.priorityqueue;

import org.junit.Test;
import us.bigfatnoob.utils.Compare;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import static org.junit.Assert.*;


/**
 * Created by @bigfatnoob on 4/2/17.
 * Test functions of the heap.
 */
public class HeapTest {

    private Heap<Integer> heap;

    private Integer[] items = new Integer[]{0,-1,1,-2,2,-3,3,-4,4,-5,5,-6,6};

    private List<Integer> itemList = Arrays.asList(items);

    private Comparator<Integer> absComparator = (Integer o1, Integer o2) ->
            ((Integer) Math.abs(o1)).compareTo(Math.abs(o2));

    @Test(expected = NullPointerException.class)
    public void testNullPointer() {
        heap = new Heap<Integer>(null);
    }

    @Test
    public void testMaxHeap() {
        heap = new Heap<Integer>(items, Compare.Order.DESCENDING);
        assertEquals(Collections.max(itemList), heap.root());
    }

    @Test
    public void testMinHeap() {
        heap = new Heap<Integer>(items, Compare.Order.ASCENDING);
        assertEquals(Collections.min(itemList), heap.root());
    }

    @Test
    public void testMaxHeapComparator() {
        heap = new Heap<Integer>(items, absComparator, Compare.Order.DESCENDING);
        assertEquals(Collections.max(itemList, absComparator), heap.root());
    }

    @Test
    public void testMinHeapComparator() {
        heap = new Heap<Integer>(items, absComparator, Compare.Order.ASCENDING);
        assertEquals(Collections.min(itemList, absComparator), heap.root());
    }

}