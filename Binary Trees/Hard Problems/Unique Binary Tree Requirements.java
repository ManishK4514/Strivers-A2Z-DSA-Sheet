/*
   Unique Binary Tree Requirements
   Geek wants to know the traversals required to construct a unique binary tree. Given a pair of traversal, return true if it is possible to construct unique binary tree from the given traversals otherwise return false.
   
   Each traversal is represented with an integer: preorder - 1, inorder - 2, postorder - 3.   
   
   Example 1:
   
   Input:
   a = 1, b=2
   Output: 1
   Explanation: We can construct binary tree using inorder traversal and preorder traversal. 
   Example 2:
   
   Input: a = 1, b=3
   Output: 1 
   Explanation: We cannot construct binary tree using preorder traversal and postorder traversal. 
*/


public class Unique_Binary_Tree_Requirements {
    public static boolean isPossible(int a, int b){
        /*
         * PreOrder & PostOrder : false
         * Inorder & preOrder : true
         * Inorder & PostOrder : true
         */
        if(a == 1 && b == 3) return false;
        else if(a == b) return false;
        else if(a == 3 && b == 1) return false;
        else return true;
    }
    public static void main(String[] args) {
        /*
         * Preorder  :  1
         * Inorder   :  2
         * PostOrder :  3
         */

        int a = 1, b = 2;
        System.out.println(isPossible(a, b));
    }
}
