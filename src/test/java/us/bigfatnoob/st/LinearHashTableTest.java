package us.bigfatnoob.st;

import org.junit.Before;

/**
 * Test for LinearHashTable
 * Created by @bigfatnoob on 5/7/17.
 */
public class LinearHashTableTest extends SymbolTableTest {
    @Before
    public void initialize() {
        st = new LinearHashTable<Integer, Integer>();
    }
}
