package us.bigfatnoob.bst;

import us.bigfatnoob.bst.nodes.Node;
import us.bigfatnoob.bst.nodes.RedBlackNode;
import us.bigfatnoob.utils.Compare;

import java.util.Comparator;

/**
 * Created by @bigfatnoob on 4/30/17.
 * Instance of RedBlackBinarySearchTree.
 * Read more here(@link https://en.wikipedia.org/wiki/Red%E2%80%93black_tree)
 */
public class RedBlackBinarySearchTree<Key, Value> extends BinarySearchTree<Key, Value> {

    /**
     * Create a red black binary search tree
     */
    public RedBlackBinarySearchTree() {
        super();
    }

    /**
     * Create a red black binary search tree using a comparator
     * @param comparator: Instance of comparator
     */
    public RedBlackBinarySearchTree(Comparator<Key> comparator) {
        super(comparator);
    }

    /***
     * Insert new node into the BST.
     * @param key: Instance of key.
     * @param value: Value of Node.
     */
    public void put(Key key, Value value) {
        root = putNode(root, key, value);
        ((RedBlackNode<Key, Value>) root).setColor(RedBlackNode.BLACK);
    }

    /***
     * Removes the smallest node from the BST.
     */
    public void deleteMin() {
        if (isEmpty())
            throw new NullPointerException("The BST is empty");
        if (!isRed(root.getLeft()) && !isRed(root.getRight()))
            ((RedBlackNode<Key, Value>) root).setColor(RedBlackNode.RED);
        root = deleteMin(root);
        if (!isEmpty())
            ((RedBlackNode<Key, Value>) root).setColor(RedBlackNode.BLACK);
    }

    /***
     * Removes the largest node from the BST.
     */
    public void deleteMax() {
        if (isEmpty())
            throw new NullPointerException("The BST is empty");
        if (!isRed(root.getLeft()) && !isRed(root.getRight()))
            ((RedBlackNode<Key, Value>) root).setColor(RedBlackNode.BLACK);
        root = deleteMax(root);
        if (!isEmpty())
            ((RedBlackNode<Key, Value>) root).setColor(RedBlackNode.BLACK);
    }

    /***
     * Delete key from the BST.
     * @param key - Key of node to be deleted.
     */
    public void delete(Key key) {
        if (key == null)
            throw new NullPointerException("key is null");
        if (!contains(key))
            return;
        if (!isRed(root.getLeft()) && !isRed(root.getRight()))
            ((RedBlackNode<Key, Value>) root).setColor(RedBlackNode.BLACK);
        root = delete(root, key);
        if (!isEmpty())
            ((RedBlackNode<Key, Value>) root).setColor(RedBlackNode.BLACK);
    }

    /***
     * Delete node with a certain key in the BST.
     * @param node - Node compared against.
     * @param key - Key to be deleted.
     * @return - Node once key is deleted.
     */
    private Node<Key, Value> delete(Node<Key, Value> node, Key key) {
        int status = Compare.compare(key, node.getKey(), comparator);
        if (status < 0) {
            if (!isRed(node.getLeft()) && !isRed(node.getLeft().getLeft()))
                node = moveRedLeft(node);
            node.setLeft(delete(node.getLeft(), key));
        } else {
            if (isRed(node.getLeft()))
                node = rotateRight(node);
            if (Compare.compare(key, node.getKey(), comparator) == 0 && (node.getRight() == null))
                return null;
            if (!isRed(node.getRight()) && !isRed(node.getRight().getLeft()))
                node = moveRedRight(node);
            if (Compare.compare(key, node.getKey(), comparator) == 0) {
                Node<Key, Value> minimum = minimum(node.getRight());
                node.setKey(minimum.getKey());
                node.setValue(minimum.getValue());
                node.setRight(deleteMin(node.getRight()));
            } else
                node.setRight(delete(node.getRight(), key));
        }
        return balance(node);
    }

    /***
     * Helper method which is recursively called
     * to insert a node in the RedBlackBST
     * @param node : Instance of node compared against.
     * @param key : Instance of key.
     * @param value : Value of Node.
     * @return - Node which was compared against.
     */
    private Node<Key, Value> putNode(Node<Key, Value> node, Key key, Value value) {
        if (node == null)
            return new RedBlackNode<Key, Value>(key, value, RedBlackNode.RED, 1);
        int status = Compare.compare(key, node.getKey(), comparator);
        if (status > 0)
            node.setRight(putNode(node.getRight(), key, value));
        else if (status < 0)
            node.setLeft(putNode(node.getLeft(), key, value));
        else
            node.setValue(value);
        if (isRed(node.getRight()) && !isRed(node.getLeft()))
            node = rotateLeft(node);
        if (isRed(node.getLeft()) && isRed(node.getLeft().getLeft()))
            node = rotateRight(node);
        if (isRed(node.getLeft()) && isRed(node.getRight()))
            flipColors(node);
        node.setSize(size(node.getLeft()) + size(node.getRight()) + 1);
        return node;
    }

    /***
     * Helper method to delete the min-node with root at node.
     * @param node - Node to be checked.
     * @return - Node updated once min is deleted
     */
    private Node<Key, Value> deleteMin(Node<Key, Value> node) {
        if (node.getLeft() == null)
            return null;
        if (!isRed(node.getLeft()) && !isRed(node.getLeft().getLeft()))
            node = moveRedLeft(node);
        node.setLeft(deleteMin(node.getLeft()));
        return balance(node);
    }

    /***
     * Helper method to delete the max-node with root at node.
     * @param node - Node to be checked.
     * @return - Node updated once min is deleted
     */
    private Node<Key, Value> deleteMax(Node<Key, Value> node) {
        if (isRed(node.getLeft()))
            node = rotateRight(node);
        if (node.getRight() == null)
            return null;
        if (!isRed(node.getRight()) && !isRed(node.getRight().getLeft()))
            node = moveRedRight(node);
        node.setRight(deleteMax(node.getRight()));
        return balance(node);
    }

    /**
     * Check if the node is red.
     * @param node - Instance of node
     * @return - True if the node is a red node.
     */
    private boolean isRed(Node<Key, Value> node) {
        return node != null && node instanceof RedBlackNode && ((RedBlackNode) node).getColor() == RedBlackNode.RED;
    }

    /**
     * Rotate the node left
     * @param node - Node to be rotated.
     * @return - New node post rotation.
     */
    private Node<Key, Value> rotateLeft(Node<Key, Value> node) {
        Node<Key, Value> rotated = node.getRight();
        node.setRight(rotated.getLeft());
        rotated.setLeft(node);
        ((RedBlackNode<Key, Value>) rotated).setColor(((RedBlackNode<Key, Value>) rotated.getLeft()).getColor());
        ((RedBlackNode<Key, Value>) rotated.getLeft()).setColor(RedBlackNode.RED);
        rotated.setSize(node.getSize());
        node.setSize(1 + size(node.getLeft()) + size(node.getRight()));
        return rotated;
    }

    /***
     * Rotate the node right
     * @param node - Node to be rotated.
     * @return - New node post rotation.
     */
    private Node<Key, Value> rotateRight(Node<Key, Value> node) {
        Node<Key, Value> rotated = node.getLeft();
        node.setLeft(rotated.getRight());
        rotated.setRight(node);
        ((RedBlackNode<Key, Value>) rotated).setColor(((RedBlackNode<Key, Value>) rotated.getRight()).getColor());
        ((RedBlackNode<Key, Value>) rotated.getRight()).setColor(RedBlackNode.RED);
        rotated.setSize(node.getSize());
        node.setSize(1 + size(node.getLeft()) + size(node.getRight()));
        return rotated;
    }

    /***
     * Flip colors of child from red to black and parent to red
     * @param node - Node and its children which needs to be flipped
     */
    private void flipColors(Node<Key, Value> node) {
        toggleColor(node);
        toggleColor(node.getLeft());
        toggleColor(node.getRight());
    }

    /***
     * Change the color of a node to RED if BLACK and BLACK if RED.
     * @param node - Node to toggle color.
     */
    private void toggleColor(Node<Key, Value> node) {
        boolean color = ((RedBlackNode<Key, Value>) node).getColor();
        if (color == RedBlackNode.RED)
            ((RedBlackNode<Key, Value>) node).setColor(RedBlackNode.BLACK);
        else
            ((RedBlackNode<Key, Value>) node).setColor(RedBlackNode.RED);
    }

    /***
     * Ensure that the invariant for Red Black BST is maintained.
     * @param node - Node to be balanced.
     * @return - Balance node after transformations.
     */
    private Node<Key, Value> balance(Node<Key, Value> node) {
        if (isRed(node.getRight()))
            node = rotateLeft(node);
        if (isRed(node.getLeft()) && isRed(node.getLeft().getLeft()))
            node = rotateRight(node);
        if (isRed(node.getLeft()) && isRed(node.getRight()))
            flipColors(node);
        node.setSize(1 + size(node.getLeft()) + size(node.getRight()));
        return node;
    }

    /***
     * Transformation to ensure that either node.left is RED or node.left.left is RED.
     * @param node - Node to be transformed.
     * @return - The transformed node.
     */
    private Node<Key, Value> moveRedLeft(Node<Key, Value> node) {
        flipColors(node);
        if (isRed(node.getRight().getLeft())) {
            node.setRight(rotateRight(node.getRight()));
            node = rotateLeft(node);
            flipColors(node);
        }
        return node;
    }

    /***
     * Transformation to ensure that either node.left is RED or node.left.left is RED.
     * @param node - Node to be transformed.
     * @return - The transformed node.
     */
    private Node<Key, Value> moveRedRight(Node<Key, Value> node) {
        flipColors(node);
        if (isRed(node.getLeft().getLeft())) {
            node = rotateRight(node);
            flipColors(node);
        }
        return node;
    }

}
