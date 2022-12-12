/*
   105. Construct Binary Tree from Preorder and Inorder Traversal
   Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.
   
   Example 1:
   Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
   Output: [3,9,20,null,null,15,7]

             3
           /  \
          9   20
             /  \
            15   17

   
   Example 2:   
   Input: preorder = [-1], inorder = [-1]
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

public class Construct_Binary_Tree_from_inorder_and_preorder {
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
    public static Node buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> inMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            inMap.put(inorder[i], i);
        }
        Node root = buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
        return root;
    }
    public static Node buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, HashMap<Integer, Integer> inMap){
        if(preStart > preEnd || inStart > inEnd) return null;
        
        Node root = new Node(preorder[preStart]);

        int inRoot = inMap.get(root.val);
        int numsLeft = inRoot - inStart;

        root.left = buildTree(preorder, preStart + 1, preEnd + numsLeft, inorder, inStart, inRoot - 1, inMap);
        root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd, inMap);

        return root;
    }
    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        Node root = buildTree(preorder, inorder);
        System.out.println(levelOrder(root));
    }
}
