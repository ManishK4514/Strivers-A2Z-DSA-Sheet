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

public class Post_order_Traversal_of_Binary_Tree_using_1_stack {
    public static List<Integer> postorderTraversal(Node root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<Node> st = new Stack<>();
        Node curr = root;
        while(curr != null || !st.isEmpty()){
            if(curr != null){
                st.push(curr);
                curr = curr.left;
            }
            else{
                Node temp = st.peek().right;
                if(temp == null){
                    temp = st.pop();
                    res.add(temp.data);
                    while(!st.isEmpty() && temp == st.peek().right){
                        temp = st.pop();
                        res.add(temp.data);
                    }
                }
                else{
                    curr = temp;
                }
            }
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
