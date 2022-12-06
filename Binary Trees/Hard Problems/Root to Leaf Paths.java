/*
   Root to Leaf Paths
   Given a Binary Tree of size N, you need to find all the possible paths from root node to all the leaf node's of the binary tree.
   
   Example 1:
   
   Input:
          1
       /     \
      2       3
   Output: 1 2 #1 3 #
   Explanation: 
   All possible paths:
   1->2
   1->3
   
   Example 2:
   
   Input:
            10
          /    \
         20    30
        /  \
       40   60
   Output: 10 20 40 #10 20 60 #10 30 #
*/

import java.util.ArrayList;

class Node{
    int val;
    Node left;
    Node right;
    Node(int val){
        this.val = val;
    }
}

public class Root_to_Leaf_Paths {
    public static void getPath(Node root, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> path){
        if(root == null) return;
        if(root.left == null && root.right == null){
            path.add(root.val);
            res.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
        }
        
        // Adding
        path.add(root.val);

        // left
        getPath(root.left, res, path);
        
        // Right
        getPath(root.right, res, path);

        // Removing on BackTrack
        path.remove(path.size() - 1);
    }
    public static ArrayList<ArrayList<Integer>> binaryTreePaths(Node root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        getPath(root, res, new ArrayList<>());
        return res;
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
        System.out.println(binaryTreePaths(root));
    }
}
