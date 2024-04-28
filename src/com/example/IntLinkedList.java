package com.example;

import java.util.NoSuchElementException;

/**javadoc -d docs -sourcepath src -subpackages com.example -sourcepath test -subpackages com.example

 * A linked list implementation for storing integers.
 */
public class IntLinkedList {

    /**
     * Represents a node in the linked list.
     */
    private class ListNode {

        /**
         * The value stored in the node.
         */
        private int value;

        /**
         * The reference to the next node in the list.
         */
        private ListNode nextNode;

        /**
         * Creates a new node with the specified value.
         *
         * @param value the value to store in the node
         */
        public ListNode(int value) {
            this.value = value;
            this.nextNode = null;
        }
    }

    /**
     * The number of elements in the list.
     */
    private int listSize;

    /**
     * The first node in the list (head).
     */
    private ListNode firstNode;

    /**
     * The last node in the list (tail).
     */
    private ListNode lastNode;

    /**
     * Creates an empty linked list.
     */
    public IntLinkedList() {
        this.firstNode = null;
        this.lastNode = null;
        this.listSize = 0;
    }

    /**
     * Appends a new node with the specified value to the end of the list.
     *
     * @param value the value to store in the new node
     */
    public void appendNode(int value) {
        ListNode newNode = new ListNode(value);

        if (lastNode == null) {
            firstNode = newNode;
        } else {
            lastNode.nextNode = newNode;
        }

        lastNode = newNode;
        listSize++;
    }

    /**
     * Prepends a new node with the specified value to the beginning of the list.
     *
     * @param value the value to store in the new node
     */
    public void prependNode(int value) {
        ListNode newNode = new ListNode(value);

        if (firstNode == null) {
            firstNode = newNode;
            lastNode = newNode;
        } else {
            newNode.nextNode = firstNode;
            firstNode = newNode;
        }

        listSize++;
    }

    /**
     * Retrieves the value of the node at the specified index.
     *
     * @param index the index of the node
     * @return the value of the node at the specified index
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
    public int getNodeValue(int index) {
        if (index < 0 || index >= listSize) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }

        ListNode currentNode = firstNode;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.nextNode;
        }

        return currentNode.value;
    }

    /**
     * Returns the number of elements in the list.
     *
     * @return the number of elements in the list
     */
    public int getListSize() {
        return listSize;
    }

    /**
     * Prints all elements in the list to the console.
     */
    public void printAllElements() {
        ListNode currentNode = firstNode;
        System.out.print("Elements in the list: ");

        while (currentNode != null) {
            System.out.print(currentNode.value + " ");
            currentNode = currentNode.nextNode;
        }

        System.out.println();
    }

    /**
     * Removes all elements from the list.
     */
    public void clearList() {
        firstNode = null;
        lastNode = null;
        listSize = 0;
    }

    /**
     * Removes the last node from the list.
     *
     * @throws IllegalStateException if the list is empty
     */
    public void removeNodeFromEnd() {
        if (listSize == 0) {
            throw new IllegalStateException("No elements in the list.");
        }

        if (listSize == 1) {
            firstNode = null;
            lastNode = null;
        } else {
            ListNode currentNode = firstNode;
            while (currentNode.nextNode != lastNode) {
                currentNode = currentNode.nextNode;
            }

            currentNode.nextNode = null;
            lastNode = currentNode;
        }

        listSize--;
    }

    /**
     * Removes the first node with the specified value from the list.
     *
     * @param value the value to remove
     * @throws NoSuchElementException if the value is not found in the list
     */
    public void removeNodeWithValue(int value) {
        if (listSize == 0) {
            throw new IllegalStateException("No elements in the list.");
        }

        if (firstNode.value == value) {
            firstNode = firstNode.nextNode;
            if (listSize == 1) {
                lastNode = null;
            }
            listSize--;
            return;
        }

        ListNode currentNode = firstNode;
        while (currentNode.nextNode != null && currentNode.nextNode.value != value) {
            currentNode = currentNode.nextNode;
        }

        if (currentNode.nextNode != null) {
            if (currentNode.nextNode == lastNode) {
                lastNode = currentNode;
            }
            currentNode.nextNode = currentNode.nextNode.nextNode;
            listSize--;
        } else {
            throw new NoSuchElementException("Value not found in the list");
        }
    }

    /**
     * Removes the first node from the list.
     *
     * @throws IllegalStateException if the list is empty
     */
    public void removeNodeFromStart() {
        if (listSize == 0) {
            throw new IllegalStateException("No elements in the list.");
        }

        if (listSize == 1) {
            firstNode = null;
            lastNode = null;
        } else {
            firstNode = firstNode.nextNode;
        }

        listSize--;
    }
}
