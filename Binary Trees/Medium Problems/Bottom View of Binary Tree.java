/*
   Bottom View of Binary Tree
   Given a binary tree, print the bottom view from left to right.
   A node is included in bottom view if it can be seen when we look at the tree from bottom.
   
                         20
                       /    \
                     8       22
                   /   \        \
                 5      3       25
                       /   \      
                     10    14
   
   For the above tree, the bottom view is 5 10 3 14 25.
   If there are multiple bottom-most nodes for a horizontal distance from root, then print the later one in level traversal. For example, in the below diagram, 3 and 4 are both the bottommost nodes at horizontal distance 0, we need to print 4.
   
                         20
                       /    \
                     8       22
                   /   \     /   \
                 5      3 4     25
                        /    \      
                    10       14
   
   For the above tree the output should be 5 10 4 14 25.
    
   
   Example 1:
   
   Input:
          1
        /   \
       3     2
   Output: 3 1 2
   Explanation:
   First case represents a tree with 3 nodes
   and 2 edges where root is 1, left child of
   1 is 3 and right child of 1 is 2.
   
   Thus nodes of the binary tree will be
   printed as such 3 1 2.
   Example 2:
   
   Input:
            10
          /    \
         20    30
        /  \
       40   60
   Output: 40 20 60 30
*/

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.LinkedList;
import java.util.Queue;

class Node{
    int data;
    Node left;
    Node right;
    Node(int key){
        this.data = key;
    }
}

class Pair{
    Node node;
    int hd;
    Pair(Node node, int hd){
        this.node = node;
        this.hd = hd;
    }
}

public class Bottom_View_of_Binary_Tree {
    public static ArrayList <Integer> bottomView(Node root){
        ArrayList<Integer> ans = new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        if(root == null) return ans;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        while(!q.isEmpty()){
            Pair it = q.remove();
            int hd = it.hd;
            Node temp = it.node;
            map.put(hd, temp.data);
            if(temp.left != null) q.add(new Pair(temp.left, hd - 1));
            if(temp.right != null) q.add(new Pair(temp.right, hd + 1));
        }
        for(Integer num : map.values()){
            ans.add(num);
        }
        return ans;
    }
    public static void main(String[] args) {
        /*
            Real World Representation the below tree into the code.
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
        System.out.println(bottomView(root));
    }
}
