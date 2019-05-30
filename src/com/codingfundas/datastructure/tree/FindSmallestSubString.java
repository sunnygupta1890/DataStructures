package com.codingfundas.datastructure.tree;

public class FindSmallestSubString {

  public static void main(String[] args) {
    System.out.println(anotherSol("hellosirhowarehyou", "yh"));
  }

  public static int anotherSol(String strToBeSearched, String pattern) {

    int[] count = new int[26];

    int cnt = 0, minLen = Integer.MAX_VALUE;
    for (char ch : pattern.toCharArray()) {
      count[ch - 'a']++;
    }

    int left = 0, right = 0;
    char[] chrArr = strToBeSearched.toCharArray();
    while (right < strToBeSearched.length()) {
      if (count[chrArr[right] - 'a'] > 0) {
        cnt++;
      }
      count[chrArr[right] - 'a']--;

      while (cnt == pattern.length()) {
        minLen = Math.min(right - left + 1, minLen);
        if (count[chrArr[left] - 'a'] == 0) {
          cnt--;
        }
        count[chrArr[left] - 'a']++;
        left++;
      }
      right++;
    }

    return minLen;
  }
}
