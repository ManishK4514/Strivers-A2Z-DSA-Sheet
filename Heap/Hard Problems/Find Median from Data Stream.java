/*
   295. Find Median from Data Stream
   The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value, and the median is the mean of the two middle values.
   
   For example, for arr = [2,3,4], the median is 3.
   For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
   Implement the MedianFinder class:
   
   MedianFinder() initializes the MedianFinder object.
   void addNum(int num) adds the integer num from the data stream to the data structure.
   double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
    
   
   Example 1:
   
   Input
   ["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
   [[], [1], [2], [], [3], []]
   Output
   [null, null, null, 1.5, null, 2.0]
   
   Explanation
   MedianFinder medianFinder = new MedianFinder();
   medianFinder.addNum(1);    // arr = [1]
   medianFinder.addNum(2);    // arr = [1, 2]
   medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
   medianFinder.addNum(3);    // arr[1, 2, 3]
   medianFinder.findMedian(); // return 2.0
*/

import java.util.PriorityQueue;
import java.util.Collections;

class MedianFinder {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if(maxHeap.isEmpty() || maxHeap.peek() >= num){
            maxHeap.add(num);
        }
        else{
            minHeap.add(num);
        }

        if(maxHeap.size() > minHeap.size() + 1){
            minHeap.add(maxHeap.poll());
        }
        else if(maxHeap.size() < minHeap.size()){
            maxHeap.add(minHeap.poll());
        }
    }
    
    public double findMedian() {
        // In Case Of Even
        if(maxHeap.size() == minHeap.size()){
            return maxHeap.peek()/2.0 + minHeap.peek()/2.0;
        }
        // In Case of Odd
        return maxHeap.peek();
    }
}

public class Find_Median_from_Data_Stream {
    public static void main(String[] args) {
        MedianFinder m = new MedianFinder();
        m.addNum(1);
        m.addNum(2);
        System.out.println(m.findMedian());
        m.addNum(3);
        System.out.println(m.findMedian());
    }
}
