package com.example.sample.base.sort;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SimpleSortTests {
    public static void selectionSort(int a[]) {
        for (int i = 0; i < a.length - 1; ++i) {
            int min = i;
            for (int j = i + 1; j < a.length; ++j) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            swap(a, min, i);
        }
    }

    public static void bubbleSort(int a[]) {
        int len = a.length;

        for (int i = 1; i < len; ++i) {
            for (int j = 0; j < len - 1; ++j) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                }
            }
        }
    }

    public static void insertionSort(int a[]) {
        int len = a.length;
        int i, j, key;

        for (i = 1; i < len; ++i) {
            key = a[i];
            for (j = i - 1; (j >= 0) && (a[j] > key); --j) {
                a[j + 1] = a[j];
            }
            a[j + 1] = key;
        }
    }

    public static void swap(int a[], int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    @Test
    public void run() {
        // TODO Auto-generated method stub
        int a[] = {68, 32, 31, 26, 14, 9, 7, 2};

        selectionSort(a.clone());
        bubbleSort(a.clone());
        insertionSort(a.clone());
    }
}
