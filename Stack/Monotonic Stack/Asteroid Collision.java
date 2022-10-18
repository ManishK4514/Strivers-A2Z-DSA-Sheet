/*
    We are given an array asteroids of integers representing asteroids in a row.
    For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.    
    Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
    
    Example 1:
    
    Input: asteroids = [5,10,-5]
    Output: [5,10]
    Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.

    Example 2:    
    Input: asteroids = [8,-8]
    Output: []
    Explanation: The 8 and -8 collide exploding each other.

    Example 3:    
    Input: asteroids = [10,2,-5]
    Output: [10]
    Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
 */


import java.util.Arrays;
import java.util.Stack;

public class Asteroid_Collision {
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int val : asteroids){
            if(val > 0){
                stack.push(val);
            }
            else{
                while(!stack.empty() && stack.peek() > 0 && stack.peek() < -val){
                    stack.pop();
                }
                if(!stack.empty() && stack.peek() == -val){
                    stack.pop();
                }
                else if(!stack.empty() && stack.peek() > -val){
                    continue;
                }
                else{
                    stack.push(val);
                }
            }
        }
        int[] ans = new int[stack.size()];
        for(int i = ans.length - 1; i >= 0; i--){
            ans[i] = stack.pop();
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] asteriod = {-1, -2, 1, 3, 2, -3, 3};
        System.out.println(Arrays.toString(asteroidCollision(asteriod)));
    }
}
