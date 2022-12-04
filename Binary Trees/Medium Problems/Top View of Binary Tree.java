/*
   Q. Top View of Binary Tree
   Given below is a binary tree. The task is to print the top view of binary tree. Top view of a binary tree is the set of nodes visible when the tree is viewed from the top. For the given below tree
   
          1
       /     \
      2       3
     /  \    /   \
   4    5  6   7
   
   Top view will be: 4 2 1 3 7
   Note: Return nodes from leftmost node to rightmost node. Also if 2 nodes are outside the shadow of the tree and are at same position then consider the extreme ones only(i.e. leftmost and rightmost). 
   For ex - 1 2 3 N 4 5 N 6 N 7 N 8 N 9 N N N N N will give 8 2 1 3 as answer. Here 8 and 9 are on the same position but 9 will get shadowed.
   
   Example 1:
   
   Input:
         1
      /    \
     2      3
   Output: 2 1 3
   Example 2:
   
   Input:
          10
       /      \
     20        30
    /   \    /    \
   40   60  90    100
   Output: 40 20 10 30 100
*/

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Map;
import java.util.Queue;
import java.util.LinkedList;

class Node{
    int data;
    Node left;
    Node right;
    Node(int key){
        this.data = key;
    }
}

class Pair{
    int hd;
    Node node;
    Pair(int hd, Node node){
        this.hd = hd;
        this.node = node;
    }
}

public class Top_View_of_Binary_Tree {
    public static ArrayList<Integer> topView(Node root)    {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, root));
        while(!q.isEmpty()){
            Pair it = q.remove();
            int hd = it.hd;
            Node temp = it.node;
            if(map.get(hd) == null){
                map.put(hd, temp.data);
            }
            if(temp.left != null){
                q.add(new Pair(hd - 1, temp.left));
            }
            if(temp.right != null){
                q.add(new Pair(hd + 1, temp.right));
            }
        }
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            ans.add(entry.getValue());
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
        System.out.println(topView(root));
    }
}
