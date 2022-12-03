/*
   103. Binary Tree Zigzag Level Order Traversal
   Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).
   
   Example 1:   
   Input: root = [3,9,20,null,null,15,7]
   Output: [[3],[20,9],[15,7]]

   Example 2:   
   Input: root = [1]
   Output: [[1]]

   Example 3:   
   Input: root = []
   Output: []
*/

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

class Node{
    int data;
    Node left;
    Node right;
    Node(int key){
        this.data = key;
    }
}

public class Zig_Zag_Traversal_of_Binary_Tree {
    public static List<List<Integer>> zigzagLevelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        if(root == null) return res;
        q.add(root);
        boolean flag = false;
        while(!q.isEmpty()){
            int k = q.size();
            List<Integer> sublist = new ArrayList<>();
            for(int i = 0; i < k; i++){
                if(q.peek().left != null) q.add(q.peek().left);
                if(q.peek().right != null) q.add(q.peek().right);
                if(flag){
                    // Adding in reverse order by Adding at starting
                    sublist.add(0, q.remove().data);
                }
                else{
                    sublist.add(q.remove().data);
                }
            }
            flag = !flag;
            res.add(sublist);
        }
        return res;
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
        System.out.println(zigzagLevelOrder(root));
    }
}
