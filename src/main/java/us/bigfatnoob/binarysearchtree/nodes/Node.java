package us.bigfatnoob.binarysearchtree.nodes;

/**
 * Instance of Node used in a Binary Search Tree
 * Created by @bigfatnoob on 4/30/17.
 */
public class Node<Key, Value> {
    /***
     * Key for node which is used
     * to construct the BST.
     */
    protected Key key;

    /***
     * Value stored in the node.
     */
    protected Value value;

    /***
     * Left and Right child of the node.
     */
    protected Node<Key, Value> left, right;

    /***
     * Return number of nodes in the BST.
     */
    protected int size;

    protected Node(){}

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
    public Node(Key key, Value value, int size) {
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
     * Set the left child of the node.
     * @param left - Instance of the left child
     */
    public void setLeft(Node<Key, Value> left) {
        this.left = left;
    }

    /***
     * @return - Right child of node.
     */
    public Node<Key, Value> getRight() {
        return right;
    }

    /***
     * Set the right child of the node.
     * @param right - Instance of the right child
     */
    public void setRight(Node<Key, Value> right) {
        this.right = right;
    }

    /***
     * @return - Key of node.
     */
    public Key getKey() {
        return key;
    }

    /***
     * Set the key for node.
     * @param key - Key to be set.
     */
    public void setKey(Key key) {
        this.key = key;
    }

    /***
     * @return - Value of node.
     */
    public Value getValue() {
        return value;
    }

    /***
     * Set the value contained in the node.
     * @param value - Value to be set.
     */
    public void setValue(Value value) {
        this.value = value;
    }


    /***
     * @return - Size of the node
     */
    public int getSize() {
        return size;
    }

    /***
     * @param size - Set the size of the node.
     */
    public void setSize(int size) {
        this.size = size;
    }
}