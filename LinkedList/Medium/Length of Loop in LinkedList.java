class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}

*/

//Function should return the length of the loop in LL.

class Solution
{
    public static int countNodes(Node slow){
        int res = 1;
        Node node = slow;
        while(node.next != slow){
            res++;
            node = node.next;
        }
        return res;
    }
    //Function to find the length of a loop in the linked list.
    static int countNodesinLoop(Node head)
    {
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return countNodes(slow);
            }
        }
        return 0;
    }
}
