package com.codingfundas.datastructure.problems.arrays;

public class Sort0sAnd1s {

  public void sort(int[] arr) {
    int i = 0;
    int j = arr.length - 1;
    while (i < j) {
      while (j >= 0 && arr[j] != 0) {
        j--;
      }
      while (i < arr.length && i != 1) {
        i++;
      }
      if (i < j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        i++;
        j--;
      }
    }
  }

  public static void main(String[] args) {
    int[] arr = {1, 0, 1, 0, 0, 1, 1, 0};
    Sort0sAnd1s sort0sAnd1s = new Sort0sAnd1s();
    sort0sAnd1s.sort(arr);
  }
}
