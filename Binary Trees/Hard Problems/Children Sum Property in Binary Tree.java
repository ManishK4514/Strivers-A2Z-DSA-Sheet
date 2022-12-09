/*
   Check for Children Sum Property in a Binary Tree
   Problem Statement: Children Sum Property in a Binary Tree. Write a program that converts any binary tree to one that follows the children sum property.
   
   The children sum property is defined as, For every node of the tree, the value of a node is equal to the sum of values of its children(left child and right child).
   
   Note: 
   
   The node values can be increased by 1 any number of times but decrement of any node value is not allowed.
   A value for a NULL node can be assumed as 0.
   You are not allowed to change the structure of the given binary tree.


                     1                                     37
                   /  \                                   /  \
                 2     3                                12    25
                / \   / \         -------->            / \   / \
               4   5 6   7                            4   8 6   19
                  /     / \                              /     / \
                 8    9    10                           8    9    10 
*/

import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

class Node{
    int val;
    Node left;
    Node right;
    Node(int val){
        this.val = val;
    }
}

public class Children_Sum_Property_in_Binary_Tree {
    public static List<List<Integer>> levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        List<List<Integer>> wrapList = new LinkedList<>();
        if(root == null) return wrapList;
        queue.add(root);
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<>();
            for(int i = 0; i < levelNum; i++){
                if(queue.peek().left != null) queue.add(queue.peek().left);
                if(queue.peek().right != null) queue.add(queue.peek().right);
                subList.add(queue.remove().val);
            }
            wrapList.add(subList);
        }
        return wrapList;
    }
    public static void changeTree(Node root){
        if(root == null) return;
        int child = 0;
        if(root.left != null) child += root.left.val;
        if(root.right != null) child += root.right.val;
        if(child >= root.val) root.val = child;
        else{
            if(root.left != null) root.left.val = root.val;
            if(root.right != null) root.right.val = root.val;
        }
        changeTree(root.left);
        changeTree(root.right);

        int tot = 0;
        if(root.left != null) tot += root.left.val;
        if(root.right != null) tot += root.right.val;
        if(root.left != null || root.left != null) root.val = tot;
    }
    public static void main(String[] args) {
        /*
            Visualisation of the tree in real world
                     1
                   /  \
                 2     3
                / \   / \
               4   5 6   7
                  /     / \
                 8    9    10
        */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(8);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.left = new Node(9);
        root.right.right.right = new Node(10);
        changeTree(root);
        System.out.println(levelOrder(root));
    }
}
