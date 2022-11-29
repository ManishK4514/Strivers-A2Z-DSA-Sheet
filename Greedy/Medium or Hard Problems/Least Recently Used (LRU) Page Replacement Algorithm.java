/*
   Page Faults in LRU
   This problem is part of GFG SDE Sheet. Click here to view more.  
   
   In operating systems that use paging for memory management, page replacement algorithm is needed to decide which page needs to be replaced when the new page comes in. Whenever a new page is referred and is not present in memory, the page fault occurs and Operating System replaces one of the existing pages with a newly needed page.
   
   Given a sequence of pages in an array pages[] of length N and memory capacity C, find the number of page faults using Least Recently Used (LRU) Algorithm. 
   
   Note:- Before solving this example revising the OS LRU cache mechanism is recommended.
   
   Example 1:
   
   Input: N = 9, C = 4
   pages = {5, 0, 1, 3, 2, 4, 1, 0, 5}
   Output: 8
   Explaination: memory allocated with 4 pages 5, 0, 1, 
   3: page fault = 4
   page number 2 is required, replaces LRU 5: 
   page fault = 4+1 = 5
   page number 4 is required, replaces LRU 0: 
   page fault = 5 + 1 = 6
   page number 1 is required which is already present: 
   page fault = 6 + 0 = 6
   page number 0 is required which replaces LRU 3: 
   page fault = 6 + 1 = 7
   page number 5 is required which replaces LRU 2: 
   page fault = 7 + 1  = 8.
*/


import java.util.HashMap;
import java.util.Map;

public class Least_Recently_Used_LRU_Page_Replacement_Algorithm {
    public static int pageFaults(int N, int C, int pages[]){
        HashMap<Integer, Integer> map = new HashMap<>();
        int pagesFault = 0;
        for(int i = 0; i < pages.length; i++){
            if(map.size() < C){
                if(!map.containsKey(pages[i])){
                    pagesFault++;
                    map.put(pages[i], i);
                }
                else{
                    map.put(pages[i], i);
                }
            }
            else{
                if(map.containsKey(pages[i])){
                    map.put(pages[i], i);
                }
                else{
                    pagesFault++;
                    int value = 0;
                    int idx = Integer.MAX_VALUE;
                    for(Map.Entry<Integer, Integer> entry: map.entrySet()){
                        if(idx > entry.getValue()){
                            idx = entry.getValue();
                            value = entry.getKey();
                        }
                    }
                    map.remove(value);
                    map.put(pages[i], i);
                }
            }
        }
        return pagesFault;
    }
    public static void main(String[] args) {
        int N = 9, C = 4;
        int[] pages = {5, 0, 1, 3, 2, 4, 1, 0, 5};
        System.out.println(pageFaults(N, C, pages));
    }    
}
