package com.codingfundas.datastructure.codingpatterns.slidingwindow;

public class LongestSubstringWithoutRepeatingCharacters {

  public static int findLongestSubstring(String str) {
    int result = 0;
    char[] arr = str.toCharArray();
    int i = 0;
    int j = 0;
    int[] freq = new int[256];
    while (i < arr.length) {
      freq[arr[i]]++;
      while (freq[arr[i]] > 1) {
        freq[arr[j]]--;
        j++;
      }
      result = Math.max(result, i - j + 1);
      i++;
    }
    return result;
  }
}
