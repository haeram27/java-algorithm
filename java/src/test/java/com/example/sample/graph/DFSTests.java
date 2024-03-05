package com.example.sample.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
public class DFSTests {
    class Graph {
        private int numberOfVertex;
        private List<List<Integer>> adj;


        Graph(int size) {
            numberOfVertex = size;
            adj = new ArrayList<List<Integer>>();
            for (int i = 0; i < size; ++i) {
                adj.add(new ArrayList<Integer>());
            }
        }

        void addEdge(int src, int dest) {
            adj.get(src).add(dest);
        }

        void DFSTraversal(int startVertex) {
            // stack/queue : to make order of next visiting vertex
            // visited : to check vertext is visited(enqueue or enstack) before or not
            ArrayDeque<Integer> stack = new ArrayDeque<>();
            boolean visited[] = new boolean[numberOfVertex];

            // initialize stack with start point
            visited[startVertex] = true;
            stack.push(startVertex);

            // traversal graph with stack
            while (!stack.isEmpty()) {
                int cur = stack.pop();
                System.out.print(cur + " ");

                for (int next : adj.get(cur)) {
                    if (!visited[next]) {
                        visited[next] = true;
                        stack.push(next);
                    }
                }
            }
            System.out.println();
        }

        // !!! ReverseAdjecentOrder makes same order of recursive call
        void DFSTraversalReverseAdjecentOrder(int vertex) {
            boolean visited[] = new boolean[numberOfVertex];
            ArrayDeque<Integer> stack = new ArrayDeque<Integer>();

            // initialize stack with start point
            visited[vertex] = true;
            stack.offerFirst(vertex);

            while (!stack.isEmpty()) {
                int cur = stack.poll();
                System.out.print(cur + " ");

                List<Integer> list = new ArrayList<>(adj.get(cur));
                Collections.reverse(list);

                for (int next : list) {
                    if (!visited[next]) {
                        visited[next] = true;
                        stack.offerFirst(next);
                    }
                }
            }
            System.out.println();
        }

        void DFS(int v) {
            DFSTraversal(v);
        }

        void DFS() {
            for (int i = 0; i < numberOfVertex; ++i) {
                DFSTraversal(i);
            }
        }
    }

    @Test
    public void run() {
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 4);
        g.addEdge(1, 0);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 1);
        g.addEdge(2, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 2);
        g.addEdge(3, 4);
        g.addEdge(4, 0);
        g.addEdge(4, 2);
        g.addEdge(4, 3);


        g.DFS(2);
        System.out.println();
        g.DFS();
    }
}
