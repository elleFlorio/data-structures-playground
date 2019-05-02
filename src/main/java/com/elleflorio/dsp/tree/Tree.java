package com.elleflorio.dsp.tree;

public interface Tree<K extends Comparable<K>, V> {

    V search(K key);

    V minimum();

    V maximum();

    V predecessor(K key);

    V successor(K key);

    void insert(K key, V value);

    void delete(K key);
}
