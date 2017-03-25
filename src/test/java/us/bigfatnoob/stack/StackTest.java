package us.bigfatnoob.stack;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

/**
 * Created by @bigfatnoob on 3/23/17.
 * Generic Test skeleton for Stack.
 */
public abstract class StackTest {

    Stack<Integer> stack;

    private Integer[] items = new Integer[]{0,1,2,3,4,5,6};

    private void insertAll() {
        for (Integer item : items) {
            stack.push(item);
        }
    }

    @Test(expected = NullPointerException.class)
    public void testNullPointer() {
        stack.push(null);
    }

    @Test(expected = NoSuchElementException.class)
    public void testEmptyPop() {
        stack.pop();
    }

    @Test(expected = NoSuchElementException.class)
    public void testEmptyPeek() {
        stack.peek();
    }

    @Test
    public void testEmpty() {
        assertTrue(stack.isEmpty());
    }


    @Test
    public void testPushAndSize() {
        insertAll();
        assertEquals("Stack size is not equal to array size", items.length, stack.size());
    }

    @Test
    public void testPopAndPeek() {
        insertAll();
        assertEquals("Popped item not equal to last item in array", items[items.length - 1], stack.pop());
        assertEquals("Peeked item not equal to last item in array", items[items.length - 2], stack.peek());
    }

}