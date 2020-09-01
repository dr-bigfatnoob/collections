package us.bigfatnoob.symboltable;

import org.junit.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.junit.Assert.*;

/**
 * Test functions for Symbol Table
 * Created by @bigfatnoob on 5/7/17.
 */
public abstract class SymbolTableTest {

    protected SymbolTable<Integer, Integer> st;

    private Integer[] items = new Integer[]{0,-1,1,-2,2,-3,3,-4,4,-5,5,-6,6};

    private List<Integer> itemList = shuffle(Arrays.asList(items));

    private List<Integer> shuffle(List<Integer> lst) {
        Collections.shuffle(lst);
        return lst;
    }

    @Test
    public void testSuccess() {
        for (Integer item: itemList) {
            st.put(item, item);
        }
        assertEquals(items.length, st.size());
        assertEquals(true, st.contains(0));
        assertEquals(false, st.contains(10));
        int i = 0;
        for (Integer item: st.keys()) {
            assertEquals(item, st.get(item));
            i++;
        }
        assertEquals(items.length, i);
        st.delete(5);
        assertEquals(items.length - 1, st.size());
        st.delete(10);
        assertEquals(items.length - 1, st.size());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void minTest() {
        st.min();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void maxTest() {
        st.max();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void floorTest() {
        st.floor(null);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void ceilingTest() {
        st.ceiling(null);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void rankTest() {
        st.rank(null);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void selectTest() {
        st.select(0);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void deleteMinTest() {
        st.deleteMin();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void deleteMaxTest() {
        st.deleteMax();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void sizeTest() {
        st.size(null, null);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void keysTest() {
        st.keys(null, null);
    }
}
