package com.example.sample.base.ds;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ArrayTests {
    /**
     * reverse one dimensional array
     *    1  2  3   >>>   3  2  1
     */
    void reverseArray(int[] array) {
        int len = array.length;

        // just swap item 0 with item n-1, 1 with n-2, ...
        for (int idx = 0; idx < len / 2; ++idx) {
            // swap
            int temp = array[idx];
            array[idx] = array[len - 1 - idx];
            array[len - 1 - idx] = temp;
        }
    }

    /**
     * flip row of matrix(two-dimensional array)
     * exchange top and bottom rows
     *         cols
     *        1  2  3         7  8  9    
     *  rows  4  5  6   >>>   4  5  6
     *        7  8  9         1  2  3
     */
    void flipRows(int[][] matrix) {
        int rowLen = matrix.length;
        int colLen = matrix[0].length;

        for (int row = 0; row < rowLen / 2; ++row) {
            for (int col = 0; col < colLen; ++col) {
                // swap: a[row][col] <-> a[row_max_index-row][col];
                int temp = matrix[row][col];
                matrix[row][col] = matrix[rowLen - 1 - row][col];
                matrix[rowLen - 1 - row][col] = temp;
            }
        }
    }

    /**
     * flip cols of NxM matrix(two-dimensional array)
     * exchange left and right columns
     *         cols
     *        1  2  3         3  2  1    
     *  rows  4  5  6   >>>   6  5  4
     *        7  8  9         9  8  7
     */
    void flipCols(int[][] matrix) {
        int rowLen = matrix.length;
        int colLen = matrix[0].length;

        for (int row = 0; row < rowLen; ++row) {
            for (int col = 0; col < colLen / 2; ++col) {
                // swap: a[row][col] <-> a[row][col_max_index-col];
                int temp = matrix[row][col];
                matrix[row][col] = matrix[row][colLen - 1 - col];
                matrix[row][colLen - 1 - col] = temp;
            }
        }
    }

    /**
     * clockwise rotate of NxN matrix(two-dimensional array)
     * rotate NxN array as clockwise direction
     *         cols
     *        1  2  3         7  4  1    
     *  rows  4  5  6   >>>   8  5  2
     *        7  8  9         9  6  3
     */
    int[][] clockwiseRotate(int[][] matrix) {
        int len = matrix.length;

        int[][] rotated = new int[len][len];
        for (int row = 0; row < len; ++row) {
            for (int col = 0; col < len; ++col) {
                // insert: r[row][col] = m[max_index-col][row];
                rotated[row][col] = matrix[len - 1 - col][row];
            }
        }
        return rotated;
    }

    /**
     * reverse-clockwise rotate of NxN matrix(two-dimensional array)
     * rotate NxN array as revserse-clockwise direction
     *         cols
     *        1  2  3         3  6  9    
     *  rows  4  5  6   >>>   2  5  8
     *        7  8  9         1  4  7
     */
    int[][] reverseClockwiseRotate(int[][] matrix) {
        int len = matrix.length;

        int[][] rotated = new int[len][len];
        for (int row = 0; row < len; ++row) {
            for (int col = 0; col < len; ++col) {
                // insert: r[row][col] = m[col][max_index-row];
                rotated[row][col] = matrix[col][len - 1 - row];
            }
        }
        return rotated;
    }

    @Test
    public void run() {
        long start = System.currentTimeMillis();

        int[] a1 = {10, 20, 30, 40, 50};
        reverseArray(a1);
        System.out.println(Arrays.toString(a1));

        int[][] a2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        flipRows(a2);
        System.out.println(Arrays.deepToString(a2));

        int[][] a3 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        flipCols(a3);
        System.out.println(Arrays.deepToString(a3));

        int[][] a4 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] clockwise = clockwiseRotate(a4);
        int[][] rclockwise = reverseClockwiseRotate(a4);
        System.out.println(Arrays.deepToString(clockwise));
        System.out.println(Arrays.deepToString(rclockwise));

        System.out.println(String.format("Process time: %d msec", System.currentTimeMillis() - start));
    }
}
