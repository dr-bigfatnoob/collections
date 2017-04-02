package us.bigfatnoob.pq;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by @bigfatnoob on 4/2/17.
 * Test for Min Priority Queue.
 */
public class MinPQTest extends PriorityQueueTest{

    @Override
    protected void setUp() {
        priorityQueue = new MinPQ<>();
    }

    @Override
    protected void setUpComparator() {
        priorityQueue = new MinPQ<>(absComparator);
    }

    @Test
    public void testMin() {
        setUp();
        insertAll();
        Assert.assertEquals(getMin(), ((MinPQ) priorityQueue).min());
    }

    @Test
    public void testDelMin() {
        setUp();
        insertAll();
        Assert.assertEquals(getMin(), ((MinPQ) priorityQueue).delMin());
        Assert.assertEquals(size() - 1, priorityQueue.size());
    }

    @Test
    public void testComparatorMin() {
        setUpComparator();
        insertAll();
        Assert.assertEquals(getCompMin(), ((MinPQ) priorityQueue).min());
    }

    @Test
    public void testComparatorDelMin() {
        setUpComparator();
        insertAll();
        Assert.assertEquals(getCompMin(), ((MinPQ) priorityQueue).delMin());
        Assert.assertEquals(size() - 1, priorityQueue.size());
    }
}