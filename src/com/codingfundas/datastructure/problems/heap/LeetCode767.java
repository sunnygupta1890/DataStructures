package com.codingfundas.datastructure.problems.heap;

import java.util.*;

class LeetCode767 {
  public String reorganizeString(String s) {
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
    }
    Set<Character> set = map.keySet();
    PriorityQueue<Pair> pq =
        new PriorityQueue<Pair>(
            new Comparator<Pair>() {
              public int compare(Pair a, Pair b) {
                return b.count - a.count;
              }
            });
    for (Character k : set) {
      pq.add(new Pair(k, map.get(k)));
    }
    Pair prev = null;
    StringBuilder sb = new StringBuilder();
    while (!pq.isEmpty()) {
      Pair curr = pq.poll();
      sb.append(curr.ch);
      curr.count--;
      if (prev != null) {
        if (prev.count > 0) {
          pq.add(prev);
        }
      }
      prev = curr;
    }
    assert prev != null;
    if (prev.count > 0) {
      return "";
    }
    return sb.toString();
  }

  static class Pair {
    char ch;
    int count;

    public Pair(char ch, int count) {
      this.ch = ch;
      this.count = count;
    }
  }

  public static void main(String[] args) {
    LeetCode767 leetCode767 = new LeetCode767();
    String st = leetCode767.reorganizeString("aab");
  }
}
