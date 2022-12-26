/*
   230. Kth Smallest Element in a BST
   Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
      
   Example 1:   
   Input: root = [3,1,4,null,2], k = 1
   Output: 1

   Example 2:   
   Input: root = [5,3,6,2,4,null,null,1], k = 3
   Output: 3
*/

class Node{
    int val;
    Node left;
    Node right;
    Node(int val){
        this.val = val;
    }
}

public class Find_Kth_smallest_element_in_BST {
    /* 
        Approach 1: (With Sorting) --> Time Complexity: O(NlogN) & Space Complexity: O(N)
        ArrayList<Integer> list = new ArrayList<>();
        public static void preOrder(Node root){
            if(root == null) return;
            list.add(root.val);
            preOrder(root.left);
            preOrder(root.right);
        }
        public static int kthSmallest(Node root, int k) {
            if(root == null) return -1;
            preOrder(root);
            Collections.sort(list);
            return list.get(k - 1);
        }
    */

    /* 
        Approach 2: (Without Sorting) --> Time Complexity: O(N) & Space Complexity: O(N)
        ArrayList<Integer> list = new ArrayList<>();
        public static void inOrder(Node root){
            if(root == null) return;        
            inOrder(root.left);
            list.add(root.val);
            inOrder(root.right);
        }
        public static int kthSmallest(Node root, int k) {
            if(root == null) return -1;
            inOrder(root);
            return list.get(k - 1);
        }
    */

    // Approach 3: Morris Traversel --> Time Complexity: O(N) & Space Complexity: O(1)
    public static int kthSmallest(Node root, int k) {
        Node curr = root;
        int count = 0;
        while(curr != null){
            if(curr.left == null){
                count++;
                if(count == k) return curr.val;
                curr = curr.right;
            }
            else{
                Node prev = curr.left;
                while(prev.right != null && prev.right != curr){
                    prev = prev.right;
                }
                if(prev.right == null){
                    prev.right = curr;
                    curr = curr.left;
                }
                else{
                    prev.right = null;
                    count++;
                    if(count == k) return curr.val;
                    curr = curr.right;
                }
            }
        }
        return -1;
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
        System.out.println(kthSmallest(root, 3));
    }
}
