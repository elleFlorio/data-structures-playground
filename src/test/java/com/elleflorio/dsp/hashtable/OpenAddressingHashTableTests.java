package com.elleflorio.dsp.hashtable;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OpenAddressingHashTableTests {

    @Test
    public void putGetTest() {
        HashTable<Integer, String> tableLinear =
                new OpenAddressingHashTable<>(ProbeFunctionType.LINEAR);
        tableLinear.put(0, "a");
        tableLinear.put(10, "b");
        tableLinear.put(20, "c");
        tableLinear.put(30, "d");
        tableLinear.put(40, "e");
        tableLinear.put(50, "f");
        tableLinear.put(60, "g");
        tableLinear.put(70, "h");
        tableLinear.put(80, "i");
        tableLinear.put(90, "j");
        tableLinear.put(100, "k");

        assertEquals("a", tableLinear.get(0));
        assertEquals("b", tableLinear.get(10));
        assertEquals("c", tableLinear.get(20));
        assertEquals("d", tableLinear.get(30));
        assertEquals("e", tableLinear.get(40));
        assertEquals("f", tableLinear.get(50));
        assertEquals("g", tableLinear.get(60));
        assertEquals("h", tableLinear.get(70));
        assertEquals("i", tableLinear.get(80));
        assertEquals("j", tableLinear.get(90));
        assertEquals("k", tableLinear.get(100));

        HashTable<Integer, String> tableQuadratic =
                new OpenAddressingHashTable<>(ProbeFunctionType.QUADRATIC);
        tableQuadratic.put(0, "a");
        tableQuadratic.put(10, "b");
        tableQuadratic.put(20, "c");
        tableQuadratic.put(30, "d");
        tableQuadratic.put(40, "e");
        tableQuadratic.put(50, "f");
        tableQuadratic.put(60, "g");
        tableQuadratic.put(70, "h");
        tableQuadratic.put(80, "i");
        tableQuadratic.put(90, "j");
        tableQuadratic.put(100, "k");

        assertEquals("a", tableQuadratic.get(0));
        assertEquals("b", tableQuadratic.get(10));
        assertEquals("c", tableQuadratic.get(20));
        assertEquals("d", tableQuadratic.get(30));
        assertEquals("e", tableQuadratic.get(40));
        assertEquals("f", tableQuadratic.get(50));
        assertEquals("g", tableQuadratic.get(60));
        assertEquals("h", tableQuadratic.get(70));
        assertEquals("i", tableQuadratic.get(80));
        assertEquals("j", tableQuadratic.get(90));
        assertEquals("k", tableQuadratic.get(100));

        HashTable<Integer, String> tableDoubleHashing =
                new OpenAddressingHashTable<>(ProbeFunctionType.DOUBLE_HASHING);
        tableDoubleHashing.put(0, "a");
        tableDoubleHashing.put(10, "b");
        tableDoubleHashing.put(20, "c");
        tableDoubleHashing.put(30, "d");
        tableDoubleHashing.put(40, "e");
        tableDoubleHashing.put(50, "f");
        tableDoubleHashing.put(60, "g");
        tableDoubleHashing.put(70, "h");
        tableDoubleHashing.put(80, "i");
        tableDoubleHashing.put(90, "j");
        tableDoubleHashing.put(100, "k");

        assertEquals("a", tableDoubleHashing.get(0));
        assertEquals("b", tableDoubleHashing.get(10));
        assertEquals("c", tableDoubleHashing.get(20));
        assertEquals("d", tableDoubleHashing.get(30));
        assertEquals("e", tableDoubleHashing.get(40));
        assertEquals("f", tableDoubleHashing.get(50));
        assertEquals("g", tableDoubleHashing.get(60));
        assertEquals("h", tableDoubleHashing.get(70));
        assertEquals("i", tableDoubleHashing.get(80));
        assertEquals("j", tableDoubleHashing.get(90));
        assertEquals("k", tableDoubleHashing.get(100));

    }

    @Test
    public void sizeDeleteTest() {
        HashTable<Integer, String> tableLinear =
                new OpenAddressingHashTable<>(ProbeFunctionType.LINEAR);
        tableLinear.put(0, "a");
        tableLinear.put(10, "b");
        tableLinear.put(20, "c");
        tableLinear.put(30, "d");

        assertEquals(4, tableLinear.getSize());

        tableLinear.delete(0);
        tableLinear.delete(10);
        tableLinear.put(0, "a");

        assertEquals(3, tableLinear.getSize());

        tableLinear.delete(12);

        assertEquals(3, tableLinear.getSize());

        HashTable<Integer, String> tableQuadratic =
                new OpenAddressingHashTable<>(ProbeFunctionType.QUADRATIC);
        tableQuadratic.put(0, "a");
        tableQuadratic.put(10, "b");
        tableQuadratic.put(20, "c");
        tableQuadratic.put(30, "d");

        assertEquals(4, tableQuadratic.getSize());

        tableQuadratic.delete(0);
        tableQuadratic.delete(10);
        tableQuadratic.put(0, "a");

        assertEquals(3, tableQuadratic.getSize());

        tableQuadratic.delete(12);

        assertEquals(3, tableQuadratic.getSize());

        HashTable<Integer, String> tableDoubleHashing =
                new OpenAddressingHashTable<>(ProbeFunctionType.DOUBLE_HASHING);
        tableDoubleHashing.put(0, "a");
        tableDoubleHashing.put(10, "b");
        tableDoubleHashing.put(20, "c");
        tableDoubleHashing.put(30, "d");

        assertEquals(4, tableDoubleHashing.getSize());

        tableDoubleHashing.delete(0);
        tableDoubleHashing.delete(10);
        tableDoubleHashing.put(0, "a");

        assertEquals(3, tableDoubleHashing.getSize());

        tableDoubleHashing.delete(12);

        assertEquals(3, tableDoubleHashing.getSize());

    }
}
