package us.bigfatnoob.priorityqueue;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by @bigfatnoob on 4/2/17.
 */
public class MaxPQTest extends PriorityQueueTest {

    @Override
    protected void setUp() {
        priorityQueue = new MaxPQ<>();
    }

    @Override
    protected void setUpComparator() {
        priorityQueue = new MaxPQ<>(absComparator);
    }

    @Test
    public void testMax() {
        setUp();
        insertAll();
        Assert.assertEquals(getMax(), ((MaxPQ) priorityQueue).max());
    }

    @Test
    public void testDelMax() {
        setUp();
        insertAll();
        Assert.assertEquals(getMax(), ((MaxPQ) priorityQueue).delMax());
        Assert.assertEquals(size() - 1, priorityQueue.size());
    }

    @Test
    public void testComparatorMax() {
        setUpComparator();
        insertAll();
        Assert.assertEquals(getCompMax(), ((MaxPQ) priorityQueue).max());
    }

    @Test
    public void testComparatorDelMax() {
        setUpComparator();
        insertAll();
        Assert.assertEquals(getCompMax(), ((MaxPQ) priorityQueue).delMax());
        Assert.assertEquals(size() - 1, priorityQueue.size());
    }

}