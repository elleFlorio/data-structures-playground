package com.elleflorio.dsp.tree;

public class TreeNode<K extends Comparable, V> {

    protected K key;
    protected V value;
    protected TreeNode<K, V> left;
    protected TreeNode<K, V> right;
    protected TreeNode<K, V> parent;

    protected TreeNode(K key, V value, TreeNode<K, V> left, TreeNode<K, V> right, TreeNode<K, V> parent) {
        this.key = key;
        this.value = value;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }

    public TreeNode(K key, V value, TreeNode<K, V> parent) {
        this.key = key;
        this.value = value;
        this.parent = parent;
        this.left = null;
        this.right = null;
    }
}
