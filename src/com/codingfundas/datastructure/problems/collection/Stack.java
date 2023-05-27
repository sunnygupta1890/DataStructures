package com.codingfundas.datastructure.problems.collection;

public class Stack {
  // I am encapsulating this array in my stack class.
  private int[] arr;
  int current = -1;
  int capacity;

  public Stack(int capacity) {
    this.capacity = capacity;
    arr = new int[capacity];
  }

  public void push(int k) {
    if (current == capacity - 1) {
      throw new RuntimeException("My stack is full");
    }
    current++;
    arr[current] = k;
  }

  public int pop() {
    if (current == -1) {
      throw new RuntimeException("My stack is empty");
    }
    int popElement = arr[current];
    current--;
    return popElement;
  }
}
