package com.codingfundas.datastructure.problems.sort;

import java.util.Comparator;

public class IDComparator implements Comparator<Student> {

  @Override
  public int compare(Student o1, Student o2) {
    return o1.getId() - o2.getId();
  }
}
