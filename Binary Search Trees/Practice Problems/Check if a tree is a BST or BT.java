/*
   98. Validate Binary Search Tree
   Given the root of a binary tree, determine if it is a valid binary search tree (BST).
   
   A valid BST is defined as follows:
   
   The left 
   subtree
    of a node contains only nodes with keys less than the node's key.
   The right subtree of a node contains only nodes with keys greater than the node's key.
   Both the left and right subtrees must also be binary search trees.
    
   
   Example 1:   
   Input: root = [2,1,3]
   Output: true

   Example 2:   
   Input: root = [5,1,4,null,null,3,6]
   Output: false
   Explanation: The root node's value is 5 but its right child's value is 4.
*/

class Node{
    int val;
    Node left;
    Node right;
    Node(int val){
        this.val = val;
    }
}

public class Validate_Binary_Search_Tree {
    /* 
        Approach 1: (With Sorting) --> Time Complexity: O(NlogN) & Space Complexity: O(N)
        ArrayList<Integer> list = new ArrayList<>();
        public static void inorder(Node root){
            if(root == null) return;
            inorder(root.left);
            list.add(root.val);
            inorder(root.right);
        }
        public static boolean isValidBST(Node root) {
            inorder(root);
            ArrayList<Integer> list2 = new ArrayList<>(list);
            Collections.sort(list2);
            HashSet<Integer> set = new HashSet<>();
            for(int i = 0; i < list.size(); i++){
                set.add(list.get(i));
                if(list.get(i) != list2.get(i)) return false;
            }
            if(set.size() != list.size()) return false;
            return true;
        }
    */
    
    public static boolean helper(Node root, long min , long max){
        if(root == null) return true;
        if(root.val <= min || root.val >= max) return false;
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
    public static boolean isValidBST(Node root) {        
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
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
        System.out.println(isValidBST(root));
    }
}
