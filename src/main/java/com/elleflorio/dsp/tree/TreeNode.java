package com.elleflorio.dsp.tree;

import static com.elleflorio.dsp.tree.TreeColorType.*;

public class TreeNode<K extends Comparable, V> {

    protected K key;
    protected V value;
    protected TreeColorType color;
    protected TreeNode<K, V> left;
    protected TreeNode<K, V> right;
    protected TreeNode<K, V> parent;

    protected TreeNode(K key, V value, TreeColorType color, TreeNode<K, V> parent) {
        this.key = key;
        this.value = value;
        this.color = color;
        this.parent = parent;
        this.left = null;
        this.right = null;
    }

    protected TreeNode(K key, V value, TreeNode<K, V> parent) {
        this.key = key;
        this.value = value;
        this.color = BLACK;
        this.parent = parent;
        this.left = null;
        this.right = null;
    }
}
