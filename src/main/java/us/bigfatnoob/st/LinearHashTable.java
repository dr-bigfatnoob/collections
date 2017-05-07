package us.bigfatnoob.st;

import us.bigfatnoob.queue.LinkedQueue;
import us.bigfatnoob.queue.Queue;

/**
 * Hash Table implementation using
 * Linear Probing Technique.
 * Created by @bigfatnoob on 5/7/17.
 */
public class LinearHashTable<Key, Value> implements SymbolTable<Key, Value> {
    private static final int DEFAULT_INITIAL_TABLE_SIZE = 4;

    /***
     * Number of elements in the symbol table.
     */
    private int size;

    /***
     * Size of the Array.
     */
    private int arraySize;

    /***
     * Array storing all the keys
     */
    private Key[] keys;

    /***
     * Array storing all the values
     */
    private Value[] values;

    /***
     * Create a linear hash table.
     */
    public LinearHashTable() {
        this(DEFAULT_INITIAL_TABLE_SIZE);
    }

    /**
     * Create a linear hash table of size @<code>arraySize</code>
     * @param arraySize: Size of the symbol table array.
     */
    public LinearHashTable(int arraySize) {
        this.arraySize = arraySize;
        size = 0;
        keys = (Key[]) new Object[arraySize];
        values = (Value[]) new Object[arraySize];
    }

    @Override
    public void put(Key key, Value value) {
        if (key == null)
            throw new NullPointerException("Key to put cannot be null");
        if (size >= arraySize/2)
            resize(2 * arraySize);
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % arraySize) {
            if (keys[i].equals(key)) {
                values[i] = value;
                return;
            }
        }
        keys[i] = key;
        values[i] = value;
        size++;
    }

    @Override
    public Value get(Key key) {
        if (key == null)
            throw new NullPointerException("Key to put cannot be null");
        for (int i = hash(key); keys[i] != null; i = (i + 1) % arraySize)
            if (keys[i].equals(key))
                return values[i];
        return null;
    }

    @Override
    public void delete(Key key) {
        if (key == null)
            throw new NullPointerException("Key to put cannot be null");
        if (!contains(key))
            return;
        int i = hash(key);
        while (!key.equals(keys[i])) {
            i = (i + 1) % arraySize;
        }
        keys[i] = null;
        values[i] = null;
        i = (i + 1) % arraySize;
        while (keys[i] != null) {
            Key k = keys[i];
            Value v = values[i];
            keys[i] = null;
            values[i] = null;
            size--;
            put(k, v);
            i = (i + 1) % arraySize;
        }
        size--;
        if (size > DEFAULT_INITIAL_TABLE_SIZE && size <= arraySize / 8)
            resize(arraySize / 2);
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
        for (Key key: keys)
            if (key != null)
                queue.enqueue(key);
        return queue;
    }

    /******
     * Private Helper Utilities
     *******/

    /***
     * Return a hash value between 0 and buckets-1
     * @param key: Key to be hashed
     * @return - Hash for key.
     */
    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % arraySize;
    }

    /***
     * Resize the SymbolTable
     * @param arraySize: Size of the array post resize.
     */
    private void resize(int arraySize) {
        LinearHashTable<Key, Value> temp = new LinearHashTable<Key, Value>(arraySize);
        for (int i = 0; i < this.arraySize; i++)
            if (keys[i] != null)
                temp.put(keys[i], values[i]);
        this.arraySize = temp.arraySize;
        this.size = temp.size;
        this.keys = temp.keys;
        this.values = temp.values;
    }
}
