/*
   Floor in BST
   You are given a BST(Binary Search Tree) with n number of nodes and value x. your task is to find the greatest value node of the BST which is smaller than or equal to x.
   Note: when x is smaller than the smallest node of BST then returns -1.
   
   Example:
   
   Input:
   n = 7               2
                        \
                         81
                       /     \
                    42       87
                      \       \
                       66      90
                      /
                    45
   x = 87
   Output:
   87
   Explanation:
   87 is present in tree so floor will be 87.
   Example 2:
   
   Input:
   n = 4                     6
                              \
                               8
                             /   \
                           7       9
   x = 11
   Output:
   9
*/

class Node{
    int val;
    Node left;
    Node right;
    Node(int val){
        this.val = val;
    }
}

public class Floor_in_a_Binary_Search_Tree {
    public static int floor(Node root, int x) {
        int floor = -1;
        while(root != null){
            if(root.val == x) return x;
            else if(root.val > x){
                root = root.left;
            }
            else{
                floor = root.val;
                root = root.right;
            }
        }
        return floor;
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
        System.out.println(floor(root, 5));
    }
}
