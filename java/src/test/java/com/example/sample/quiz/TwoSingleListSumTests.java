package com.example.sample.quiz;

import org.junit.jupiter.api.Test;

class Node {
    int data;
    Node next;

    Node() {
    }

    Node(int data) {
        this.data = data;
    }
}

public class TwoSingleListSumTests {

    void printNode(Node n) {
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }

    Node nodeSumTest(Node l1, Node l2) {
        // TODO:
        Node head = null;

        return head;
    }

    @Test
    void run1() {
        Node a, b, c;
        Node l1, l2;

        a = new Node(1);
        b = new Node(2);
        c = new Node(3);
        a.next = b;
        b.next = c;
        l1 = a;
        printNode(l1);

        a = new Node(4);
        b = new Node(5);
        c = new Node(6);
        a.next = b;
        b.next = c;
        l2 = a;
        printNode(l2);

        Node n = nodeSumTestA(l1, l2);
        printNode(n);
    }

    @Test
    void run2() {
        Node a, b, c;
        Node l1, l2;

        a = new Node(9);
        b = new Node(9);
        c = new Node(9);
        a.next = b;
        b.next = c;
        l1 = a;
        printNode(l1);

        a = new Node(9);
        b = new Node(9);
        c = new Node(0);
        a.next = b;
        b.next = c;
        l2 = a;
        printNode(l2);

        Node n = nodeSumTestA(l1, l2);
        printNode(n);
    }

    Node nodeSumTestA(Node l1, Node l2) {
        // ANSWER:
        Node head = null, last = null;
        int q = 0; // quotient

        while (l1 != null || l2 != null) {
            int v1 = 0, v2 = 0;
            if (l1 == null) {
                v1 = 0;
            } else {
                v1 = l1.data;
            }

            if (l2 == null) {
                v2 = 0;
            } else {
                v2 = l2.data;
            }

            int v = v1 + v2 + q;
            q = v / 10;
            int r = v % 10;

            if (head == null) {
                head = new Node(r);
                last = head;
            } else {
                last.next = new Node(r);
                last = last.next;
            }

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return head;
    }

    @Test
    void runA1() {
        Node a, b, c;
        Node l1, l2;

        a = new Node(1);
        b = new Node(2);
        c = new Node(3);
        a.next = b;
        b.next = c;
        l1 = a;
        printNode(l1);

        a = new Node(4);
        b = new Node(5);
        c = new Node(6);
        a.next = b;
        b.next = c;
        l2 = a;
        printNode(l2);

        Node n = nodeSumTestA(l1, l2);
        printNode(n);
    }

    @Test
    void runA2() {
        Node a, b, c;
        Node l1, l2;

        a = new Node(9);
        b = new Node(9);
        c = new Node(9);
        a.next = b;
        b.next = c;
        l1 = a;
        printNode(l1);

        a = new Node(9);
        b = new Node(9);
        c = new Node(0);
        a.next = b;
        b.next = c;
        l2 = a;
        printNode(l2);

        Node n = nodeSumTestA(l1, l2);
        printNode(n);
    }

}
