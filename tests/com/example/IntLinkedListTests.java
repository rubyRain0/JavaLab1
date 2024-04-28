package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the IntLinkedList class.
 */
public class IntLinkedListTests {

    /**
     * The IntLinkedList instance to test.
     */
    private IntLinkedList intLinkedList;

    /**
     * Sets up the IntLinkedList instance before each test.
     */
    @BeforeEach
    public void setUp() {
        intLinkedList = new IntLinkedList();
    }

    /**
     * Tests the appendNode method.
     */
    @Test
    public void testAppendNode() {
        intLinkedList.appendNode(1);
        assertEquals(1, intLinkedList.getListSize());
        assertEquals(1, intLinkedList.getNodeValue(0));

        intLinkedList.appendNode(2);
        assertEquals(2, intLinkedList.getListSize());
        assertEquals(2, intLinkedList.getNodeValue(1));
    }

    /**
     * Tests the prependNode method.
     */
    @Test
    public void testPrependNode() {
        intLinkedList.prependNode(1);
        assertEquals(1, intLinkedList.getListSize());
        assertEquals(1, intLinkedList.getNodeValue(0));

        intLinkedList.prependNode(2);
        assertEquals(2, intLinkedList.getListSize());
        assertEquals(2, intLinkedList.getNodeValue(0));
    }

    /**
     * Tests the getNodeValue method.
     */
    @Test
    public void testGetNodeValue() {
        intLinkedList.appendNode(1);
        intLinkedList.appendNode(2);
        intLinkedList.appendNode(3);

        assertEquals(1, intLinkedList.getNodeValue(0));
        assertEquals(2, intLinkedList.getNodeValue(1));
        assertEquals(3, intLinkedList.getNodeValue(2));
    }

    /**
     * Tests the getListSize method.
     */
    @Test
    public void testGetListSize() {
        assertEquals(0, intLinkedList.getListSize());

        intLinkedList.appendNode(1);
        assertEquals(1, intLinkedList.getListSize());

        intLinkedList.appendNode(2);
        assertEquals(2, intLinkedList.getListSize());
    }

    /**
     * Tests the clearList method.
     */
    @Test
    public void testClearList() {
        intLinkedList.appendNode(1);
        intLinkedList.appendNode(2);

        intLinkedList.clearList();
        assertEquals(0, intLinkedList.getListSize());
    }

    /**
     * Tests the removeNodeFromEnd method.
     */
    @Test
    public void testRemoveNodeFromEnd() {
        intLinkedList.appendNode(1);
        intLinkedList.appendNode(2);

        intLinkedList.removeNodeFromEnd();
        assertEquals(1, intLinkedList.getListSize());
        assertEquals(1, intLinkedList.getNodeValue(0));
    }

    /**
     * Tests the removeNodeWithValue method.
     */
    @Test
    public void testRemoveNodeWithValue() {
        intLinkedList.appendNode(1);
        intLinkedList.appendNode(2);
        intLinkedList.appendNode(3);

        intLinkedList.removeNodeWithValue(2);
        assertEquals(2, intLinkedList.getListSize());
        assertEquals(1, intLinkedList.getNodeValue(0));
        assertEquals(3, intLinkedList.getNodeValue(1));
    }

    /**
     * Tests the removeNodeFromStart method.
     */
    @Test
    public void testRemoveNodeFromStart() {
        intLinkedList.appendNode(1);
        intLinkedList.appendNode(2);

        intLinkedList.removeNodeFromStart();
        assertEquals(1, intLinkedList.getListSize());
        assertEquals(2, intLinkedList.getNodeValue(0));
    }
}
