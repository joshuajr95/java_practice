public interface LinkedList {




    /**
     * Gets the value at the specified index. Index numbers start at 0
     * @param index     int: index of value to be gotten
     * @return          int: value of node at given index
     */
    public int get(int index);


    /**
     * Appends a value to the end of the linked list
     * @param value     value to add to the list
     */
    public void append(int value);


    /**
     * Appends a value to the front of the linked list
     * @param value     value to be appended
     */
    public void appendFront(int value);


    /**
     * Inserts a node with the given value after the specified index.
     * Note that this does not allow you to insert a node at the beginning
     * of the list. This must be done with appendFront.
     * @param value     value to be placed in the node
     * @param index     index of the list after which to insert the node
     */
    public void insert(int value, int index);


    /**
     * Removes the last node in the linked list and returns
     * the value to the caller.
     * @return      int: value stored in the removed node
     */
    public int popBack();


    /**
     * Removes a node from the front of the list
     * @return      value stored in the removed node
     */
    public int popFront();


    /**
     * Removes the node at the given index and
     * returns the value contained to the caller
     * @param index     int: index of the node to be removed
     * @return          int: value of the removed node
     */
    public int remove(int index);


    /**
     * Reverses the linked list in place
     */
    public void reverse();


    /**
     * Prints the contents of the linked list in order with
     * tabs between elements.
     */
    public void listContents();


    /**
     * Gets the size of the list
     * @return      returns the number of elements in (size of) the list
     */
    public int getSize();

    /**
     * Returns true if the list passed in as parameter
     * has the same elements as this list object
     * @param list      LinkedList: list to compare to this list
     * @return          boolean: true if lists are equal
     */
    public boolean equals(LinkedList list);
}
