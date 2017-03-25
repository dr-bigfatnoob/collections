package us.bigfatnoob.stack;

import org.junit.Before;

import static org.junit.Assert.*;

/**
 * Created by @bigfatnoob on 3/24/17.
 * Test for LinkedStack.
 */
public class LinkedStackTest extends StackTest{
    @Before
    public void setUp() throws Exception {
        stack = new LinkedStack<Integer>();
    }
}