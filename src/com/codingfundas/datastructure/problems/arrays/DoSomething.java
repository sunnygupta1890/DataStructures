package com.codingfundas.datastructure.problems.arrays;

import java.util.Date;

public class DoSomething {
  public static void main(String[] args) {
    Date d = new Date();
    d.setMonth(12);
    Employee employee = new Employee(13, "Sunny", d);
    d.setMonth(11);
    searchEmplyee(employee);
  }

  public static void searchEmplyee(Employee emp) {
    Date d = emp.getDate();
    d.setMonth(11);
  }
}
