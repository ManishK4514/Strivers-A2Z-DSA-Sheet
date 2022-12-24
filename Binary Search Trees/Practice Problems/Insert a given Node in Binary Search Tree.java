/*
   701. Insert into a Binary Search Tree
   You are given the root node of a binary search tree (BST) and a value to insert into the tree. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.
   
   Notice that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.
   
   Example 1:   
   Input: root = [4,2,7,1,3], val = 5
   Output: [4,2,7,1,3,5]
   Explanation: Another accepted tree is:
   
   Example 2:   
   Input: root = [40,20,60,10,30,50,70], val = 25
   Output: [40,20,60,10,30,50,70,null,null,25]

   Example 3:   
   Input: root = [4,2,7,1,3,null,null,null,null,null,null], val = 5
   Output: [4,2,7,1,3,5]
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

public class Insert_a_given_Node_in_Binary_Search_Tree {
    public static Node insertIntoBST(Node root, int val) {
        // Approach: Every time we will find the null (leaf) so that we can insert there our node without altering much tree
        if(root == null) return new Node(val);
        Node curr = root;
        while(true){
            if(curr.val < val){
                if(curr.right != null) curr = curr.right;
                else{
                    curr.right = new Node(val);
                    break;
                }
            }
            else{
                if(curr.left != null) curr = curr.left;
                else{
                    curr.left = new Node(val);
                    break;
                }
            }
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
        insertIntoBST(root, 65);
        System.out.println(levelOrder(root));
    }
}
