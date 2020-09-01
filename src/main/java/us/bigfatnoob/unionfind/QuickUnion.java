package us.bigfatnoob.unionfind;

import java.util.HashMap;

/**
 * Each Item keeps a pointer to only its parent item.
 */
public class QuickUnion<Item> implements UnionFind<Item> {

    HashMap<Item, Item> map;

    QuickUnion(){}

    public QuickUnion(Item[] items) {
        map = new HashMap<Item, Item>();
        for (Item item: items) {
            map.put(item, item);
        }
    }

    /***
     * Retrieve the root of the item
     * @param item : Instance of Item
     * @return :  Root of item.
     */
    protected Item root(Item item) {
        while (item != map.get(item))
            item = map.get(item);
        return item;
    }

    public void union(Item p, Item q) {
        Item pRoot = root(p);
        Item qRoot = root(q);
        map.put(pRoot, qRoot);
    }

    public boolean connected(Item p, Item q) {
        return root(p) == root(q);
    }
}
