package com.example.sample.algo;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PermutationTests {
    // TODO: implement permutation() Under Here
    public <T> void permutation(T[] data, T[] out, int r, int depth, boolean[] visited) {
        // TODO:
    }

    /**
     *
     * @brief permutation
     *
     * @tparam T
     * @param data      element list (size >= r)
     * @param out       result of combination (size = r)
     * @param r         round (number of output elements)
     * @param depth     index of out[](permutation), if depth==2 then 0~(depth-1) index is filled in out[]
     *                  index i on for() statement is index of data[] to be candidate of out[depth]
     * @param visited   check consumed element(index) of data[] while traversal
     */
    public <T> void permutation_answer(T[] data, T[] out, int r, int depth, boolean[] visited) {
        //System.out.println(String.format("depth=%d, start=%d", depth, start));
        if (depth == r) {
            for (var e : out) {
                System.out.print(e + " ");
            }
            System.out.println();
            return;
        }

        // i is index for data[] to be out[depth]
        for (int i = 0; i < data.length; i++) {
            if (!visited[i]) {
                out[depth] = data[i];
                // data[i] can NOT be selected in next depth
                visited[i] = true;
                permutation_answer(data, out, r, depth + 1, visited);
                // data[i] can be selected again in previous depth
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
        permutation(data, out, r, 0, visited);
    }
}
