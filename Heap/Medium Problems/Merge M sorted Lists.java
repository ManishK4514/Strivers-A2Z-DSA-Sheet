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

Solution 1: BruteForce Approach:-
  
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        ListNode head = new ListNode();
        ListNode temp = head;
        List<Integer> l = new ArrayList<>();
        for(ListNode list : lists){
            while(list != null){
                l.add(list.val);
                list = list.next;
            }
        }
        Collections.sort(l);
        for(int val : l){
            temp.next = new ListNode(val);
            temp = temp.next;
        }
        return head.next;
    }
}

Solution 2: Optimized Approach:

public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> q = new PriorityQueue<ListNode>((a,b) -> a.val - b.val);
        // only head pointer of all lists are added
        for(ListNode l : lists){
            if(l!=null){
                q.add(l);
            }        
        }
        ListNode head = new ListNode(-1);
        ListNode point = head;
        while(!q.isEmpty()){ 
            point.next = q.poll();
            point = point.next; 
            if(point.next!=null){
                q.add(point.next); // add next of current smallest
            }
        }
        return head.next;
    }
