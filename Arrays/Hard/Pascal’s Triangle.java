/*
 * Program to generate Pascal’s Triangle
   Problem Statement: Given an integer N, return the first N rows of Pascal’s triangle.
   
   In Pascal’s triangle, each number is the sum of the two numbers directly above it as shown in the figure below:
   
   
   Example 1:
   
   Input Format: N = 5
   
   Result:
       1
      1 1
     1 2 1
    1 3 3 1
   1 4 6 4 1
   
   Explanation: There are 5 rows in the output matrix. Each row corresponds to each one of the rows in the image shown above.
   Example 2:
   
   Input Format: N = 1
   Result: 1
 */

import java.util.List;
import java.util.ArrayList;

public class Pascals_Triangle {
    public static List<List<Integer>> generate(int numRows) {
      List<List<Integer>> ans = new ArrayList<>();
      List<Integer> row, pre = null;
      for (int i = 0; i < numRows; i++) {
          row = new ArrayList<Integer>();
          for (int j = 0; j <= i; j++) {
              if (j == 0 || j == i) {
                row.add(1);
              } else {
                row.add(pre.get(j - 1) + pre.get(j));
              }
          }
          pre = row;
          ans.add(row);
      }
      return ans;
    }

  public static void main(String[] args) {
    int n = 5;
    System.out.println(generate(n));
  }
}
