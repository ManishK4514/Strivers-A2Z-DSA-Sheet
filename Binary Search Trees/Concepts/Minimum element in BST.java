/*
   Minimum element in BST
   Given a Binary Search Tree. The task is to find the minimum element in this given BST.
   
   Example 1:   
   Input:
              5
            /    \
           4      6
          /        \
         3          7
        /
       1
   Output: 1

   Example 2:   
   Input:
                9
                 \
                  10
                   \
                    11
   Output: 9
   Your Task:
   The task is to complete the function minValue() which takes root as the argument and returns the minimum element of BST. If the tree is empty, there is no minimum element, so return -1 in that case.
*/


class Node{
    int val;
    Node left;
    Node right;
    Node(int val){
        this.val = val;
    }
}

public class Minimum_element_in_BST {
    public static int minValue(Node node) {
        int prev = -1;
        while(node != null){
            prev = node.val;
            node = node.left;
        }
        return prev;
    }
    public static void main(String[] args) {
        /*
            Tree Diagram: 
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
        System.out.println(minValue(root));
    }
}
