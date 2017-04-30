package us.bigfatnoob.st;

/**
 * Created by @bigfatnoob on 4/29/17.
 * Interface defining basic functions in a SymbolTable
 */
public interface SymbolTable<Key, Value> {

    /***
     * Insert key-value pair into the table
     * @param key - Key for the Symbol Table
     * @param value - Value that refers key.
     */
    public void put(Key key, Value value);

    /***
     * Retrieve value paired with key.
     * @param key - Key to be looked up
     */
    public Value get(Key key);

    /***
     * Delete value paired with key
     * from the Symbol Table.
     * @param key - Key to be deleted.
     */
    public void delete(Key key);

    /***
     * Check if key exists in Symbol Table
     * @param key - Key to be checked.
     * @return True if key exists.
     */
    public boolean contains(Key key);

    /***
     * Check if Symbol Table is empty.
     * @return True if symbol table is empty.
     */
    public boolean isEmpty();

    /***
     * Return size of the symbol table.
     * @return - Size of the Symbol Table
     */
    public int size();

    /***
     * Return the smallest key in the Symbol Table
     * @return - Smallest Key
     */
    public Key min();

    /***
     * Return the largest key in the Symbol Table
     * @return - largest Key
     */
    public Key max();

    /***
     * Return the closest smaller key in the
     * Symbol Table if not found.
     * @param key - Key to be looked up
     * @return - key if it is found in the table else the closest smaller key
     */
    public Key floor(Key key);

    /***
     * Return the closest larger key in the
     * Symbol Table if not found.
     * @param key - Key to be looked up
     * @return - key if it is found in the table else the closest larger key
     */
    public Key ceiling(Key key);

    /***
     * Return rank of the key in the symbol table.
     * @param key - Key to check rank.
     * @return - Number of keys less than key.
     */
    public int rank(Key key);

    /***
     * Return Key with rank k
     * @param k - Rank of Key
     * @return - Key with rank k.
     */
    public Key select(int k);

    /***
     * Remove the smallest key from the Symbol Table.
     */
    public void deleteMin();

    /***
     * Remove the largest key from the Symbol Table.
     */
    public void deleteMax();

    /***
     * Return number of keys between low and high.
     * @param low - Min value to compare.
     * @param high - Max value to compare
     * @return - number of keys between low and high.
     */
    public int size(Key low, Key high);

    /***
     * Return all the keys between low and high in sorted order
     * @param low - Min key value.
     * @param high - Max key value.
     * @return -
     */
    public Iterable<Key> keys(Key low, Key high);

    /***
     * All the keys in the table.
     * @return - All the keys in the table in sorted order.
     */
    public Iterable<Key> keys();
}
