/*
 * Q. Merge Overlapping Sub-intervals.
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

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Merge_Overlapping_Sub_intervals {
    public static List<List<Integer>> merge(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if (ans.size() == 0 || ans.get(ans.size() - 1).get(1) < intervals[i][0]) {
                ArrayList<Integer> v = new ArrayList<>();
                v.add(intervals[i][0]);
                v.add(intervals[i][1]);
                ans.add(v);
            } else {
                ans.get(ans.size() - 1).set(1, Math.max(ans.get(ans.size() - 1).get(1), intervals[i][1]));
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] arr = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        List<List<Integer>> ans = merge(arr);
        System.out.println("Merged Overlapping Intervals are ");
        for (List<Integer> it : ans) {
            System.out.println(it.get(0) + " " + it.get(1));
        }
    }
}
