package us.bigfatnoob.uf;

import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Generic Test Skeleton for UnionFind
 */
public abstract class UnionFindTest {

    UnionFind<Integer> unionFind;
    final Integer[] items = new Integer[]{1,2,3,4,5,6,7,8,9};


    @Test
    public void test() throws Exception {
        unionFind.union(items[0], items[1]);
        unionFind.union(items[3], items[4]);
        unionFind.union(items[5], items[5]);
        unionFind.union(items[3], items[6]);
        unionFind.union(items[7], items[8]);
        unionFind.union(items[4], items[8]);
        unionFind.union(items[0], items[8]);
        assertTrue(unionFind.connected(items[0], items[1]));
        assertFalse(unionFind.connected(items[0], items[2]));
    }

}