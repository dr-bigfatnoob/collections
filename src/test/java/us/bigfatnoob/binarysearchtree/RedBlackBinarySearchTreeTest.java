package us.bigfatnoob.binarysearchtree;

import java.util.Comparator;

/**
 * Created by @bigfatnoob on 5/1/17.
 * Test functions for RedBlackBinarySearchTree
 */
public class RedBlackBinarySearchTreeTest extends BinarySearchTreeTest{

    protected void initialize(Comparator<Integer> comparator) {
        bst = new RedBlackBinarySearchTree<>(comparator);
    }

}