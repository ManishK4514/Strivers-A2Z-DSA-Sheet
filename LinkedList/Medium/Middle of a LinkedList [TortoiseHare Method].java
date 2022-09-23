/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/*
  class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode node = head;
        int count = 0;
        while(node != null){
            count++;
            node = node.next;
        }
        int index = count/2;
        node = head;
        for(int i = 0; i < index; i++){
            node = node.next;
        }
        return node;
    }
}

*/

class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
