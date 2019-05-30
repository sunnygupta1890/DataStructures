package com.codingfundas.datastructure.tree;

/**
 * Created by sunngupt on 8/12/18.
 */

import java.io.*;
import java.util.*;

class Counter {
    int count;
}

class Solution {


//(4,4) to (0,0)
    //For N=5, one path should be EEEEENNNNN (acc to picture)
    //but in the example it is mentioned as EEENNN
    //can you please clarify?

    // N = 5 => EEEENNNN (0,0 ) => (4,4)
    //i am going from 0,1 then 1,2 then 1,3 ... 1,4
    //EEEE got it


    static int numOfPathsToDest(int n) {
        // your code goes here
        //your good name?
        Counter c = new Counter();
        numOfPathsToDest1(0, 0, 0, 0, c);
        return c.count;
    }

    // 0, 0, 4, 4
    static void numOfPathsToDest1(int x, int y, int finalX, int finalY, Counter c) {

        //i >= j
        if (x < y) {
            return;
        }

        if (x == finalX && y == finalY) {
            c.count++;
            return;
        }

        //go east
        if (x + 1 <= finalX)
            numOfPathsToDest1(x + 1, y, finalX, finalY, c);

        //go north
        if (y + 1 <= finalY)
            numOfPathsToDest1(x, y + 1, finalX, finalY, c);

        return;

    }

    public static void main(String[] args) {
        System.out.print(numOfPathsToDest(4));
    }

}