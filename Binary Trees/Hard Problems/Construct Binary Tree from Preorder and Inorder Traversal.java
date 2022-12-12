/*
   106. Construct Binary Tree from Inorder and Postorder Traversal
   Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.
   
   Example 1:
   Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
   Output: [3,9,20,null,null,15,7]

             3
           /  \
          9   20
             /  \
            15   7

   
   Example 2:
   Input: inorder = [-1], postorder = [-1]
   Output: [-1]
*/

import java.util.HashMap;
import java.util.Queue;
import java.util.List;
import java.util.LinkedList;

class Node{
    int val;
    Node left;
    Node right;
    Node(int val){
        this.val = val;
    }
}

public class Construct_the_Binary_Tree_from_Postorder_and_Inorder_Traversal {
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
    public static Node buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> inMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            inMap.put(inorder[i], i);
        }
        Node root = buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, inMap);
        return root;
    }
    public static Node buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, HashMap<Integer, Integer> inMap){
        if(inStart > inEnd || postStart > postEnd) return null;
        Node root = new Node(postorder[postEnd]);
        
        int inRoot = inMap.get(root.val);
        int numsRight = inEnd - inRoot;

        root.left = buildTree(inorder, inStart, inRoot - 1, postorder, postStart, postEnd - numsRight - 1, inMap);
        root.right = buildTree(inorder, inRoot + 1, inEnd, postorder, postEnd - numsRight, postEnd - 1, inMap);

        return root;
    }
    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        Node root = buildTree(inorder, postorder);
        System.out.println(levelOrder(root));
    }
}
