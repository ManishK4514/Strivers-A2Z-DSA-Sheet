/*
   543. Diameter of Binary Tree
   Given the root of a binary tree, return the length of the diameter of the tree.
   
   The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
   
   The length of a path between two nodes is represented by the number of edges between them.
   
   Example 1:
   Input: root = [1,2,3,4,5]
   Output: 3
   Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].

   Example 2:   
   Input: root = [1,2]
   Output: 1
*/

class Node{
    int data;
    Node left;
    Node right;
    Node(int key){
        this.data = key;
    }
}

public class Diameter_of_Binary_Tree {
    public static int height(Node root, int[] diameter){
        if(root ==  null) return 0;

        int lh = height(root.left, diameter);
        int rh = height(root.right, diameter);
        diameter[0] = Math.max(diameter[0], lh + rh);
        return 1 + Math.max(lh, rh);        
    }
    public static int diameterOfBinaryTree(Node root) {
        int[] diameter = new int[1];
        height(root, diameter);
        return diameter[0];
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
        System.out.println(diameterOfBinaryTree(root));
    }
}
