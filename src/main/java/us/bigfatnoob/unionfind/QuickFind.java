package us.bigfatnoob.unionfind;

import java.util.HashMap;

/**
 * Eager Approach implementing Union Find
 */
public class QuickFind<Item> implements UnionFind<Item> {

    private HashMap<Item, Item> map;

    public QuickFind(Item[] items) {
        map =  new HashMap<Item, Item>();
        for (Item item: items) {
            map.put(item, item);
        }
    }

    public void union(Item p, Item q) {
        Item pRep = map.get(p);
        Item qRep = map.get(q);
        for (Item key: map.keySet()) {
            if (map.get(key) == pRep)
                map.put(key, qRep);
        }
    }

    public boolean connected(Item p, Item q) {
        return map.get(p) == map.get(q);
    }

}
