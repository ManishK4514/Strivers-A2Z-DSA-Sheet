/*
   101. Symmetric Tree
   Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
   
   Example 1:   
   Input: root = [1,2,2,3,4,4,3]
   Output: true

   Example 2:   
   Input: root = [1,2,2,null,3,null,3]
   Output: false
*/

class Node{
    int data;
    Node left;
    Node right;
    Node(int key){
        this.data = key;
    }
}

public class Symmetric_Binary_Tree {
    public static boolean isSymmetric(Node root) {
        return root == null || isSymmetricHelp(root.left, root.right);
    }
    public static boolean isSymmetricHelp(Node left, Node right){
        if(left == null || right == null){
            return left == right;
        }
        if(left.data != right.data) return false;
        return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
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
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(4);
        root.right.right = new Node(3);
        System.out.println(isSymmetric(root));
    }
}
