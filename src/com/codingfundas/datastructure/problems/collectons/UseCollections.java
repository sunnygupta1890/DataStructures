package com.codingfundas.datastructure.problems.collectons;

import java.util.*;

public class UseCollections {

  public static void main(String[] args) {
    //
    List<Student> list = new ArrayList<>();
    list.add(new Student(12, "Sunny", "Narwana", "NM"));
    list.add(new Student(13, "Deep", "Narwana", "M"));
    list.add(new Student(14, "Lokesh", "Delhi", "NM"));
    list.add(new Student(15, "Akash", "Delhi", "M"));
    list.add(new Student(12, "Sunny", "Narwana", "NM"));
    list.add(new Student(16, "Kamal", "kuk", "M"));
    list.add(new Student(14, "Lokesh", "Delhi", "NM"));

    List<Student> newlist = new ArrayList<>();
    for (Student std : list) {
      boolean bhaiExistKartaHaiKya = false;
      for (Student stdInr : newlist) {
        if (std.getId() == stdInr.getId()) {
          bhaiExistKartaHaiKya = true;
          break;
        }
      }
      if (!bhaiExistKartaHaiKya) {
        newlist.add(std);
      }
    }

    System.out.println(newlist);
    System.out.println(newlist.size());

    Iterator<Student> itr = list.iterator();
    while (itr.hasNext()) {
      Student std = itr.next();
      // System.out.println(std.getId());
    }

    for (Student std : list) {
      // System.out.println(std.getId());
    }

    // K - V pair
    // (Address - String) - List<Student>
    // Map<>
    // Narwana

    Map<String, List<Student>> map = new HashMap<>();

    Map<String, String> map1 = new HashMap<>();

    String str = map1.put("sunny", "12");
    System.out.println(str);
    str = map1.put("sunny", "13");
    System.out.println(str);

    // Narwana, List<> 2 object
    // Delhi, List<2 object>
    // Kuk, List< 1 object>

    // --------------
    // M ---------List<>
    // NM ----------<List>

    for (Student std : list) {
      String stream = std.getStream();
      List<Student> l = map.get(stream);
      if (l == null) {
        List<Student> newList = new ArrayList<>();
        newList.add(std);
        map.put(stream, newList);
      } else {
        l.add(std);
        map.put(stream, l);
      }
    }

    Set<Student> set = new HashSet<>(list);
    System.out.println(set);

    // System.out.println(map);
  }
}
