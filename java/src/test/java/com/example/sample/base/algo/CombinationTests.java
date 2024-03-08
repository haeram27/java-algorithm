package com.example.sample.base.algo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CombinationTests {

    // TODO: implement combination() Under Here
    public <T> void combination(T[] data, T[] out, int r, int depth, int start) {
        // TODO:
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
    * @param r         round (number of output elements)
    * @param depth     current level of combination, if depth==2 then 0~(depth-1) index is filled in out array 
    * @param start     start is index of data to be candidate of out[depth]
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

        /**
         * depth : index of out[], level of combination selecting tree
         * i : index for data[] to be out[depth], i can be controlled by for() and start
         */
        for (int i = start; i < data.length; i++) {
            // data[i] is selected for current depth
            out[depth] = data[i];
            // data[i] can NOT be select in next depth because pass i+1 as start
            combination_answer(data, out, r, depth + 1, i + 1);
        }
    }
}
