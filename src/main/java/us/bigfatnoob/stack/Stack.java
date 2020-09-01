package us.bigfatnoob.stack;

/**
 * Created by @bigfatnoob on 3/23/17.
 * Interface defining basic actions
 * of a stack.
 */
public interface Stack<Item> extends Iterable<Item>{

    /***
     * Push an item into array.
     * @param item: Item to be pushed onto stack.
     */
    public void push(Item item);


    /***
     * Removes head of the stack and returns it.
     * @return item: head of stack.
     */
    public Item pop();


    /***
     * Look at the head of the stack and returns it.
     * @return item: head of stack.
     */
    public Item peek();


    /***
     * Check if stack is empty.
     * @return isEmpty: true if stack is empty.
     */
    public boolean isEmpty();


    /***
     * Return the size of the stack.
     * @return int: size of the stack.
     */
    public int size();
}
