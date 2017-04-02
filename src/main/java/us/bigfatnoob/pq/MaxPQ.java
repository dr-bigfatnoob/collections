package us.bigfatnoob.pq;

import us.bigfatnoob.utils.Compare;

import java.util.Comparator;

/**
 * Created by @bigfatnoob on 4/2/17.
 * Max Priority Queue implementation.
 */
public class MaxPQ<Item> extends PriorityQueue<Item>{

    /***
     * Create a new instance of a Max Priority Queue
     */
    public MaxPQ(){
        super(1);
        this.order = Compare.Order.DESCENDING;
    }

    /***
     * Create a new instance of a priority queue with an initial size
     * @param capacity: Initial size of the priority queue.
     */
    public MaxPQ(int capacity) {
        super(capacity);
        this.order = Compare.Order.DESCENDING;
    }

    /***
     * Create a new instance of a priority queue using a comparator.
     * @param comparator: Instance of comparator
     */
    public MaxPQ(Comparator<Item> comparator) {
        super(1, comparator);
        this.order = Compare.Order.DESCENDING;
    }

    /***
     * Create a new instance of a priority queue using a comparator and
     * and initial size
     * @param capacity: Initial size of the priority queue.
     * @param comparator: Instance of comparator
     */
    public MaxPQ(int capacity, Comparator<Item> comparator) {
        super(capacity, comparator);
        this.order = Compare.Order.DESCENDING;
    }

    /***
     * Return the maximum Item from the priority queue.
     * @return - Max Item from the priority queue.
     */
    public Item max() {
        return head();
    }

    /***
     * Delete and return the maximum Item from the priority queue.
     * @return - Max Item from priority queue.
     */
    public Item delMax() {
        return delHead();
    }

}
