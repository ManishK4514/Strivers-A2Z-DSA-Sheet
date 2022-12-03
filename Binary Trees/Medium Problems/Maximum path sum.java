/*
   124. Binary Tree Maximum Path Sum
   A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
   
   The path sum of a path is the sum of the node's values in the path.
   
   Given the root of a binary tree, return the maximum path sum of any non-empty path.
   
   Example 1:   
   Input: root = [1,2,3]
   Output: 6
   Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.

   Example 2:   
   Input: root = [-10,9,20,null,null,15,7]
   Output: 42
   Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.
*/

class Node{
    int data;
    Node left;
    Node right;
    Node(int key){
        this.data = key;
    }
}

public class Maximum_path_sum {
    public static int maximumPath(Node root, int[] maxSum){
        if(root == null) return 0;
        // Not Consider Negative Value Take "0" Instead
        int lSum = Math.max(0, maximumPath(root.left, maxSum));
        // Not Consider Negative Value Take "0" Instead
        int rSum = Math.max(0, maximumPath(root.right, maxSum));
        maxSum[0] = Math.max(maxSum[0], root.data + (lSum + rSum));
        return root.data + Math.max(lSum, rSum);
    }
    public static int maxPathSum(Node root) {
        int[] maxSum = new int[1];
        maxSum[0] = Integer.MIN_VALUE;
        maximumPath(root, maxSum);
        return maxSum[0];
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
        System.out.println(maxPathSum(root));
    }
}
