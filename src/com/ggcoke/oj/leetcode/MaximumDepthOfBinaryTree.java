package com.ggcoke.oj.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wang Huisong <ggcoke@foxmail.com>
 */
public class MaximumDepthOfBinaryTree {

    public int maxDepthRecursive(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int leftMaxDepth = maxDepthRecursive(root.left);
        int rightMaxDepth = maxDepthRecursive(root.right);

        return leftMaxDepth > rightMaxDepth ? leftMaxDepth + 1 : rightMaxDepth + 1;
    }

    public int maxDepthWithoutRecursive(TreeNode root) {
        if (root == null) {
            return 0;
        }

        List<TreeNode> stacks = new ArrayList<TreeNode>();
        stacks.add(root);

        while (stacks != null && !stacks.isEmpty()) {
            int count = stacks.size();
            TreeNode node = stacks.remove(count - 1);

            if (node.right != null) {
                stacks.add(node.right);
            }

            if (node.left != null) {
                stacks.add(node.left);
            }

        }

        return 0;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
