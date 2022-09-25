
/*
class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
} 
*/

class Solution
{
    public static Node reverse(Node head){
        Node preNode = null;
        Node currNode = head;
        Node nextNode = head;
        while(currNode != null){
            nextNode = nextNode.next;
            currNode.next = preNode;
            preNode = currNode;
            currNode = nextNode;
        }
        return preNode;
    }
    public static Node addOne(Node head) 
    { 
        Node newHead = head;
        newHead = reverse(newHead);
        int carry = 0;
        Node prev = null, curr = newHead, current1 = newHead;
        while(curr != null){
            int sum = 0;
            if(prev == null){
                sum = curr.data + 1;
            }
            else{
                sum = curr.data + carry;
            }
            carry = sum/10;
            curr.data = sum%10;
            prev = curr;
            curr = curr.next;
        }
        if(carry != 0){
            Node new_head = new Node(carry);
            prev.next = new_head;
        }
        return reverse(current1);
    }
}
