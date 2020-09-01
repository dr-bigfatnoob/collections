package us.bigfatnoob.set;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * Collection of distinct keys
 * Created by @bigfatnoob on 5/7/17.
 */
public class Set<Key> implements Iterable<Key> {

    /***†
     * Auxiliary data structure used
     * to store the elements. The
     * elements are stored as a
     * Red Black Binary Search Tree.
     */
    private TreeSet<Key> set;

    /***
     * Initialize an instance of Set.
     */
    public Set() {
        set = new TreeSet<Key>();
    }

    /***
     * Insert key into the set.
     * @param key: Key to be inserted.
     */
    public void add(Key key) {
        if (key == null)
            throw new NullPointerException("key for add cannot be null");
        set.add(key);
    }

    /***
     * Check if key exists in the set.
     * @param key: Key to be checked.
     * @return - True if key exists in Set.
     */
    public boolean contains(Key key) {
        if (key == null)
            throw new NullPointerException("key for contains cannot be null");
        return set.contains(key);
    }

    /***
     * Remove key from set.
     * @param key: Key to be removed.
     */
    public void remove(Key key) {
        if (key == null)
            throw new NullPointerException("key for remove cannot be null");
        set.remove(key);
    }

    /***
     * Return size of the set.
     * @return - size of the set.
     */
    public int size() {
        return set.size();
    }

    /***
     * Return union of the sets.
     * @param other - Set to compute union with
     * @return - Union of two sets.
     */
    public Set<Key> union(Set<Key> other) {
        Set<Key> union = new Set<Key>();
        for (Key key: this) {
            union.add(key);
        }
        for (Key key: other) {
            union.add(key);
        }
        return union;
    }

    /***
     * Return intersection of the sets.
     * @param other - Set to compute intersection with
     * @return - Intersection of two sets.
     */
    public Set<Key> intersection(Set<Key> other) {
        Set<Key> intersection = new Set<Key>();
        Set<Key> one, two;
        if (this.size() < other.size()) {
            one = this;
            two = other;
        } else {
            one = other;
            two = this;
        }
        for (Key key : one) {
            if (two.contains(key))
                intersection.add(key);
        }
        return intersection;
    }

    /***
     * Return difference of the set @other from @this.
     * @param other - Set to subtract
     * @return - @this - @other
     */
    public Set<Key> difference(Set<Key> other) {
        Set<Key> difference = new Set<Key>();
        for (Key key: this) {
            if (!other.contains(key))
                difference.add(key);
        }
        return difference;
    }

        @Override
    public Iterator<Key> iterator() {
        return set.iterator();
    }
}
