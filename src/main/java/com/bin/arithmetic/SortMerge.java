package com.bin.arithmetic;

import java.util.Arrays;

/**
 * 归并排序
 */
public class SortMerge {
    public static void main(String[] args) {
        int[] arr = {10, 6, 2, 7, 9, 5, 7, 8, 1};
        mergeSortRecursion(arr);
        System.out.println(Arrays.toString(arr));

        int[] arr2 = {10, 2, 9, 6, 7, 1, 4};
        iterateSort(arr2);
        System.out.println(Arrays.toString(arr2));
    }

    /**
     * 自上而下的递归
     * @param arr
     */
    public static void mergeSortRecursion(int[] arr) {
        recurSort(arr, 0 , arr.length - 1);
    }

    public static void recurSort(int[] arr, int start, int end) {
        if (start < end) {
            // 中分法递归切割数组
            int mid = (start + end) / 2;
            recurSort(arr, start, mid);
            recurSort(arr, mid +1, end);
            merge(arr, start, mid, end);
        }
    }

    /**
     * 子下而上的迭代
     * 第一次  比较两个元素   从 low 到high ,即两个为一组，进行比较     步长为1
     * 第二次  比较四个元素   从 low 到high ,即四个为一组，进行比较     步长为2
     * 第n次  比较2*n个元素   从 low 到high ,即2*n个为一组，进行比较     步长为n
     */
    public static void iterateSort(int[] arr) {
        int end, i, ld = arr.length - 1;
        // 循环步长
        for (int n = 1; n < arr.length; n = 2 * n) {
            // 分割出的每个数据， 每一步最后位置 2 倍步长 + 开始位置 - 1  --> 2 * i + j - 1
            for (i = 0; (end = 2 * n + i - 1) < arr.length; i += 2 * n) {
                merge(arr, i, i + n - 1, end);
            }
            // 经过上面的排序，它会可能遗忘最后一个数字没放进去
            if (n + i - 1 < arr.length) {
                merge(arr, i, i + n - 1, ld);
            }
        }
    }

    /**
     * 对递归法数组的合并，第一次进行来的时候，数组为 0 0 1
     */
    public static void merge(int[] arr, int start, int mid, int end) {
        // 临时数组，用来存放排序的数据
        int[] temp = new int[end - start + 1];
        int t = 0, st = start, et = mid + 1;
        // 以两个数组第一个数据为起点，进行比较排序，从小打到的放到 temp 中
        while (st <= mid && et <= end) {
            if (arr[st] <= arr[et])
                temp[t++] = arr[st++];
            else
                temp[t++] = arr[et++];
        }

        /*
         * 经过上面的排序后，数据已经从小到大的放入到了 temp 中了，但是单个数组中的数据可能还没有被取完，
         * 比如： 1 3 5    2 4 6
         * 经过上面的比较，1 2 3 4 5 都会被放 temp 中，但是 6 放不进去；
         */
        while (et <= end) temp[t++] = arr[et++];
        while (st <= mid) temp[t++] = arr[st++];

        for (int i = 0; i < t; i++) {
            arr[start++] = temp[i];
        }
    }
}
