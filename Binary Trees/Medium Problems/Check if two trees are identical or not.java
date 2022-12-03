/*
   100. Same Tree
   Given the roots of two binary trees p and q, write a function to check if they are the same or not.
   
   Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
   
   Example 1:   
   Input: p = [1,2,3], q = [1,2,3]
   Output: true
   Example 2:
   
   
   Input: p = [1,2], q = [1,null,2]
   Output: false

   Example 3:   
   Input: p = [1,2,1], q = [1,1,2]
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

public class Check_if_two_trees_are_identical_or_not {
    public static boolean isSameTree(Node p, Node q) {
        if(p == null || q == null){
            return p == q;
        }
        return p.data == q.data && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
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

        // First Tree
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

        // Second Tree
        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.left.left = new Node(4);
        root2.left.right = new Node(5);
        root2.left.right.left = new Node(8);
        root2.right.left = new Node(6);
        root2.right.right = new Node(7);
        root2.right.right.left = new Node(9);
        root2.right.right.right = new Node(10);

        System.out.println(isSameTree(root, root2));
    }
}
