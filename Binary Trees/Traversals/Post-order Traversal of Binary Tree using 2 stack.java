/*
   145. Binary Tree Postorder Traversal
   Given the root of a binary tree, return the postorder traversal of its nodes' values.
   
   Example 1:
   Input: root = [1,null,2,3]
   Output: [3,2,1]

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

public class PostOrder_Traversal_of_Binary_Tree_using_2_stack {
    public static List<Integer> postorderTraversal(Node root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        st1.push(root);
        while(!st1.isEmpty()){
            Node node = st1.peek();
            st2.push(st1.pop());
            if(node.left != null) st1.push(node.left);
            if(node.right != null) st1.push(node.right);
        }
        while(!st2.isEmpty()){
            res.add(st2.pop().data);
        }
        return res;
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
        System.out.println(postorderTraversal(root));
    }
}
