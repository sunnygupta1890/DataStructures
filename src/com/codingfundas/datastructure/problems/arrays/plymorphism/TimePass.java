package com.codingfundas.datastructure.problems.arrays.plymorphism;

import java.util.Scanner;

public class TimePass {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    int[] arr = new int[a];
    for (int i = 0; i < a; i++) {
      arr[i] = sc.nextInt();
    }
    System.out.println(arr);
  }
}
