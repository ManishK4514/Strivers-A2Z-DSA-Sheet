/*
   Merge Overlapping Sub-intervals
   Problem Statement: Given an array of intervals, merge all the overlapping intervals and return an array of non-overlapping intervals.
   
   Examples
   
   Example 1:    
   Input: intervals=[[1,3],[2,6],[8,10],[15,18]]   
   Output: [[1,6],[8,10],[15,18]]   
   Explanation: Since intervals [1,3] and [2,6] are overlapping we can merge them to form [1,6]
    intervals.
   
   Example 2:   
   Input: [[1,4],[4,5]]   
   Output: [[1,5]]   
   Explanation: Since intervals [1,4] and [4,5] are overlapping we can merge them to form [1,5].
 */


import java.util.Arrays;
import java.util.ArrayList;

public class Merge_Intervals {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        ArrayList<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        int i = 1; 
        while(i < intervals.length){
            int[] lastInterval = res.get(res.size() - 1);
            if(lastInterval[1] >= intervals[i][0]){
                lastInterval[1] = Math.max(lastInterval[1], intervals[i][1]);
            }
            else{
                res.add(intervals[i]);
            }
            i++;
        }
        return res.toArray(new int[res.size()][]);
    }
    public static void main(String[] args) {
        int[][]intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] nums = merge(intervals);
        for(int[] num : nums){
            System.out.print(Arrays.toString(num) + " ");
        }
    }
}
