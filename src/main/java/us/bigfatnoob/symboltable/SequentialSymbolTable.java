package us.bigfatnoob.symboltable;

import us.bigfatnoob.queue.LinkedQueue;
import us.bigfatnoob.queue.Queue;

/**
 * Sequential implementation of Symbol table using linked list.
 * Highly unoptimized implementation and should not be used directly
 * Created by @bigfatnoob on 5/7/17.
 */
public class SequentialSymbolTable<Key, Value> implements SymbolTable<Key, Value> {

    /***
     * Number of items int eh symbol table.
     */
    private int size;

    private Node head;

    @Override
    public void put(Key key, Value value) {
        if (key == null)
            throw new NullPointerException("Key to put cannot be null");
        for (Node node = head; node != null; node = node.next) {
            if (key.equals(node.key)) {
                node.value = value;
                return;
            }
        }
        head = new Node(key, value, head);
        size++;
    }

    @Override
    public Value get(Key key) {
        if (key == null)
            throw new NullPointerException("Key to search cannot be null");
        for (Node node = head; node != null; node = node.next)
            if (key.equals(node.key))
                return node.value;
        return null;
    }

    @Override
    public void delete(Key key) {
        if (key == null)
            throw new NullPointerException("Key to delete cannot be null");
        delete(head, key);
    }

    @Override
    public boolean contains(Key key) {
        return get(key) != null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Key min() {
        throw new UnsupportedOperationException("This is a sequential operation and cannot be supported optimally.");
    }

    @Override
    public Key max() {
        throw new UnsupportedOperationException("This is a sequential operation and cannot be supported optimally.");
    }

    @Override
    public Key floor(Key key) {
        throw new UnsupportedOperationException("This is a sequential operation and cannot be supported optimally.");
    }

    @Override
    public Key ceiling(Key key) {
        throw new UnsupportedOperationException("This is a sequential operation and cannot be supported optimally.");
    }

    @Override
    public int rank(Key key) {
        throw new UnsupportedOperationException("This is a sequential operation and cannot be supported optimally.");
    }

    @Override
    public Key select(int k) {
        throw new UnsupportedOperationException("This is a sequential operation and cannot be supported optimally.");
    }

    @Override
    public void deleteMin() {
        throw new UnsupportedOperationException("This is a sequential operation and cannot be supported optimally.");
    }

    @Override
    public void deleteMax() {
        throw new UnsupportedOperationException("This is a sequential operation and cannot be supported optimally.");
    }

    @Override
    public int size(Key low, Key high) {
        throw new UnsupportedOperationException("This is a sequential operation and cannot be supported optimally.");
    }

    @Override
    public Iterable<Key> keys(Key low, Key high) {
        throw new UnsupportedOperationException("This is a sequential operation and cannot be supported optimally.");
    }

    @Override
    public Iterable<Key> keys() {
        Queue<Key> queue = new LinkedQueue<Key>();
        for (Node node = head; node != null; node = node.next)
            queue.enqueue(node.key);
        return queue;
    }

    /******
     * Private Helper Utilities
     *******/

    /***
     * Helper class used to indicate each
     * element in the symbol table.
     */
    private class Node {
        private Key key;
        private Value value;
        private Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private Node delete(Node node, Key key) {
        if (node == null)
            return null;
        if (node.key.equals(key)) {
            size--;
            return node.next;
        }
        node.next = delete(node.next, key);
        return node;
    }
}
