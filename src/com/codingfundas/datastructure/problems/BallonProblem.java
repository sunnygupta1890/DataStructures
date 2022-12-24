package com.codingfundas.datastructure.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class BallonProblem {

  // Assuming heightArr contains non-negative numbers.
  public static int numberOfRequiredArrows(int[] heightArr) {

    Map<Integer, TreeSet<Integer>> map = new HashMap<>();

    // populate the map with height as key and list of indexes as value
    TreeSet<Integer> setIndex = null;
    for (int i = 0; i < heightArr.length; i++) {
      if (map.containsKey(heightArr[i])) {
        setIndex = map.get(heightArr[i]);
      } else {
        setIndex = new TreeSet<>();
        map.put(heightArr[i], setIndex);
      }
      setIndex.add(i);
    }

    int numberOfRequiredArrows = 0;
    for (int i = 0; i < heightArr.length; i++) {
      int numberFound = heightArr[i];
      if (numberFound == -1) {
        continue;
      }

      numberOfRequiredArrows++;
      int nextHeight = numberFound;
      int prevIndex = -1;
      while (map.containsKey(nextHeight) && nextHeight >= 0) {

        TreeSet<Integer> indexSet = map.get(nextHeight);
        Integer index = indexSet.ceiling(prevIndex);
        // If you don't find an index greater than the previous Index,
        // then you should break e.g. in case of 6,4,5, when you are at index 2, you need a balloon
        // of height 4 with index greater than 2, but you didn't find it
        if (index == null) {
          break;
        } else {
          prevIndex = index;
          indexSet.remove(index);
          if (indexSet.size() == 0) {
            map.remove(heightArr[index]);
          }
          if (index != null) {
            heightArr[index] = -1;
          }
          nextHeight--;
        }

      }
    }

    return numberOfRequiredArrows;
  }

  public static void main(String[] args) {
    int[] heightArr = {4,3,6,3};
    System.out.println(numberOfRequiredArrows(heightArr));
  }

}
