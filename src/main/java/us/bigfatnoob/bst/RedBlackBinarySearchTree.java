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
        root = put((RedBlackNode<Key, Value>) root, key, value);
        ((RedBlackNode<Key, Value>) root).setColor(RedBlackNode.BLACK);
    }

    /***
     * Helper method which is recursively called
     * to insert a node in the RedBlackBST
     * @param node: Instance of node compared against.
     * @param key: Instance of key.
     * @param value: Value of Node.
     * @return - Node which was compared against.
     */
    private RedBlackNode<Key, Value> put(RedBlackNode<Key, Value> node, Key key, Value value) {
        if (node == null)
            return new RedBlackNode<Key, Value>(key, value, RedBlackNode.RED, 1);
        int status = Compare.compare(key, node.getKey(), comparator);
        if (status < 0)
            node.setLeft(put((RedBlackNode<Key, Value>) node.getLeft(), key, value));
        else if (status > 0)
            node.setRight(put((RedBlackNode<Key, Value>) node.getRight(), key, value));
        else
            node.setValue(value);
        if (isRed(node.getRight()) && !isRed(node.getLeft()))
            node = (RedBlackNode<Key, Value>) rotateLeft(node);
        if (isRed(node.getLeft()) && isRed(node.getLeft().getLeft()))
            node = (RedBlackNode<Key, Value>) rotateRight(node);
        if (isRed(node.getLeft()) && isRed(node.getRight()))
            flipColors(node);
        node.setSize(size(node.getLeft()) + size(node.getRight()) + 1);
        return node;
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
    private Node<Key, Value> rotateLeft(RedBlackNode<Key, Value> node) {
        RedBlackNode<Key, Value> rotated = (RedBlackNode<Key, Value>) node.getRight();
        node.setRight(rotated.getLeft());
        rotated.setLeft(node);
        rotated.setColor(node.getColor());
        node.setColor(RedBlackNode.RED);
        rotated.setSize(node.getSize());
        node.setSize(1 + size(node.getLeft()) + size(node.getRight()));
        return rotated;
    }

    /***
     * Rotate the node right
     * @param node - Node to be rotated.
     * @return - New node post rotation.
     */
    private Node<Key, Value> rotateRight(RedBlackNode<Key, Value> node) {
        RedBlackNode<Key, Value> rotated = (RedBlackNode<Key, Value>) node.getLeft();
        node.setLeft(rotated.getRight());
        rotated.setRight(node);
        rotated.setColor(node.getColor());
        node.setColor(RedBlackNode.RED);
        rotated.setSize(node.getSize());
        node.setSize(1 + size(node.getLeft()) + size(node.getRight()));
        return rotated;
    }

    /***
     * Flip colors of child from red to black and parent to red
     * @param node - Node and its children which needs to be flipped
     */
    private void flipColors(RedBlackNode<Key, Value> node) {
        node.setColor(RedBlackNode.RED);
        ((RedBlackNode<Key, Value>) node.getLeft()).setColor(RedBlackNode.BLACK);
        ((RedBlackNode<Key, Value>) node.getRight()).setColor(RedBlackNode.BLACK);
    }

}
