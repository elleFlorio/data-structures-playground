package com.elleflorio.dsp.tree;

import static com.elleflorio.dsp.tree.TreeColorType.BLACK;

public class RedBlackTree<K extends Comparable<K>, V> implements Tree<K, V> {

    private TreeNode<K, V> root;

    public RedBlackTree(K key, V value) {
        this.root = new TreeNode<>(key, value, BLACK, null);
    }

    @Override
    public V search(K key) {
        return null;
    }

    @Override
    public V minimum() {
        return null;
    }

    @Override
    public V maximum() {
        return null;
    }

    @Override
    public V predecessor(K key) {
        return null;
    }

    @Override
    public V successor(K key) {
        return null;
    }

    @Override
    public void insert(K key, V value) {

    }

    /*
     *       [node]                                        [pivot]
     *      /      \                                      /       \
     *    [a]    [pivot]     --> [left rotate] -->     [node]     [c]
     *          /       \                             /      \
     *        [b]       [c]                         [a]      [b]
     */
    private void leftRotate(TreeNode<K, V> node) {
        TreeNode<K, V> pivot = node.right;

        node.right = pivot.left;

        if (pivot.left != null) {
            pivot.left.parent = node;
        }

        pivot.parent = node.parent;

        if (node.parent == null) {
            this.root = pivot;
        } else if (node == node.parent.left) {
            node.parent.left = pivot;
        } else {
            node.parent.right = pivot;
        }

        pivot.left = node;
        node.parent = pivot;
    }

    @Override
    public void delete(K key) {

    }
}
