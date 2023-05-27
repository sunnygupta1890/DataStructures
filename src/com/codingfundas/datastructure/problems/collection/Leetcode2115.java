package com.codingfundas.datastructure.problems.collection;

import java.util.*;

class Leetcode2115 {
  public List<String> findAllRecipes(
      String[] recipes, List<List<String>> ingredients, String[] supplies) {

    HashMap<String, Integer> recMap = new HashMap<>();
    HashMap<String, ArrayList<String>> graph = new HashMap<>();
    int n = recipes.length;
    HashSet<String> sup = new HashSet<>();

    Collections.addAll(sup, supplies);

    for (int i = 0; i < n; i++) {
      recMap.put(recipes[i], i);
    }

    int[] indegree = new int[n];
    for (int i = 0; i < n; i++) {
      for (String str : ingredients.get(i)) {
        if (!sup.contains(str)) {
          graph.putIfAbsent(str, new ArrayList<>());
          ArrayList<String> list = graph.get(str);
          list.add(recipes[i]);
          indegree[i]++;
        }
      }
    }

    Queue<String> q = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      if (indegree[i] == 0) {
        q.add(recipes[i]);
      }
    }
    List<String> ans = new ArrayList<>();
    while (!q.isEmpty()) {
      String node = q.peek();
      q.poll();
      ans.add(node);
      if (graph.containsKey(node)) {
        for (String str : graph.get(node)) {
          indegree[recMap.get(str)]--;
          if (indegree[recMap.get(str)] == 0) q.add(str);
        }
      }
    }

    return ans;
  }

  public static void main(String[] args) {
    Leetcode2115 leetcode2115 = new Leetcode2115();
    String[] recipes = {"chai"};
    List<List<String>> inged = new ArrayList<>();
    List<String> inner = new ArrayList<>();
    inner.add("chaipatti");
    inner.add("chini");
    inged.add(inner);
    String[] supplies = {"chini"};
    List<String> res = leetcode2115.findAllRecipes(recipes, inged, supplies);
    res.forEach(System.out::println);
  }
}
