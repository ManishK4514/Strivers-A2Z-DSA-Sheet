/*
   435. Non-overlapping Intervals
   Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
   
   Example 1:
   
   Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
   Output: 1
   Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
   Example 2:
   
   Input: intervals = [[1,2],[1,2],[1,2]]
   Output: 2
   Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.
   Example 3:
   
   Input: intervals = [[1,2],[2,3]]
   Output: 0
   Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
*/


import java.util.Arrays;

public class Non_overlapping_Intervals {
    public static int eraseOverlapIntervals(int[][] intervals) {
        // Sorting the Array according to the First element or starting time of interval
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        int ans = 0, previous = 0;
        for(int current = 1; current < intervals.length; current++){
            if(intervals[previous][1] > intervals[current][0]){
                ans++;
                if(intervals[previous][1] > intervals[current][1]){
                    previous = current;
                }
            }
            else{
                previous = current;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
        System.out.println(eraseOverlapIntervals(intervals));
    }
}
