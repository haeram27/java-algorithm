package com.example.sample.base.sort;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class QuickSortTests {
    void quickSort(int[] arr, int begin, int end) {
        if (begin >= end)
            return;

        int partitionIndex = partition(arr, begin, end); // partitionIndex is pivot's index and is sorted position
        quickSort(arr, begin, partitionIndex - 1); // no need to include partitonIndex
        quickSort(arr, partitionIndex + 1, end); // no need to include partitonIndex
    }

    /**
     * partition() make divide array as two part based on pivot value and return pivot's index
     * given array after partition() -> | less or equal than pivot | pivot | greater than pivot | 
     * after partition() only pivot value will be placed at sorted position
     * pivot value is standard reference value to divide values as two part of array
     * ahead part includes less or equal than pivot value
     * behind part includes greater than pivot value
     * partition() returns sorted index of pivot so next partition() invoking should NOT include current pivot index
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
        swap(arr, end, ++i); // end is pivot's index, after the swap, pivot values will be placed at ++i index
        return i; // resturn pivot's index
    }

    void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    @Test
    public void run() {
        int[] arr = { 9, 5, 1, 0, 6, 2, 3, 4, 7, 8 };
        System.out.println("Before sorting");
        System.out.println(Arrays.toString(arr));

        quickSort(arr, 0, arr.length - 1);
        System.out.println("After sorting");
        System.out.println(Arrays.toString(arr));
    }
}
