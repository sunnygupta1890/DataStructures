package com.codingfundas.datastructure.problems;

import java.util.Arrays;

public class MinimumNumberOfMeetingRooms {

  public static int minimumNumberOfMeetingRooms(long[] start, long[] end) {

    Arrays.sort(start);
    Arrays.sort(end);

    int l = start.length;
    int i = 1;
    int j = 0;

    int minMeetingRoomsRequired = 1;
    int noOfOngoingMeetings = 1;

    while (i < l && j < l) {
      if (end[j] > start[i]) {
        noOfOngoingMeetings++;
        if (minMeetingRoomsRequired < noOfOngoingMeetings) {
          minMeetingRoomsRequired = noOfOngoingMeetings;
        }
        i++;
      } else {
        noOfOngoingMeetings--;
        j++;
      }
    }

    return minMeetingRoomsRequired;
  }

  public static void main(String[] args) {
    long start[] = {9L, 11L, 9L};
    long end[] = {14L, 12L, 11L};

    System.out.println(minimumNumberOfMeetingRooms(start, end));
  }
}
