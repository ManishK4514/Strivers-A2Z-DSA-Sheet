/*
   846. Hand of Straights
   Alice has some number of cards and she wants to rearrange the cards into groups so that each group is of size groupSize, and consists of groupSize consecutive cards.
   
   Given an integer array hand where hand[i] is the value written on the ith card and an integer groupSize, return true if she can rearrange the cards, or false otherwise.
   
    
   
   Example 1:
   
   Input: hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
   Output: true
   Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8]
   Example 2:
   
   Input: hand = [1,2,3,4,5], groupSize = 4
   Output: false
   Explanation: Alice's hand can not be rearranged into groups of 4.

 */


// import java.util.Arrays;
// import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Map;
import java.util.HashMap;

public class Hands_of_Straights {
    public static boolean isNStraightHand(int[] hand, int groupSize) {
        /*
           // Solution 1: 
           Arrays.sort(hand);
           ArrayList<Integer> list = new ArrayList<>();
           for(int i = 0; i < hand.length; i++){
               list.add(hand[i]);
           }
           while(true){
               int k = list.get(0);
               for(int i = 0; i < groupSize; i++){
                   if(list.size() != 0 && list.contains(k)){
                       list.remove(Integer.valueOf(k));
                   }
                   else{
                       return false;
                   }
                   k++;
               }
               if(list.size() == 0){
                   break;
               }
           }
           return true;
        */
        
        // Solution 2: 
        if(hand.length % groupSize != 0){
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < hand.length; i++){
            map.put(hand[i], map.getOrDefault(hand[i], 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            pq.add(entry.getKey());
        }
        while(!pq.isEmpty()){
            int min = pq.peek();
            for(int i = 0; i < groupSize; i++){
                if(map.containsKey(min)){
                    map.put(min, map.get(min) - 1);
                    if(map.get(min) == 0){
                        pq.remove();
                    }
                }
                else{
                    return false;
                }
                if(map.get(min) == 0){
                    map.remove(min);
                }
                min++;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[] hand = {1, 2, 3, 6, 2, 3, 4, 7, 8};
        System.out.println(isNStraightHand(hand, 3));
    }
}
