package us.bigfatnoob.unionfind;

import org.junit.Before;

/**
 * Created by @bigfatnoob on 3/19/17.
 * Test for Quick Find
 */
public class QuickFindTest extends UnionFindTest{
    @Before
    public void setUp() throws Exception {
        unionFind = new QuickFind<Integer>(items);
    }
}