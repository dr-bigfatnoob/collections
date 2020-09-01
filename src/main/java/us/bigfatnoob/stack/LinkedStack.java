package us.bigfatnoob.stack;

import us.bigfatnoob.queue.LinkedQueue;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by @bigfatnoob on 3/23/17.
 * Linked List based implementation of Stack.
 */
public class LinkedStack<Item> implements Stack<Item>{

    /***
     * Each node of a class.
     */
    private class Node<Item> {
        /***
         * Instance of item.
         */
        Item item;

        /***
         * Next element of stack.
         */
        Node<Item> next;

        Node(Item item) {
            this.item = item;
        }

    }

    /***
     * Head of stack.
     */
    private Node<Item> head;

    /***
     * Size of stack.
     */
    private int size;

    public void push(Item item) {
        if (item == null)
            throw new NullPointerException();
        Node<Item> node = new Node<>(item);
        Node<Item> oldHead = head;
        if (oldHead == null) {
            head = node;
        } else {
            node.next = oldHead;
            head = node;
        }
        size++;
    }

    public Item pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Item item = head.item;
        head = head.next;
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
        return size==0;
    }

    public int size() {
        return size;
    }


    /***
     * Return an iterator over the items in LIFO order.
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
