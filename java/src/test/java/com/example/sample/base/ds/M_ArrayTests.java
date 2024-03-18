package com.example.sample.base.ds;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class M_ArrayTests {
    /**
    * # median between two integer
    * mid = (lo+hi)/2
    *
    * # median for array index
    * 
    * ## median of entire index
    * mid = array.length/2
    * for(i=0; i<mid; i++)
    * 
    * ## median of index range
    * mid = (lo+hi+1)/2
    * for(i=lo; i<mid; i++)
    */


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
        int rlen = matrix.length;
        int clen = matrix[0].length;

        for (int r = 0; r < rlen / 2; ++r) {
            for (int c = 0; c < clen; ++c) {
                // swap(a[r][c], a[rlen-1-r][c]); (rlen-1) == last row index
                int temp = matrix[r][c];
                matrix[r][c] = matrix[rlen - 1 - r][c];
                matrix[rlen - 1 - r][c] = temp;
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
        int rlen = matrix.length;
        int clen = matrix[0].length;

        for (int r = 0; r < rlen; ++r) {
            for (int c = 0; c < clen / 2; ++c) {
                // swap(a[r][c], a[r][clen-1-c]); (clen-1) == last column index
                int temp = matrix[r][c];
                matrix[r][c] = matrix[r][clen - 1 - c];
                matrix[r][clen - 1 - c] = temp;
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
     *
     * !!! clockwise rotation is CR=(clockwise, row antipode)
     * array's last_index is array.length - 1
     * index i's antipode is [len-1-i] == [last_index-index]
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

        for (int r = 0; r < len; ++r) {
            for (int c = 0; c < len; ++c) {
                // len-1-i == antipode of index i in array
                // clockwise rotation is CR=(clockwise, row antipode)
                rotated[c][len - 1 - r] = matrix[r][c];
            }
        }

        return rotated;
    }

    /**
     * Quest: 
     * clockwise rotate of NxN matrix(two-dimensional array) with M times
     */
    int[][] clockwiseRotateN(int[][] matrix, int times) {
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

    int[][] clockwiseRotateNA(int[][] matrix, int times) {
        int len = matrix.length;
        int[][] source = new int[len][len];
        int[][] rotated = new int[len][len];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                source[i][j] = matrix[i][j];
            }
        }

        // 4 times rotation is same with original square matrix
        for (int t = 1; t <= times % 4; t++) {
            for (int r = 0; r < len; ++r) {
                for (int c = 0; c < len; ++c) {
                    // len-1-i == antipode of index i in array
                    rotated[c][len - 1 - r] = source[r][c];
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
     * 
     * !!! reverse clockwise rotation is RC=(reverse-clockwise, col antipode)
     * array's last_index is array.length - 1
     * index i's antipode is [len-1-i] == [last_index-index]
     */
    int[][] reverseClockwiseRotate(int[][] matrix) {
        // TODO:

        return new int[matrix.length][matrix[0].length];
    }

    @Test
    public void reverseClockwiseRotateTest() {
        long start = System.nanoTime();

        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] rclockwise = reverseClockwiseRotateA(matrix);
        System.out.println(Arrays.deepToString(rclockwise));

        System.out.println(String.format("Process time: %d nsec", System.nanoTime() - start));
    }

    int[][] reverseClockwiseRotateA(int[][] matrix) {
        int len = matrix.length;
        int[][] rotated = new int[len][len];

        for (int r = 0; r < len; ++r) {
            for (int c = 0; c < len; ++c) {
                // len-1-i == antipode of index i in array
                // reverse clockwise rotation is RC=(reverse-clockwise, col antipode)
                rotated[len - 1 - c][r] = matrix[r][c];
            }
        }

        return rotated;
    }

    /**
     * Quest: 
     * reverse clockwise rotate of NxN matrix(two-dimensional array) with M times
     */
    int[][] reverseClockwiseRotateN(int[][] matrix, int times) {
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

    int[][] reverseClockwiseRotateNA(int[][] matrix, int times) {
        int len = matrix.length;
        int[][] source = new int[len][len];
        int[][] rotated = new int[len][len];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                source[i][j] = matrix[i][j];
            }
        }

        // 4 times rotation is same with original square matrix
        for (int t = 1; t <= times % 4; t++) {
            for (int r = 0; r < len; ++r) {
                for (int c = 0; c < len; ++c) {
                    // len-1-i == antipode of index i in array
                    // reverse clockwise rotation is RC=(reverse-clockwise, col antipode)
                    rotated[len - 1 - c][r] = matrix[r][c];
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
