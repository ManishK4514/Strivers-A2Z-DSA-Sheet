/*
   Q. Minimum time taken to BURN the Binary Tree from a Node
   Given a binary tree and a node called target. Find the minimum time required to burn the complete binary tree if the target is set on fire. It is known that in 1 second all nodes connected to a given node get burned. That is its left child, right child, and parent.


   Example 1:
   
   Input:      
             1
           /   \
         2      3
       /  \      \
      4    5      6
          / \      \
         7   8      9
                      \
                      10
   Target Node = 8
   Output: 7
   Explanation: If leaf with the value 
   8 is set on fire. 
   After 1 sec: 5 is set on fire.
   After 2 sec: 2, 7 are set to fire.
   After 3 sec: 4, 1 are set to fire.
   After 4 sec: 3 is set to fire.
   After 5 sec: 6 is set to fire.
   After 6 sec: 9 is set to fire.
   After 7 sec: 10 is set to fire.
   It takes 7s to burn the complete tree.
   Example 2:
   
   Input:      
             1
           /   \
         2      3
       /  \      \
      4    5      7
     /    / 
    8    10
   Target Node = 10
   Output: 5
*/

import java.util.Queue;
import java.util.LinkedList;
import java.util.HashMap;

class Node{
    int val;
    Node left;
    Node right;
    Node(int val){
        this.val = val;
    }
}
public class Minimum_time_taken_to_BURN_the_Binary_Tree_from_a_Node {
    public static Node start;
    public static Node find(Node root, int target){
        if(root.val == target) return root;
        if(root.left != null) find(root.left, target);
        if(root.right != null) find(root.right, target);
        return null;
    }
    public static void markParent(Node root, HashMap<Node, Node> parent_track, int startVal){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Node current = queue.remove();
                if(current.val == startVal) start = current;
                if(current.left != null){
                    parent_track.put(current.left, current);
                    queue.add(current.left);
                }
                if(current.right != null){
                    parent_track.put(current.right, current);
                    queue.add(current.right);
                }
            }
        }
    }
    public static int timeToBurnTree(Node root, int startVal) {  
        HashMap<Node, Node> parent_track = new HashMap<>();
        markParent(root, parent_track, startVal);
        int count = 0;
        Queue<Node> queue = new LinkedList<>();
        HashMap<Node, Boolean> visited = new HashMap<>();
        queue.add(start);
        visited.put(start, true);
        while(!queue.isEmpty()){
            int size = queue.size();
            int flag = 0;
            for(int i = 0; i < size; i++){
                Node current = queue.remove();
                if(current.left != null && visited.get(current.left) == null){
                    queue.add(current.left);
                    visited.put(current.left, true);
                    flag = 1;
                }
                if(current.right != null && visited.get(current.right) == null){
                    queue.add(current.right);
                    visited.put(current.right, true);
                    flag = 1;
                }
                if(parent_track.get(current) != null && visited.get(parent_track.get(current)) == null){
                    queue.add(parent_track.get(current));
                    visited.put(parent_track.get(current), true);
                    flag = 1;
                }           
            }
            // Check if any node burned at this level so that we will increase count
            if(flag == 1) count++;
        }
        return count;
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
        System.out.println(timeToBurnTree(root, 3));
    }
}
