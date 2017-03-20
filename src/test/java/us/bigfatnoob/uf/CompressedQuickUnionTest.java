package us.bigfatnoob.uf;

import org.junit.Before;

/**
 * Created by @bigfatnoob on 3/20/17.
 * Test for Path Compressed Union Find.
 */
public class CompressedQuickUnionTest extends UnionFindTest{
    @Before
    public void setUp() throws Exception {
        unionFind = new CompressedQuickUnion<Integer>(items);
    }
}