/*
   235. Lowest Common Ancestor of a Binary Search Tree
   Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.
   
   According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
   
   Example 1:   
   Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
   Output: 6
   Explanation: The LCA of nodes 2 and 8 is 6.

   Example 2:   
   Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
   Output: 2
   Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.

   Example 3:   
   Input: root = [2,1], p = 2, q = 1
   Output: 2
*/

class Node{
    int val;
    Node left;
    Node right;
    Node(int val){
        this.val = val;
    }
}

public class LCA_in_Binary_Search_Tree {
    /* 
        Approach 1: --> Time Complexity: O(N) & Space Complexity: O(4N)
        ArrayList<Node> list = new ArrayList<>();
        public static void preOrder(Node root, Node target, ArrayList<Node> temp){
            if(root == null) return;
            if(root == target){
                temp.add(root);
                list = new ArrayList<Node>(temp);
            }
            temp.add(root);
            preOrder(root.left, target, temp);
            preOrder(root.right, target, temp);
            temp.remove(temp.size() - 1);
        }
        public static Node lowestCommonAncestor(Node root, Node p, Node q) {
            preOrder(root, p, new ArrayList<Node>());
            ArrayList<Node> list1 = new ArrayList<>(list);
            list.clear();
            preOrder(root, q, new ArrayList<>());
            ArrayList<Node> list2 = new ArrayList<>(list);
            int n = Math.min(list1.size(), list2.size());
            Node ans = null;
            for(int i = 0; i < n; i++){
                if(list1.get(i) != list2.get(i)) return ans;
                ans = list1.get(i);
            }
            return ans;
        }
    */

    /* 
        Approach 2: (for all Binary Tree) --> Time Complexity: O(N) & Space Complexity: O(2N)
        public static Node lowestCommonAncestor(Node root, Node p, Node q) {
            if(root == null || root == p || root == q) return root;
            Node left = lowestCommonAncestor(root.left, p, q);
            Node right = lowestCommonAncestor(root.right, p, q);
            if(left == null) return right;
            else if(right == null) return left;
            else{
                return root;
            }
        }
    */

    // Approach 3: (for Binary Search Tree Specific) --> Time Complexity: O(N) & Space Complexity: O(1)
    public static Node lowestCommonAncestor(Node root, Node p, Node q) {
        if(root == null) return null;
        int curr = root.val;
        if(curr < p.val && curr < q.val){
            return lowestCommonAncestor(root.right, p, q);
        }
        if(curr > p.val && curr > q.val){
            return lowestCommonAncestor(root.left, p, q);
        }
        return root;
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
        // p = 4 && q = 8
        System.out.println(lowestCommonAncestor(root, root.left.left, root.left.right.left).val);
    }
}
