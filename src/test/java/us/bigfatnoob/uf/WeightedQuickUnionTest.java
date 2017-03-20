package us.bigfatnoob.uf;

import org.junit.Before;

/**
 * Created by @bigfatnoob on 3/20/17.
 * Test for Weighted Quick Union
 */
public class WeightedQuickUnionTest extends UnionFindTest{
    @Before
    public void setUp() throws Exception {
        unionFind = new WeightedQuickUnion<Integer>(items);
    }

}