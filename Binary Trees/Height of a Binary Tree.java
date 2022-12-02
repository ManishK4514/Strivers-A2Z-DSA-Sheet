/*
   104. Maximum Depth of Binary Tree
   Given the root of a binary tree, return its maximum depth.
   
   A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
   
   Example 1:
   
   
   Input: root = [3,9,20,null,null,15,7]
   Output: 3
   Example 2:
   
   Input: root = [1,null,2]
   Output: 2
*/

class Node{
    int data;
    Node left;
    Node right;
    Node(int key){
        this.data = key;
    }
}

public class Height_of_a_Binary_Tree {
    // Iterative
    /*
        public int maxDepth(TreeNode root) {
            int height = 0;
            Queue<TreeNode> queue = new LinkedList<>();
            if(root == null) return 0;
            queue.add(root);
            while(!queue.isEmpty()){
                int k = queue.size();
                for(int i = 0; i < k; i++){                
                    if(queue.peek().left != null) queue.add(queue.peek().left);
                    if(queue.peek().right != null) queue.add(queue.peek().right);
                    queue.remove();
                }
                height++;
            }
            return height;
        }
    */

    // Recurive
    public static int maxDepth(Node root) {
        if(root == null) return 0;
        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);
        return 1 + Math.max(lh, rh);
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
        System.out.println(maxDepth(root));
    }
}
