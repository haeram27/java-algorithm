package com.example.sample.base.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class M_TreeTraversalTests {
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
    // use stack for this question
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

        Deque<Node> q = new ArrayDeque<Node>();

        q.offer(root);
        while (!q.isEmpty()) {
            Node node = q.poll();
            System.out.print(node.data + " ");

            if (node.left != null)
                q.offer(node.left);
            if (node.right != null)
                q.offer(node.right);
        }
    }

    void reverseLevelOrderTraversal_a(Node root) {
        if (root == null)
            return;

        Deque<Node> q = new ArrayDeque<>();
        Deque<Integer> stack = new ArrayDeque<>();
        Node node;

        q.offer(root);
        while (!q.isEmpty()) {
            node = q.poll();
            stack.push(node.data);

            if (node.right != null)
                q.offer(node.right);
            if (node.left != null)
                q.offer(node.left);
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
        preOrderTraversal_a(root.left);
        preOrderTraversal_a(root.right);
    }

    void inOrderTraversal_a(Node root) {
        if (root == null)
            return;

        inOrderTraversal_a(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal_a(root.right);
    }

    void postOrderTraversal_a(Node root) {
        if (root == null)
            return;

        postOrderTraversal_a(root.left);
        postOrderTraversal_a(root.right);
        System.out.print(root.data + " ");
    }

    // max number of link (count leaf from 0)
    public int getMaxDepth_a(Node root) {
        if (root == null)
            return 0;

        // Leaf Node This state except leaf from count
        if (root.left == null && root.right == null)
            return 0;

        int l = getMaxDepth_a(root.left);
        int r = getMaxDepth_a(root.right);

        return (l > r) ? l + 1 : r + 1;
    }

    // max level of node (count leaf from 1)
    public int getMaxLevel_a(Node root) {
        if (root == null)
            return 0;

        // Leaf Node:: This accounts for height = 1.
        if (root.left == null && root.right == null)
            return 1;

        int l = getMaxLevel_a(root.left);
        int r = getMaxLevel_a(root.right);

        return (l > r) ? l + 1 : r + 1;
    }

    //findLowestCommonAncester
    Node findLCA_a(Node root, int n1, int n2) {
        // Base case 
        if (root == null)
            return null;

        // If either n1 or n2 matches with root's key, report 
        // the presence by returning root (Note that if a key is 
        // ancestor of other, then the ancestor key becomes LCA 
        if (root.data == n1 || root.data == n2)
            return root;

        // Look for keys in left and right subtrees 
        Node l = findLCA_a(root.left, n1, n2);
        Node r = findLCA_a(root.right, n1, n2);

        // If both of the above calls return Non-NULL, then one key 
        // is present in once subtree and other is present in other, 
        // So this node is r LCA 
        if (l != null && r != null)
            return root;

        // Otherwise check if left subtree or right subtree is LCA 
        return (l != null) ? l : r;
    }

    @Test
    public void run_a() {
        // creating a binary tree and entering the nodes
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("Level order(bfs): ");
        levelOrderTraversal_a(root);
        System.out.println();

        System.out.println("Reverse Level order: ");
        reverseLevelOrderTraversal_a(root);
        System.out.println();

        System.out.println("dfs order: ");
        dfsTraversal_a(root);
        System.out.println();

        System.out.println("pre order: ");
        preOrderTraversal_a(root);
        System.out.println();

        System.out.println("in order: ");
        inOrderTraversal_a(root);
        System.out.println();

        System.out.println("post order: ");
        postOrderTraversal_a(root);
        System.out.println();

        System.out.println("MaxDepth: ");
        System.out.println(getMaxDepth_a(root));

        System.out.println("MaxLevel: ");
        System.out.println(getMaxLevel_a(root));

        System.out.println("findLCA: ");
        var lca = findLCA_a(root, 4, 5);
        if (lca != null)
            System.out.println(lca.data);
    }
}
