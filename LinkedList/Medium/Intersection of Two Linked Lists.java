/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

// Solution 1: Time Complexity: O(N + M) & Space Complexity: O(N).
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        while(headA != null){
            set.add(headA);
            headA = headA.next;
        }
        while(headB != null){
            if(set.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}


// Solution 2: Time Complexity: O(2N) & Space Complexity: O(1).

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == headB){
            return headA;
        }
        int countA = 0;
        int countB = 0;
        ListNode dummyA = headA;
        ListNode dummyB = headB;
        while(dummyA != null || dummyB != null){
            if(dummyA != null){
                countA++;
                dummyA = dummyA.next;
            }
            if(dummyB != null){
                countB++;
                dummyB = dummyB.next;
            }
        }
        int temp = 0;
        if(countA >= countB){
            temp = countA - countB;
            dummyA = headA;
            dummyB= headB;
            while(temp > 0){
                dummyA = dummyA.next;
                temp--;
            }
        }
        else if(countB > countA){
            temp = countB - countA;
            dummyB = headB;
            dummyA= headA;
            while(temp > 0){
                dummyB = dummyB.next;
                temp--;
            }
        }
        if(dummyA == dummyB){
            return dummyA;
        }
        while(dummyA != null || dummyB != null){
            if(dummyA != null){
                countA++;
                dummyA = dummyA.next;
            }
            if(dummyB != null){
                countB++;
                dummyB = dummyB.next;
            }
            if(dummyA == dummyB){
                return dummyA;
            }
        }
        return null;
    }
}

// Solution 3: Time Complexity: O(2N) & Space Complexity: O(1).

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        while(a != b){
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }
}
