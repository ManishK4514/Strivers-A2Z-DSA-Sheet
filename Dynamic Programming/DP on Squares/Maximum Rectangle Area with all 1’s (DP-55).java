/*
    Q. Maximum Rectangle Area with all 1’s | DP on Rectangles: DP 55

    Practice : https://leetcode.com/problems/maximal-rectangle/

    Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

    Example 1:    
    
    Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
    Output: 6
    Explanation: The maximal rectangle is shown in the above picture.
    Example 2:
    
    Input: matrix = [["0"]]
    Output: 0
    Example 3:
    
    Input: matrix = [["1"]]
    Output: 1
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


public class Maximum_Rectangle_Area_with_all_1s {
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
        
        // filling right Array: Finding Next Smallest element to the right
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
        
        // Filling weight array
        int[] weight = new int[heights.length];
        for(int i = 0; i < weight.length; i++){
            // calculating area = Length * breadth;
            weight[i] = heights[i] * ((right[i] - left[i]) - 1);
        }

        // Now find the largest area of Historgram
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < weight.length; i++){
            max = Math.max(max, weight[i]);
        }
        return max;
    }

    public static int maximalRectangle(char[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[] heights = new int[m];

        int maxArea = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == '1') heights[j]++;
                else heights[j] = 0;
            }

            int area = largestRectangleArea(heights);
            maxArea = Math.max(maxArea, area);
        }
        
        return maxArea;
    }

    public static void main(String[] args) {
        char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(maximalRectangle(matrix));
    }    
}
