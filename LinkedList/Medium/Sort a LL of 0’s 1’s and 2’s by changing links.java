/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class Solution
{
    //Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head)
    {
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        Node node = head;
        while(node != null){
            if(node.data == 0){
                count0++;
            }
            else if(node.data == 1){
                count1++;
            }
            else{
                count2++;
            }
            node = node.next;
        }
        node = head;
        while(count0 > 0 || count1 > 0 || count2 > 0){
            if(count0 > 0){
                node.data = 0;
                count0--;
            }
            else if(count1 > 0){
                node.data = 1;
                count1--;
            }
            else{
                node.data = 2;
                count2--;
            }
            node = node.next;
        }
        return head;
    }
}

class Solution
{
    //Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head)
    {
        // creating three seprate nodes
        Node zeroHead = new Node(0);
        Node zeroTail = zeroHead;
        Node oneHead = new Node(0);
        Node oneTail = oneHead;
        Node twoHead = new Node(0);
        Node twoTail = twoHead;
        
        Node temp = head;
        while(temp != null){
            if(temp.data == 0){
                zeroTail.next = temp;
                zeroTail = zeroTail.next;
            }
            else if(temp.data == 1){
                oneTail.next = temp;
                oneTail = oneTail.next;
            }
            else if(temp.data == 2){
                twoTail.next = temp;
                twoTail = twoTail.next;
            }
            temp = temp.next;
        }
        
        // merging
        
        if(oneHead.next != null){
            zeroTail.next = oneHead.next;
        }
        else{
            zeroTail.next = twoHead.next;
        }
        oneTail.next = twoHead.next;
        twoTail.next = null;
        head = zeroHead.next;
        return head;
    }
}

