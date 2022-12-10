/*
   Time To Burn Tree
   Problem Statement
   Detailed explanation ( Input/output format, Notes, Constraints, Images )
   Sample Input 1 :
   1 2 3 4 -1 -1 5 -1 -1 -1 -1
   2    
   Sample Output 1 :
   3
   Explanation Of Sample Input 1 :
   The given binary tree will look as - 
   
   The Start node is 2.
   In the zeroth minute, Node 2 will start to burn.
   After one minute, Nodes 1 and 4 that are adjacent to 2 will burn completely.
   After two minutes, Node 3 that is adjacent to node 1 will burn completely.
   After three minutes, the only remaining Node 5 will be burnt and there will be no nodes remaining in the binary tree i.e the whole tree will burn in 3 minutes.
   Sample Input 2 :
   3 1 2 5 6 -1 -1 -1 -1 -1 -1
   3
   Sample Output 2 :
   2            
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
            count++;
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
                if(parent_track.get(current) != null && visited.get(parent_track.get(current)) == null){
                    queue.add(parent_track.get(current));
                    visited.put(parent_track.get(current), true);
                }            }
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
