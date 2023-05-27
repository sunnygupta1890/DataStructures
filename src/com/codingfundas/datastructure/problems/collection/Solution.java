package com.codingfundas.datastructure.problems.collection;

import java.util.*;

class Solution {
  public List<String> findAllRecipes(
      String[] recipes, List<List<String>> ingredients, String[] supplies) {
    Set<String> set = new HashSet<>();
    for (String supp : supplies) {
      set.add(supp);
    }
    Set<String> receipeSet = new HashSet<>();
    Map<String, Integer> map = new HashMap<>();
    int k = 0;
    for (String receipe : recipes) {
      receipeSet.add(receipe);
      map.put(receipe, k);
      k++;
    }
    int i = 0;
    List<String> finres = new ArrayList<>();
    Map<String, List<String>> cache = new HashMap<>();
    for (String receipe : recipes) {
      List<String> res = new ArrayList<>();
      Set<String> visited = new HashSet<>();
      findIngrediants(receipeSet, receipe, ingredients, i, res, map, cache, visited);
      cache.put(receipe, res);
      if (set.containsAll(res)) {
        finres.add(receipe);
      }
      i++;
    }
    return finres;
  }

  // "sandwich", 1
  public void findIngrediants(
      Set<String> receipes,
      String receipe,
      List<List<String>> ingredients,
      int index,
      List<String> res,
      Map<String, Integer> map,
      Map<String, List<String>> cache,
      Set<String> visited) {
    if (visited.contains(receipe)) {
      return;
    }
    visited.add(receipe);
    if (cache.containsKey(receipe)) {
      res.addAll(cache.get(receipe));
      return;
    }
    for (String stuff : ingredients.get(index)) {
      if (receipes.contains(stuff)) {
        // need to call findIngredients again
        findIngrediants(receipes, stuff, ingredients, map.get(stuff), res, map, cache, visited);
      } else {
        res.add(stuff);
      }
    }
  }

  public static void main(String[] args) {
    String[] recipes = {"ju", "fzjnm", "x", "e", "zpmcz", "h", "q"};
    List<List<String>> outerList = new ArrayList<>();

    // create the inner lists and add them to the outer list
    List<String> innerList1 = Collections.singletonList("d");
    List<String> innerList2 = Arrays.asList("hveml", "f", "cpivl");
    List<String> innerList3 = Arrays.asList("cpivl", "zpmcz", "h", "e", "fzjnm", "ju");
    List<String> innerList4 = Arrays.asList("cpivl", "hveml", "zpmcz", "ju", "h");
    List<String> innerList5 = Arrays.asList("h", "fzjnm", "e", "q", "x");
    List<String> innerList6 = Arrays.asList("d", "hveml", "cpivl", "q", "zpmcz", "ju", "e", "x");
    List<String> innerList7 = Arrays.asList("f", "hveml", "cpivl");

    outerList.add(innerList1);
    outerList.add(innerList2);
    outerList.add(innerList3);
    outerList.add(innerList4);
    outerList.add(innerList5);
    outerList.add(innerList6);
    outerList.add(innerList7);

    String[] supplies = {"f", "hveml", "cpivl", "d"};
    Solution s = new Solution();
    s.findAllRecipes(recipes, outerList, supplies);
  }
}
