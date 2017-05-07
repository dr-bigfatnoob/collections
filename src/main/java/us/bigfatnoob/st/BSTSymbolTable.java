package us.bigfatnoob.st;

import us.bigfatnoob.bst.RedBlackBinarySearchTree;
import java.util.Comparator;

/**
 * Binary Search Table based implementation
 * of Symbol Table.
 * Created by @bigfatnoob on 4/29/17.
 */
public class BSTSymbolTable<Key, Value> implements SymbolTable<Key, Value>{

    private RedBlackBinarySearchTree<Key, Value> bst;

    /***
     * Create an instance of Symbol Table
     * using Binary Search Tree.
     */
    public BSTSymbolTable() {
        bst = new RedBlackBinarySearchTree<Key, Value>();
    }

    public BSTSymbolTable(Comparator<Key> comparator) {
        bst = new RedBlackBinarySearchTree<Key, Value>(comparator);
    }

    @Override
    public void put(Key key, Value value) {
        bst.put(key, value);
    }

    @Override
    public Value get(Key key) {
        return bst.get(key);
    }

    @Override
    public void delete(Key key) {
        bst.delete(key);
    }

    @Override
    public boolean contains(Key key) {
        return bst.get(key) != null;
    }

    @Override
    public boolean isEmpty() {
        return bst.size() == 0;
    }

    @Override
    public int size() {
        return bst.size();
    }

    @Override
    public Key min() {
        return bst.minimum();
    }

    @Override
    public Key max() {
        return bst.maximum();
    }

    @Override
    public Key floor(Key key) {
        return bst.floor(key);
    }

    @Override
    public Key ceiling(Key key) {
        return bst.ceil(key);
    }

    @Override
    public int rank(Key key) {
        return bst.rank(key);
    }

    @Override
    public Key select(int k) {
        return bst.select(k);
    }

    @Override
    public void deleteMin() {
        bst.deleteMin();
    }

    @Override
    public void deleteMax() {
        bst.deleteMax();
    }

    @Override
    public int size(Key low, Key high) {
        return bst.size(low, high);
    }

    @Override
    public Iterable<Key> keys(Key low, Key high) {
        return bst.keys(low, high);
    }

    @Override
    public Iterable<Key> keys() {
        return bst.keys();
    }
}
