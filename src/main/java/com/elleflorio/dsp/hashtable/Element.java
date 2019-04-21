package com.elleflorio.dsp.hashtable;


public class Element<K, V> {

    protected K key;
    protected V value;
    protected boolean active;
    protected Element<K, V> next;

    public Element(K key, V value) {
        this.key = key;
        this.value = value;
        this.active = true;
    }
}
