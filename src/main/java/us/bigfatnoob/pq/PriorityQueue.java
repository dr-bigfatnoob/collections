package us.bigfatnoob.pq;

import us.bigfatnoob.utils.Compare;

import java.util.Comparator;

/**
 * Created by @bigfatnoob on 4/2/17.
 * Abstract Class for Priority Queue
 */
public abstract class PriorityQueue<Item> {

    /***
     * Auxiliary array that stores the contents of the PQ
     */
    protected Item[] pq;

    /***
     * Size of array
     */
    private int n = 0;

    /***
     * Optional instance of comparator
     */
    protected Comparator<Item> comparator;

    protected Compare.Order order;

    /***
     * Create a new instance of a priority queue with an initial size
     * @param capacity: Initial size of the priority queue.
     */
    PriorityQueue(int capacity) {
        pq = (Item[]) new Object[capacity + 1];
    }

    /***
     * Create a new instance of a priority queue using a comparator and
     * and initial size
     * @param capacity: Initial size of the priority queue.
     * @param comparator: Instance of comparator
     */
    PriorityQueue(int capacity, Comparator<Item> comparator) {
        this(capacity);
        this.comparator = comparator;
    }

    /***
     * Check if the priority queue is empty.
     * @return True if the priority queue is empty
     */
    public boolean isEmpty() {
        return n == 0;
    }

    /***
     * Insert a new item into the priority queue.
     * @param item: Instance of item to be inserted.
     */
    public void insert(Item item) {
        if ((n >= pq.length - 1))
            resize(2 * pq.length);
        pq[++n] = item;
        swim(n);
    }

    /***
     * Return size of the priority queue.
     * @return - Size of the priority queue.
     */
    public int size() {
        return n;
    }

    /***
     * Return the head of the priority queue.
     * @return - Head of the priority queue.
     */
    Item head() {
        if (isEmpty())
            throw new NullPointerException("Priority Queue is empty.");
        return pq[1];
    }

    /***
     * Delete and return the head of the priority queue.
     * @return - Head of the priority queue.
     */
    Item delHead() {
        if (isEmpty())
            throw new NullPointerException("Priority Queue is empty.");
        Item max = pq[1];
        Compare.exch(pq, 1, n--);
        sink(1);
        pq[n+1] = null;
        if (n > 0 && n == (pq.length - 1) / 4)
            resize(pq.length / 2);
        return max;
    }

    /***
     * If the child is larger than the parent, move it up the priority queue.
     * @param k: Index of item in array
     */
    protected void swim(int k) {
        while (k > 1 && less(pq[k/2], pq[k])) {
            Compare.exch(pq, k/2, k);
            k = k / 2;
        }
    }

    /***
     * If the parent is less than either children, move it down the priority queue.
     * @param k: Index of item in array.
     */
    protected void sink(int k) {
        while (2*k <= n) {
            int toSwap = 2*k;
            if (toSwap < n && less(pq[toSwap], pq[toSwap + 1]))
                toSwap++;
            if (!less(pq[k], pq[toSwap]))
                break;
            Compare.exch(pq, toSwap, k);
            k = toSwap;
        }
    }

    /***
     * Resize items. Complexity O(n)
     * @param capacity: Capacity after resizing.
     */
    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        System.arraycopy(pq, 1, copy, 1, n);
        pq = copy;
    }

    private boolean less(Object one, Object two) {
        if (order.equals(Compare.Order.DESCENDING))
            return Compare.less(one, two, comparator);
        else
            return Compare.more(one, two, comparator);

    }

    private boolean more(Object one, Object two) {
        if (order.equals(Compare.Order.DESCENDING))
            return Compare.more(one, two, comparator);
        else
            return Compare.less(one, two, comparator);

    }

}
