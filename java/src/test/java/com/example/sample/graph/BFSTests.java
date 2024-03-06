package com.example.sample.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BFSTests {
    /* directional graph class using adjacency list */
    class Graph {
        private int numberOfVertex;
        private List<List<Integer>> adj; // adjacency list

        /** Constructor*/
        Graph(int size) {
            // initialize number of vertexes
            numberOfVertex = size;

            // initialize adjacency list
            adj = new ArrayList<List<Integer>>();
            for (int i = 0; i < size; ++i) {
                adj.add(new ArrayList<Integer>());
            }
        }

        /** 
         * connect links s->n 
         *  s - start node
         *  n - adjacent node
         */
        void addEdge(int s, int n) {
            adj.get(s).add(n);
        }

        /**
         * BFS traversal using Queue
         */
        void BFSTraversal(int s) {
            // TODO
        }

        void BFSTraversal_answer(int startVertex) {
            // visited : to check vertext is visited(enqueue or enstack) or not
            boolean visited[] = new boolean[numberOfVertex];
            visited[startVertex] = true;

            // stack/queue : to make order of next visiting vertex
            ArrayDeque<Integer> queue = new ArrayDeque<>();
            queue.offer(startVertex);

            // traversal graph with queue
            while (!queue.isEmpty()) {
                // get current vertext
                int cur = queue.poll();
                System.out.print(cur + " ");

                // get adjacent of current vertex
                for (int next : adj.get(cur)) {
                    if (!visited[next]) {
                        // if vertex is visited once it can NOT be visited again
                        visited[next] = true;
                        // insert next vertex to visit into queue(FIFO order)
                        queue.offer(next);
                    }
                }
            }
            System.out.println();
        }

        void BFS(int start) {
            BFSTraversal(start);
        }

        void BFS() {
            for (int i = 0; i < numberOfVertex; ++i) {
                BFSTraversal(i);
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
        g.BFS(0); /* BFS searching start from given node */
        g.BFS();
    }
}
