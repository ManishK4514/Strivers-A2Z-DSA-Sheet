// Write a program for the Boundary Traversal of Binary Tree

import java.util.ArrayList;

class Node{
    int data;
    Node left;
    Node right;
    Node(int key){
        this.data = key;
    }
}

public class Boundary_Traversal_of_Binary_Tree {
    public static boolean isLeaf(Node node){
        return node.left == null && node.right == null;
    }
    public static void addLeftBoundry(Node root, ArrayList<Integer> res){
        Node curr = root.left;
        while(curr != null){
            if(isLeaf(curr) == false) res.add(curr.data);
            if(curr.left != null) curr = curr.left;
            else curr = curr.right;
        }
    }
    public static void addRightBoundry(Node root, ArrayList<Integer> res){        
        ArrayList<Integer> temp = new ArrayList<>();
        Node curr = root.right;
        while(curr != null){
            if(isLeaf(curr) == false) temp.add(curr.data);
            if(curr.right != null) curr = curr.right;
            else curr = curr.left;
        }
        // Adding Right boundary in reverse order to Achieve Anti-ClockWise
        for(int i = temp.size() - 1; i >= 0; i--){
            res.add(temp.get(i));
        }
    }
    public static void addLeaves(Node root, ArrayList<Integer> res){
        if(isLeaf(root)){
            res.add(root.data);
        }
        if(root.left != null) addLeaves(root.left, res);
        if(root.right != null) addLeaves(root.right, res);
    }
    public static ArrayList<Integer> printBoundry(Node root){
        ArrayList<Integer> ans = new ArrayList<>();
        if(isLeaf(root) == false) ans.add(root.data);
        addLeftBoundry(root, ans);
        addLeaves(root, ans);
        addRightBoundry(root, ans);
        return ans;
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
        System.out.println(printBoundry(root));
    }
}
