package com.codingfundas.datastructure.problems.strings;

public class RollString {
  String findRollOut(String s, long roll[], int N) {
    char[] arr = s.toCharArray();
    for (int i = 0; i < roll.length; i++) {

      char ch = (char) ((('z' + roll[i]) - 'a') % 26 + 'a');
      arr[i] = ch;
    }

    return new String(arr);
  }

  public static void main(String[] args) {
    RollString rollString = new RollString();
    System.out.println(rollString.findRollOut("z", new long[] {2}, 1));
  }
}
