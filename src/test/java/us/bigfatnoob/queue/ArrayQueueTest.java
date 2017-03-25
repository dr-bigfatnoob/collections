package us.bigfatnoob.queue;

import org.junit.Before;

import static org.junit.Assert.*;

/**
 * Created by @bigfatnoob on 3/24/17.
 * Test for ArrayQueue.
 */
public class ArrayQueueTest extends QueueTest{
    @Before
    public void setUp() throws Exception {
        queue = new ArrayQueue<Integer>();
    }
}