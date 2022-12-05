/*
   199. Binary Tree Right Side View
   Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
   
   Example 1:   
   Input: root = [1,2,3,null,5,null,4]
   Output: [1,3,4]

   Example 2:   
   Input: root = [1,null,3]
   Output: [1,3]

   Example 3:   
   Input: root = []
   Output: []
*/

import java.util.List;
// import java.util.Queue;
// import java.util.LinkedList;
import java.util.ArrayList;

class Node{
    int data;
    Node left;
    Node right;
    Node(int key){
        this.data = key;
    }
}

public class Binary_Tree_Right_Side_View {
    /* 
        // Iteretive
        public static List<Integer> rightSideView(Node root) {
            List<Integer> ans = new ArrayList<>();
            Queue<Node> q = new LinkedList<>();
            if(root == null) return ans;
            q.add(root);
            while(!q.isEmpty()){
                int k = q.size();
                int RightMost = 0;
                for(int i = 0; i < k; i++){
                    if(q.peek().left != null) q.add(q.peek().left);
                    if(q.peek().right != null) q.add(q.peek().right);
                    RightMost = q.remove().data;
                }
                ans.add(RightMost);
            }
            return ans;
        }
    */

    // Recursive
    public static List<Integer> rightSideView(Node root) {
        List<Integer> ans = new ArrayList<>();
        rightView(root, ans, 0);
        return ans;
    }
    public static void rightView(Node root, List<Integer> ans, int currDepth){
        if(root == null) return;
        // Storing ans in our list
        if(currDepth == ans.size()) ans.add(root.data);
        // Right
        if(root.right != null) rightView(root.right, ans, currDepth + 1);
        // Left
        if(root.left != null) rightView(root.left, ans, currDepth + 1);
    }
    public static void main(String[] args) {
        /*
            Visualisation of the tree in real world
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
        System.out.println(rightSideView(root));
    }
}
