package com.codingfundas.datastructure.problems.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ColletionOfferedByJava {

  // List, Set, Map
  public static void main(String[] args) {
    // Generic - <T> - Type Information
    List<Integer> l1 = new ArrayList<Integer>(); // This is much much better
    l1.add(1); // 0
    l1.add(3); // 1
    l1.add(5); // 2

    Iterator<Integer> itr = l1.iterator();
    while (itr.hasNext()) {
      System.out.println(itr.next());
    }
    // System.out.println(l2.containsAll(l1));
  }

  // this method is taking reference of List interface
  public static int countTotal(List<Integer> list) {
    int total = 0;
    for (int k : list) {
      total += k;
    }
    return total;
  }
}
