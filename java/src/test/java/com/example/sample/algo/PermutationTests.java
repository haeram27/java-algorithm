package com.example.sample.algo;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PermutationTests {
    /**
     * TODO: implement permutation() Under Here
     *
     * @brief permutation
     *
     * @tparam T
     * @param data      element list (size >= r)
     * @param out       result of combination (size = r)
     * @param visited   check using element of data while traversal
     * @param depth     index of out(permutation), if depth==2 then 0~(depth-1) index is filled in out array
     *                  index i on for statement is index of data to be candidate of out[depth]
     */
    public <T> void permutation(T[] data, T[] out, boolean[] visited, int r, int depth) {
        //System.out.println(String.format("depth=%d, start=%d", depth, start));
        if (depth == r) {
            for (var e : out) {
                System.out.print(e + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < data.length; i++) {
            if (visited[i] != true) {
                visited[i] = true;
                out[depth] = data[i];
                permutation(data, out, visited, r, depth + 1);
                visited[i] = false;
            }
        }
    }

    @Test
    public void run() {
        int r = 2;
        String[] data = {"a", "b", "c", "d"}; // n = 4
        String[] out = new String[r];
        boolean[] visited = new boolean[data.length];
        Arrays.fill(visited, false);

        System.out.println("\n[permutation recursive]===================");

        /* !!!! combination caller !!!! */
        permutation(data, out, visited, r, 0);
    }
}
