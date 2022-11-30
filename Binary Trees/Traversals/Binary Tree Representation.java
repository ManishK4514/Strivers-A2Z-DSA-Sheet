class Node{
    int data;
    Node left;
    Node right;
    Node(int key){
        this.data = key;
    }
}

public class Binary_Tree_Representation {
    public static void main(String[] args) {
        /*
            Real World Representation the below tree into the code.
                    1
                   /\
                 2   3
                / \  /
               4   5 6
                      \
                       7
        */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.left.right = new Node(7);
    }
}
