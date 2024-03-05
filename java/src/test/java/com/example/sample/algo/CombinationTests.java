package com.example.sample.algo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CombinationTests {

    // TODO: implement combination() Under Here
    public <T> void combination(T[] data, T[] out, int r, int depth, int start) {
        System.out.println("TODO");
    }

    @Test
    public void run() {
        int r = 2;
        String[] data = {"a", "b", "c", "d"}; // n = 4
        String[] out = new String[r];

        System.out.println("\n[combination recursive]===================");

        /* !!!! combination caller !!!! */
        combination(data, out, r, 0, 0);
    }

    /**
     * @brief combination
     *
     * @tparam T
     * @param data      element list (size >= r)
     * @param out       result of combination (size = r)
     * @param r         size of out
     * @param start     start is index of data to be candidate of out[depth]
     * @param depth     current level of combination, if depth==2 then 0~(depth-1) index is filled in out array 
     */
    public <T> void combination_answer(T[] data, T[] out, int r, int depth, int start) {
        //System.out.println(String.format("depth=%d, start=%d", depth, start));
        if (depth == r) {
            for (var e : out) {
                System.out.print(e + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < data.length; i++) {
            out[depth] = data[i];
            combination(data, out, r, depth + 1, i + 1);
        }
    }
}
