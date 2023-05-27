package com.codingfundas.datastructure.problems.arrays;

import java.util.Date;

public class Employee {

  private int id;
  private String name;
  private Date d;

  public Employee(int id, String name, Date d) {
    this.id = id;
    this.name = name;
    this.d = d;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Date getDate() {
    Date d1 = new Date();
    d1.setMonth(d.getMonth());
    d1.setDate(d.getDate());
    return d1;
  }
}
