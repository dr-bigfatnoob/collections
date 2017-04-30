package us.bigfatnoob.st;

import us.bigfatnoob.bst.BinarySearchTree;
import us.bigfatnoob.bst.Node;
import us.bigfatnoob.queue.LinkedQueue;
import us.bigfatnoob.queue.Queue;
import us.bigfatnoob.stack.LinkedStack;
import us.bigfatnoob.stack.Stack;
import us.bigfatnoob.utils.Compare;

import java.util.Comparator;

/**
 * Binary Search Table based implementation
 * of Symbol Table.
 * Created by @bigfatnoob on 4/29/17.
 */
public class BSTSymbolTable<Key, Value> implements SymbolTable<Key, Value>{

    private BinarySearchTree<Key, Value> bst;

    /***
     * Create an instance of Symbol Table
     * using Binary Search Tree.
     */
    public BSTSymbolTable() {
        bst = new BinarySearchTree<Key, Value>();
    }

    public BSTSymbolTable(Comparator<Key> comparator) {
        bst = new BinarySearchTree<Key, Value>(comparator);
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
        if (k < 0 || k > bst.size() - 1)
            throw new IndexOutOfBoundsException("Index out of bounds for a table with size " + bst.size());
        Stack<Node<Key, Value>> stack = new LinkedStack<Node<Key, Value>>();
        int i = -1;
        Node<Key, Value> node = bst.getRoot();
        stack.push(node);
        node = node.getLeft();
        while (!stack.isEmpty() || node != null) {
            if (node == null) {
                i++;
                if (i == k)
                    return stack.pop().getKey();
                node = stack.pop().getRight();
            } else {
                stack.push(node);
                node = node.getLeft();
            }
        }
        return null;
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
        Stack<Node<Key, Value>> stack = new LinkedStack<Node<Key, Value>>();
        Node<Key, Value> node = bst.getRoot();
        stack.push(node);
        node = node.getLeft();
        int count = 0;
        while (!stack.isEmpty() || node != null) {
            if (node == null) {
                if (Compare.compare(stack.peek().getKey(), high, bst.getComparator()) > 0) {
                    return count;
                } else if (Compare.compare(stack.peek().getKey(), low, bst.getComparator()) >= 0) {
                    ++count;
                }
                node = stack.pop().getRight();
            } else {
                stack.push(node);
                node = node.getLeft();
            }
        }
        return count;
    }

    @Override
    public Iterable<Key> keys(Key low, Key high) {
        Stack<Node<Key, Value>> stack = new LinkedStack<Node<Key, Value>>();
        Queue<Key> queue = new LinkedQueue<Key>();
        Node<Key, Value> node = bst.getRoot();
        stack.push(node);
        node = node.getLeft();
        while (!stack.isEmpty() || node != null) {
            if (node == null) {
                if (Compare.compare(stack.peek().getKey(), high, bst.getComparator()) > 0) {
                    return queue;
                } else if (Compare.compare(stack.peek().getKey(), low, bst.getComparator()) >= 0) {
                    queue.enqueue(stack.peek().getKey());
                }
                node = stack.pop().getRight();
            } else {
                stack.push(node);
                node = node.getLeft();
            }
        }
        return queue;
    }

    @Override
    public Iterable<Key> keys() {
        return bst.keys();
    }

    public static void main(String[] args) {
        Integer[] items = new Integer[]{0,1,2,3,4,5,6,7,8};
        SymbolTable<Integer, Integer> st = new BSTSymbolTable<>();
        for (Integer item: items)
            st.put(item, item);
        System.out.println(st.size(1, 4));
    }
}
