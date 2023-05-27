package com.codingfundas.datastructure.problems.arrays;

public class TryOutMultipleInheritance {
  interface F{

  }

  interface H extends F{

  }

  interface J extends F{

  }

  interface P extends H, J{

  }

  interface A {
    default void hello() {
      System.out.println("default A");
    }

    public H commonMethod();

    static void bye() {
      System.out.println("bye");
    }
  }

  interface C {
    public J commonMethod();

    default void hello() {
      System.out.println("default C");
    }
  }

  static class B implements A, C {
    @Override
    public void hello() {
      A.super.hello();
      C.super.hello();
    }

    @Override
    public P commonMethod() {
      return null;
    }
  }

  public static void main(String[] args) {
    B b = new B();
    b.hello();
    A.bye();
  }
}
