package us.bigfatnoob.pq;

import us.bigfatnoob.utils.Compare;

import java.util.Comparator;

/**
 * Created by @bigfatnoob on 4/2/17.
 * Instance of Heap implemented using a Priority Queue.
 */
public class Heap<Item> {

    private PriorityQueue<Item> pq;

    /***
     * Create an instance of Heap
     * @param items: Contents of the heap.
     */
    public Heap(Item[] items) {
        this(items, null, Compare.Order.ASCENDING);
    }

    /***
     * Create an instance of Heap
     * @param items: Contents of the heap.
     * @param order: Order of the Heap.
     */
    public Heap(Item[] items, Compare.Order order) {
        this(items, null, order);
    }

    /***
     * Create an instance of Heap
     * @param items: Contents of the Heap
     * @param comparator: Comparator to orgainze the Heap
     */
    public Heap(Item[] items, Comparator<Item> comparator) {
        this(items, comparator, Compare.Order.ASCENDING);
    }

    /***
     * Create an instance of Heap using a comparator
     * @param items: Contents of the Heap
     * @param comparator: Comparator to organize the Heap
     * @param order: Order of the Heap.
     */
    public Heap(Item[] items, Comparator<Item> comparator, Compare.Order order) {
        if (items == null || items.length == 0)
            throw new NullPointerException("Items cannot be null or empty.");
        if (order.equals(Compare.Order.DESCENDING))
            pq = new MaxPQ<Item>(comparator);
        else
            pq = new MinPQ<Item>(comparator);
        for(Item item: items)
            pq.insert(item);
    }

    /***
     * If the parent is less than either children, move it down the priority queue.
     * @param k: Index of item in array.
     */
    public void sink(int k) {
        pq.sink(k);
    }

    /***
     * Return size of the Heap
     * @return - Size of heap.
     */
    public int size() {
        return pq.size();
    }

    /***
     * Return head of heap.
     * @return - Root of the heap.
     */
    public Item root() {
        return pq.head();
    }

    /***
     * Remove head of heap
     * @return - Root of the heap.
     */
    public Item delRoot() {
        return pq.delHead();
    }

    /***
     * Make a heap of the priority queue.
     */
    public void heapify() {
        for(int k = size()/2; k >= 1; k--)
            sink(k);
    }

}
