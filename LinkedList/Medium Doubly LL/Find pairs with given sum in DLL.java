class Node
{
    int data;
    Node next,prev;
    
    Node(int x){
        data = x;
        next = null;
        prev = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

class Solution {
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Node node = head;
        Node second = node.next;
        while(node.next != null){
            while(second != null){
                if((node.data + second.data) == target){
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(node.data);
                    temp.add(second.data);
                    ans.add(temp);
                }
                second = second.next;
            }
            node = node.next;
            second = node.next;
        }
        return ans;
    }
}
