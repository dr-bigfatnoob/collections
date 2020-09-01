package us.bigfatnoob.unionfind;

/**
 * Interface for Union Find.
 */
public interface UnionFind<Item> {

    /***
     * Adds p and q to the same set.
     *
     * @param p - Instance of Item
     * @param q - Instance of Item
     */
    void union(Item p, Item q);


    /***
     * Checks if p and q are connected
     *
     * @param p - Instance of p
     * @param q - Instance of q
     * @return True if p and q are connected
     */
    boolean connected(Item p, Item q);


}
