/*
 * Entire Implementation Of Linked List.
 * 
 * Code Written by Manish Kumar
 * Date: 19-09-2022
 */


public class LindkedListImplementaion {
    Node head;
    private int size;
    class Node{
        int value;
        Node next;

        Node(int value){
            this.value = value;
            this.next = null;
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

    // Get Size of LinkedList
    public void getSize(){
        System.out.println(size);
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
        list.display();
        list.getSize();
        list.deleteFirst();
        list.display();
        list.getSize();
        list.deleteLast();
        list.display();
        list.getSize();
        list.insertFirst(11);
        list.display();
        list.getSize();
    }
}
