package us.bigfatnoob.priorityqueue;

import us.bigfatnoob.utils.Compare;

import java.util.Comparator;

/**
 * Created by @bigfatnoob on 4/2/17.
 * Min Priority Queue implementation.
 */
public class MinPQ<Item> extends PriorityQueue<Item>{

    /***
     * Create a new instance of a Min Priority Queue
     */
    public MinPQ() {
        super(1);
        this.order = Compare.Order.ASCENDING;
    }

    /***
     * Create a new instance of a priority queue with an initial size
     * @param capacity: Initial size of the priority queue.
     */
    public MinPQ(int capacity) {
        super(capacity);
        this.order = Compare.Order.ASCENDING;
    }

    /***
     * Create a new instance of a priority queue using a comparator.
     * @param comparator: Instance of comparator
     */
    public MinPQ(Comparator<Item> comparator) {
        super(1, comparator);
        this.order = Compare.Order.ASCENDING;
    }

    /***
     * Create a new instance of a priority queue using a comparator and
     * and initial size
     * @param capacity: Initial size of the priority queue.
     * @param comparator: Instance of comparator
     */
    public MinPQ(int capacity, Comparator<Item> comparator) {
        super(capacity, comparator);
        this.order = Compare.Order.ASCENDING;
    }

    /***
     * Return the minimum Item from the priority queue.
     * @return - Min Item from the priority queue.
     */
    public Item min() {
        return head();
    }

    /***
     * Delete and return the minimum Item from the priority queue.
     * @return - Min Item from priority queue.
     */
    public Item delMin() {
        return delHead();
    }

}
