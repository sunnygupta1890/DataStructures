package com.codingfundas.datastructure.codingpatterns.intervals;

import java.util.ArrayList;
import java.util.List;

public class FindingOverlappingIntervals {
  public int[][] mergeIntervals(int[][] intervals) {
    List<int[]> list = new ArrayList<>();
    int prevStart = intervals[0][0]; // 1 1 1
    int prevEnd = intervals[0][1]; // 3 4 5
    for (int i = 1; i < intervals.length; i++) {
      int currStart = intervals[i][0]; // 2 3 6
      int currEnd = intervals[i][1]; // 4 5 7
      // 2 <= 3
      // 3 <= 4
      // 6 <= 5 false
      if (currStart <= prevEnd) {
        // 4, 3
        // 5 ,4
        //
        prevStart = Math.min(currStart, prevStart);
        prevEnd = Math.max(currEnd, prevEnd);
      } else {
        // {1.5}
        list.add(new int[] {prevStart, prevEnd});
        prevStart = currStart;
        prevEnd = currEnd;
      }
    }
    list.add(new int[] {prevStart, prevEnd});
    int[][] result = new int[list.size()][2];
    int i = 0;
    for (int[] arr : list) {
      result[i][0] = arr[0];
      result[i][1] = arr[1];
      i++;
    }
    return result;
  }

  public static void main(String[] args) {
    // int[][] intervals = {{3, 4}, {2, 5}, {3, 6}};
    int[][] intervals = {{2, 3}, {1, 1}, {0, 1}};
    FindingOverlappingIntervals findingOverlappingIntervals = new FindingOverlappingIntervals();
    int[][] result = findingOverlappingIntervals.mergeIntervals(intervals);
    System.out.println(result);
  }
}
