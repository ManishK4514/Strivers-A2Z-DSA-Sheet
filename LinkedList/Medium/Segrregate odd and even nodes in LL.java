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
class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode oddHead = null, oddTail = null, evenHead = null, evenTail = null;
        int count = 1;
        while(head != null){
            // Even
            if(count % 2 == 0){
                if(evenHead == null){
                    evenHead = head;
                    evenTail = head;
                }
                else{
                    evenTail.next = head;
                    evenTail = evenTail.next;
                }
            }
            // Odd
            if(count % 2 != 0){
                if(oddHead == null){
                    oddHead = head;
                    oddTail = head;
                }
                else{
                    oddTail.next = head;
                    oddTail = evenTail.next;
                }
            }
            count++;
            head = head.next;
        }
        if(evenHead == null){
            return oddHead;
        }
        evenTail.next = null;
        oddTail.next = evenHead;
        
        return oddHead;
    }
}
