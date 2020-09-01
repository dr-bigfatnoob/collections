package us.bigfatnoob.symboltable;

import us.bigfatnoob.queue.LinkedQueue;
import us.bigfatnoob.queue.Queue;

/**
 * Hash Table implementation using Separate
 * Chaining Hash Technique.
 * Created by @bigfatnoob on 5/7/17.
 */
public class ChainedHashTable<Key, Value> implements SymbolTable<Key, Value> {
    private static final int DEFAULT_INITIAL_SIZE = 4;

    /***
     * Number of elements in the symbol table.
     */
    private int size;

    /***
     * Number of buckets in the symbol table.
     */
    private int buckets;

    /***
     * Array of sequential symbol tables.
     * This should be equal to m.
     */
    private SequentialSymbolTable<Key, Value>[] st;

    /***
     * Initialize an empty symbol table.
     */
    public ChainedHashTable() {
        this(DEFAULT_INITIAL_SIZE);
    }

    /***
     * Initialize an empty symbol table of size @<code>buckets</code>
     * @param buckets: Size of the symbol table.
     */
    public ChainedHashTable(int buckets) {
        this.buckets = buckets;
        st = (SequentialSymbolTable<Key, Value>[]) new SequentialSymbolTable[buckets];
        for (int i=0; i < this.buckets; i++)
            st[i] = new SequentialSymbolTable<Key, Value>();
    }

    @Override
    public void put(Key key, Value value) {
        if (key == null)
            throw new NullPointerException("Key to put cannot be null");
        if (size >= 10 * buckets)
            resize(2 * buckets);
        int hash = hash(key);
        if (!st[hash].contains(key))
            size++;
        st[hash(key)].put(key, value);
    }

    @Override
    public Value get(Key key) {
        if (key == null)
            throw new NullPointerException("Key to put cannot be null");
        return st[hash(key)].get(key);
    }

    @Override
    public void delete(Key key) {
        if (key == null)
            throw new NullPointerException("Key to put cannot be null");
        int hash = hash(key);
        if (st[hash].contains(key))
            size--;
        st[hash(key)].delete(key);
        if (buckets > DEFAULT_INITIAL_SIZE && size < 2 * buckets)
            resize(buckets / 2);
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
        for (SequentialSymbolTable<Key, Value> sst: st)
            for (Key key: sst.keys())
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
        return (key.hashCode() & 0x7fffffff) % buckets;
    }

    /***
     * Resize the SymbolTable
     * @param buckets: Number of buckets post resize.
     */
    private void resize(int buckets) {
        ChainedHashTable<Key, Value> temp = new ChainedHashTable<Key, Value>(buckets);
        for (int i = 0; i < this.buckets; i++)
            for (Key key: st[i].keys())
                temp.put(key, st[i].get(key));
        this.buckets = temp.buckets;
        this.size = temp.size;
        this.st = temp.st;
    }
}
