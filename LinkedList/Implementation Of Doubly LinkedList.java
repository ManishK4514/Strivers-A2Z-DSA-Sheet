/*
 * Entire Implementation Of Doubly-Linked List.
 * 
 * Code Written by Manish Kumar
 * Date: 20-09-2022
 */



public class DLL {
    private Node head;
    
    // insert at First Index
    public void insertFirst(int value){
        Node node = new Node(value); 
        node.next = head;
        node.prev = null;
        if(head != null){
            head.prev = node;
        }
        head = node;
    }

    // insert at Last Index
    public void insertLast(int value){
        Node node = new Node(value); 
        Node temp = head;
        node.next = null;
        if(head == null){
            node.prev = null;
            head = node;
            return;
        }
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = node;
        node.prev = temp;
    }
    
    // Search Value in the LinkedList
    public Node find(int value){
        Node node = head;
        while(node != null){
            if(node.value == value){
                return node;
            }
            node = node.next;
        }
        return null;
    }

    // insert after Index
    public void insert(int after, int value){
        Node node = new Node(value);
        Node p = find(after);
        if(p == null){
            System.out.println("Node Doesn't Exist");
            return;
        }
        node.next = p.next;
        p.next = node;
        node.prev = p;
        if(node.next != null){
            node.next.prev = node;
        }
    }
    // Print LinkedList
    public void display(){
        if(head == null){
            System.out.println("LinkedList is empty!");
        }
        Node node = head;
        Node last = null;
        while(node != null){
            System.out.print(node.value + " -> ");
            last = node;
            node = node.next;
        }
        System.out.println("NULL");

        System.out.println("Print in Reverse: ");
        while(last != null){
            System.out.print(last.value + " -> ");
            last = last.prev;
        }
        System.out.println("NULL");
    }
    
    class Node{
        private int value;
        private Node next;
        private Node prev;

        public Node(int value){
            this.value = value;
        }
        public Node(int value, Node next, Node prev){
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
    public static void main(String[] args) {
        DLL list = new DLL();
        list.insertFirst(15);
        list.insertFirst(14);
        list.insertLast(18);
        list.display();
        list.insert(15, 16);
        list.insert(16, 17);
        list.display();
    }
}
