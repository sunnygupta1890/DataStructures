package com.codingfundas.datastructure.problems.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Leetcode1405 {

  public String longestDiverseString(int a, int b, int c) {
    PriorityQueue<Custom> customPriorityQueue = new PriorityQueue<>();

    StringBuilder builder = new StringBuilder();
    List<Custom> customList = new ArrayList<>();
    customPriorityQueue.add(new Custom('a', a));
    customPriorityQueue.add(new Custom('b', b));
    customPriorityQueue.add(new Custom('c', c));

    do {
      for (Custom custom : customList) {
        customPriorityQueue.add(custom);
      }
      customList.clear();
      while (!customPriorityQueue.isEmpty()) {
        Custom custom = customPriorityQueue.poll();
        if (custom.value >= 2) {
          builder.append(custom.ch);
          builder.append(custom.ch);
          custom.setValue(custom.value - 2);
        } else if (custom.value == 1) {
          builder.append(custom.ch);
          custom.setValue(custom.value - 1);
        }
        if (custom.value > 0) {
          customList.add(custom);
        }
      }
    } while (!customList.isEmpty());
    return builder.toString();
  }

  public static void main(String[] args) {
    Leetcode1405 leetcode1405 = new Leetcode1405();
    String finalResult = leetcode1405.longestDiverseString(2, 3, 7);
    System.out.println(finalResult);
  }

  static class Custom implements Comparable<Custom> {
    char ch;
    int value;

    public Custom(char ch, int value) {
      this.ch = ch;
      this.value = value;
    }

    public void setValue(int value) {
      this.value = value;
    }

    @Override
    public int compareTo(Custom o) {
      return o.value - this.value;
    }
  }
}
