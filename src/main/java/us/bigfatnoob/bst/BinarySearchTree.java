package us.bigfatnoob.bst;

import us.bigfatnoob.bst.nodes.Node;
import us.bigfatnoob.queue.LinkedQueue;
import us.bigfatnoob.queue.Queue;
import us.bigfatnoob.utils.Compare;
import java.util.Comparator;

/**
 * Created by @bigfatnoob on 4/13/17.
 * Instance of BinarySearchTree. Read more here(@link https://en.wikipedia.org/wiki/Binary_search_tree)
 */
public class BinarySearchTree<Key, Value> {

    protected Node<Key, Value> root;

    protected Comparator<Key> comparator;

    /***
     * Create a binary search tree.
     */
    public BinarySearchTree() {}

    /***
     * Create a binary search tree using a comparator.
     * @param comparator: Instance of comparator
     */
    public BinarySearchTree(Comparator<Key> comparator) {
        this.comparator = comparator;
    }

    /***
     * @return - Root of the BST.
     */
    public Node<Key, Value> getRoot() {
        return root;
    }

    /***
     * @return - Return comparator
     */
    public Comparator<Key> getComparator() {
        return comparator;
    }

    /***
     * Return size of the BST.
     * @return - Size of BST
     */
    public int size(){
        return size(root);
    }

    /***
     * Return number of keys between two keys.
     * @param low - Lower bound for search.
     * @param high - Upper bound for search.
     * @return
     */
    public int size(Key low, Key high) {
        if (low == null || high == null)
            throw new NullPointerException("Arguments to size cannot be null");
        if (Compare.compare(low, high, comparator) > 0)
            return 0;
        if (contains(high))
            return rank(high) - rank(low) + 1;
        else
            return rank(high) - rank(low);
    }

    /***
     * Check if Binary Search Tree is Empty
     * @return - True if BST is empty.
     */
    public boolean isEmpty() {
        return size(root) == 0;
    }

    /***
     * Check if key exists in the binary search tree.
     * @param key - Key to be checked
     * @return - True if key exists
     */
    public boolean contains(Key key) {
        if (key == null) throw new NullPointerException("argument to contains is null");
        return get(key) != null;
    }

    /***
     * Get the value of a key from the BST.
     * @param key: Instance of key.
     * @return - Value of the node matching the key else null.
     */
    public Value get(Key key) {
        Node<Key, Value> current = root;
        while (current != null) {
            int status = Compare.compare(key, current.getKey(), comparator);
            if (status < 0)
                current = current.getLeft();
            else if (status > 0)
                current = current.getRight();
            else
                return current.getValue();
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
        Node<Key, Value> current = root;
        if (current == null)
            throw new NullPointerException("BST is empty");
        return minimum(current).getKey();
    }


    /***
     * Find the rightmost key of BST.
     * @return - The rightmost key in BST.
     */
    public Key maximum() {
        Node<Key, Value> current = root;
        if (current == null)
            throw new NullPointerException("BST is empty");
        return maximum(current).getKey();
    }


    /***
     * Find the floor of the key in BST.
     * @param key: Key to be compared against.
     * @return - Floor of key in BST.
     */
    public Key floor(Key key) {
        if (root == null)
            throw new NullPointerException("BST is empty");
        Node<Key, Value> node = floor(root, key);
        if (node == null)
            return null;
        return node.getKey();
    }


    /***
     * Find the ceiling of the key in BST.
     * @param key: Key to be compared against.
     * @return - Ceiling of key in BST.
     */
    public Key ceil(Key key) {
        if (root == null)
            throw new NullPointerException("BST is empty");
        Node<Key, Value> node = ceil(root, key);
        if (node == null)
            return null;
        return node.getKey();
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
     * Get key from BST with a certain rank
     * @param rank - Rank of key to be retrieved.
     * @return - Key
     */
    public Key select(int rank) {
        if (rank < 0 || rank > size() - 1)
            throw new IndexOutOfBoundsException("Index out of bounds for a table with size " + size());
        Node<Key, Value> node = root;
        int currentRank = rank(node.getKey());
        while (rank != currentRank) {
            if (rank < currentRank)
                node = node.getLeft();
            else
                node = node.getRight();
            currentRank = rank(node.getKey());
        }
        return node.getKey();
    }

    /***
     * Delete node minimum key in the BST.
     */
    public void deleteMin() {
        if (isEmpty())
            throw new NullPointerException("The BST is empty");
        root = deleteMin(root);
    }


    /***
     * Delete node minimum key in the BST.
     */
    public void deleteMax() {
        if (isEmpty())
            throw new NullPointerException("The BST is empty");
        root = deleteMax(root);
    }


    /***
     * Delete node with a key from BST
     * @param key - Key of node to be deleted.
     */
    public void delete(Key key) {
        if (key == null)
            throw new NullPointerException("key is null");
        root = delete(root, key);
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
     * Retrieve keys between two keys.
     * @param low: Lower of the key to fetch.
     * @param high: Higher of the key to fetch.
     * @return - Queue of keys between low and high in sequential order.
     */
    public Iterable<Key> keys(Key low, Key high) {
        if (low == null || high == null)
            throw new NullPointerException("Arguments to size cannot be null");
        Queue<Key> queue = new LinkedQueue<Key>();
        keys(root, queue, low, high);
        return queue;
    }

    /***
     * Return the minimum child in the node.
     * @param node - Base node.
     * @return - the minimum node under this node.
     */
    protected Node<Key, Value> minimum(Node<Key, Value> node) {
        Node<Key, Value> current = node;
        while (true) {
            if (current.getLeft() != null)
                current = current.getLeft();
            else
                return current;
        }
    }


    /***
     * Return the maximum child in the node.
     * @param node - Base node.
     * @return - the maximum node under this node.
     */
    protected Node<Key, Value> maximum(Node<Key, Value> node) {
        Node<Key, Value> current = node;
        while (true) {
            if (current.getRight() != null)
                current = current.getRight();
            else
                return current;
        }
    }

    /***
     * Helper method to recursively fetch keys between low and high
     * @param node - Current node in search.
     * @param queue - Queue to populate keys.
     * @param low - Lower limit of search.
     * @param high - Higher limit of search.
     */
    private void keys(Node<Key, Value> node, Queue<Key> queue, Key low, Key high) {
        if (node == null)
            return;
        int lowStatus = Compare.compare(low, node.getKey(), comparator);
        int highStatus = Compare.compare(high, node.getKey(), comparator);
        if (lowStatus < 0)
            keys(node.getLeft(), queue, low, high);
        if (lowStatus <=0 && highStatus>=0)
            queue.enqueue(node.getKey());
        if (highStatus > 0)
            keys(node.getRight(), queue, low, high);
    }


    /***
     * Helper method which is recursively called
     * to insert a node in the BST
     * @param node: Instance of node compared against.
     * @param key: Instance of key.
     * @param value: Value of Node.
     * @return - Node which was compared against.
     */
    private Node<Key, Value> put(Node<Key, Value> node, Key key, Value value) {
        if (node == null)
            return new Node<Key, Value>(key, value, 1);
        int status = Compare.compare(key, node.getKey(), comparator);
        if (status < 0)
            node.setLeft(put(node.getLeft(), key, value));
        else if (status > 0)
            node.setRight(put(node.getRight(), key, value));
        else
            node.setValue(value);
        node.setSize(1 + size(node.getLeft()) + size(node.getRight()));
        return node;
    }


    /***
     * Helper method recursively called
     * to find the floor of a key.
     * @param node: Instance of node compared against.
     * @param key: Instance of key
     * @return - Closest floor node.
     */
    private Node<Key, Value> floor(Node<Key, Value> node, Key key) {
        if (node == null)
            return null;
        int status = Compare.compare(key, node.getKey(), comparator);
        if (status == 0)
            return node;
        if (status < 0)
            return floor(node.getLeft(), key);
        Node<Key, Value> right = floor(node.getRight(), key);
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
    private Node<Key, Value> ceil(Node<Key, Value> node, Key key) {
        if (node == null)
            return null;
        int status = Compare.compare(key, node.getKey(), comparator);
        if (status == 0)
            return node;
        if (status > 0)
            return ceil(node.getRight(), key);
        Node<Key, Value> left = ceil(node.getLeft(), key);
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
    protected int size(Node<Key, Value> node) {
        if (node == null)
            return 0;
        return node.getSize();
    }


    /***
     * Helper method recursively called
     * to find rank of the key.
     * @param node: Instance of current node.
     * @param key: Key to be compared against.
     * @return - Rank of the node.
     */
    private int rank(Node<Key, Value> node, Key key) {
        if (key == null)
            return 0;
        int status = Compare.compare(key, node.getKey(), comparator);
        if (status < 0)
            return rank(node.getLeft(), key);
        else if (status > 0)
            return 1 + size(node.getLeft()) + rank(node.getRight(), key);
        else
            return size(node.getLeft());
    }


    /***
     * Helper method to delete the min node.
     * Find node with left node as null and replace it with its right child.
     * @param node - Node to be checked.
     * @return - Node updated once min is deleted
     */
    private Node<Key, Value> deleteMin(Node<Key, Value> node) {
        if (node.getLeft() == null)
            return node.getRight();
        node.setLeft(deleteMin(node.getLeft()));
        node.setSize(1 + size(node.getLeft()) + size(node.getRight()));
        return node;
    }


    /***
     * Helper method to delete the min node.
     * Find node with left node as null and replace it with its right child.
     * @param node - Node to be checked.
     * @return - Node updated once min is deleted
     */
    private Node<Key, Value> deleteMax(Node<Key, Value> node) {
        if (node.getRight() == null)
            return node.getLeft();
        node.setRight(deleteMax(node.getRight()));
        node.setSize(1 + size(node.getLeft()) + size(node.getRight()));
        return node;
    }


    /***
     * Delete node with a certain key in the BST.
     * @param node - Node compared against.
     * @param key - Key to be deleted.
     * @return - Node once key is deleted.
     */
    private Node<Key, Value> delete(Node<Key, Value> node, Key key) {
        if (node == null)
            return null;
        int status = Compare.compare(key, node.getKey(), comparator);
        if (status < 0)
            node.setLeft(delete(node.getLeft(), key));
        else if (status > 0)
            node.setRight(delete(node.getRight(), key));
        else {
            if (node.getLeft() == null)
                return node.getRight();
            if (node.getRight() == null)
                return node.getLeft();
            Node<Key, Value> temp = node;
            if (Math.random() < 0.5) {
                node = maximum(temp.getLeft());
                node.setLeft(deleteMax(temp.getLeft()));
                node.setRight(temp.getRight());
            } else {
                node = minimum(temp.getRight());
                node.setRight(deleteMin(temp.getRight()));
                node.setLeft(temp.getLeft());
            }
        }
        node.setSize(1 + size(node.getLeft()) + size(node.getRight()));
        return node;
    }

    /***
     * Helper method to traverse a BST inorder.
     * @param node: Instance of helper node.
     * @param queue: Queue used to bookmark.
     */
    private void inOrderTraverse(Node<Key, Value> node, Queue<Key> queue) {
        if (node == null)
            return;
        inOrderTraverse(node.getLeft(), queue);
        queue.enqueue(node.getKey());
        inOrderTraverse(node.getRight(), queue);
    }
}
