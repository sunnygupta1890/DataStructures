package com.codingfundas.datastructure.tree;

import com.codingfundas.datastructure.tree.FindInorderSuccessor.Treebuilder.Node;

/**
 * http://www.spoj.com/problems/classical/
 * <p>
 * https://leetcode.com/
 * <p>
 * http://ideone.com/
 * <p>
 * Tu jitni baar tayari karega utni baar kuch naya seekhega - Thanks Dost (Ankit Tripathi) for the motivation.
 * <p>
 * Created by sunngupt on 2/5/17.
 */
public class FindInorderSuccessor {

    /**
     * Class representing Tree's Single Node
     */
    static class Treebuilder {

        static class Node {
            int data;
            Node left;
            Node right;

            public Node(int data, Node left, Node right) {
                this.data = data;
                this.left = left;
                this.right = right;
            }
        }

        public static Node constructTree() {
                /*
                For Now I am constructing a BST

                      10
                     /  \
                    6   15
                  / \  /  \
                 2  8 12  17

                */

            Node node2 = new Node(2, null, null);
            Node node8 = new Node(8, null, null);
            Node node12 = new Node(12, null, null);
            Node node17 = new Node(17, null, null);

            Node node6 = new Node(6, node2, node8);
            Node node15 = new Node(15, node12, node17);

            //Root Node
            Node node10 = new Node(10, node6, node15);

            return node10;
        }
    }

    /**
     * This fundtion will return the InOrder Successor of a given Node
     *
     * @return
     */
    public Node findInOrderSuccessor() {

        return null;
    }
}
