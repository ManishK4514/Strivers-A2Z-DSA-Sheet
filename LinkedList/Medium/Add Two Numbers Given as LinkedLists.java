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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int num1 = 0, num2 = 0;
        StringBuilder sb1 = new StringBuilder();
        while(l1 != null){
            sb1.append(l1.val);
            l1 = l1.next;
        }
        sb1.reverse();
        num1 = Integer.parseInt(sb1.toString());
        StringBuilder sb2 = new StringBuilder();
        while(l2 != null){
            sb2.append(l2.val);
            l2 = l2.next;
        }
        sb2.reverse();
        num2 = Integer.parseInt(sb2.toString());
        int ans = num1 + num2;
        
        StringBuilder res = new StringBuilder(String.valueOf(ans));
        res.reverse();
        ListNode fHead = null;
        ListNode fTail = null;
        for(int i = 0; i < res.length(); i++){
            ListNode node = new ListNode(res.charAt(i) - '0');
            if(i == 0){
                fHead = node;
                fTail = node;
            }
            else{
                fTail.next = node;
                fTail = fTail.next;
            }
        }
        fTail.next = null;
        return fHead;
    }
}

// Solution 2:

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        int carry = 0;
        while(l1 != null || l2!= null || carry == 1){
            int sum = 0;
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            } 
            sum += carry;
            carry = sum/10;
            ListNode node = new ListNode(sum%10);
            temp.next =  node; 
            temp = temp.next;
        }
        return dummy.next;
    }
}
