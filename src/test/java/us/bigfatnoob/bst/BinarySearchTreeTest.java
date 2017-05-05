package us.bigfatnoob.bst;

import org.junit.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by @bigfatnoob on 4/14/17.
 * Test functions for BinarySearchTree
 */
public class BinarySearchTreeTest {

    protected BinarySearchTree<Integer, Integer> bst;

    private Integer[] items = new Integer[]{0,-1,1,-2,2,-3,3,-4,4,-5,5,-6,6};

    private List<Integer> itemList = shuffle(Arrays.asList(items));


    private Comparator<Integer> absComparator = (Integer o1, Integer o2) ->
            ((Integer) Math.abs(o1)).compareTo(Math.abs(o2));


    @Test
    public void testBST() {
        initialize(null);
        for (Integer item: itemList) {
            bst.put(item, item);
        }
        assertEquals(bst.size(), itemList.size());
        assertEquals(bst.minimum(), Collections.min(itemList));
        assertEquals(bst.maximum(), Collections.max(itemList));
        assertEquals(bst.ceil(-7),new Integer(-6));
        assertEquals(bst.floor(7),new Integer(6));
        Collections.sort(itemList);
        assertEquals(bst.rank(4), itemList.indexOf(4));
        bst.deleteMin();
        assertEquals(bst.size(), itemList.size() - 1);
        assertEquals(bst.minimum(), itemList.get(1));
        bst.deleteMax();
        assertEquals(bst.size(), itemList.size() - 2);
        assertEquals(bst.maximum(), itemList.get(itemList.size() - 2));
        bst.delete(3);
        assertEquals(bst.size(), itemList.size() - 3);
        assertEquals(bst.contains(3), false);
    }


    @Test
    public void testBSTComparator() {
        initialize(absComparator);
        for (Integer item: itemList) {
            bst.put(item, item);
        }
        assertEquals(bst.size(), 7);
        assertEquals(bst.minimum(), Collections.min(itemList, absComparator));
        assertEquals(bst.maximum(), Collections.max(itemList, absComparator));
        assertEquals(bst.ceil(0),new Integer(0));
        assertEquals(Math.abs(bst.floor(7)), 6);
        Collections.sort(itemList, absComparator);
        assertEquals(bst.rank(4), 4);
        bst.deleteMin();
        assertEquals(bst.size(), 6);
        assertEquals(Math.abs(bst.minimum()), Math.abs(itemList.get(1)));
        bst.deleteMax();
        assertEquals(bst.size(), 5);
        assertEquals(Math.abs(bst.maximum()), -1 + Math.abs(itemList.get(itemList.size() - 1)));
    }


    private List<Integer> shuffle(List<Integer> lst) {
        Collections.shuffle(lst);
        return lst;
    }

    protected void initialize(Comparator<Integer> comparator) {
        bst = new BinarySearchTree<>(comparator);
    }

}