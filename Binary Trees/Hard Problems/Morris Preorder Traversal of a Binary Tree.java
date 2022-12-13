/*
   144. Binary Tree Preorder Traversal
   Given the root of a binary tree, return the preorder traversal of its nodes' values.
   
   Example 1:
   Input: root = [1,null,2,3]
   Output: [1,2,3]
   Example 2:   
   Input: root = []
   Output: []
   Example 3:   
   Input: root = [1]
   Output: [1]
*/

import java.util.List;
import java.util.ArrayList;

class Node{
    int val;
    Node left;
    Node right;
    Node(int key){
        this.val = key;
    }
}

public class Morris_Preorder_Traversal_of_a_Binary_Tree {
    public static List<Integer> preorderTraversal(Node root) {
        ArrayList<Integer> preorder = new ArrayList<>();
        Node curr = root;
        while(curr != null){
            if(curr.left == null){
                preorder.add(curr.val);
                curr = curr.right;
            }
            else{
                Node prev = curr.left;
                while(prev.right != null && prev.right != curr){
                    prev = prev.right;
                }
                if(prev.right == null){
                    prev.right = curr;
                    preorder.add(curr.val);
                    curr = curr.left;
                }
                else{
                    prev.right = null;                    
                    curr = curr.right;
                }
            }
        }
        return preorder;
    }
    public static void main(String[] args) {
        /*
            Real World Representation the below tree into the code.
                    1
                   /\
                 2   3
                / \  / \
               4   5 6  7
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
        System.out.println(preorderTraversal(root));
    }
}
