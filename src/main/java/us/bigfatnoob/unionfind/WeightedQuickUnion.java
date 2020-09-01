package us.bigfatnoob.unionfind;

import java.util.HashMap;

/**
 * Modification of Quick Union. In Union,
 * root of the smaller tree is added to
 * the root of the larger tree
 */
public class WeightedQuickUnion<Item> extends QuickUnion<Item> {

    HashMap<Item, Integer> size;

    public WeightedQuickUnion(Item[] items) {
        map = new HashMap<Item, Item>();
        size = new HashMap<Item, Integer>();
        for (Item item: items) {
            map.put(item, item);
            size.put(item, 0);
        }
    }

    @Override
    public void union(Item p, Item q) {
        Item pRoot = root(p);
        Item qRoot = root(q);
        Integer pSize = size.get(pRoot);
        Integer qSize = size.get(qRoot);
        if (pSize < qSize) {
            map.put(pRoot, qRoot);
            size.remove(pRoot);
        } else if (pSize > qSize) {
            map.put(qRoot, pRoot);
            size.remove(qRoot);
        } else {
            map.put(pRoot, qRoot);
            size.put(qRoot, size.get(qRoot) + 1);
            size.remove(pRoot);
        }
    }
}
