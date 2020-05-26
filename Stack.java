public interface Stack<E> {


    /**
     * Pushes the given element onto the end of the stack
     * @param element       E: element to be added to the stack
     */
    public void push(E element);


    /**
     * Pops an element from the end of the stack
     * @return      E: element from the end of the stack
     */
    public E pop();


    /**
     * Returns the element at given index, but
     * does not remove it from the list
     * @param index     int: index of item to be returned
     * @return          E: item at index i
     */
    public E get(int index);
}
