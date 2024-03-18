package com.example.sample.base.ds;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class M_ArrayTests {
    /**
    * Quest:
    * copy single dimension array
    */
    int[] arrayCopy(int[] a) {
        // TODO:
        return new int[a.length];
    }

    @Test
    public void arrayCopyTest() {
        long start = System.nanoTime();

        int[] a = {1, 2, 3, 4, 5};
        var b = arrayCopy(a);
        System.out.println(Arrays.toString(b));
        System.out.println(a);
        System.out.println(b);

        System.out.println(String.format("Process time: %d nsec", System.nanoTime() - start));
    }

    int[] arrayCopyA(int[] a) {
        // Arrays.copyOf() only copy 1st dimension(row)
        var b = Arrays.copyOf(a, a.length);
        return b;
    }


    /**
    * Quest:
    * deep copy matrix(multi dimension array)
    */
    int[][] matrixDeepCopy(int[][] a) {
        // TODO:
        return new int[a.length][a[0].length];
    }

    @Test
    public void matrixDeepCopyTest() {
        long start = System.nanoTime();

        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
        var copy = matrixDeepCopy(matrix);

        System.out.println(Arrays.deepToString(copy));

        for (int r = 0; r < matrix.length; r++) {
            System.out.println(matrix[r]);
        }

        for (int r = 0; r < copy.length; r++) {
            System.out.println(copy[r]);
        }

        System.out.println(String.format("Process time: %d nsec", System.nanoTime() - start));
    }

    int[][] matrixDeepCopyA(int[][] a) {
        var rlen = a.length;
        var clen = a[0].length;

        // shallow copy
        // Arrays.copyOf() only copy 1st dimension(row)
        var shallow = Arrays.copyOf(a, a.length);


        // deep copy
        var deepA = new int[rlen][clen];
        for (int r = 0; r < rlen; r++) {
            for (int c = 0; c < clen; c++) {
                deepA[r][c] = a[r][c];
            }
        }

        // deep copy
        // Arrays.copyOf() only copy 1st dimension(row)
        var deepB = Arrays.stream(a).map(row -> Arrays.copyOf(row, row.length)).toArray(int[][]::new);

        return deepA;
    }

    /**
     * Quest:
     * reverse one dimensional array
     *    1  2  3   >>>   3  2  1
     */
    void reverseArray(int[] array) {
        // TODO:
    }

    @Test
    public void reverseArrayTest() {
        long start = System.nanoTime();

        int[] a = {10, 20, 30, 40, 50};
        reverseArray(a);
        System.out.println(Arrays.toString(a));

        System.out.println(String.format("Process time: %d nsec", System.nanoTime() - start));
    }

    void reverseArrayA(int[] array) {
        int len = array.length;

        // just swap item 0 with item n-1, 1 with n-2, ...
        // begin index of behind half array = len/2 = last-index+1/2
        for (int idx = 0; idx < len / 2; ++idx) {
            // swap
            int temp = array[idx];
            array[idx] = array[len - 1 - idx];
            array[len - 1 - idx] = temp;
        }
    }

    void reverseArrayB(int[] array) {
        int len = array.length;

        // just swap item 0 with item last-1, 1 with last-2, ...
        for (int i = 0, j = len - 1; i < j; i++, j--) {
            // swap
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    /**
     * Quest:
     * flip row of matrix(two-dimensional array)
     * exchange top and bottom rows
     *         cols
     *        1  2  3         7  8  9    
     *  rows  4  5  6   >>>   4  5  6
     *        7  8  9         1  2  3
     */
    void flipRows(int[][] matrix) {
        // TODO:
    }

    @Test
    public void flipRowsTest() {
        long start = System.nanoTime();

        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        flipRows(matrix);
        System.out.println(Arrays.deepToString(matrix));

        System.out.println(String.format("Process time: %d nsec", System.nanoTime() - start));
    }

    void flipRowsA(int[][] matrix) {
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
     * Quest:
     * flip cols of NxM matrix(two-dimensional array)
     * exchange left and right columns
     *         cols
     *        1  2  3         3  2  1    
     *  rows  4  5  6   >>>   6  5  4
     *        7  8  9         9  8  7
     */
    void flipCols(int[][] matrix) {
        // TODO:
    }

    @Test
    public void flipColsTest() {
        long start = System.nanoTime();

        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        flipCols(matrix);
        System.out.println(Arrays.deepToString(matrix));

        System.out.println(String.format("Process time: %d nsec", System.nanoTime() - start));
    }

    void flipColsA(int[][] matrix) {
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
     * Quest:
     * clockwise rotate of NxN matrix(two-dimensional array)
     * rotate NxN array as clockwise direction
     *         cols
     *        1  2  3         7  4  1    
     *  rows  4  5  6   >>>   8  5  2
     *        7  8  9         9  6  3
     */
    int[][] clockwiseRotate(int[][] matrix) {
        // TODO:

        return new int[matrix.length][matrix[0].length];
    }

    @Test
    public void clockwiseRotateTest() {
        long start = System.nanoTime();

        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] clockwise = clockwiseRotate(matrix);
        System.out.println(Arrays.deepToString(clockwise));

        System.out.println(String.format("Process time: %d nsec", System.nanoTime() - start));
    }


    int[][] clockwiseRotateA(int[][] matrix) {
        int len = matrix.length;
        int[][] rotated = new int[len][len];

        for (int row = 0; row < len; ++row) {
            for (int col = 0; col < len; ++col) {
                // len-1-i == antipode of index i in array
                rotated[col][len - 1 - row] = matrix[row][col];
                // rotated[row][col] = matrix[len - 1 - col][row];
            }
        }

        return rotated;
    }

    /**
     * Quest: 
     * clockwise rotate of NxN matrix(two-dimensional array) round times
     */
    int[][] clockwiseRotateN(int[][] matrix, int round) {
        // TODO:

        return new int[matrix.length][matrix[0].length];
    }

    @Test
    public void clockwiseRotateNTest() {
        long start = System.nanoTime();

        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] clockwise = clockwiseRotateNA(matrix, 3);
        System.out.println(Arrays.deepToString(clockwise));

        System.out.println(String.format("Process time: %d nsec", System.nanoTime() - start));
    }

    int[][] clockwiseRotateNA(int[][] matrix, int round) {
        int len = matrix.length;
        int[][] source = new int[len][len];
        int[][] rotated = new int[len][len];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                source[i][j] = matrix[i][j];
            }
        }

        for (int r = 1; r <= round % 4; r++) {
            for (int row = 0; row < len; ++row) {
                for (int col = 0; col < len; ++col) {
                    // len-1-i == antipode of index i in array
                    rotated[col][len - 1 - row] = source[row][col];
                }
            }

            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    source[i][j] = rotated[i][j];
                }
            }
        }

        return rotated;
    }


    /**
     * Quest:
     * reverse-clockwise rotate of NxN matrix(two-dimensional array)
     * rotate NxN array as revserse-clockwise direction
     *         cols
     *        1  2  3         3  6  9    
     *  rows  4  5  6   >>>   2  5  8
     *        7  8  9         1  4  7
     */
    int[][] reverseClockwiseRotate(int[][] matrix) {
        // TODO:

        return new int[matrix.length][matrix[0].length];
    }

    @Test
    public void reverseClockwiseRotateTest() {
        long start = System.nanoTime();

        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] rclockwise = reverseClockwiseRotate(matrix);
        System.out.println(Arrays.deepToString(rclockwise));

        System.out.println(String.format("Process time: %d nsec", System.nanoTime() - start));
    }

    int[][] reverseClockwiseRotateA(int[][] matrix) {
        int len = matrix.length;
        int[][] rotated = new int[len][len];

        for (int row = 0; row < len; ++row) {
            for (int col = 0; col < len; ++col) {
                // len-1-i == antipode of index i in array
                rotated[len - 1 - col][row] = matrix[row][col];
                // rotated[row][col] = matrix[col][len - 1 - row];
            }
        }

        return rotated;
    }

    /**
     * Quest: 
     * reverse clockwise rotate of NxN matrix(two-dimensional array) round times
     */
    int[][] reverseClockwiseRotateN(int[][] matrix, int round) {
        // TODO:

        return new int[matrix.length][matrix[0].length];
    }

    @Test
    public void reverseClockwiseRotateNTest() {
        long start = System.nanoTime();

        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] clockwise = reverseClockwiseRotateN(matrix, 3);
        System.out.println(Arrays.deepToString(clockwise));

        System.out.println(String.format("Process time: %d nsec", System.nanoTime() - start));
    }

    int[][] reverseClockwiseRotateNA(int[][] matrix, int round) {
        int len = matrix.length;
        int[][] source = new int[len][len];
        int[][] rotated = new int[len][len];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                source[i][j] = matrix[i][j];
            }
        }

        for (int r = 1; r <= round % 4; r++) {
            for (int row = 0; row < len; ++row) {
                for (int col = 0; col < len; ++col) {
                    // len-1-i == antipode of index i in array
                    rotated[len - 1 - col][row] = source[row][col];
                    // rotated[row][col] = matrix[col][len - 1 - row];
                }
            }

            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    source[i][j] = rotated[i][j];
                }
            }
        }

        return rotated;
    }
}
