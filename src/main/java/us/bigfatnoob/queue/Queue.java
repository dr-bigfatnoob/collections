package us.bigfatnoob.queue;

/**
 * Created by @bigfatnoob on 3/24/17.
 * Interface defining basic actions
 * if a queue.
 */
public interface Queue<Item> extends Iterable<Item>{

    /***
     * Insert an item onto queue
     * @param item: Item to be pushed onto queue.
     */
    public void enqueue(Item item);


    /***
     * Remove and return the least
     * recently added item onto queue
     * @return item: Tail of the queue
     */
    public Item dequeue();


    /***
     * Look at the tail of the queue and returns it.
     * @return item: Tail of the queue
     */
    public Item peek();


    /***
     * Check if the queue is empty.
     * @return isEmpty: true if queue is empty.
     */
    public boolean isEmpty();


    /***
     * Returns the size of the queue.
     * @return int: size of the queue.
     */
    public int size();
}
