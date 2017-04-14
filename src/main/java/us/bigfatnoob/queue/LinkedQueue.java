package us.bigfatnoob.queue;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * Created by @bigfatnoob on 3/24/17.
 * Linked List based implementation of Queue.
 */
public class LinkedQueue<Item> implements Queue<Item> {

    /***
     * Each node of a class.
     */
    private class Node<Item> {
        /***
         * Instance of item.
         */
        Item item;

        /***
         * Next element of queue.
         */
        Node<Item> next;

        Node(Item item) {
            this.item = item;
        }

    }

    /***
     * Head of queue.
     */
    private Node<Item> head;


    /***
     * Tail of queue.
     */
    private Node<Item> tail;


    /***
     * Size of queue.
     */
    private int size;


    public void enqueue(Item item) {
        if (item == null)
            throw new NullPointerException();
        Node<Item> oldTail = tail;
        tail = new Node<Item>(item);
        if (isEmpty())
            head = tail;
        else
            oldTail.next = tail;
        size++;
    }

    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Item item = head.item;
        head = head.next;
        if (isEmpty())
            tail = null;
        size--;
        return item;
    }

    public Item peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return head.item;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }


    /***
     * Return an iterator over the items in FIFO order.
     * @return - Instance of iterator
     */
    @Override
    public Iterator<Item> iterator() {
        return new LinkedIterator(head);
    }


    private class LinkedIterator implements Iterator<Item> {

        private Node<Item> current;

        LinkedIterator(Node<Item> start) {
            current = start;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
