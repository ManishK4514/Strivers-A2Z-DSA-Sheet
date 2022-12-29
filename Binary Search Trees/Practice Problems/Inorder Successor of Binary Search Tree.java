/*
   Q. Find Inorder Successor of Binary Search Tree.

                     10
                   /  \
                 7     30
                / \   / \
               4   9 20  35
                  /     / \
                 8    31    400
                 
    Example 1: 
    Input: 20
    Output: 30     
    
    Example 2: 
    Input: 8
    Output: 9  
    
    Example 3: 
    Input: 400
    Output: null
*/

class Node{
    int val;
    Node left;
    Node right;
    Node(int val){
        this.val = val;
    }
}

public class Inorder_Successor_in_BST {
    public static Node inorderSuccessor(Node root, Node p){
        Node successor = null;
        while(root != null){
            if(root.val <= p.val){
                root = root.right;
            }
            else{
                successor = root;
                root = root.left;
            }
        }
        return successor;
    }
    public static void main(String[] args) {
        /*
            Visualisation of the tree in real world
                     10
                   /  \
                 7     30
                / \   / \
               4   9 20  35
                  /     / \
                 8    31    400
        */
        Node root = new Node(10);
        root.left = new Node(7);
        root.right = new Node(30);
        root.left.left = new Node(4);
        root.left.right = new Node(9);
        root.left.right.left = new Node(8);
        root.right.left = new Node(20);
        root.right.right = new Node(35);
        root.right.right.left = new Node(31);
        root.right.right.right = new Node(40);
        System.out.println(inorderSuccessor(root, root.right.left).val);
    }
}
