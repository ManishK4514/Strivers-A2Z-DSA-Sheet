// This is the program to Insert Node in LinkedList at Starting index, Ending index or any Index.

class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
    ListNode(int x, ListNode next){
        this.val = x;
        this.next = next;
    }
}

class Insert_Node_In_LinkedList {
    static void PrintList(ListNode head) // Function to print the LinkedList
    {
        ListNode curr = head;
        for (; curr != null; curr = curr.next)
            System.out.print(curr.val + "-->");
        System.out.println("null");
    }

    // Insert at first Index.
    static ListNode InsertatFirst(int value, ListNode head) {
        ListNode node = new ListNode(value);
        node.next = head;
        head = node;
        return head;
    }

    // Insert at Last Index
    static ListNode InsertatLast(int value, ListNode head) {
        ListNode node = new ListNode(value);
        if(head == null){
            head = node;
            return head;
        }
        ListNode currNode = head;
        while(currNode.next != null){
            currNode = currNode.next;
        }
        currNode.next = node;
        return head;
    }

    // Insert at any Index
    static ListNode InsertatIndex(int value, int index, ListNode head) {
        if(index == 0){
            ListNode node = new ListNode(value);
            node.next = head;
            head = node;
            return head;
        }
        ListNode temp = head;
        for(int i = 0; i < index - 1; i++){
            temp = temp.next;
        }
        ListNode node = new ListNode(value, temp.next);
        temp.next = node;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = null; // head of the LinkedList
        head = InsertatFirst(40, head);
        head = InsertatFirst(30, head);
        head = InsertatFirst(20, head);
        head = InsertatIndex(9, 3, head);
        System.out.println("LinkedList before inserting : ");
        PrintList(head);
        head = InsertatLast(50, head);
        System.out.println("LinkedList after inserting : ");
        PrintList(head);
    }
}
