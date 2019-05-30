package com.codingfundas.datastructure.tree;

public class ZeroOneCount {

  // toggle zero to one
  public static int maxOnes(int[] arr, int m) {
    int left = 0, right = 0;
    int zeroCount = 0;
    int maxLen = -1;
    while (right < arr.length) {
      if (arr[right] == 0)
        zeroCount++;

      while (zeroCount > m) {
        if (arr[left] == 0) {
          zeroCount--;
        }
        left++;
      }
      maxLen = Math.max(right - left + 1, maxLen);
      right++;
    }
    return maxLen;
  }

  public static void main(String[] args) {
    int arr[] = {0, 1, 1, 0, 0, 1};
    System.out.println(maxOnes(arr, 2));
  }
}
