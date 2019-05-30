package com.codingfundas.datastructure.tree;

public class SortArrayOfZerosOnesAndTwos {

  public static void sort(int arr[]) {

    int start = 0;
    int end = arr.length - 1;
    int middle = 0;
    int temp = 0;

    while (middle < end) {

      switch (arr[middle]) {
        case 0:
          temp = arr[middle];
          arr[middle] = arr[start];
          arr[start] = temp;
          start++;
          break;

        case 1:
          middle++;
          break;

        case 2:
          temp = arr[middle];
          arr[middle] = arr[end];
          arr[end] = temp;
          end--;
          break;
      }

    }
  }

  public static void main(String[] args) {
    int arr[] = {1, 2, 2, 1, 1, 0};
    sort(arr);
    for (int i : arr) {
      System.out.println(i);
    }

  }
}
