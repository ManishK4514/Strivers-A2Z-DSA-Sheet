/*
   297. Serialize and Deserialize Binary Tree
   Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
   
   Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
   
   Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
   
   Example 1:   
   Input: root = [1,2,3,null,null,4,5]
   Output: [1,2,3,null,null,4,5]

   Example 2:   
   Input: root = []
   Output: []
*/

import java.util.Queue;
import java.util.List;
import java.util.LinkedList;

class Node{
    int val;
    Node left;
    Node right;
    Node(int val){
        this.val = val;
    }
}

public class Serialize_and_deserialize_Binary_Tree {
    // To Print the Tree Level Wise
    public static List<List<Integer>> levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        List<List<Integer>> wrapList = new LinkedList<>();
        if(root == null) return wrapList;
        queue.add(root);
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<>();
            for(int i = 0; i < levelNum; i++){
                if(queue.peek().left != null) queue.add(queue.peek().left);
                if(queue.peek().right != null) queue.add(queue.peek().right);
                subList.add(queue.remove().val);
            }
            wrapList.add(subList);
        }
        return wrapList;
    }

    // Encodes a tree to a single string.
    public static String serialize(Node root) {
        if(root == null) return "";
        StringBuilder res = new StringBuilder();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node node = queue.remove();
            if(node == null){
                res.append("n ");
                continue;
            }
            res.append(node.val + " ");
            queue.add(node.left);
            queue.add(node.right);
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public static Node deserialize(String data) {
        if(data == "") return null;
        Queue<Node> queue = new LinkedList<>();
        String[] values = data.split(" ");
        Node root = new Node(Integer.parseInt(values[0]));
        queue.add(root);
        for(int i = 1; i < values.length; i++){
            Node parent = queue.remove();
            if(!values[i].equals("n")){
                Node left = new Node(Integer.parseInt(values[i]));
                parent.left = left;
                queue.add(left);
            }
            if(!values[++i].equals("n")){
                Node right = new Node(Integer.parseInt(values[i]));
                parent.right = right;
                queue.add(right);
            }
        }
        return root;
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
        String data = serialize(root);
        Node resRoot = deserialize(data);
        System.out.println(levelOrder(resRoot));
    }
}
