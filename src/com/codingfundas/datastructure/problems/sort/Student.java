package com.codingfundas.datastructure.problems.sort;

public class Student implements Comparable<Student> {
  private int id;
  private String name;
  private String address;
  private String stream;

  public Student(int id, String name, String address, String stream) {
    this.id = id;
    this.name = name;
    this.address = address;
    this.stream = stream;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getAddress() {
    return address;
  }

  public String getStream() {
    return stream;
  }

  @Override
  public boolean equals(Object o) {
    Student student = (Student) o;
    return this.id == student.id;
  }

  @Override
  public int hashCode() {
    return id;
  }

  @Override
  public int compareTo(Student o) {
    //
    // when i compare s1 with s2
    // s1.compareTo(s2) +ve -ve 0
    // -ve s1 is lesser than s2
    // + ve s1 is greater than s2
    // 0 s1 and s2 are equal
    return this.name.compareTo(o.name);
  }
}
