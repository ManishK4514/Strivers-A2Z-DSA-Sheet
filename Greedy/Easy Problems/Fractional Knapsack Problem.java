/*
   Fractional Knapsack
   Given weights and values of N items, we need to put these items in a knapsack of capacity W to get the maximum total value in the knapsack.
   Note: Unlike 0/1 knapsack, you are allowed to break the item. 
   
    
   
   Example 1:
   
   Input:
   N = 3, W = 50
   values[] = {60,100,120}
   weight[] = {10,20,30}
   Output:
   240.00
   Explanation:Total maximum value of item
   we can have is 240.00 from the given
   capacity of sack. 
   Example 2:
   
   Input:
   N = 2, W = 50
   values[] = {60,100}
   weight[] = {10,20}
   Output:
   160.00
   Explanation:
   Total maximum value of item
   we can have is 160.00 from the given
   capacity of sack. 
*/

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

class ItemComparator implements Comparator<Item>{
    @Override
    public int compare(Item a, Item b){
        double r1 = (double)(a.value)/(double)(a.weight);
        double r2 = (double)(b.value)/(double)(b.weight);
        if(r1 < r2) return 1;
        else if(r1 > r2) return -1;
        else return 0;
    }
}
class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int w, Item arr[], int n)
    {
        Arrays.sort(arr, new ItemComparator());
        double ans = 0;
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i].value + " " + arr[i].weight);
        }
        for(int i = 0; i < arr.length; i++){
            if(w >= arr[i].weight){
                ans += arr[i].value;
                w -= arr[i].weight;
            }
            else{
                ans += (((double)(arr[i].value)/(double)(arr[i].weight)) * (double)(w));
                break;
            }
        }
        return ans;
    }
}
public class Fractional_Knapsack_Problem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution s = new Solution();
        Item[] arr = new Item[84];
        for(int i = 0; i < arr.length; i++){
            Item item = new Item(sc.nextInt(), sc.nextInt());
            arr[i] = item;
        }
        int w = 87;
        double ans = s.fractionalKnapsack(w, arr, arr.length);
        System.out.println(ans);
        sc.close();
    }
}
