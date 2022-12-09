/*
   863. All Nodes Distance K in Binary Tree
   Given the root of a binary tree, the value of a target node target, and an integer k, return an array of the values of all nodes that have a distance k from the target node.
   
   You can return the answer in any order.
   
    
   
   Example 1:
   
   
   Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
   Output: [7,4,1]
   Explanation: The nodes that are a distance 2 from the target node (with value 5) have values 7, 4, and 1.
   Example 2:
   
   Input: root = [1], target = 1, k = 3
   Output: []


                     3           
                   /  \         
                 5     1        
                / \   / \         -------> [7, 4, 1] are the elements at distance K = 2 from Node [5]
               6   2 0   8        
                  / \            
                 7   4                     
*/

import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.ArrayList;

class Node{
    int val;
    Node left;
    Node right;
    Node(int val){
        this.val = val;
    }
}

public class Print_all_the_Nodes_at_a_distance_of_K_in_a_Binary_Tree {
    public static void markParent(Node root, HashMap<Node, Node> parent_track){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Node current = queue.remove();
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
    public static List<Integer> distanceK(Node root, Node target, int k) {
        HashMap<Node, Node> parent_track = new HashMap<>();
        markParent(root, parent_track);
        HashMap<Node, Boolean> visited = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(target);
        visited.put(target, true);
        int curr_level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            if(curr_level == k) break;
            curr_level++;
            for(int i = 0; i < size; i++){
                Node current = queue.remove();
                if(current.left != null && visited.get(current.left) == null){
                    queue.add(current.left);
                    visited.put(current.left, true);
                }
                if(current.right != null && visited.get(current.right) == null){
                    queue.add(current.right);
                    visited.put(current.right, true);
                }
                if(parent_track.get(current) != null && visited.get(parent_track.get(current))== null){
                    queue.add(parent_track.get(current));
                    visited.put(parent_track.get(current), true);
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        while(!queue.isEmpty()){
            result.add(queue.remove().val);
        }
        return result;
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
        int k = 2;
        System.out.println(distanceK(root, root.right, k));
    }
}
