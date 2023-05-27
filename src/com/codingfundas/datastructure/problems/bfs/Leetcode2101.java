package com.codingfundas.datastructure.problems.bfs;

import java.util.*;

class Leetcode2101 {
  public int maximumDetonation(int[][] bombs) {
    Map<Integer, Set<Integer>> graph = new HashMap<>();
    for (int i = 0; i < bombs.length; i++) {
      for (int j = 0; j < bombs.length; j++) {
        formEdges(bombs, i, j, graph);
      }
    }
    int max = Integer.MIN_VALUE;
    for (int index = 0; index < bombs.length; index++) {
      max = Math.max(max, bfs(graph, index));
    }
    return max;
  }

  public int bfs(Map<Integer, Set<Integer>> graph, int index) {
    Queue<Integer> q = new LinkedList<>();
    Set<Integer> s = new HashSet<>();
    int count = 1;
    q.add(index);
    s.add(index);
    while (!q.isEmpty()) {
      int k = q.poll();

      if (graph.containsKey(k)) {
        for (int m : graph.get(k)) {
          if (s.add(m)) {
            q.add(m);
            count++;
          }
        }
      }
    }
    return count;
  }

  public void formEdges(int[][] bombs, int i, int j, Map<Integer, Set<Integer>> graph) {
    int[] bomb1 = bombs[i];
    int[] bomb2 = bombs[j];
    double k = distance(bomb1[0], bomb1[1], bomb2[0], bomb2[1]);
    long rsq = (long) bomb1[2] * bomb1[2];
    if (rsq >= k) {
      Set<Integer> set = graph.getOrDefault(i, new HashSet<>());
      set.add(j);
      graph.put(i, set);
    }

    long rsq1 = (long) bomb2[2] * bomb2[2];
    if (rsq1 >= k) {
      Set<Integer> set = graph.getOrDefault(j, new HashSet<>());
      set.add(i);
      graph.put(j, set);
    }
  }

  public long distance(int x1, int y1, int x2, int y2) {
    long m = x2 - x1;
    long n = y2 - y1;
    return m * m + n * n;
  }
}
