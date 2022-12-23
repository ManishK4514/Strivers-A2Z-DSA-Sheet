/*
   114. Flatten Binary Tree to Linked List
   Given the root of a binary tree, flatten the tree into a "linked list":
   
   The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
   The "linked list" should be in the same order as a pre-order traversal of the binary tree.
    
   
   Example 1:   
   Input: root = [1,2,5,3,4,null,6]
   Output: [1,null,2,null,3,null,4,null,5,null,6]

   Example 2:   
   Input: root = []
   Output: []

   Example 3:   
   Input: root = [0]
   Output: [0]
*/

class Node{
    int val;
    Node left;
    Node right;
    Node(int key){
        this.val = key;
    }
}

public class Flatten_Binary_Tree_to_LinkedList {
    static Node prev = null;
    public static void flatten(Node root) {
        if(root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
    
    /* 
        // Iterative
        public static void flatten(Node root) {
            if(root == null) return;
            Stack<Node> stack = new Stack<>();
            stack.push(root);
            while(!stack.isEmpty()){
                Node curr = stack.pop();
                if(curr.right != null) stack.push(curr.right);
                if(curr.left != null) stack.push(curr.left);
                if(!stack.isEmpty()) curr.right = stack.peek();
                curr.left = null;
            }
        }
    */
    public static void main(String[] args) {
        /*
            Real World Representation the below tree into the code.
                    1
                   /\
                 2   3
                / \  / \
               4   5 6  7
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
        flatten(root);
        while(root.right!=null){
          System.out.print(root.val+"->");
          root=root.right;
        }
        System.out.print(root.val);
    }
}
