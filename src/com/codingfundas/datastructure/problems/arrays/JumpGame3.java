package com.codingfundas.datastructure.problems.arrays;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class JumpGame3 {
  public boolean canReach(int[] arr, int start) {
    Queue<Integer> q = new LinkedList<>();
    int len = arr.length;
    Set<Integer> set = new HashSet<>();
    q.add(start);
    while (!q.isEmpty()) {
      int k = q.poll();
      if (arr[k] == 0) {
        return true;
      }
      set.add(k);
      if (k - arr[k] >= 0 && !set.contains(k - arr[k])) {
        q.add(k - arr[k]);
      }
      if (k + arr[k] < len && !set.contains(k + arr[k])) {
        q.add(k + arr[k]);
      }
    }
    return false;
  }
}
