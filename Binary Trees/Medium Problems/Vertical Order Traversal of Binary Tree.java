/*
   987. Vertical Order Traversal of a Binary Tree
   Given the root of a binary tree, calculate the vertical order traversal of the binary tree.
   
   For each node at position (row, col), its left and right children will be at positions (row + 1, col - 1) and (row + 1, col + 1) respectively. The root of the tree is at (0, 0).
   
   The vertical order traversal of a binary tree is a list of top-to-bottom orderings for each column index starting from the leftmost column and ending on the rightmost column. There may be multiple nodes in the same row and same column. In such a case, sort these nodes by their values.
   
   Return the vertical order traversal of the binary tree.
      
   Example 1:
   Input: root = [3,9,20,null,null,15,7]
   Output: [[9],[3,15],[20],[7]]
   Explanation:
   Column -1: Only node 9 is in this column.
   Column 0: Nodes 3 and 15 are in this column in that order from top to bottom.
   Column 1: Only node 20 is in this column.
   Column 2: Only node 7 is in this column.
   
   Example 2:
   Input: root = [1,2,3,4,5,6,7]
   Output: [[4],[2],[1,5,6],[3],[7]]
   Explanation:
   Column -2: Only node 4 is in this column.
   Column -1: Only node 2 is in this column.
   Column 0: Nodes 1, 5, and 6 are in this column.
             1 is at the top, so it comes first.
             5 and 6 are at the same position (2, 0), so we order them by their value, 5 before 6.
   Column 1: Only node 3 is in this column.
   Column 2: Only node 7 is in this column.
   
   Example 3:
   Input: root = [1,2,3,4,6,5,7]
   Output: [[4],[2],[1,5,6],[3],[7]]
   Explanation:
   This case is the exact same as example 2, but with nodes 5 and 6 swapped.
   Note that the solution remains the same since 5 and 6 are in the same location and should be ordered by their values.
*/

import java.util.List;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.PriorityQueue;
import java.util.LinkedList;
import java.util.Queue;

class Node{
    int data;
    Node left;
    Node right;
    Node(int key){
        this.data = key;
    }
}

class Tuple{
    Node node;
    int row;
    int col;
    public Tuple(Node node, int row, int col){
        this.node = node;
        this.row = row;
        this.col = col;
    }
}

public class Vertical_Order_Traversal_of_Binary_Tree {
    public static List<List<Integer>> verticalTraversal(Node root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(root, 0, 0));
        while(!q.isEmpty()){
            Tuple tuple = q.remove();
            Node node = tuple.node;
            int x = tuple.row;
            int y = tuple.col;

            if(!map.containsKey(x)){
                map.put(x, new TreeMap<>());
            }
            if(!map.get(x).containsKey(y)){
                map.get(x).put(y, new PriorityQueue<>());
            }
            map.get(x).get(y).add(node.data);

            if(node.left != null){
                q.add(new Tuple(node.left, x - 1, y + 1));
            }
            if(node.right != null){
                q.add(new Tuple(node.right, x + 1, y + 1));
            }
        }
        List<List<Integer>> list = new ArrayList<>();
        for(TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()){
            list.add(new ArrayList<>());
            for(PriorityQueue<Integer> nodes : ys.values()){
                while(!nodes.isEmpty()){
                    list.get(list.size() - 1).add(nodes.remove());
                }
            }
        }
        return list;
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
        System.out.println(verticalTraversal(root));
    }
}
