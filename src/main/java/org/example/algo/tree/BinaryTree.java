package org.example.algo.tree;


public class BinaryTree {
    TreeNode root;

    BinaryTree() {
        root = null;
    }

    void insert(int value) {
        root = insertRec(root, value);
    }

    private TreeNode insertRec(TreeNode root, int value) {
        if (root == null) {
            root = new TreeNode(value);
        }

        if (value < root.value) {
            root.left = insertRec(root.left, value);
        }
        return null;
    }

}
