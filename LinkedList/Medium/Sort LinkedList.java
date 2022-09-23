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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode temp = null;
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null){
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        temp.next = null;
        
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        
        return merge(l1, l2);
    }
    public ListNode mergeList(ListNode h1, ListNode h2){
        ListNode finalHead = null, finalTail = null;
        while(h1 != null && h2 != null){
            if(finalHead == null && finalTail == null){
                if(h1.val > h2.val){
                    finalHead = h2;
                    finalTail = h2;
                    h2 = h2.next;
                }
                else{
                    finalHead = h1;
                    finalTail = h1;
                    h1 = h1.next;
                }
            }
            else{
                if(h1.val > h2.val){
                    finalTail.next = h2;
                    h2 = h2.next;
                }
                else{
                    finalTail.next = h1;
                    h1 = h1.next;
                }
            }
        }
        while(h1 != null){
            finalTail.next = h1;
            h1 = h1.next;
        }
        while(h2 != null){
            finalTail.next = h2;
            h2 = h2.next;
        }
        return finalHead;
    }
}
