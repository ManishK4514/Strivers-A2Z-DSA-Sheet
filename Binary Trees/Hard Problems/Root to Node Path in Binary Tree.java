/*
   Path to Given Node
   Given a Binary Tree A containing N nodes.
   
   You need to find the path from Root to a given node B.
   
   NOTE:
   
   No two nodes in the tree have same data values.
   You can assume that B is present in the tree A and a path always exists.
   
   Example Input
   Input 1:
   
    A =
   
              1
            /   \
           2     3
          / \   / \
         4   5 6   7 
   
   
   B = 5
   
   Input 2:
   
    A = 
               1
             /   \
            2     3
           / \ .   \
          4   5 .   6
   
   
   B = 1
   
   
   Example Output
   Output 1:
   
    [1, 2, 5]
   Output 2:
   
    [1]
   
   
   Example Explanation
   Explanation 1:
   
    We need to find the path from root node to node with data value 5.
    So the path is 1 -> 2 -> 5 so we will return [1, 2, 5]
   Explanation 2:
   
    We need to find the path from root node to node with data value 1.
    As node with data value 1 is the root so there is only one node in the path.
   So we will return [1]
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

public class Root_to_Node_Path_in_Binary_Tree {
    public static boolean getPath(Node root, ArrayList<Integer> res, int target){
        if(root == null) return false;
        res.add(root.val);
        if(root.val == target) return true;
        
        if(getPath(root.left, res, target) || getPath(root.right, res, target)){
            return true;
        }
        
        res.remove(res.size() - 1);
        return false;
    }
    public static ArrayList<Integer> solve(Node A, int B) {
        ArrayList<Integer> res = new ArrayList<>();
        if(A == null) return res;
        getPath(A, res, B);
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
        System.out.println(solve(root, 10));
    }
}
