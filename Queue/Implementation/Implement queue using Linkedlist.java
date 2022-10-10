class Queue {
    private Node head;
    private Node tail;

    static class Node{
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
            this.next = null;
        }
    }
    public boolean isEmpty(){
        return head == null && tail == null;
    }
    // push
    public void push(int value){
        Node node = new Node(value);
        if(isEmpty()){
            head = node;
            tail = node;
            return;
        }
        tail.next = node;
        tail = node;
    }
    
    // pop
    public int pop(){
        if(isEmpty()){
            return -1;
        }
        int front = head.value;
        if(head == tail){
            tail = null;
            head = null;
        }
        else{
            head = head.next;
        }
        return front;
    }
    // peek
    public int peek(){
        if(isEmpty()){
            return -1;
        }
        return head.value;
    }
}

public class Implement_queue_using_Linkedlist {
    public static void main(String[] args) {
        Queue q = new Queue();
        q.push(10);
        q.push(11);
        q.push(12);
        q.push(13);

        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.pop();
        }
    }
}
