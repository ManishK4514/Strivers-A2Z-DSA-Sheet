/*
    207. Course Schedule
    There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
    
    For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
    Return true if you can finish all courses. Otherwise, return false.
    
     
    
    Example 1:
    
    Input: numCourses = 2, prerequisites = [[1,0]]
    Output: true
    Explanation: There are a total of 2 courses to take. 
    To take course 1 you should have finished course 0. So it is possible.

    Example 2:
    
    Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
    Output: false
    Explanation: There are a total of 2 courses to take. 
    To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

    Example 1:
    Input: N = 4, P = 3,  array[] = {{1,0},{2,1},{3,2}}
    Output: true
    Explanation: It is possible to finish all the tasks in the order : 3 2 1 0.
    First, we will finish task 3. Then we will finish task 2, task 1, and task 0.
    
    Example 2:
    Input: N = 4, P = 4,  array[] = {{1,2},{4,3},{2,4},{4,1}}
    Output: false
    Explanation: It is impossible to finish all the tasks. Let’s analyze the pairs:
    For pair {1, 2} -> we need to finish task 1 first and then task 2. (order : 1 2).
    For pair{4, 3} -> we need to finish task 4 first and then task 3. (order: 4 3).
    For pair {2, 4} -> we need to finish task 2 first and then task 4. (order: 1 2 4 3).
    But for pair {4, 1} -> we need to finish task 4 first and then task 1 but this pair contradicts the previous pair. So, it is not possible to finish all the tasks.
*/

// import java.util.Arrays;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Course_Schedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();        
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] nums : prerequisites){
            adj.get(nums[1]).add(nums[0]);
        }
        
        int[] indegree = new int[n];
        for(int i = 0; i < n; i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(indegree[i] == 0) q.add(i);
        }
        
        int[] ans = new int[n];
        int k = 0;
        while(!q.isEmpty()){
            int node = q.remove();
            ans[k++] = node;
            
            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0) q.add(it);
            }
        }
        return k == n;
    } 
    public static void main(String[] args) {
        int[][] prerequisites = {{1, 0}};
        int numCourses = 2;
        System.out.println(canFinish(numCourses, prerequisites));
    }
}
