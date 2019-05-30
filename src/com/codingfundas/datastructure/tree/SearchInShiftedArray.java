package com.codingfundas.datastructure.tree;

/**
 * Created by sunngupt on 8/15/18.
 */
public class SearchInShiftedArray {

  public static void main(String[] args) {
    int[] arr = {5, 6, 7, 8, 1, 2, 3, 4};
    System.out.println(searchInShiftedArr1(arr, 2));
  }


  static int searchInShiftedArr(int[] arr, int num) {
    int start = 0;
    int end = arr.length - 1;
    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (num == arr[mid]) {
        return mid;
      } else if (num > arr[mid]) {
        if (arr[mid] > start) {
          start = mid + 1;
        } else {
          end = mid - 1;
        }
      } else if (num < arr[mid]) {
        if (arr[mid] > start) {
          start = mid + 1;
        } else {
          end = mid - 1;
        }
      }
    }
    return -1;
  }

  static int searchInShiftedArr1(int[] arr, int num) {
    int start = 0;
    int end = arr.length - 1;
    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (num == arr[mid]) {
        return mid;
      }

      if (arr[mid] > start) {
        // left sorted
        if (arr[start] <= num && arr[mid] >= num) {
          end = mid - 1;
          continue;
        }
        start = mid + 1;
      } else if (arr[mid] < start) {
        // right sorted
        if (arr[mid] <= num && arr[end] >= num) {
          start = mid + 1;
          continue;
        }
        end = mid - 1;
      }
    }
    return -1;
  }

}
