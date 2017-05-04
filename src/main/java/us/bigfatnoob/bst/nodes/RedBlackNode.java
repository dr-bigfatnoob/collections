package us.bigfatnoob.bst.nodes;

/**
 * Created by @bigfatnoob on 4/30/17.
 */
public class RedBlackNode<Key, Value> extends Node {

    public static final boolean RED = true;

    public static final boolean BLACK = false;

    private boolean color;

    /***
     * Create an instance of red black node
     * @param key: Key for the node
     * @param value: Value for the node
     */
    public RedBlackNode(Key key, Value value) {
        super(key, value);
    }

    /***
     * Create an instance of red black node
     * @param key: Key for the node.
     * @param value: Value for the node.
     * @param size: Size of the node
     */
    public RedBlackNode(Key key, Value value, int size) {
        super(key, value, size);
    }

    /***
     * Create a red node
     * @param key
     * @param value
     * @param color
     * @param size
     */
    public RedBlackNode(Key key, Value value, boolean color, int size) {
        super(key, value, size);
        this.color = color;
    }

    /***
     * Set the color of the node to red or black
     * @param color: Set the color of the node.
     */
    public void setColor(boolean color) {
        this.color = color;
    }

    /***
     * Return the color of the node.
     * @return - Color of the node.
     */
    public boolean getColor() {
        return color;
    }
}
