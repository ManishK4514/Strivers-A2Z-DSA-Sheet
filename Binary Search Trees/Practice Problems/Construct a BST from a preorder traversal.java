/*
   1008. Construct Binary Search Tree from Preorder Traversal
   Given an array of integers preorder, which represents the preorder traversal of a BST (i.e., binary search tree), construct the tree and return its root.
   
   It is guaranteed that there is always possible to find a binary search tree with the given requirements for the given test cases.
   
   A binary search tree is a binary tree where for every node, any descendant of Node.left has a value strictly less than Node.val, and any descendant of Node.right has a value strictly greater than Node.val.
   
   A preorder traversal of a binary tree displays the value of the node first, then traverses Node.left, then traverses Node.right.
   
   Example 1:   
   Input: preorder = [8,5,1,7,10,12]
   Output: [8,5,10,1,7,null,12]

   Example 2:   
   Input: preorder = [1,3]
   Output: [1,null,3]
*/

class Node{
    int val;
    Node left;
    Node right;
    Node(int val){
        this.val = val;
    }
}

public class Construct_a_BST_from_a_preorder_traversal {
    public static void printPreorder(Node root) {
        if (root == null) return;    
        System.out.print(root.val + " ");
        printPreorder(root.left);
        printPreorder(root.right);
    }
    
    /* 
        Approach 1: --> Time Complexity: O(N^2) & Space Complexity: O(4N)
        public static Node bstFromPreorder(int[] preorder) {
            Node root = new Node(preorder[0]);        
            for(int i = 1; i < preorder.length; i++){
                int curr = preorder[i];
                Node dummy = root;
                Node prev = null;
                while(dummy != null){
                    prev = dummy;
                    if(curr > dummy.val) dummy = dummy.right;
                    else dummy = dummy.left;
                }
                if(curr < prev.val) prev.left = new Node(curr);
                else prev.right = new Node(curr); 
            }
            return root;
        }
    */
    
    // Approach 2: --> Time Complexity: O(N) & Space Complexity: O(4N)
    static int i = 0;
    public static Node bstFromPreorder(int[] preorder) {
        return bstFromPreorder(Integer.MAX_VALUE, preorder);
    }
    public static Node bstFromPreorder(int bound, int[] preorder){
        if(i == preorder.length || preorder[i] > bound) return null;
        Node root = new Node(preorder[i++]);
        root.left = bstFromPreorder(root.val, preorder);
        root.right = bstFromPreorder(bound, preorder);
        return root;
    }
    
    public static void main(String[] args) {
        int[] preorder = {8,5,1,7,10,12};
        Node root = bstFromPreorder(preorder);
        printPreorder(root);
    }
}
