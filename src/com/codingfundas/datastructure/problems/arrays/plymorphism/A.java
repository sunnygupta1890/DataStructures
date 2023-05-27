package com.codingfundas.datastructure.problems.arrays.plymorphism;

class C {
  public X m1() {
    System.out.println("Non-Parameterized in C");
    return null;
  }

  public void m3() {}
}

public class A extends C {
  public void m1(int a) {
    System.out.println("Parameterized");
  }

  public Y m1() {
    System.out.println("Non-Parameterized in A");
    return null;
  }

  public static void main(String[] args) {
    // Base b = new Derived();
    C a = new C();
    hello(a);
    hello(new D());
    hello(new E());
  }

  // C - D, E
  public static void hello(C a) {
    System.out.println(a.m1());
  }
}

class D extends C {
  public Y m1() {
    System.out.println("Parameterized");
    return null;
  }
}

class E extends C {
  public Y m1() {
    System.out.println("Parameterized");
    return null;
  }
}
// overloading
class B extends A {
  public Y m1() {
    System.out.println("Non-Parameterized in B");
    return null;
  }

  public void m2(int a) {
    System.out.println("Parameterized");
  }

  @Override
  public String toString() {
    return "B ka object";
  }
}

class X {}

class Y extends X {}
