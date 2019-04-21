package com.elleflorio.dsp.hashtable;

public interface HashTable<K, V> {

    void put(K key, V value);

    V get(K key);

    void delete(K key);

    int getSize();

}
