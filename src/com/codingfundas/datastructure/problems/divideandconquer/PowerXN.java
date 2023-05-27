package com.codingfundas.datastructure.problems.divideandconquer;

import java.util.HashMap;
import java.util.Map;

public class PowerXN {

  private Map<Integer, Double> map = new HashMap<>();

  public double myPow(double x, int n) {
    if (n < 0) {
      x = 1 / x;
      n = -n;
    }
    return myPow1(x, n);
  }

  public double myPow1(double x, int n) {
    if (n == 1) {
      map.put(1, x);
      return x;
    }
    if (n % 2 == 0) {
      int k = n / 2;
      if (map.containsKey(k)) {
        return map.get(k) * map.get(k);
      }
      double m = myPow1(x, k);
      return m * m;
    }
    if (map.containsKey(n / 2)) {
      return map.get(n / 2) * map.get(n / 2);
    }
    return myPow1(x, n / 2) * myPow1(x, n / 2) * x;
  }

  public static void main(String[] args) {
    PowerXN powerXN = new PowerXN();
    System.out.println(powerXN.myPow(2, -2));
  }
}
