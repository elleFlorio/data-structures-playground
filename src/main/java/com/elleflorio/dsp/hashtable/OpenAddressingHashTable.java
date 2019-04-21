package com.elleflorio.dsp.hashtable;

import com.elleflorio.dsp.exception.TableErrorOverflow;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;
import java.util.function.BiFunction;

public class OpenAddressingHashTable<K, V> implements HashTable<K, V> {

    private static final int SLOTS = 1024;
    private final BiFunction<K, Integer, Integer> probe;
    private final Element<K, V>[] elements;

    private BiFunction<K, Integer, Integer> linearProbing =
            (K key, Integer i) -> (key.hashCode() + i) % SLOTS;

    private BiFunction<K, Integer, Integer> quadraticProbing = (K key, Integer i) -> {
        float c1 = 0.5f;
        float c2 = 0.5f;

        return (int) (key.hashCode() + c1 * i + c2 * (i ^ 2)) % SLOTS;
    };

    private BiFunction<K, Integer, Integer> doubleHashing = (K key, Integer i) -> {
        int h1 = key.hashCode() % SLOTS;
        int h2 = 1 + (key.hashCode() % (SLOTS - 1));

        return (h1 + i * h2) % SLOTS;
    };

    public OpenAddressingHashTable(ProbeFunctionType probeFunctionType) {
        this.probe = this.getProbeFunction(probeFunctionType);
        this.elements = (Element<K, V>[]) Array.newInstance(Element.class, SLOTS);
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < SLOTS; i++) {
            int index = probe.apply(key, i);
            if (elements[index] == null || !elements[index].active) {
                elements[index] = new Element<>(key, value);
                return;
            }
        }

        throw new TableErrorOverflow("Table is full");
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < SLOTS; i++) {
            int index = probe.apply(key, i);
            if (elements[index] != null && elements[index].active) {
                return elements[index].value;
            }
        }

        return null;
    }

    @Override
    public void delete(K key) {
        for (int i = 0; i < SLOTS; i++) {
            int index = probe.apply(key, i);
            if (
                    elements[index] != null &&
                    elements[index].key.equals(key) &&
                    elements[index].active
            ) {
                elements[index].active = false;
                return;
            }
        }
    }

    private BiFunction<K, Integer, Integer> getProbeFunction(ProbeFunctionType probeFunctionType) {
        switch (probeFunctionType) {
            case LINEAR:
                return this.linearProbing;
            case QUADRATIC:
                return this.quadraticProbing;
            case DOUBLE_HASHING:
                return this.doubleHashing;
        }

        return null;
    }

    @Override
    public int getSize() {
        return (int) Arrays.stream(elements)
                .filter(Objects::nonNull)
                .filter(e -> e.active)
                .count();
    }
}
