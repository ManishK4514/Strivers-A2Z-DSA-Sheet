/*
   653. Two Sum IV - Input is a BST
   Given the root of a binary search tree and an integer k, return true if there exist two elements in the BST such that their sum is equal to k, or false otherwise.
   
   Example 1:   
   Input: root = [5,3,6,2,4,null,7], k = 9
   Output: true

   Example 2:   
   Input: root = [5,3,6,2,4,null,7], k = 28
   Output: false
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

class BSTIterator {
    Stack<Node> st = new Stack<>();
    boolean reverse;
    public BSTIterator(Node root, boolean reverse) {
        this.reverse = reverse;
        pushAll(root);        
    }
    
    public int next() {
        Node tmpNode = st.pop();
        if(reverse == false) pushAll(tmpNode.right);
        else pushAll(tmpNode.left);
        return tmpNode.val;
    }

    public void pushAll(Node root){
        while(root != null){
            st.push(root);
            if(reverse){
                root = root.right;
            }
            else{
                root = root.left;
            }
        }
    }
}

public class Two_Sum_In_BST_OR_Check_if_there_exists_a_pair_with_Sum_K {
    /* 
        Approach 1: --> Time Complexity: O(2N) & Space Complexity: O(3N)
        public static boolean twoSum(ArrayList<Integer> nums, int target){
            HashSet<Integer> set = new HashSet<>();
            for(int i = 0; i < nums.size(); i++){
                if(set.contains(target - nums.get(i))) return true;
                else set.add(nums.get(i));
            }
            return false;
        }
        ArrayList<Integer> list = new ArrayList<>();
        public static void inorder(Node root){
            if(root == null) return;
            inorder(root.left);
            list.add(root.val);
            inorder(root.right);
        }
        public static boolean findTarget(Node root, int k) {
            inorder(root);
            return twoSum(list, k);
        }
    */

    /* 
        Approach 2: (for all Binary Tree) --> Time Complexity: O(N) & Space Complexity: O(2N)
        HashSet<Integer> set = new HashSet<>();
        public static boolean inorder(Node root, int target){
            if(root == null) return false;
            
            if(set.contains(target - root.val)) return true;
            set.add(root.val);
            return inorder(root.left, target) || inorder(root.right, target);
        }
        public static boolean findTarget(Node root, int k) {
            return inorder(root, k);
        }
    */

    // Approach 3: Optimized Approach --> Time Complexity-> O(N) & Space Complexity: O(2H)
    public static boolean findTarget(Node root, int k) {
        if(root == null) return false;
        BSTIterator l = new BSTIterator(root, false);
        BSTIterator r = new BSTIterator(root, true);
        
        int i = l.next(), j = r.next();
        while(i < j){
            if(i + j == k) return true;
            else if(i + j < k) i = l.next();
            else j = r.next();
        }
        return false;
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
        System.out.println(findTarget(root, 55));
    }
}
