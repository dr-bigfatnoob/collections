package us.bigfatnoob.bst;

import us.bigfatnoob.queue.LinkedQueue;
import us.bigfatnoob.queue.Queue;
import us.bigfatnoob.utils.Compare;

import java.util.Comparator;

/**
 * Created by @bigfatnoob on 4/13/17.
 * Instance of BinarySearchTree. Read more here(@link https://en.wikipedia.org/wiki/Binary_search_tree)
 */
public class BinarySearchTree<Key, Value> {

    private Node root;

    private Comparator<Key> comparator;

    private class Node {
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
        private Node left, right;

        /***
         * Return number of nodes in the BST.
         */
        private int size;

        /***
         * Create a new node.
         * @param key: Key for the node
         * @param value: Value for the node.
         */
        Node(Key key, Value value) {
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
    }


    /***
     * Create a binary search tree using a comparator.
     * @param comparator: Instance of comparator
     */
    public BinarySearchTree(Comparator<Key> comparator) {
        this.comparator = comparator;
    }


    /***
     * Create a binary search tree.
     */
    public BinarySearchTree() {}

    /***
     * Return size of the BST.
     * @return - Size of BST
     */
    public int size(){
        return size(root);
    }


    /***
     * Get the value of a key from the BST.
     * @param key: Instance of key.
     * @return - Value of the node matching the key else null.
     */
    public Value get(Key key) {
        Node current = root;
        while (current != null) {
            int status = Compare.compare(key, current.key, comparator);
            if (status < 0)
                current = current.left;
            else if (status > 0)
                current = current.right;
            else
                return current.value;
        }
        return null;
    }


    /***
     * Insert new node into the BST.
     * @param key: Instance of key.
     * @param value: Value of Node.
     */
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }


    /***
     * Find the leftmost key of the BST.
     * @return - The leftmost key in BST.
     */
    public Key minimum() {
        Node current = root;
        if (current == null)
            throw new NullPointerException("BST is empty");
        return minimum(current).key;
    }


    /***
     * Find the rightmost key of BST.
     * @return - The rightmost key in BST.
     */
    public Key maximum() {
        Node current = root;
        if (current == null)
            throw new NullPointerException("BST is empty");
        return maximum(current).key;
    }


    /***
     * Find the floor of the key in BST.
     * @param key: Key to be compared against.
     * @return - Floor of key in BST.
     */
    public Key floor(Key key) {
        if (root == null)
            throw new NullPointerException("BST is empty");
        Node node = floor(root, key);
        if (node == null)
            return null;
        return node.key;
    }


    /***
     * Find the ceiling of the key in BST.
     * @param key: Key to be compared against.
     * @return - Ceiling of key in BST.
     */
    public Key ceil(Key key) {
        if (root == null)
            throw new NullPointerException("BST is empty");
        Node node = ceil(root, key);
        if (node == null)
            return null;
        return node.key;
    }


    /***
     * Return rank of the key in the BST
     * @param key: Key to find the rank of the BST.
     * @return - Rank of the key.
     */
    public int rank(Key key) {
        return rank(root, key);
    }


    /***
     * Delete node minimum key in the BST.
     */
    public void deleteMin() {
        root = deleteMin(root);
    }


    /***
     * Delete node minimum key in the BST.
     */
    public void deleteMax() {
        root = deleteMax(root);
    }


    /***
     * Delete node with a key from BST
     * @param key - Key of node to be deleted.
     */
    public void delete(Key key) {
        root = delete(root, key);
    }


    /***
     * Delete node with a certain key in the BST.
     * @param node - Node compared against.
     * @param key - Key to be deleted.
     * @return - Node once key is deleted.
     */
    private Node delete(Node node, Key key) {
        if (node == null)
            return null;
        int status = Compare.compare(key, node.key, comparator);
        if (status < 0)
            node.left = delete(node.left, key);
        else if (status > 0)
            node.right = delete(node.right, key);
        else {
            if (node.left == null)
                return node.right;
            if (node.right == null)
                return node.left;
            Node temp = node;
            if (Math.random() < 0.5) {
                node = maximum(temp.left);
                node.left = deleteMax(temp.left);
                node.right = temp.right;
            } else {
                node = minimum(temp.right);
                node.right = deleteMin(temp.right);
                node.left = temp.left;
            }
        }
        node.size = 1 + size(node.left) + size(node.right);
        return node;
    }


    /***
     * Retrieve all the keys in BST traversed inorder
     * @return - Iterable instance of all keys in BST.
     */
    public Iterable<Key> keys() {
        if (root == null)
            throw new NullPointerException("BST is empty");
        Queue<Key> queue = new LinkedQueue<>();
        inOrderTraverse(root, queue);
        return queue;
    }


    /***
     * Helper method which is recursively called
     * to insert a node in the BST
     * @param node: Instance of node compared against.
     * @param key: Instance of key.
     * @param value: Value of Node.
     * @return - Node which was compared against.
     */
    private Node put(Node node, Key key, Value value) {
        if (node == null)
            return new Node(key, value, 1);
        int status = Compare.compare(key, node.key, comparator);
        if (status < 0)
            node.left = put(node.left, key, value);
        else if (status > 0)
            node.right = put(node.right, key, value);
        else
            node.value = value;
        node.size = 1 + size(node.left) + size(node.right);
        return node;
    }


    /***
     * Helper method recursively called
     * to find the floor of a key.
     * @param node: Instance of node compared against.
     * @param key: Instance of key
     * @return - Closest floor node.
     */
    private Node floor(Node node, Key key) {
        if (node == null)
            return null;
        int status = Compare.compare(key, node.key, comparator);
        if (status == 0)
            return node;
        if (status < 0)
            return floor(node.left, key);
        Node right = floor(node.right, key);
        if (right != null)
            return right;
        else
            return node;
    }


    /***
     * Helper method recursively called
     * to find the ceil of a key.
     * @param node: Instance of node compared against.
     * @param key: Instance of key
     * @return - Closest ceil node.
     */
    private Node ceil(Node node, Key key) {
        if (node == null)
            return null;
        int status = Compare.compare(key, node.key, comparator);
        if (status == 0)
            return node;
        if (status > 0)
            return ceil(node.right, key);
        Node left = ceil(node.left, key);
        if (left != null)
            return left;
        else
            return node;
    }


    /***
     * Return size of the node.
     * @param node: Instance of node.
     * @return - Size of the node.
     */
    private int size(Node node) {
        if (node == null)
            return 0;
        return node.size;
    }


    /***
     * Helper method recursively called
     * to find rank of the key.
     * @param node: Instance of current node.
     * @param key: Key to be compared against.
     * @return - Rank of the node.
     */
    private int rank(Node node, Key key) {
        if (key == null)
            return 0;
        int status = Compare.compare(key, node.key, comparator);
        if (status < 0)
            return rank(node.left, key);
        else if (status > 0)
            return 1 + size(node.left) + rank(node.right, key);
        else
            return size(node.left);
    }


    /***
     * Helper method to delete the min node.
     * Find node with left node as null and replace it with its right child.
     * @param node - Node to be checked.
     * @return - Node updated once min is deleted
     */
    private Node deleteMin(Node node) {
        if (node.left == null)
            return node.right;
        node.left = deleteMin(node.left);
        node.size = 1 + size(node.left) + size(node.right);
        return node;
    }


    /***
     * Helper method to delete the min node.
     * Find node with left node as null and replace it with its right child.
     * @param node - Node to be checked.
     * @return - Node updated once min is deleted
     */
    private Node deleteMax(Node node) {
        if (node.right == null)
            return node.left;
        node.right = deleteMax(node.right);
        node.size = 1 + size(node.left) + size(node.right);
        return node;
    }


    /***
     * Return the minimum child in the node.
     * @param node - Base node.
     * @return - the minimum node under this node.
     */
    private Node minimum(Node node) {
        Node current = node;
        while (true) {
            if (current.left != null)
                current = current.left;
            else
                return current;
        }
    }


    /***
     * Return the maximum child in the node.
     * @param node - Base node.
     * @return - the maximum node under this node.
     */
    private Node maximum(Node node) {
        Node current = node;
        while (true) {
            if (current.right != null)
                current = current.right;
            else
                return current;
        }
    }


    /***
     * Helper method to traverse a BST inorder.
     * @param node: Instance of helper node.
     * @param queue: Queue used to bookmark.
     */
    private void inOrderTraverse(Node node, Queue<Key> queue) {
        if (node == null)
            return;
        inOrderTraverse(node.left, queue);
        queue.enqueue(node.key);
        inOrderTraverse(node.right, queue);
    }
}
