package com.codingfundas.datastructure.problems.queue;

import java.util.LinkedList;
import java.util.Queue;

public class ThrotllingRequests {
  public int throttle(int[] arr) {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q10 = new LinkedList<>();
    Queue<Integer> q60 = new LinkedList<>();

    int dropped = 0;
    for (int currTime : arr) {
      while (!q1.isEmpty() && q1.peek() < currTime) {
        q1.poll();
      }

      while (!q10.isEmpty() && q10.peek() < Math.max(1, currTime - 9)) {
        q10.poll();
      }

      while (!q60.isEmpty() && q60.peek() < Math.max(1, currTime - 59)) {
        q60.poll();
      }

      q1.add(currTime);
      q10.add(currTime);
      q60.add(currTime);

      boolean drop0 = false;
      boolean drop10 = false;
      boolean drop60 = false;

      if (q1.size() > 3) {
        drop0 = true;
      }

      if (q10.size() > 20) {
        drop10 = true;
      }

      if (q60.size() > 60) {
        drop60 = true;
      }

      if (drop0 || drop10 || drop60) {
        dropped++;
      }
    }

    return dropped;
  }

  public int ThrottlingGateway(int[] requestTime) {
    int cnt = 0;
    for (int i = 0; i < requestTime.length; i++) {
      if (i > 2 && requestTime[i] == requestTime[i - 3]) {
        cnt++;
      } else if (i > 19 && requestTime[i] - requestTime[i - 20] < 10) {
        cnt++;
      } else if (i > 59 && requestTime[i] - requestTime[i - 60] < 60) {
        cnt++;
      }
    }
    return cnt;
  }

  public static void main(String[] args) {
    int[] arr = {2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 8, 10, 11, 11, 11, 12};
    ThrotllingRequests throtllingRequests = new ThrotllingRequests();
    System.out.println(throtllingRequests.ThrottlingGateway(arr));
  }
}
