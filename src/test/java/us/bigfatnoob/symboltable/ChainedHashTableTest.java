package us.bigfatnoob.symboltable;

import org.junit.Before;

/**
 * Test for ChainedHashedTable
 * Created by @bigfatnoob on 5/7/17.
 */
public class ChainedHashTableTest extends SymbolTableTest {
    @Before
    public void initialize() {
        st = new ChainedHashTable<Integer, Integer>();
    }
}
