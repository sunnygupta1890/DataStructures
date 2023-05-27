package com.codingfundas.datastructure.problems.arrays.plymorphism;

public class Hello {
  public void m1() {
    System.out.println("Hello");
  }

  public static void main(String[] args) {
    HelloChild hello = new HelloChild();
    hello.m1();
  }
}

class HelloChild extends Hello {
  public void m1() {
    System.out.println("HelloChild");
  }

  public void m1(int a) {}
}
