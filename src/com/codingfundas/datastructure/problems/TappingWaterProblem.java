package com.codingfundas.datastructure.problems;

public class TappingWaterProblem {

  /**
   * https://www.geeksforgeeks.org/trapping-rain-water/
   * 
   * @param arr
   * @return
   */
  public static int findTappingWaterUnits(int[] arr) {

    int[] left = new int[arr.length];
    int[] right = new int[arr.length];

    left[0] = 0;
    right[arr.length - 1] = 0;

    for (int i = 1; i < arr.length; i++) {
      int leftArrPrevMax = Math.max(left[i - 1], arr[i - 1]);
      if (leftArrPrevMax >= arr[i]) {
        left[i] = leftArrPrevMax;
      }
    }

    for (int j = arr.length - 2; j >= 0; j--) {
      int rightArrNextMax = Math.max(right[j + 1], arr[j + 1]);
      if (rightArrNextMax >= arr[j]) {
        right[j] = rightArrNextMax;
      }
    }

    int result = 0;

    for (int k = 0; k < arr.length; k++) {
      if (Math.min(left[k], right[k]) - arr[k] > 0) {
        result += (Math.min(left[k], right[k]) - arr[k]);
      }
    }

    return result;

  }

  public static void main(String[] args) {
    int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    System.out.println(findTappingWaterUnits(arr));
  }
}
