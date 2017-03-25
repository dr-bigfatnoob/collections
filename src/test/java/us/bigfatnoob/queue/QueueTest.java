package us.bigfatnoob.queue;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

/**
 * Created by @bigfatnoob on 3/24/17.
 * Generic Test skeleton for Queue.
 */
public abstract class QueueTest {

    Queue<Integer> queue;

    private Integer[] items = new Integer[]{0,1,2,3,4,5,6};

    private void insertAll() {
        for (Integer item : items) {
            queue.enqueue(item);
        }
    }

    @Test(expected = NullPointerException.class)
    public void testNullPointer() {
        queue.enqueue(null);
    }

    @Test(expected = NoSuchElementException.class)
    public void testEmptyDeque() {
        queue.dequeue();
    }

    @Test(expected = NoSuchElementException.class)
    public void testEmptyPeek() {
        queue.peek();
    }

    @Test
    public void testEmpty() {
        assertTrue(queue.isEmpty());
    }


    @Test
    public void testEnqueueAndSize() {
        insertAll();
        assertEquals("Queue size is not equal to array size", items.length, queue.size());
    }

    @Test
    public void testDequeAndSize() {
        insertAll();
        assertEquals("Popped item not equal to last item in array", items[0], queue.dequeue());
        assertEquals("Peeked item not equal to last item in array", items[1], queue.peek());
    }
}