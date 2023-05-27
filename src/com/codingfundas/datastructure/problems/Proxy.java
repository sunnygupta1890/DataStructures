package com.codingfundas.datastructure.problems;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

public class Proxy {

  public static void main(String[] args) {
    //
    new InvocationHandler() {
      @Override
      public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
      }
    };
  }

  public static boolean checkPositiveOrNegative(List<Integer> arr) {
    int countNegative = 0;
    for (Integer i : arr) {
      if (i < 0) {
        countNegative++;
      }
    }
    return countNegative % 2 == 0;
  }
}
