/*
    Area of largest rectangle in Histogram (LeetCode 84 (Hard))
    Problem Statement: Given an array of integers heights representing the histogram’s bar height where the width of each bar is 1  return the area of the largest rectangle in histogram.

    Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram. 
    
    Example:    
    Input: N =6, heights[] = {2,1,5,6,2,3}    
    Output: 10
    
    Explanation:

 */

import java.util.Stack;

class Pair{
    int first;
    int second;
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
public class Largest_Rectangle_in_Histogram {
    public static int largestRectangleArea(int[] heights) {
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        
        // filling left Array: Finding Next Smallest element to the left
        Stack<Pair> stack1 = new Stack<>();
        for(int i = 0; i < heights.length; i++){
            while(!stack1.empty() && stack1.peek().first >= heights[i]){
                stack1.pop();
            }
            if(stack1.empty()){
                left[i] = -1;
            }
            else{
                left[i] = stack1.peek().second;
            }
            stack1.push(new Pair(heights[i], i));
        }

        Stack<Pair> stack2 = new Stack<>();
        for(int i = heights.length - 1; i >= 0; i--){
            while(!stack2.empty() && stack2.peek().first >= heights[i]){
                stack2.pop();
            }
            if(stack2.empty()){
                right[i] = heights.length;
            }
            else{
                right[i] = stack2.peek().second;
            }
            stack2.push(new Pair(heights[i], i));
        }
        
        // Filling weight array & find the largest area of Historgram
        int[] weight = new int[heights.length];
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < weight.length; i++){
            // calculating area = Length * breadth;
            max = Math.max(weight[i] = heights[i] * ((right[i] - left[i]) - 1), max);
        }
        return max;
    }
    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(heights));
    }
}
