package com.codingfundas.datastructure.problems.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LeetCode752 {

  public int openLock(String[] deadends, String target) {
    Set<String> deadEnds = new HashSet<String>();
    Set<String> visited = new HashSet<String>();
    for (String str : deadends) {
      deadEnds.add(str);
    }
    Queue<String> list = new LinkedList<>();
    int level = 0;
    String start = "0000";
    list.add(start);
    while (!list.isEmpty()) {
      int count = list.size();

      while (count != 0) {
        String pattern = list.poll();
        count--;
        if (!visited.add(pattern)) {
          continue;
        }
        if (pattern != null && pattern.equals(target)) {
          return level;
        }
        if (deadEnds.contains(pattern)) {
          continue;
        }
        for (int i = 0; i < 4; i++) {
          String moveUp = moveUp(pattern, i);
          if (!visited.contains(moveUp)) {
            list.add(moveUp);
          }
          String moveDown = moveDown(pattern, i);
          if (!visited.contains(moveDown)) {
            list.add(moveDown);
          }
        }

      }
      level++;
    }
    return -1;
  }

  private String moveUp(String input, int index) {
    char ch = input.charAt(index);
    char p = '0';
    if (input.charAt(index) != '9') {
      p = (char) (ch + 1);
    }
    String str = input.substring(0, index) + p + input.substring(index + 1);
    return str;
  }

  private String moveDown(String input, int index) {
    char ch = input.charAt(index);
    char p = '9';
    if (input.charAt(index) != '0') {
      p = (char) (ch - 1);
    }
    String str = input.substring(0, index) + p + input.substring(index + 1);
    return str;
  }

  public static void main(String[] args) {
    String[] deadends = {"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"};
    LeetCode752 leetCode752 = new LeetCode752();
    System.out.println(leetCode752.openLock(deadends, "8888"));
  }
}
