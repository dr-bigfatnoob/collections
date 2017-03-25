package us.bigfatnoob.stack;

import java.util.NoSuchElementException;

/**
 * Created by @bigfatnoob on 3/23/17.
 * Linked List based implementation of Stack.
 */
public class LinkedStack<Item> implements Stack<Item>{

    /***
     * Each node of a class.
     */
    private class Node {
        /***
         * Instance of item.
         */
        Item item;

        /***
         * Next element of stack.
         */
        Node next;

        Node(Item item) {
            this.item = item;
        }

    }

    /***
     * Head of stack.
     */
    private Node head;

    /***
     * Size of stack.
     */
    private int size;

    public void push(Item item) {
        if (item == null)
            throw new NullPointerException();
        Node node = new Node(item);
        Node oldHead = head;
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
}
