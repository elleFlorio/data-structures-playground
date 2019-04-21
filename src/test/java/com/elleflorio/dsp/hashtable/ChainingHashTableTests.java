package com.elleflorio.dsp.hashtable;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChainingHashTableTests {

    @Test
    public void putGetTest() {
        HashTable<Integer, String> tableDiv =
                new ChainingHashTable<>(701, HashFunctionType.DIVISION);
        tableDiv.put(0, "a");
        tableDiv.put(10, "b");
        tableDiv.put(20, "c");
        tableDiv.put(30, "d");
        tableDiv.put(40, "e");
        tableDiv.put(50, "f");
        tableDiv.put(60, "g");
        tableDiv.put(70, "h");
        tableDiv.put(80, "i");
        tableDiv.put(90, "j");
        tableDiv.put(100, "k");

        assertEquals("a", tableDiv.get(0));
        assertEquals("b", tableDiv.get(10));
        assertEquals("c", tableDiv.get(20));
        assertEquals("d", tableDiv.get(30));
        assertEquals("e", tableDiv.get(40));
        assertEquals("f", tableDiv.get(50));
        assertEquals("g", tableDiv.get(60));
        assertEquals("h", tableDiv.get(70));
        assertEquals("i", tableDiv.get(80));
        assertEquals("j", tableDiv.get(90));
        assertEquals("k", tableDiv.get(100));

        HashTable<Integer, String> tableMul =
                new ChainingHashTable<>(1024, HashFunctionType.MULTIPLICATION);
        tableMul.put(0, "a");
        tableMul.put(10, "b");
        tableMul.put(20, "c");
        tableMul.put(30, "d");
        tableMul.put(40, "e");
        tableMul.put(50, "f");
        tableMul.put(60, "g");
        tableMul.put(70, "h");
        tableMul.put(80, "i");
        tableMul.put(90, "j");
        tableMul.put(100, "k");

        assertEquals("a", tableMul.get(0));
        assertEquals("b", tableMul.get(10));
        assertEquals("c", tableMul.get(20));
        assertEquals("d", tableMul.get(30));
        assertEquals("e", tableMul.get(40));
        assertEquals("f", tableMul.get(50));
        assertEquals("g", tableMul.get(60));
        assertEquals("h", tableMul.get(70));
        assertEquals("i", tableMul.get(80));
        assertEquals("j", tableMul.get(90));
        assertEquals("k", tableMul.get(100));

        HashTable<Integer, String> tableUniversal =
                new ChainingHashTable<>(500, HashFunctionType.UNIVERSAL);
        tableUniversal.put(0, "a");
        tableUniversal.put(10, "b");
        tableUniversal.put(20, "c");
        tableUniversal.put(30, "d");
        tableUniversal.put(40, "e");
        tableUniversal.put(50, "f");
        tableUniversal.put(60, "g");
        tableUniversal.put(70, "h");
        tableUniversal.put(80, "i");
        tableUniversal.put(90, "j");
        tableUniversal.put(100, "k");

        assertEquals("a", tableUniversal.get(0));
        assertEquals("b", tableUniversal.get(10));
        assertEquals("c", tableUniversal.get(20));
        assertEquals("d", tableUniversal.get(30));
        assertEquals("e", tableUniversal.get(40));
        assertEquals("f", tableUniversal.get(50));
        assertEquals("g", tableUniversal.get(60));
        assertEquals("h", tableUniversal.get(70));
        assertEquals("i", tableUniversal.get(80));
        assertEquals("j", tableUniversal.get(90));
        assertEquals("k", tableUniversal.get(100));

    }

    @Test
    public void sizeDeleteTest() {
        HashTable<Integer, String> tableDiv =
                new ChainingHashTable<>(701, HashFunctionType.DIVISION);
        tableDiv.put(0, "a");
        tableDiv.put(10, "b");
        tableDiv.put(20, "c");
        tableDiv.put(30, "d");

        assertEquals(4, tableDiv.getSize());

        tableDiv.delete(0);
        tableDiv.delete(10);
        tableDiv.put(0, "a");

        assertEquals(3, tableDiv.getSize());

        tableDiv.delete(12);

        assertEquals(3, tableDiv.getSize());

        HashTable<Integer, String> tableMul =
                new ChainingHashTable<>(1024, HashFunctionType.MULTIPLICATION);
        tableMul.put(0, "a");
        tableMul.put(10, "b");
        tableMul.put(20, "c");
        tableMul.put(30, "d");

        assertEquals(4, tableMul.getSize());

        tableMul.delete(0);
        tableMul.delete(10);
        tableMul.put(0, "a");

        assertEquals(3, tableMul.getSize());

        tableMul.delete(12);

        assertEquals(3, tableMul.getSize());

        HashTable<Integer, String> tableUniversal =
                new ChainingHashTable<>(1024, HashFunctionType.UNIVERSAL);
        tableUniversal.put(0, "a");
        tableUniversal.put(10, "b");
        tableUniversal.put(20, "c");
        tableUniversal.put(30, "d");

        assertEquals(4, tableUniversal.getSize());

        tableUniversal.delete(0);
        tableUniversal.delete(10);
        tableUniversal.put(0, "a");

        assertEquals(3, tableUniversal.getSize());

        tableUniversal.delete(12);

        assertEquals(3, tableUniversal.getSize());

    }
}
