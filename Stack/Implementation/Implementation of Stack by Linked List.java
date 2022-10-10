/*
 *  Fully Implementation of Stack Using LinkedList.
 *  Code Written by: Manish Kumar
 *  Date: 10-10-2022
 */


class Stack {
    public static Node head;
    static class Node{
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
            this.next = null;
        }
    }
    public boolean isEmpty(){
        return head == null;
    }
    // push
    public void push(int value){
        Node node = new Node(value);
        if(isEmpty()){
            head = node;
            return;
        }
        node.next = head;
        head = node;
    }
    
    // pop
    public int pop(){
        if(isEmpty()){
            return -1;
        }
        int top = head.value;
        head = head.next;
        return top;
    }
    // peek
    public int pick(){
        if(isEmpty()){
            return -1;
        }
        return head.value;
    }
}

public class Implementation_Of_Stack {    
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(10);
        s.push(11);
        s.push(12);
        s.push(13);
        
        while(!s.isEmpty()){
            System.out.println(s.pick());
            s.pop();
        }
    }
}
