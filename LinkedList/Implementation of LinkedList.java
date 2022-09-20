/*
 * Entire Implementation Of Linked List.
 * 
 * Code Written by Manish Kumar
 * Date: 19-09-2022
 */


public class LindkedListImplementaion {
    private Node head;
    private int size;
    class Node{
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
            this.next = null;
        }
        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    // add Node at first
    public void insertFirst(int value){
        size++;
        Node node = new Node(value);
        if(head == null){
            head = node;
            return;
        }
        node.next = head;
        head = node;
    }
    
    // add Node at last 
    public void insertLast(int value){
        size++;
        Node node = new Node(value);
        if(head == null){
            head = node;
            return;
        }
        Node currNode = head;
        while(currNode.next != null){
            currNode = currNode.next;
        }
        currNode.next = node;
    }

    // Insert at Index no.
    public void insert(int value, int index){
        if(index == 0){
            insertFirst(value);
            return;
        }
        size++;
        Node temp = head;
        for(int i = 0; i < index; i++){
            temp = temp.next;
        }
        Node node = new Node(value, temp.next);
        temp.next = node;
    }

    // print list
    public void display(){
        if(head == null){
            System.out.println("List is Empty!");
            return;
        }
        Node currNode = head;
        while(currNode != null){
            System.out.print(currNode.value + " -> ");
            currNode = currNode.next;
        }
        System.out.println("Null");
    }

    // Delete Frist Node
    public void deleteFirst(){
        if(head == null){
            System.out.println("List is already Empty!");
            return;
        }
        head = head.next;
        size--;
    }

    // Delete Last Node
    public void deleteLast(){
        if(head == null){
            System.out.println("List is already Empty!");
            return;
        }
        size--;
        if(head.next == null){
            head = null;
            return;
        }
        Node SecondLast = head;
        Node LastNode = head.next;
        while(LastNode.next != null){
            LastNode = LastNode.next;
            SecondLast = SecondLast.next;
        }
        SecondLast.next = null;
    }

    // Delete any node
    public void delete(int index){
        if(index == 0){
            deleteFirst();
            return;
        }
        size--;
        Node prev = get(index - 1);
        prev.next = prev.next.next;
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

    // Get Size of LinkedList
    public void getSize(){
        System.out.println(size);
    }
    public Node get(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }
    public static void main(String[] args) {
        LindkedListImplementaion list = new LindkedListImplementaion();
        list.insertFirst(12);
        list.insertFirst(11);
        list.insertLast(13);
        list.insertLast(14);
        list.insertLast(15);
        list.insertLast(16);
        list.insertLast(17);
        // list.insert(13, 2);
        list.display();
        list.delete(2);
        list.display();
        // list.getSize();
        // list.delete(6);  --> not enough elements
        // list.display();
        // list.display();
        // list.getSize();
        // list.deleteFirst();
        // list.display();
        // list.getSize();
        // list.deleteLast();
        // list.display();
        // list.getSize();
        // list.insertFirst(11);
        // list.display();
        // list.getSize();
    }
}
