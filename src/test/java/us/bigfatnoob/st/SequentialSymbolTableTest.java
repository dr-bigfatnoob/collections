package us.bigfatnoob.st;

import org.junit.Before;

/**
 * Test for SequentialSymbolTable
 * Created by @bigfatnoob on 5/7/17.
 */
public class SequentialSymbolTableTest extends SymbolTableTest{
    @Before
    public void initialize() {
        st = new SequentialSymbolTable<Integer, Integer>();
    }
}
