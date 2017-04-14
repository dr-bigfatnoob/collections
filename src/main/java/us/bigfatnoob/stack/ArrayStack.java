package us.bigfatnoob.stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by @bigfatnoob on 3/23/17.
 * Array based implementation of Stack.
 */
public class ArrayStack<Item> implements Stack<Item> {

    /***
     * Items in stack.
     */
    private Item[] items;

    /***
     * Size of stack.
     */
    private int size;

    public ArrayStack() {
        items = (Item[]) new Object[1];
    }

    public void push(Item item) {
        if (item == null)
            throw new NullPointerException();
        if (size == items.length)
            resize(2 * items.length);
        items[size++] = item;
    }

    public Item pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return items[--size];
    }

    public Item peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return items[size-1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    /***
     * Resize items. Complexity O(n)
     * @param capacity: Capacity after resizing.
     */
    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        System.arraycopy(items, 0, copy, 0, size);
        items = copy;
    }

    /***
     * Return an iterator over the items in LIFO order.
     * @return - Instance of iterator
     */
    @Override
    public Iterator<Item> iterator() {
        return new ArrayIterator(size - 1);
    }

    private class ArrayIterator implements Iterator<Item> {

        private int current;

        ArrayIterator(int end) {
            this.current = end;
        }

        @Override
        public boolean hasNext() {
            return current >= 0;
        }

        @Override
        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException();
            return items[current--];
        }
    }
}
