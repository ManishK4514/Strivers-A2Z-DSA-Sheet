/*
   450. Delete Node in a BST
   Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.
   
   Basically, the deletion can be divided into two stages:
   
   Search for a node to remove.
   If the node is found, delete the node.
    
   
   Example 1:   
   Input: root = [5,3,6,2,4,null,7], key = 3
   Output: [5,4,6,2,null,null,7]
   Explanation: Given key to delete is 3. So we find the node with value 3 and delete it.
   One valid answer is [5,4,6,2,null,null,7], shown in the above BST.
   Please notice that another valid answer is [5,2,6,null,4,null,7] and it's also accepted.
   
   Example 2:   
   Input: root = [5,3,6,2,4,null,7], key = 0
   Output: [5,3,6,2,4,null,7]
   Explanation: The tree does not contain a node with value = 0.

   Example 3:   
   Input: root = [], key = 0
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

public class Delete_Node_in_a_BST {
    public static Node deleteNode(Node root, int key) {
        if(root == null) return null;
        if(root.val == key){
            return helper(root);
        }
        Node dummy = root;
        while(root != null){
            if(root.val > key){
                if(root.left != null && root.left.val == key){
                    root.left = helper(root.left);
                    break;
                }
                else{
                    root = root.left;
                }
            }
            else{
                if(root.right != null && root.right.val == key){
                    root.right = helper(root.right);
                    break;
                }
                else{
                    root = root.right;
                }
            }
        }
        return dummy;
    }
    public static Node helper(Node root){
        if(root.left == null){
            return root.right;
        }
        else if(root.right == null){
            return root.left;
        }
        Node rightChild = root.right;
        Node lastRight = findLastRight(root.left);
        lastRight.right = rightChild;
        return root.left;
    }
    public static Node findLastRight(Node root){
        if(root.right == null) return root;
        return findLastRight(root.right);
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
        deleteNode(root, 7);
        System.out.println(levelOrder(root));
    }
}
