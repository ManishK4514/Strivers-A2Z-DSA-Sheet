// Q. Write a program for Preorder, Inorder and PoastOrder Traversal in one Traversal.

import java.util.ArrayList;
import java.util.Stack;

class Pair{
    Node node;
    int num;
    Pair(Node node, int num){
        this.node = node;
        this.num = num;
    }
}
class Node{
    int data;
    Node left;
    Node right;
    Node(int key){
        this.data = key;
    }
}

public class Preorder_Inorder_and_Postorder_Traversal_in_one_Traversal {
    public static void preInPostTraversal(Node root){
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root, 1));
        ArrayList<Integer> pre = new ArrayList<>();
        ArrayList<Integer> in = new ArrayList<>();
        ArrayList<Integer> post = new ArrayList<>();
        if(root == null) return;
        while(!st.isEmpty()){
            Pair it = st.pop();

            // this is the part of pre
            // Increment 1 to 2
            // push the left side of the tree
            if(it.num == 1){
                pre.add(it.node.data);
                it.num++;
                st.push(it);

                if(it.node.left != null){
                    st.push(new Pair(it.node.left, 1));
                }
            }

            // this is the part of in
            // Increment 2 to 3
            // push the right side of the tree
            else if(it.num == 2){
                in.add(it.node.data);
                it.num++;
                st.push(it);

                if(it.node.right != null){
                    st.push(new Pair(it.node.right, 1));
                }
            }

            // this is the part of Post
            // Don't push it back again 
            else{
                post.add(it.node.data);
            }
        }
        System.out.println(pre);
        System.out.println(in);
        System.out.println(post);
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
        preInPostTraversal(root);
    }
}
