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


class Node{
    int data;
    Node left;
    Node right;
    Node(int key){
        this.data = key;
    }
}

public class Preorder_Traversal_of_Binary_Tree {
    public static void preOrderTraversal(Node node){
        if(node == null){
            return;
        }
        System.out.print(node.data + " ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
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
        preOrderTraversal(root);
    }
}
