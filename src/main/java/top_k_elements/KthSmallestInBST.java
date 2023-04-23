package top_k_elements;

import java.util.Stack;

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

/**
 * Kth Smallest Element in a BST
 * Try to solve the Kth Smallest Element in a BST problem.
 * <p>
 * Statement
 * Given the root node of a binary search tree and an integer value k, return the kth smallest value from all the nodes of the tree.
 */
public class KthSmallestInBST {
    public static int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        int count = 0;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            count++;
            if (count == k) {
                return curr.val;
            }
            curr = curr.right;
        }
        return -1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        int k = 3;
        int kthSmallest = kthSmallest(root, k);
        System.out.println("The " + k + "th smallest element in the BST is: " + kthSmallest);

    }
}
