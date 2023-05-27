package com.codingfundas.datastructure.problems.collectons;

import java.util.HashMap;
import java.util.Map;

public class UseMap {

  public static void main(String[] args) {

    // new object == double equals
    // id - 1 sal - 2000
    // id - 2 sal - 3000

    String str = "101010101010101012222332445667";
    char[] arr = str.toCharArray();
    Map<Character, Integer> countMap = new HashMap<>();
    for (char ch : arr) {
      if (countMap.containsKey(ch)) {
        int count = countMap.get(ch);
        count++;
        countMap.put(ch, count);
      } else {
        countMap.put(ch, 1);
      }
    }

    System.out.println(countMap);

    // System.out.println(set);
    // Map<Address, List<Student>>

    // map.get("narwana");
    // map.get("delhi");

  }

  static class Key {
    int id;

    public Key(int id) {
      this.id = id;
    }

    @Override
    public boolean equals(Object o) {
      Key key = (Key) o;
      return this.id == key.id;
    }

    @Override
    public int hashCode() {
      return id;
    }
  }

  public Map<String, Boolean> wordMultiple(String[] strings) {
    Map<String, Boolean> map = new HashMap<>();
    for (String str : strings) {
      if (map.containsKey(str)) {
        map.put(str, true);
      } else {
        map.put(str, false);
      }
    }
    return map;
  }

  public String[] allSwap(String[] strings) {
    return null;
  }
}
