public class CLL {
    private Node head;
    private Node tail;
    public CLL(){
        this.head = null;
        this.tail = null;
    }

    // Insert value;
    public void insert(int value){
        Node node = new Node(value);
        if(head == null){
            head = node;
            tail = node;
            return;
        }
        tail.next = node;
        node.next = head;
        tail = node;
    }

    // Printing Node Value
    public void display(){
        Node node = head;
        if(head != null){
            do{
                System.out.print(node.value + " -> ");
                node = node.next;
            }while(node != head);
        }
        System.out.println("HEAD");
    }

    // Delete Node
    public void delete(int value){
        Node node = head;
        if(node == null){
            return;
        }
        if(node.value == value){
            head = head.next;
            tail.next = head;
            return;
        }

        do{
            Node n = node.next;
            if(n.value == value){
                node.next = n.next;
                break;
            }
            node = node.next;
        }while(node != head);
    }
    class Node{
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }
    }
    public static void main(String[] args) {
        CLL list = new CLL();
        list.insert(12);
        list.insert(13);
        list.insert(14);
        list.insert(15);
        list.delete(13);
        list.display();
    }
}
