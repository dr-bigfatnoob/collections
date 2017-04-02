package us.bigfatnoob.pq;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by @bigfatnoob on 4/2/17.
 * Generic Test skeleton for Priority Queue.
 */
public abstract class PriorityQueueTest {

    PriorityQueue<Integer> priorityQueue;

    private Integer[] items = new Integer[]{0,-1,1,-2,2,-3,3,-4,4,-5,5,-6,6};

    private List<Integer> itemList = Arrays.asList(items);

    Comparator<Integer> absComparator = (Integer o1, Integer o2) ->
            ((Integer) Math.abs(o1)).compareTo(Math.abs(o2));

    protected abstract void setUp();

    protected abstract void setUpComparator();

    protected void insertAll() {
        for (Integer item : items) {
            priorityQueue.insert(item);
        }
    }

    protected int getMin() {
        return Collections.min(itemList);
    }

    protected int getMax() {
        return Collections.max(itemList);
    }

    protected int getCompMin() {
        return Collections.min(itemList, absComparator);
    }

    protected int getCompMax() {
        return Collections.max(itemList, absComparator);
    }

    protected int size() {
        return items.length;
    }

    @Test(expected = NullPointerException.class)
    public void testNullPointer() {
        priorityQueue.insert(null);
    }

    @Test
    public void testEmpty() {
        setUp();
        assertTrue(priorityQueue.isEmpty());
    }

    @Test
    public void testInsert() {
        setUp();
        insertAll();
        assertEquals(items.length, priorityQueue.size());
    }
}