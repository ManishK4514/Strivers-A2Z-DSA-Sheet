/*
   Ceil in a Binary Search Tree
   Given a BST and a number X, find Ceil of X.
   Note: Ceil(X) is a number that is either equal to X or is immediately greater than X.
   
   Example 1:
   
   Input:
         5
       /   \
      1     7
       \
        2 
         \
          3
   X = 3
   Output: 3
   Explanation: We find 3 in BST, so ceil
   of 3 is 3.
   Example 2:
   
   Input:
        10
       /  \
      5    11
     / \ 
    4   7
         \
          8
   X = 6
   Output: 7
   Explanation: We find 7 in BST, so ceil
   of 6 is 7.
*/

class Node{
    int val;
    Node left;
    Node right;
    Node(int val){
        this.val = val;
    }
}

public class Ceil_in_a_Binary_Search_Tree {
    public static int findCeil(Node root, int key) {
        int ceil = -1;
        while(root != null){
            if(root.val == key) return key;
            else if(root.val < key){
                root = root.right;
            }
            else{
                ceil = root.val;
                root = root.left;
            }
        }
        return ceil;
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
        System.out.println(findCeil(root, 5));
    }
}
