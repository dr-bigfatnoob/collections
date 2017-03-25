package us.bigfatnoob.queue;

import java.util.NoSuchElementException;

/**
 * Created by @bigfatnoob on 3/24/17.
 * Linked List based implementation of Queue.
 */
public class LinkedQueue<Item> implements Queue<Item> {

    /***
     * Each node of a class.
     */
    private class Node {
        /***
         * Instance of item.
         */
        Item item;

        /***
         * Next element of queue.
         */
        Node next;

        Node(Item item) {
            this.item = item;
        }

    }

    /***
     * Head of queue.
     */
    private Node head;


    /***
     * Tail of queue.
     */
    private Node tail;


    /***
     * Size of queue.
     */
    private int size;


    public void enqueue(Item item) {
        if (item == null)
            throw new NullPointerException();
        Node oldTail = tail;
        tail = new Node(item);
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
}
