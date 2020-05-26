/** Class for a linked list data type */
public class SingleLinkedList implements LinkedList {
    private Node first;
    private Node last;
    private int size;


    /**
     * Constructor for a linked list that takes an integer as input
     * @param firstValue    value to be put into the first node
     */
    public SingleLinkedList(int firstValue) {
        this.first = new Node(firstValue);
        this.last = this.first;
        this.size = 1;
    }


    /**
     * Constructor for a linked list object that takes as input
     * an array of values.
     * @param values        int array of input values
     */
    public SingleLinkedList(int[] values) {
        this.first = new Node(values[0]);
        Node previousNode = this.first;

        for (int i = 1; i < values.length; i++) {
            previousNode.setNext(new Node(values[i]));
            previousNode = previousNode.getNext();
        }

        this.last = previousNode;
        this.size = values.length;
    }


    public SingleLinkedList() {
        this.size = 0;
    }


    /**
     * Gets the value at the specified index. Index numbers start at 0
     * @param index     int: index of value to be gotten
     * @return          int: value of node at given index
     */
    public int get(int index) {

        if (this.size < index || this.first == null) {
            throw new IndexOutOfBoundsException();
        }

        Node currentNode = this.first;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }

        return currentNode.getValue();
    }


    /**
     * Appends a node to the end of the linked list
     * @param value     Node object to add to the list
     */
    public void append(int value) {
        Node newLastNode = new Node(value);

        if (this.last != null) {
            this.last.setNext(newLastNode);
            this.last = newLastNode;
        }

        else {
            this.first = newLastNode;
            this.last = this.first;
        }

        this.size++;
    }


    /**
     * Appends a node to the front of the linked list
     * @param value     value to be appended
     */
    public void appendFront(int value) {
        Node nodeToAdd = new Node(value);

        if(this.first == null) {
            this.first = nodeToAdd;
            this.last = this.first;
        }

        else {
            nodeToAdd.setNext(this.first);
            this.first = nodeToAdd;
        }
        this.size++;
    }


    /**
     * Inserts a node with the given value after the specified index.
     * Note that this does not allow you to insert a node at the beginning
     * of the list. This must be done with appendFront.
     * @param value     value to be placed in the node
     * @param index     index of the list after which to insert the node
     */
    public void insert(int value, int index) {

        if (index > this.size || this.first == null) {
            throw new IndexOutOfBoundsException();
        }

        Node currentNode = this.first;

        for (int i = 1; i <= index; i++) {
            currentNode = currentNode.getNext();
        }

        Node nextNode = currentNode.getNext();
        Node nodeToInsert = new Node(value);
        nodeToInsert.setNext(nextNode);
        currentNode.setNext(nodeToInsert);
        this.size++;
    }


    /**
     * Removes the last node in the linked list and returns
     * the value to the caller.
     * @return      int: value stored in the removed node
     */
    public int popBack() {

        if (this.first == null) {
            throw new NullPointerException();
        }

        Node currentNode = this.first;
        Node previousNode = null;

        while(currentNode.getNext() != null) {
            previousNode = currentNode;
            currentNode = currentNode.getNext();
        }

        if (previousNode == null) {
            this.first = null;
            this.last = null;
        }

        else {
            previousNode.setNext(null);
            this.last = previousNode;
        }

        this.size--;

        return currentNode.getValue();
    }


    /**
     * Removes a node from the front of the list
     * @return      value stored in the removed node
     */
    public int popFront() {

        if (this.first == null) {
            throw new IndexOutOfBoundsException();
        }

        Node currentNode = this.first;

        if (currentNode.getNext() == null) {
            this.first = null;
            this.last = null;
        }

        else {
            this.first = currentNode.getNext();
            currentNode.setNext(null);
        }

        this.size--;

        return currentNode.getValue();
    }


    /**
     * Removes the node at the given index and
     * returns the value contained to the caller
     * @param index     int: index of the node to be removed
     * @return          int: value of the removed node
     */
    public int remove(int index) {
        Node currentNode = this.first;
        Node nextNode = this.first.getNext();
        Node previousNode = this.first;

        for (int i = 1; i <= index; i++) {
            if (i != 1) {
                previousNode = previousNode.getNext();
            }

            currentNode = currentNode.getNext();
            nextNode = nextNode.getNext();
        }

        previousNode.setNext(nextNode);
        currentNode.setNext(null);
        this.size--;

        return currentNode.getValue();
    }


    /**
     * Reverses the linked list in place
     */
    public void reverse() {

        if (this.first == null) {
            throw new NullPointerException();
        }
        else if (this.first.getNext() == null) {

        }
        else {
            Node currentNode = this.first;
            Node nextNode = this.first.getNext();
            Node previousNode = this.first;
            this.last = this.first;

            for (int i = 1; i < this.size; i++) {

                // reverse the next pointer
                if (i == 1) {
                    currentNode.setNext(null);
                }
                else {
                    currentNode.setNext(previousNode);
                }

                // move currentNode, nextNode, and previousNode
                if (i == 1) {
                    currentNode = nextNode;
                    nextNode = nextNode.getNext();

                }

                else if (i == this.size -1) {

                }

                else {
                    previousNode = currentNode;
                    currentNode = nextNode;
                    nextNode = nextNode.getNext();
                }
            }

            nextNode.setNext(currentNode);
            this.first = nextNode;
        }
    }


    /**
     * Prints the contents of the linked list in order with
     * tabs between elements.
     */
    public void listContents() {
        Node currentNode = this.first;
        while (currentNode.getNext() != null) {
            System.out.print(currentNode.getValue() + "\t");
            currentNode = currentNode.getNext();
        }

        System.out.print(currentNode.getValue() + "\n");

    }

    /**
     * Gets the size of the list
     * @return      returns the number of elements in (size of) the list
     */
    public int getSize() {
        return size;
    }


    /**
     * Returns true if the list passed in as parameter
     * has the same elements as this list object
     * @param list      LinkedList: list to compare to this list
     * @return          boolean: true if lists are equal
     */
    public boolean equals(LinkedList list) {
        boolean isEqual = true;

        if (this.first == null ) {
            throw new NullPointerException();
        }

        if (this.size != list.getSize()) {
            isEqual = false;
        }

        else {
            Node currentNode = this.first;

            for (int i = 0; i < this.size; i++) {
                if (currentNode.getValue() != list.get(i)) {
                    isEqual = false;
                }
                currentNode = currentNode.getNext();
            }
        }

        return isEqual;
    }
}







/** Class for the node objects comprising the linked list. The linked list object
 * creates nodes using this class. */
class Node {

    /** variables to store the value in the node
     * and a pointer to the next node */
    private int value;
    private Node next;


    /**
     * Constructor for a Node object using a value, but
     * leaving the next pointer uninitialized
     * @param value     integer value to be stored in the Node object
     * */
    protected Node(int value) {
        this.value = value;
    }


    /**
     * Constructor for a Node object initializing both the
     * value and next pointer
     * @param value     integer value to be stored in the Node
     * @param next      pointer to the next Node object in the list
     */
    protected Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }


    /** GETTERS AND SETTERS */

    protected int getValue() {
        return value;
    }

    protected void setValue(int value) {
        this.value = value;
    }

    /* here need to return pointer since user
    must be able to access the next node */
    protected Node getNext() {
        return next;
    }

    protected void setNext(Node next) {
        this.next = next;
    }
}
