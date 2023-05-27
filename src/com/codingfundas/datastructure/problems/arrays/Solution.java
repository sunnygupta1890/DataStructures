package com.codingfundas.datastructure.problems.arrays;

public class Solution {
  public static int frogJump(int n, int heights[]) {
    calcEnergy(0, heights, 0, heights.length);
    return min;
  }

  static int min = Integer.MAX_VALUE;

  public static void calcEnergy(int curr, int heights[], int total, int n) {
    if (curr == heights.length - 1) {
      min = Math.min(min, total);
      return;
    }
    if (curr + 1 < n)
      calcEnergy(curr + 1, heights, total + Math.abs(heights[curr + 1] - heights[curr]), n);
    if (curr + 2 < n)
      calcEnergy(curr + 2, heights, total + Math.abs(heights[curr + 2] - heights[curr]), n);
  }

  public static void main(String[] args) {
    //
    int heights[] = {7, 4, 4, 2, 6, 6, 3, 4};
    System.out.println(frogJump(8, heights));
  }
}
