package com.codingfundas.datastructure.problems.bfs;

import java.util.HashMap;
import java.util.Map;

public class Leetcode1105 {


        public int minHeightShelves(int[][] books, int shelfWidth) {
            Map<String, Integer> seen = new HashMap<>();
            return helper(0, 0, books, shelfWidth, shelfWidth, seen);
        }

        public int helper(int id, int shelf_height, int[][] books, int shelfWidth, int remaining_width,  Map<String, Integer> seen){
            if(remaining_width < 0)
                return Integer.MAX_VALUE;

            // Key in the seen map would compose of "id" index in the books array, "shelf_height" so far, "remaining_width" in the current level of the shelf
            String key = id + "_"+ shelf_height + "_" + remaining_width;

            // if we have already performed this calculation previously, just re-use the result from the seen map
            if(seen.containsKey(key))
                return seen.get(key);

            if(id == books.length)
                return shelf_height;

            int book_thickness = books[id][0], book_height = books[id][1];

            int add_to_current = helper(id+1, Math.max(book_height, shelf_height), books, shelfWidth, remaining_width - book_thickness, seen);
            int add_to_next = shelf_height + helper(id+1, book_height, books, shelfWidth, shelfWidth- book_thickness, seen);

            // update the result in the map to be used for later
            int result = Math.min(add_to_current, add_to_next);

            // update the seen map to be re-used later in the future, if needed
            seen.put(key, result);
            return result;
        }

    }

