package com.codingfundas.datastructure.problems.arrays;

public class JumpGame2 {
  public int jump(int[] nums) {
    int jumpCount = 0;
    int canJumpTo = 0;
    int nextJumpIndex = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nextJumpIndex < i) {
        break;
      }
      if (i == nums.length - 1) {
        return jumpCount;
      }
      canJumpTo = Math.max(canJumpTo, i + nums[i]);
      if (i == nextJumpIndex) {
        jumpCount++;
        nextJumpIndex = canJumpTo;
        canJumpTo = 0;
      }
    }
    return -1;
  }
}
