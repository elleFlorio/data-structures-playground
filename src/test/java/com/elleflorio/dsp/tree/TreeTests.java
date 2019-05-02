package com.elleflorio.dsp.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TreeTests {

    @Test
    public void insertSearchDeleteTest() {
        Tree<Integer, String> tree = new Bst<>(5, "a");

        tree.insert(3, "b");
        tree.insert(7, "c");
        tree.insert(2, "d");
        tree.insert(8, "e");
        tree.insert(4, "f");
        tree.insert(6, "g");

        assertEquals("a", tree.search(5));
        assertEquals("b", tree.search(3));
        assertEquals("c", tree.search(7));
        assertEquals("d", tree.search(2));
        assertEquals("e", tree.search(8));
        assertEquals("f", tree.search(4));
        assertEquals("g", tree.search(6));
        assertNull(tree.search(0));
        assertNull(tree.search(10));

        tree.delete(5);
        tree.delete(8);
        tree.delete(10);
        assertNull(tree.search(5));
        assertNull(tree.search(8));
    }

    @Test
    public void minimumMaximumTest() {
        Tree<Integer, String> tree = new Bst<>(5, "a");

        tree.insert(3, "b");
        tree.insert(7, "c");
        tree.insert(2, "d");
        tree.insert(8, "e");
        tree.insert(4, "f");
        tree.insert(6, "g");

        assertEquals("d", tree.minimum());
        assertEquals("e", tree.maximum());

        tree.delete(2);
        tree.delete(8);
        assertEquals("b", tree.minimum());
        assertEquals("c", tree.maximum());
    }

    @Test
    public void precedessorSuccessorTest() {
        Tree<Integer, String> tree = new Bst<>(5, "a");

        tree.insert(3, "b");
        tree.insert(7, "c");
        tree.insert(2, "d");
        tree.insert(8, "e");
        tree.insert(4, "f");
        tree.insert(6, "g");

        assertEquals("c", tree.successor(6));
        assertEquals("a", tree.predecessor(6));
    }

}
