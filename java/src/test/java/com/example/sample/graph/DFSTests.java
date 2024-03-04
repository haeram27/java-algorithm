package com.example.sample.graph;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
public class DFSTests {
    class Graph {
        private int V;
        private List<List<Integer>> adj;

        Graph(int v) {
            V = v;
            adj = new ArrayList<List<Integer>>();
            for (int i = 0; i < v; ++i) {
                adj.add(new ArrayList<Integer>());
            }
        }

        void addEdge(int s, int n) {
            adj.get(s).add(n);
        }

        void DFSUtil(int s, boolean[] visited) {
            visited[s] = true;
            System.out.print(s + " ");

            for (int n : adj.get(s)) {
                if (!visited[n])
                    DFSUtil(n, visited);
            }
        }

        void DFS(int v) {
            boolean[] visited = new boolean[V];

            DFSUtil(v, visited);
        }

        void DFS() {
            boolean[] visited = new boolean[V];

            for (int i = 0; i < V; ++i) {
                if (visited[i] == false)
                    DFSUtil(i, visited);
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
