/*
   99. Recover Binary Search Tree
   You are given the root of a binary search tree (BST), where the values of exactly two nodes of the tree were swapped by mistake. Recover the tree without changing its structure.
   
   Example 1:
   Input: root = [1,3,null,null,2]
   Output: [3,1,null,null,2]
   Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3 makes the BST valid.
   
   Example 2:
   Input: root = [3,1,4,null,null,2]
   Output: [2,1,4,null,null,3]
   Explanation: 2 cannot be in the right subtree of 3 because 2 < 3. Swapping 2 and 3 makes the BST valid.
*/

class Node{
    int val;
    Node left;
    Node right;
    Node(int val){
        this.val = val;
    }
}

public class Recover_Binary_Search_Tree {
    static Node first, middle, last, prev;
    public static void inorder(Node root){
        if(root == null) return;
        inorder(root.left);
        if(prev != null && prev.val > root.val){
            if(first == null){
                first = prev;
                middle = root;
            }
            else last = root;
        }
        prev = root;
        inorder(root.right);
    }
    public static void recoverTree(Node root) {
        first = middle = last = null;
        prev = new Node(Integer.MIN_VALUE);
        inorder(root);
        if(first != null && last != null){
            int t = first.val;
            first.val = last.val;
            last.val = t;
        }
        else if(first != null && middle != null){
            int t = first.val;
            first.val = middle.val;
            middle.val = t;
        }
    }
    public static void printInorder(Node root) {
        if (root == null) return;    
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
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
        root.left.left = new Node(35);
        root.left.right = new Node(9);
        root.left.right.left = new Node(8);
        root.right.left = new Node(20);
        root.right.right = new Node(4);
        root.right.right.left = new Node(31);
        root.right.right.right = new Node(40);
        System.out.print("Before: ");
        printInorder(root);
        recoverTree(root);
        System.out.println();
        System.out.print("After: ");
        printInorder(root);
    }
}
