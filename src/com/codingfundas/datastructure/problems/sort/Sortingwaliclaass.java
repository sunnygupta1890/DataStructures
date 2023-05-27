package com.codingfundas.datastructure.problems.sort;

import java.util.ArrayList;
import java.util.List;

public class Sortingwaliclaass {

  public static void main(String[] args) {
    List<Student> list = new ArrayList<>();
    list.add(new Student(15, "Sunny", "Narwana", "NM"));
    list.add(new Student(11, "Deep", "Narwana", "M"));
    list.add(new Student(16, "Deep", "Narwana", "M"));
    list.add(new Student(12, "Lokesh", "Delhi", "NM"));
    list.add(new Student(11, "Akash", "Delhi", "M"));

    // Collections.sort(list);

    List<Integer> list1 = new ArrayList<>();
    list1.add(2);
    list1.add(14);
    list1.add(11);
    list1.add(10);

    // 21, 14, 11, 10
    // 14, 21, 11, 10
    // 14, 11, 10, 21
    // 11, 10, 14, 21
    // 10, 11, 14, 21

    int[] arr = {21, 14, 11, 10};

    for (int j = 0; j < arr.length; j++) {
      for (int i = 1; i < arr.length; i++) {
        if (arr[i] < arr[i - 1]) {
          // swap
          int temp = arr[i];
          arr[i] = arr[i - 1];
          arr[i - 1] = temp;
        }
      }
    }

    System.out.println(arr);
  }
}
