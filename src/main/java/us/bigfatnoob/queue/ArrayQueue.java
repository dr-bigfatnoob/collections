package us.bigfatnoob.queue;

import java.util.NoSuchElementException;

/**
 * Created by @bigfatnoob on 3/24/17.
 * Array based implementation of Queue.
 */
public class ArrayQueue<Item> implements Queue<Item> {
    /***
     * Items in queue.
     */
    private Item[] items;

    /***
     * Size of queue.
     */
    private int size;

    private int start = 0;

    public ArrayQueue() {items = (Item []) new Object[1];}

    public void enqueue(Item item) {
        if (item == null)
            throw new NullPointerException();
        if (size == items.length - 1)
            resize(2 * (size + 1));
        items[size++] = item;
    }

    public Item dequeue() {
        if (isEmpty())
            throw new NoSuchElementException();
        Item item = items[start++];
        if ((size-start) > 0 && (size-start) == items.length / 4)
            resize(items.length / 2);
        return item;
    }

    public Item peek() {
        if (isEmpty())
            throw new NoSuchElementException();
        return items[start];
    }

    public boolean isEmpty() {
        return size - start == 0;
    }

    public int size() {
        return size - start;
    }

    /***
     * Resize items. Complexity O(n)
     * @param capacity: Capacity after resizing.
     */
    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        System.arraycopy(items, start, copy, 0, size);
        items = copy;
        start = 0;
    }
}
