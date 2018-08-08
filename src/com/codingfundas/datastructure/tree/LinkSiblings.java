package com.codingfundas.datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sunngupt on 8/8/18.
 *
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/
 *
 *
 */


//  Definition for binary tree with next pointer.
class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;

    TreeLinkNode(int x) {
        val = x;
    }
}

public class LinkSiblings {

    Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();

    public void connect(TreeLinkNode root) {

        if (root == null) {
            return;
        }

        //add root in tree
        queue.add(root);

        while (!queue.isEmpty()) {

            int count = queue.size();

            TreeLinkNode prevLinkNode = null;
            TreeLinkNode currentLinkNode = null;

            while (count > 0) {
                currentLinkNode = queue.poll();

                if (currentLinkNode.left != null)
                    queue.add(currentLinkNode.left);

                if (currentLinkNode.right != null)
                    queue.add(currentLinkNode.right);

                if (prevLinkNode != null) {
                    prevLinkNode.next = currentLinkNode;
                }
                prevLinkNode = currentLinkNode;
                count--;
            }

        }

    }

    public static void main(String[] args) {

    }
}
