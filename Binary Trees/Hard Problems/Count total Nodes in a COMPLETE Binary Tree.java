/*
   222. Count Complete Tree Nodes
   Given the root of a complete binary tree, return the number of the nodes in the tree.
   
   According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
   
   Design an algorithm that runs in less than O(n) time complexity.
   
   Example 1:   
   Input: root = [1,2,3,4,5,6]
   Output: 6

   Example 2:   
   Input: root = []
   Output: 0

   Example 3:   
   Input: root = [1]
   Output: 1
*/

class Node{
    int val;
    Node left;
    Node right;
    Node(int val){
        this.val = val;
    }
}

public class Count_total_Nodes_in_a_COMPLETE_Binary_Tree {
    /*      
        // Recursive -> Time Complexity: O(N) & Space Complexity: O(H)
        int count = 0;
        public static void preOrder(Node root){
            if(root == null) return;
            count++;
            preOrder(root.left);
            preOrder(root.right);
        }
        public static int countNodes(Node root) {
           preOrder(root);
           return count;
        }
    */

    /*      
        // Iterative -> Time Complexity: O(N) & Space Complexity: O(H)
        public int countNodes(Node root) {
            int count = 0;
            Queue<Node> queue = new LinkedList<>();
            if(root == null) return 0;
            queue.add(root);
            while(!queue.isEmpty()){
                int size = queue.size();
                count += size;
                for(int i = 0; i < size; i++){
                    if(queue.peek().left != null) queue.add(queue.peek().left);
                    if(queue.peek().right != null) queue.add(queue.peek().right);               
                    queue.remove();
                }
            }
            return count;
        }
    */
    
    public static int countNodes(Node root) {
        if(root == null) return 0;
        int left = findLeftHeight(root);
        int right = findRightHeight(root);
        if(left == right) return ((1<<(left)) - 1);
        else return 1 + countNodes(root.left) + countNodes(root.right);
     }
     public static int findLeftHeight(Node root){
         int count = 0;
         while(root != null){
             count++;
             root = root.left;
         }
         return count;
     }
     public static int findRightHeight(Node root){
         int count = 0;
         while(root != null){
             count++;
             root = root.right;
         }
         return count;
     }
    public static void main(String[] args) {
        /*
            Visualisation of the tree in real world
                      1
                    /   \
                  2      3
                /  \    /  \
               4    5  6   7
             /  \  /
            8   9 10
        */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);        
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);
        root.left.right.left = new Node(10);
        System.out.println(countNodes(root));
    }
}
