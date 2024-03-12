package com.example.sample.base.sort;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class QuickSortTests {
    void quickSort(int[] arr, int begin, int end) {
        if (begin >= end)
            return;

        int partitionIndex = partition(arr, begin, end);
        quickSort(arr, begin, partitionIndex - 1);
        quickSort(arr, partitionIndex + 1, end);
    }

    /**
     * partition() make divide array as two part based on pivot value
     * pivot value is standard reference value to divide values of array 
     * ahead part includes less or equal than pivot value
     * behind part includes greater than pivot value
     * @param arr
     * @param begin
     * @param end
     * @return i index of pivot
     */
    int partition(int[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);
        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                swap(arr, j, ++i);
            }
        }
        swap(arr, end, ++i);
        return i;
    }

    void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    @Test
    public void run() {
        int[] arr = {9, 5, 1, 0, 6, 2, 3, 4, 7, 8};
        System.out.println("Before sorting");
        System.out.println(Arrays.toString(arr));

        quickSort(arr, 0, arr.length - 1);
        System.out.println("After sorting");
        System.out.println(Arrays.toString(arr));
    }
}
