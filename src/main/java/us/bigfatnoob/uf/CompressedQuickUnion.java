package us.bigfatnoob.uf;

/**
 * Includes path compression in WeightedQuickUnion by modifying the root method.
 */
public final class CompressedQuickUnion<Item> extends WeightedQuickUnion<Item> {


    public CompressedQuickUnion(Item[] items) {
        super(items);
    }

    @Override
    protected Item root(Item item) {
        while (item != map.get(item)) {
            map.put(item, map.get(map.get(item)));
            item = map.get(item);
        }
        return item;
    }
}
