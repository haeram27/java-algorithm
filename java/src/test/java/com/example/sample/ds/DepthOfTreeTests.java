package com.example.sample.ds;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DepthOfTreeTests {
    class TreeNode {
        private TreeNode left, right;

        public TreeNode(TreeNode left, TreeNode right) {
            this.left = left;
            this.right = right;
        }

        public int getMaxDepth() {
            int lDepth = 0;
            int rDepth = 0;

            // Depth:: Leaf TreeNode is counted by 0
            if (this.left == null && this.right == null)
                return 0;

            if (this.left != null) {
                lDepth = this.left.getMaxDepth();
            }

            if (this.right != null) {
                rDepth = this.right.getMaxDepth();
            }

            return Math.max(lDepth, rDepth) + 1;
        }

        public int getMaxLevel() {
            int lLevel = 0;
            int rLevel = 0;

            // Depth:: Leaf TreeNode is counted by 1
            if (this.left == null && this.right == null)
                return 1;

            if (this.left != null) {
                lLevel = this.left.getMaxLevel();
            }

            if (this.right != null) {
                rLevel = this.right.getMaxLevel();
            }

            return Math.max(lLevel, rLevel) + 1;
        }
    }

    @Test
    public void run() {
        TreeNode leaf1 = new TreeNode(null, null);
        TreeNode leaf2 = new TreeNode(null, null);
        TreeNode node = new TreeNode(leaf1, null);
        TreeNode root = new TreeNode(node, leaf2);
        System.out.println("Max Level: " + root.getMaxLevel());
        System.out.println("Max Depth: " + root.getMaxDepth());
    }
}
