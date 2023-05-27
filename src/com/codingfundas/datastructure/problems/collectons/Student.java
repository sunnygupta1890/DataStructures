package com.codingfundas.datastructure.problems.collectons;

public class Student {
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
}
