package us.bigfatnoob.bst;

/**
 * Instance of Node used in a Binary Search Tree
 * Created by @bigfatnoob on 4/30/17.
 */
public class Node<Key, Value> {
    /***
     * Key for node which is used
     * to construct the BST.
     */
    private Key key;

    /***
     * Value stored in the node.
     */
    private Value value;

    /***
     * Left and Right child of the node.
     */
    Node<Key, Value> left, right;

    /***
     * Return number of nodes in the BST.
     */
    int size;

    /***
     * Create a new node.
     * @param key: Key for the node
     * @param value: Value for the node.
     */
    public Node(Key key, Value value) {
        this.key = key;
        this.value = value;
    }

    /***
     * Create a new node.
     * @param key: Key for the node
     * @param value: Value for the node.
     * @param size: Size of the node.
     */
    Node(Key key, Value value, int size) {
        this.key = key;
        this.value = value;
        this.size = size;
    }

    /***
     * @return - Left child of node.
     */
    public Node<Key, Value> getLeft() {
        return left;
    }

    /***
     * @return - Right child of node.
     */
    public Node<Key, Value> getRight() {
        return right;
    }

    /***
     * @return - Key of node.
     */
    public Key getKey() {
        return key;
    }

    /***
     * @return - Value of node.
     */
    public Value getValue() {
        return value;
    }

    void setValue(Value value) {
        this.value = value;
    }
}