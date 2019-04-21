package com.elleflorio.dsp.hashtable;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.Function;

public class ChainingHashTable<K, V> implements HashTable<K, V> {

    private final static double A = (Math.sqrt(5) - 1) / 2; // Knuth[211]
    private final static int P = 701;

    private ArrayList<Element<K, V>> elements;
    private Function<K, Integer> hash;
    private int slots;
    private int size;

    private int a;
    private int b;

    /*
     * Division method: k mod m
     * k = key (int)
     * m = # of slots
     * m should not be a power of 2.
     * m should be a prime not too close to an exact power of 2.
     * */
    private Function<K, Integer> division = (K key) -> {
        int hashed = key.hashCode();
        return hashed % slots;
    };

    /*
     * Multiplication method: |_ m(kA mod 1)_|
     * k = key (int)
     * m = # of slots
     * A = constant
     * m should be a power of 2.
     * Good choice for A is (sqrt(5) - 1)/2 according to Knuth [211]
     * */
    private Function<K, Integer> multiplication = (K key) -> {
        int hashed = key.hashCode();
        return (int) Math.floor(slots * (hashed * A % 1));
    };

    /*
     * Universal hashing: ((ak + b) mod p) mod m
     * k = key (int)
     * m = # of slots
     * p = prime large enough to store all keys
     * a = [1..p-1]
     * b = [0..p-1]
     */
    private Function<K, Integer> universal = (K key) -> {
        int hashed = key.hashCode();
        return ((a * hashed + b) % P) % slots;
    };

    public ChainingHashTable(int slots, HashFunctionType hashType) {
        this.slots = slots;
        this.hash = getHashFunction(hashType);
        this.elements = new ArrayList<>();
        for (int b = 0; b < slots; b++) {
            elements.add(null);
        }

        this.a = getRandomNumberInRange(1, P - 1);
        this.b = getRandomNumberInRange(0, P - 1);
    }

    private Function<K, Integer> getHashFunction(HashFunctionType hashType) {
        switch (hashType) {
            case DIVISION:
                return this.division;
            case MULTIPLICATION:
                return this.multiplication;
            case UNIVERSAL:
                return this.universal;
        }

        return null;
    }

    private int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    @Override
    public void put(K key, V value) {
        int index = this.hash.apply(key);
        Element head = elements.get(index);
        while (head != null) {
            if (head.key == key) {
                head.value = value;
                return;
            }

            head = head.next;
        }

        Element<K, V> elem = new Element<>(key, value);
        head = elements.get(index);
        elem.next = head;
        elements.set(index, elem);
        size++;
    }

    @Override
    public V get(K key) {
        int index = this.hash.apply(key);
        Element head = elements.get(index);
        if (head == null) {
            return null;
        }

        while (head != null) {
            if (head.key.equals(key)) {
                return (V) head.value;
            }

            head = head.next;
        }

        return null;
    }

    @Override
    public void delete(K key) {
        int index = this.hash.apply(key);
        Element<K, V> head = elements.get(index);
        if (head == null) {
            return;
        }

        Element prev = null;
        while (head != null) {
            if (head.key.equals(key)) {
                break;
            }

            prev = head;
            head = head.next;
        }

        if (head == null) {
            return;
        }

        if (prev != null) {
            prev.next = head.next;
        } else {
            elements.set(index, head.next);
        }

        this.size--;
    }

    @Override
    public int getSize() {
        return this.size;
    }
}
