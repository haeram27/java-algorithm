package com.example.sample.algo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CombinationTests {

    /**
     * TODO: implement combination() Under Here
     *
     * @brief combination
     *
     * @tparam T
     * @param data      element list (size >= r)
     * @param out       result of combination (size = r)
     * @param r         size of out
     * @param start     start index in data to be candidate
     * @param depth     current level of combination, if depth==2 then 0~(depth-1) index is filled in out array 
     */
    public <E> void combination(E[] data, E[] out, int r, int start, int depth) {
        System.out.println(String.format("depth=%d, start=%d", depth, start));
        if (depth == r) {
            for (var e : out) {
                System.out.print(e + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < data.length; i++) {
            out[depth] = data[i];
            combination(data, out, r, i + 1, depth + 1);
        }
    }

    @Test
    public void run() {
        int r = 2;
        Character[] data = {'a', 'b', 'c', 'd'}; // n = 4
        Character[] out = new Character[r];

        System.out.println("\n[combination recursive]===================");

        /* !!!! combination caller !!!! */
        combination(data, out, r, 0, 0);
    }
}
