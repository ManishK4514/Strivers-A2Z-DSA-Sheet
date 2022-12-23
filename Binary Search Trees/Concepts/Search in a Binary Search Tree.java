/*
   700. Search in a Binary Search Tree
   You are given the root of a binary search tree (BST) and an integer val.
   
   Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a node does not exist, return null.
   
   Example 1:   
   Input: root = [4,2,7,1,3], val = 2
   Output: [2,1,3]

   Example 2:   
   Input: root = [4,2,7,1,3], val = 5
   Output: []
*/

import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

class Node{
    int val;
    Node left;
    Node right;
    Node(int val){
        this.val = val;
    }
}

public class Search_in_a_Binary_Search_Tree {
    /* 
        // BruteForce Approach: Time Complexity: O(N)
        Node node = null;
        public void search(Node root, int target){
            if(root == null) return;
            if(root.val == target) node = root;
            search(root.left, target);
            search(root.right, target);
        }
        public static Node searchBST(Node root, int val) {
            search(root, val);
            return node;
        }
    */

    // Optimized Approach: Time Complexity: O(H)
    public static Node searchBST(Node root, int val) {
        while(root != null && root.val != val){
            root = val < root.val ? root.left : root.right;
        }
        return root;
    }

    // for Traversal
    public static List<List<Integer>> levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        List<List<Integer>> wrapList = new LinkedList<>();
        if(root == null) return wrapList;
        queue.add(root);
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<>();
            for(int i = 0; i < levelNum; i++){
                if(queue.peek().left != null) queue.add(queue.peek().left);
                if(queue.peek().right != null) queue.add(queue.peek().right);
                subList.add(queue.remove().val);
            }
            wrapList.add(subList);
        }
        return wrapList;
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
        Node res = searchBST(root, 30);
        System.out.println(levelOrder(res));
    }
}
