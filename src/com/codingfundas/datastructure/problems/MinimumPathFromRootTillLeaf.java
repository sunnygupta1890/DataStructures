package com.codingfundas.datastructure.problems;

import java.util.ArrayList;
import java.util.List;

public class MinimumPathFromRootTillLeaf {

  /**
   * Given a k-ary tree with weights at each node, find path to leaf with shortest weight.
   * 
   * @param node
   * @param sumTillNow
   * @param minVal
   * @param path
   * @param tempList
   * @param finalList
   */
  public static void minimumPathSum(Node node, int sumTillNow, MinVal minVal, int path,
      List<Node> tempList, List<Node> finalList) {
    
    if(node == null) {
      return;
    }
    if(tempList.size() <= path) {
      tempList.add(path, node);  
    }else {
      tempList.set(path, node);
    }
    
    sumTillNow += node.getValue();
    if(sumTillNow > minVal.val) {
      return;
    }
    
    List<Node> children = node.getNodeList();
    //Leaf node found
    if(children == null) {
      if(sumTillNow < minVal.val) {
        minVal.val = sumTillNow;
        copy(tempList, finalList);
      }
    }else {
      int temp = path +1;
      for(Node child : children) {
        minimumPathSum(child, sumTillNow, minVal, temp,
            tempList, finalList);
      }
    }
    
  }
  
  public static void copy(List<Node> l1, List<Node> l2) {
    l2.clear();
    l2.addAll(l1);
  }

  static class Node {
    
    private int value;

    public Node(int value) {
      this.value = value;
    }
    
    List<Node> nodeList;

    public void add(Node node) {
      if (null == nodeList) {
        nodeList = new ArrayList<Node>();
      }
      nodeList.add(node);
    }
    
    public int getValue() {
      return value;
    }
    
    public List<Node> getNodeList() {
      return nodeList;
    }

  }

  static class MinVal {
    int val = Integer.MAX_VALUE;
  }


  public static void main(String[] args) {

    /*
     *              2
     *            /     \
     *          5         7
     *      /     \    /     \
     *      5     5   3      2
     * 
     */
    Node n1 = new Node(3);
    Node n2 = new Node(2);
    Node n3 = new Node(5);
    Node n4 = new Node(5);
      
    Node n5 = new Node(7);
    n5.add(n1);
    n5.add(n2);
 
    Node n6 = new Node(5);
    n6.add(n3);
    n6.add(n4);
    
    Node n7 = new Node(2);
    n7.add(n5);
    n7.add(n6);
    
    List<Node> finalList = new ArrayList<>();
    
    minimumPathSum(n7, 0, new MinVal(), 0, new ArrayList<>(), finalList);
    
    for(Node n: finalList) {
      System.out.println(n.value);
    }
    
  }
}
