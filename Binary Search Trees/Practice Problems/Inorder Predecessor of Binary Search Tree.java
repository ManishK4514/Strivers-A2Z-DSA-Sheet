/*
   Q. Find Inorder Predecessor of Binary Search Tree.

                     10
                   /  \
                 7     30
                / \   / \
               4   9 20  35
                  /     / \
                 8    31    400
                 
    Example 1: 
    Input: 8
    Output: 7   
    
    Example 2: 
    Input: 35
    Output: 31
    
    Example 3: 
    Input: 4
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

public class Inorder_predecessor_in_BST {
    // Time Complexity: O(H) & Space Complexity: O(1).
    public static Node inorderPredecessor(Node root, Node p){
        Node predecessor = null;
        while(root != null){
            if(root.val >= p.val){
                root = root.left;
            }
            else{
                predecessor = root;
                root = root.right;
            }
        }
        return predecessor;
    }
    public static void main(String[] args) {
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
        System.out.println(inorderPredecessor(root, root.right.right).val);
    }
}
