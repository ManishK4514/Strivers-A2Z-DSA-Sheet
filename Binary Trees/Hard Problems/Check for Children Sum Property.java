/*
   Children Sum Parent
   Given a Binary Tree. Check whether all of its nodes have the value equal to the sum of their child nodes.
   
   
   Example 1:
   
   Input:
        10
       /
     10 
   Output: 1
   Explanation: Here, every node is sum of
   its left and right child.
   Example 2:
   
   Input:
          1
        /   \
       4     3
      /  \
     5    N
   Output: 0
   Explanation: Here, 1 is the root node
   and 4, 3 are its child nodes. 4 + 3 =
   7 which is not equal to the value of
   root node. Hence, this tree does not
   satisfy the given conditions.
*/

class Node{
    int val;
    Node left;
    Node right;
    Node(int val){
        this.val = val;
    }
}

public class Check_for_Children_Sum_Property {
    public static int isSumProperty(Node root)    {
        if(root==null || (root.left==null && root.right==null)){
            return 1;
        }
        int sum = 0;
        if(root.left!=null) sum += root.left.val;
        if(root.right!=null) sum += root.right.val;

        if(sum==root.val && isSumProperty(root.left)==1 && isSumProperty(root.right)==1){
            return 1;
        }
        return 0;
    }
    public static void main(String[] args) {
        /*
            Visualisation of the tree in real world
                    10
                   /  \
                  5    5
        */
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(5);
        System.out.println(isSumProperty(root));
    }
}
