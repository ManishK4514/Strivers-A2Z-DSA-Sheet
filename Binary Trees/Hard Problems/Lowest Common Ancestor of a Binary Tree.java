/*
   236. Lowest Common Ancestor of a Binary Tree
   Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
   
   According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
      
   Example 1:   
   Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
   Output: 3
   Explanation: The LCA of nodes 5 and 1 is 3.

   Example 2:   
   Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
   Output: 5
   Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.

   Example 3:   
   Input: root = [1,2], p = 1, q = 2
   Output: 1
*/

// import java.util.ArrayList;

class Node{
    int val;
    Node left;
    Node right;
    Node(int val){
        this.val = val;
    }
}

public class Lowest_Common_Ancestor_of_a_Binary_Tree {
    /* 
        // Solution 1:

        public static boolean getPath(Node root, ArrayList<Node> res, Node target){
            if(root == null) return false;
            res.add(root);
            if(root == target) return true;
            
            if(getPath(root.left, res, target) || getPath(root.right, res, target)){
                return true;
            }
            
            res.remove(res.size() - 1);
            return false;
        }
        public static ArrayList<Node> solve(Node A, Node B) {
            ArrayList<Node> res = new ArrayList<>();
            if(A == null) return res;
            getPath(A, res, B);
            return res;
        }
        public static Node lowestCommonAncestor(Node root, Node p, Node q) {
            ArrayList<Node> arr1 = solve(root, p);
            ArrayList<Node> arr2 = solve(root, q);
            Node node = null;
            for(int i = 0; i < Math.min(arr1.size(), arr2.size()); i++){
                if(arr1.get(i) == arr2.get(i)) node = arr1.get(i);
                else break;
            }
            return node;
        }
    */

    // Solution 2: (Optimized)
    public static Node lowestCommonAncestor(Node root, Node p, Node q) {
        // base case
        if(root == null || root == p || root == q){
            return root;
        }

        Node left = lowestCommonAncestor(root.left, p, q);
        Node right = lowestCommonAncestor(root.right, p, q);

        if(left == null) return right;
        else if(right == null) return left;
        else return root;
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
        Node p = new Node(2);
        Node q = new Node(3);
        System.out.println(lowestCommonAncestor(root, p, q));
    }
}
