package com.example.sample.base.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TreeTraversalTests {
    /* Class to represent Tree node */
    class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
        }
    }

    // BFS == queue, Level Order Traversal
    void levelOrderTraversal(Node root) {
        // TODO:
    }

    void reverseLevelOrderTraversal(Node root) {
        // TODO:
    }

    // DFS == stack, preOrder, inOrder, postOrder
    void dfsTraversal(Node root) {
        // TODO:
    }

    void preOrderTraversal(Node root) {
        // TODO:
    }

    void inOrderTraversal(Node root) {
        // TODO:
    }

    void postOrderTraversal(Node root) {
        // TODO:
    }

    // max number of link (count leaf from 0)
    public int getMaxDepth(Node root) {
        // TODO:
        return 0;
    }

    // max level of node (count leaf from 1)
    public int getMaxLevel(Node root) {
        // TODO:
        return 0;
    }

    //find Lowest Common Ancester
    Node findLCA(Node root, int n1, int n2) {
        // TODO:
        return null;
    }

    @Test
    public void run() {
        // creating a binary tree and entering the nodes
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("Level order: ");
        levelOrderTraversal(root);
        System.out.println();

        System.out.println("Reverse Level order: ");
        reverseLevelOrderTraversal(root);
        System.out.println();

        System.out.println("dfs order: ");
        dfsTraversal(root);
        System.out.println();

        System.out.println("pre order: ");
        preOrderTraversal(root);
        System.out.println();

        System.out.println("in order: ");
        inOrderTraversal(root);
        System.out.println();

        System.out.println("post order: ");
        postOrderTraversal(root);
        System.out.println();

        System.out.println("MaxDepth: ");
        System.out.println(getMaxDepth(root));

        System.out.println("MaxLevel: ");
        System.out.println(getMaxLevel(root));

        System.out.println("findLCA: ");
        var lca = findLCA(root, 4, 5);
        if (lca != null)
            System.out.println(lca.data);
    }

    // BFS == queue, Level Order Traversal
    void levelOrderTraversal_a(Node root) {
        if (root == null)
            return;

        Deque<Node> queue = new ArrayDeque<Node>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.print(node.data + " ");

            if (node.left != null)
                queue.offer(node.left);
            if (node.right != null)
                queue.offer(node.right);
        }
    }

    void reverseLevelOrderTraversal_a(Node root) {
        if (root == null)
            return;

        Deque<Node> q = new ArrayDeque<>();
        q.add(root);

        Deque<Integer> stack = new ArrayDeque<>();

        Node node;

        while (!q.isEmpty()) {
            node = q.poll();
            stack.push(node.data);

            if (node.right != null)
                q.add(node.right);
            if (node.left != null)
                q.add(node.left);
        }

        // pop all nodes from the stack and print them
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    // DFS == stack, preOrder, inOrder, postOrder
    void dfsTraversal_a(Node root) {
        if (root == null)
            return;

        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.print(node.data + " ");
            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
        }
    }

    void preOrderTraversal_a(Node root) {
        if (root == null)
            return;

        System.out.print(root.data + " ");
        if (root.left != null)
            preOrderTraversal(root.left);
        if (root.right != null)
            preOrderTraversal(root.right);
    }

    void inOrderTraversal_a(Node root) {
        if (root == null)
            return;

        if (root.left != null)
            inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        if (root.right != null)
            inOrderTraversal(root.right);
    }

    void postOrderTraversal_a(Node root) {
        if (root == null)
            return;

        if (root.left != null)
            postOrderTraversal(root.left);
        if (root.right != null)
            postOrderTraversal(root.right);
        System.out.print(root.data + " ");
    }

    // max number of link (count leaf from 0)
    public int getMaxDepth_a(Node root) {
        if (root == null)
            return 0;

        int lDepth = 0;
        int rDepth = 0;

        // Leaf Node This state except leaf from count
        if (root.left == null && root.right == null)
            return 0;

        if (root.left != null)
            lDepth = getMaxDepth(root.left);
        if (root.right != null)
            rDepth = getMaxDepth(root.right);

        return (lDepth > rDepth) ? lDepth + 1 : rDepth + 1;
    }

    // max level of node (count leaf from 1)
    public int getMaxLevel_a(Node root) {
        if (root == null)
            return 0;

        int lDepth = 0;
        int rDepth = 0;

        // Leaf Node:: This accounts for height = 1.
        if (root.left == null && root.right == null)
            return 1;

        if (root.left != null)
            lDepth = getMaxLevel(root.left);
        if (root.right != null)
            rDepth = getMaxLevel(root.right);

        return (lDepth > rDepth) ? lDepth + 1 : rDepth + 1;
    }

    //findLowestCommonAncester
    Node findLCA_a(Node root, int n1, int n2) 
    { 
        // Base case 
        if (root == null) 
            return null; 

        // If either n1 or n2 matches with root's key, report 
        // the presence by returning root (Note that if a key is 
        // ancestor of other, then the ancestor key becomes LCA 
        if (root.data == n1 || root.data == n2) 
            return root; 

        // Look for keys in left and right subtrees 
        Node left_lca = findLCA(root.left, n1, n2);
        Node right_lca = findLCA(root.right, n1, n2);

        // If both of the above calls return Non-NULL, then one key 
        // is present in once subtree and other is present in other, 
        // So this node is the LCA 
        if (left_lca != null && right_lca != null)
            return root;

        // Otherwise check if left subtree or right subtree is LCA 
        return (left_lca != null) ? left_lca : right_lca; 
    }
}
