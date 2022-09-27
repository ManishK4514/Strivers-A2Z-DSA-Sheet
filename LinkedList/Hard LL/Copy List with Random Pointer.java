/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

// Solution 1: Time Complexity: O(N) & Space Complexity: O(N).

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node,Node> hashMap=new HashMap<>();
        Node temp = head;
        while(temp != null) {
            Node newNode = new Node(temp.val);
            hashMap.put(temp,newNode);
            temp = temp.next;
        }
        Node t = head;
        while(t != null) {
        Node node = hashMap.get(t);
        node.next = (t.next != null) ? hashMap.get(t.next):null;
        node.random = (t.random != null) ? hashMap.get(t.random):null;
        t = t.next;
        }
        return hashMap.get(head);
    }
}

// Solution 2: Time Complexity: O(N) & Space Complexity: O(1).

class Solution {
    public Node copyRandomList(Node head) {
        Node iter = head;
        Node front = head;
        // Step1 -> create the copy of all node
        while(iter != null){
            front = iter.next;
            Node copy = new Node(iter.val);
            copy.next = iter.next;
            iter.next = copy;
            iter = front;
        }
        // Step2 -> connect all random pointer
        iter = head;
        while(iter != null){
            if(iter.random != null){
                iter.next.random = iter.random.next;
            }
            else{
                iter.next.random = null;
            }
            iter = iter.next.next;
        }
        // Step3 -> segrigate all node
        iter = head;
        Node pseduHead = new Node(0);
        Node copy = pseduHead;
        while(iter != null){
            front = iter.next.next;
            copy.next = iter.next;
            iter.next = front;
            copy = copy.next;
            iter = iter.next;
        }
        return pseduHead.next;
    }
}
