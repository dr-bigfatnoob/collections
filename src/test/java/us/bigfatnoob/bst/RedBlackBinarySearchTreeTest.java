package us.bigfatnoob.bst;

import java.util.Comparator;

import static org.junit.Assert.*;

/**
 * Created by @bigfatnoob on 5/1/17.
 * Test functions for RedBlackBinarySearchTree
 */
public class RedBlackBinarySearchTreeTest extends BinarySearchTreeTest{

    protected void initialize(Comparator<Integer> comparator) {
        bst = new RedBlackBinarySearchTree<>(comparator);
    }

}