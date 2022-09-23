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
    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> temp = new ArrayList<>();
        ListNode node = head;
        while(node != null){
            temp.add(node.val);
            node = node.next;
        }
        int i = 0, j = temp.size() - 1;
        while(i < j){
            if(temp.get(i) != temp.get(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}


lass Solution {
    public ListNode reverse(ListNode head){
        ListNode prevNode = null;
        ListNode currNode = head;
        ListNode nextNode = head;
        while(nextNode != null){
            nextNode = nextNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        return prevNode;
    }
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode dummy = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = reverse(slow.next);
        slow = slow.next;
        while(slow != null){
            if(dummy.val != slow.val){
                return false;
            }
            slow = slow.next;
            dummy = dummy.next;
        }
        return true;
    }
}
