/*
   94. Binary Tree Inorder Traversal
   Given the root of a binary tree, return the inorder traversal of its nodes' values.
   
   Example 1:    
   Input: root = [1,null,2,3]
   Output: [1,3,2]

   Example 2:   
   Input: root = []
   Output: []

   Example 3:   
   Input: root = [1]
   Output: [1]
*/

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

class Node{
    int data;
    Node left;
    Node right;
    Node(int key){
        this.data = key;
    }
}

public class Iterative_Inorder_Traversa_of_Binary_Tree {
    public static List<Integer> inorderTraversal(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Node> st = new Stack<>();
        Node node = root;
        while(true){
            if(node != null){
                st.push(node);
                node = node.left;
            } 
            else{
                if(st.isEmpty()) break;
                node = st.pop();
                res.add(node.data);
                node = node.right;
            }      
        }
        return res;
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
        System.out.println(inorderTraversal(root));
    }
}
