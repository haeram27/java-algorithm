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

    Node nodeSumTest(Node l1, Node l2) {
        // TODO:
        Node n = new Node();
        Node head = n;

        int p = 0, r = 0;
        int l1v, l2v;

        while (l1 != null || l2 != null) {
            if (l1 != null) {
                l1v = l1.data;
            } else {
                l1v = 0;
            }

            if (l2 != null) {
                l2v = l2.data;
            } else {
                l2v = 0;
            }

            int v = l1v + l2v + p;
            p = v / 10;
            r = v % 10;

            n.data = r;
            n.next = new Node();
            n = n.next;

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return head;
    }

    void printNode(Node n) {
        while (n != null) {
            System.out.println(n.data);
            n = n.next;
        }
    }

    @Test
    void runA() {
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

        Node n = nodeSumTest(l1, l2);
        printNode(n);
    }

    @Test
    void runB() {
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

        Node n = nodeSumTest(l1, l2);
        printNode(n);
    }

}
