/*
   173. Binary Search Tree Iterator
   Implement the BSTIterator class that represents an iterator over the in-order traversal of a binary search tree (BST):
   
   BSTIterator(TreeNode root) Initializes an object of the BSTIterator class. The root of the BST is given as part of the constructor. The pointer should be initialized to a non-existent number smaller than any element in the BST.
   boolean hasNext() Returns true if there exists a number in the traversal to the right of the pointer, otherwise returns false.
   int next() Moves the pointer to the right, then returns the number at the pointer.
   Notice that by initializing the pointer to a non-existent smallest number, the first call to next() will return the smallest element in the BST.
   
   You may assume that next() calls will always be valid. That is, there will be at least a next number in the in-order traversal when next() is called.
   
   Example 1:   
   Input
   ["BSTIterator", "next", "next", "hasNext", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
   [[[7, 3, 15, null, null, 9, 20]], [], [], [], [], [], [], [], [], []]
   Output
   [null, 3, 7, true, 9, true, 15, true, 20, false]
   
   Explanation
   BSTIterator bSTIterator = new BSTIterator([7, 3, 15, null, null, 9, 20]);
   bSTIterator.next();    // return 3
   bSTIterator.next();    // return 7
   bSTIterator.hasNext(); // return True
   bSTIterator.next();    // return 9
   bSTIterator.hasNext(); // return True
   bSTIterator.next();    // return 15
   bSTIterator.hasNext(); // return True
   bSTIterator.next();    // return 20
   bSTIterator.hasNext(); // return False
*/

import java.util.Stack;

class Node{
    int val;
    Node left;
    Node right;
    Node(int val){
        this.val = val;
    }
}

public class Binary_Search_Tree_Iterator {
    /*
       // BruteForce Approach: Time Complexity: O(N) & Space Complexity: O(N);
       Node root;
       static int i = 0;
       static ArrayList<Integer> list = new ArrayList<>();
       public static void inorder(Node root){
           if(root == null) return;
           inorder(root.left);
           list.add(root.val);
           inorder(root.right);
       }
       public BSTIterator(Node root) {
           this.root = root;
           inorder(root);
       }
       
       public static int next() {
           int val = list.get(i);
           i++;
           return val;
       }
       
       public static boolean hasNext() {
           return i != list.size();
       }
    */

    // Optimized Approach: Time Complexity: O(1) & Space Complexity: O(H);
    static Stack<Node> st = new Stack<>();
    public Binary_Search_Tree_Iterator(Node root) {
        pushAll(root);
    }
    
    public static int next() {
        Node tmpNode = st.pop();
        pushAll(tmpNode.right);
        return tmpNode.val;
    }
    
    public static boolean hasNext() {
        return !st.isEmpty();
    }

    public static void pushAll(Node root){
        while(root != null){
            st.push(root);
            root = root.left;
        }
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
        new  Binary_Search_Tree_Iterator(root);
        System.out.println(next()); 
        System.out.println(next()); 
        System.out.println(hasNext());
        System.out.println(next()); 
        System.out.println(hasNext());
        System.out.println(next()); 
        System.out.println(hasNext());
        System.out.println(next()); 
        System.out.println(hasNext());
        System.out.println(next()); 
        System.out.println(hasNext());
        System.out.println(next()); 
        System.out.println(hasNext());
        System.out.println(next()); 
        System.out.println(hasNext());
        System.out.println(next()); 
        System.out.println(hasNext());
        System.out.println(next()); 
        System.out.println(hasNext());
    }
}
