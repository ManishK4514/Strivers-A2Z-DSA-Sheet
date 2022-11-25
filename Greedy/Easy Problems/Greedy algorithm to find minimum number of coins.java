/*
   Minimum number of Coins
   This problem is part of GFG SDE Sheet. Click here to view more.  
   
   Given an infinite supply of each denomination of Indian currency { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 } and a target value N.
   Find the minimum number of coins and/or notes needed to make the change for Rs N. You must return the list containing the value of coins required. 
   
   Example 1:
   
   Input: N = 43
   Output: 20 20 2 1
   Explaination: 
   Minimum number of coins and notes needed 
   to make 43. 
   
   Example 2:
   
   Input: N = 1000
   Output: 500 500
   Explaination: minimum possible notes
   is 2 notes of 500.
*/

import java.util.*;

public class Greedy_algorithm_to_find_minimum_number_of_coins {
    public static List<Integer> minPartition(int n)    {
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000);
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = list.size() - 1; i >= 0; i--){
            while(n >= list.get(i)){
                res.add(list.get(i));
                n -= list.get(i);
            }
            if(n == 0){
                break;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int n = 43;
        System.out.println(minPartition(n));
    }
}
