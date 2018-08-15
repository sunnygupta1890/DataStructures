package com.codingfundas.datastructure.tree;

import java.util.Arrays;

/**
 * Created by sunngupt on 8/15/18.
 */

/**
 * Given an array of number in sorted order, count the pair of number whose sum is less than X.
 */
public class PairCountSumLessThanX {

    public static void main(String[] args) {
        //given a sorted array
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(pairCount(arr, 8));
    }

    static int pairCount(int[] arr, int sum) {
        int i = 0;
        int j = arr.length - 1;
        int maxI = j;
        int count = 0;

        while (i <= maxI) {
            //updating max limit for next iteration
            j = maxI;
            while (i < j) {
                if (arr[i] + arr[j] < sum) {
                    System.out.println(arr[i] + " .. " + arr[j]);
                    count++;
                } else {
                    maxI = j;
                }
                j--;
            }
            i++;
        }
        return count;
    }
}
