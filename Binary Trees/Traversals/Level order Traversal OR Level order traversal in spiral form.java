/*
   Level Order Traversal of a Binary Tree
   Problem Statement: Level order traversal of a binary tree. Given the root node of the tree and you have to print the value of the level of the node by level.

   Example 1:
   /*
            
            3
           /\
         9   20
            /  \
           15   7
    */
   
//    Output:
   
//    3 9 20 15 7
//    We will print the nodes of the first level (20), then we will print nodes of second level(10,30) and at last we will print nodes of the last level(5,15,25,35)
   
//    Example 2:
//    5 10 15
   


import java.util.Queue;
import java.util.List;
import java.util.LinkedList;

class Node{
    int data;
    Node left;
    Node right;
    Node(int key){
        this.data = key;
    }
}

public class Level_order_Traversal {
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
                subList.add(queue.remove().data);
            }
            wrapList.add(subList);
        }
        return wrapList;
    }
    public static void main(String[] args) {
        /*
            Real World Representation the below tree into the code.
                    3
                   /\
                 9   20
                    /  \
                   15   7
        */
        Node root = new Node(1);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);
        System.out.println(levelOrder(root));
    }
}


// FOR SPIRAL ORDER


public static void reverse(List<Integer> subList){
        int i = 0, j = subList.size() - 1;
        while(i < j){
            int temp = subList.get(i);
            subList.set(i, subList.get(j));
            subList.set(j, temp);
            i++; j--;
        }
    }
    ArrayList<Integer> findSpiral(Node root) 
    {
        ArrayList<Integer> res = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        List<List<Integer>> wrapList = new LinkedList<>();
        if(root == null) return res;
        int k = 0;
        queue.add(root);
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<>();
            for(int i = 0; i < levelNum; i++){
                if(queue.peek().left != null) queue.add(queue.peek().left);
                if(queue.peek().right != null) queue.add(queue.peek().right);
                subList.add(queue.remove().data);
            }
            if(k % 2 == 0){
                reverse(subList);
            }
            k++;
            wrapList.add(subList);
        }
        
        for(List<Integer> subList : wrapList){
            for(int num : subList){
                res.add(num);
            }
        }
        return res;
    }
