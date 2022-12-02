/*
   110. Balanced Binary Tree
   Given a binary tree, determine if it is 
   height-balanced
   
   Example 1:   
   Input: root = [3,9,20,null,null,15,7]
   Output: true

   Example 2:   
   Input: root = [1,2,2,3,3,null,null,4,4]
   Output: false
   Example 3:
   
   Input: root = []
   Output: true
*/

class Node{
    int data;
    Node left;
    Node right;
    Node(int key){
        this.data = key;
    }
}

public class Check_if_the_Binary_tree_is_height_balanced_or_not {
    public static int maxDepth(Node root) {
        if(root == null) return 0;
        int lh = maxDepth(root.left);
        if(lh == -1) return -1;
        int rh = maxDepth(root.right);
        if(rh == -1) return -1;
        if(Math.abs(lh - rh) > 1) return -1;
        return 1 + Math.max(lh, rh);
    }
    public static boolean isBalanced(Node root) {
        return maxDepth(root) != -1;
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
        System.out.println(isBalanced(root));
    }
}
