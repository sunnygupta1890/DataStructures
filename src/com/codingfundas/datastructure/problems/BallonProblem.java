package com.codingfundas.datastructure.problems;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BallonProblem {

  // Assuming heightArr contains non-negative numbers
  public static int numberOfRequiredArrows(int[] heightArr) {

    Map<Integer, Queue<Integer>> map = new HashMap<>();

    // populate the map with height as key and list of indexes as value
    Queue<Integer> indexList = null;
    for (int i = 0; i < heightArr.length; i++) {
      if (map.containsKey(heightArr[i])) {
        indexList = map.get(heightArr[i]);
      } else {
        indexList = new LinkedList<>();
        map.put(heightArr[i], indexList);
      }
      indexList.add(i);
    }

    int numberOfRequiredArrows = 0;
    for (int i = 0; i < heightArr.length; i++) {
      int numberFound = heightArr[i];
      if (numberFound == -1) {
        continue;
      }

      numberOfRequiredArrows++;
      int nextHeight = numberFound;
      while (map.containsKey(nextHeight) && nextHeight >= 0) {

        Queue<Integer> queue = map.get(nextHeight);
        Integer index = queue.poll();

        if (queue.size() == 0) {
          map.remove(heightArr[index]);
        }
        if (index != null) {
          heightArr[index] = -1;
        }
        nextHeight--;
      }
    }

    return numberOfRequiredArrows;
  }

  public static void main(String[] args) {
    int[] heightArr = {4, 5, 4, 3, 4};
    System.out.println(numberOfRequiredArrows(heightArr));
  }

}
