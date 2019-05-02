package com.elleflorio.dsp.tree;

public class Bst<K extends Comparable<K>, V> implements Tree<K, V> {

    private TreeNode<K, V> root;

    public Bst(K key, V value) {
        this.root = new TreeNode<>(key, value, null);
    }

    @Override
    public V search(K key) {
        TreeNode<K, V> node = treeSearch(root, key);

        return node != null ? node.value : null;
    }

    private TreeNode<K, V> treeSearch(TreeNode<K, V> node, K key) {
        if (node == null || node.key.compareTo(key) == 0) {
            return node;
        }

        if (key.compareTo(node.key) < 0) {
            return treeSearch(node.left, key);
        } else {
            return treeSearch(node.right, key);
        }
    }

    @Override
    public V minimum() {
        TreeNode<K, V> node = treeMinimum(root);
        return node.value;
    }

    private TreeNode<K, V> treeMinimum(TreeNode<K, V> node) {
        while (node.left != null) {
            node = node.left;
        }

        return node;
    }

    @Override
    public V maximum() {
        TreeNode<K, V> node = treeMaximum(root);
        return node.value;
    }

    private TreeNode<K, V> treeMaximum(TreeNode<K, V> node) {
        while (node.right != null) {
            node = node.right;
        }

        return node;
    }

    @Override
    public V predecessor(K key) {
        TreeNode<K, V> node = treeSearch(root, key);
        TreeNode<K, V> predecessor = null;
        if (node != null) {
            predecessor = treePredecessor(node);
        }

        return predecessor != null ? predecessor.value : null;
    }

    private TreeNode<K, V> treePredecessor(TreeNode<K, V> node) {
        if (node.left != null) {
            return treeMaximum(node.left);
        }

        TreeNode<K, V> predecessor = node.parent;
        while (predecessor != null && node == predecessor.left) {
            node = predecessor;
            predecessor = predecessor.parent;
        }

        return predecessor;
    }

    @Override
    public V successor(K key) {
        TreeNode<K, V> node = treeSearch(root, key);
        TreeNode<K, V> successor = null;
        if (node != null) {
            successor = treeSuccessor(node);
        }

        return successor != null ? successor.value : null;
    }

    private TreeNode<K, V> treeSuccessor(TreeNode<K, V> node) {
        if (node.right != null) {
            return treeMinimum(node.right);
        }

        TreeNode<K, V> successor = node.parent;
        while (successor != null && node == successor.right) {
            node = successor;
            successor = successor.parent;
        }

        return successor;
    }

    @Override
    public void insert(K key, V value) {
        TreeNode<K, V> nodeNew = new TreeNode<>(key, value, null);

        treeInsert(nodeNew);
    }

    private void treeInsert(TreeNode<K, V> nodeNew) {
        TreeNode<K, V> parent = null;
        TreeNode<K, V> current = root;

        while (current != null) {
            parent = current;
            if (nodeNew.key.compareTo(current.key) < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        nodeNew.parent = parent;
        if (parent == null) {
            root = nodeNew; // Tree was empty
        } else if (nodeNew.key.compareTo(parent.key) < 0) {
            parent.left = nodeNew;
        } else {
            parent.right = nodeNew;
        }
    }

    @Override
    public void delete(K key) {
        TreeNode<K, V> node = treeSearch(root, key);
        if (node != null) {
            treeDelete(node);
        }
    }

    private void treeDelete(TreeNode<K, V> node) {
        if (node.left == null) {
            transplant(node, node.right);
        } else if (node.right == null) {
            transplant(node, node.left);
        } else {
            TreeNode<K, V> successor = treeMinimum(node.right);
            if (successor.parent != node) {
                transplant(successor, successor.right);
                successor.right = node.right;
                successor.right.parent = successor;
            }
            transplant(node, successor);
            successor.left = node.left;
            successor.left.parent = successor;
        }
    }

    private void transplant(TreeNode<K, V> to, TreeNode<K, V> from) {
        if (to.parent == null) {
            root = from;
        } else if (to == to.parent.left) {
            to.parent.left = from;
        } else if (to == to.parent.right) {
            to.parent.right = from;
        }

        if (from != null) {
            from.parent = to.parent;
        }

    }
}
