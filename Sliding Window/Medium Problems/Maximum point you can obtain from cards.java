/*
   1423. Maximum Points You Can Obtain from Cards
   There are several cards arranged in a row, and each card has an associated number of points. The points are given in the integer array cardPoints.
   
   In one step, you can take one card from the beginning or from the end of the row. You have to take exactly k cards.
   
   Your score is the sum of the points of the cards you have taken.
   
   Given the integer array cardPoints and the integer k, return the maximum score you can obtain.
   
   Example 1:
   
   Input: cardPoints = [1,2,3,4,5,6,1], k = 3
   Output: 12
   Explanation: After the first step, your score will always be 1. However, choosing the rightmost card first will maximize your total score. The optimal strategy is to take the three cards on the right, giving a final score of 1 + 6 + 5 = 12.
   Example 2:
   
   Input: cardPoints = [2,2,2], k = 2
   Output: 4
   Explanation: Regardless of which two cards you take, your score will always be 4.
   Example 3:
   
   Input: cardPoints = [9,7,7,9,7,7,9], k = 7
   Output: 55
   Explanation: You have to take all the cards. Your score is the sum of points of all cards.
*/

/*
Logic:
This question is a good example where simply finding a way to reword it would make your life a lot easier. 
The question is asking us to find the maximum sum of values at the left and right edges of the array. More specifically, 
it's asking us to find the max sum of k values at the edges. If we were to reword the question, we're essentially asked 
to find the minimum subarray sum of length n - k. Once we find this, we simply subtract this from the total sum and this would be our answer.

*/

public class Maximum_Points_You_Can_Obtain_from_Cards {
    public static int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += cardPoints[i];
        }
        int max = Integer.MIN_VALUE;
        int i = 0, j = 0;
        int tempsum = 0;
        while(j < (n - k)){
            tempsum += cardPoints[j];
            j++;
        }
        max = Math.max(max, sum - tempsum);
        while(j < n){
            tempsum += cardPoints[j];
            tempsum -= cardPoints[i++];
            max = Math.max(max, sum - tempsum);
            j++;
        }
        return max;
    }
    public static void main(String[] args) {
        int[] arr = {100,40,17,9,73,75};
        int k = 3;
        System.out.println(maxScore(arr, k));
    }
}
