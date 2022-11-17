/*
   621. Task Scheduler
   Given a characters array tasks, representing the tasks a CPU needs to do, where each letter represents a different task. Tasks could be done in any order. Each task is done in one unit of time. For each unit of time, the CPU could complete either one task or just be idle.
   
   However, there is a non-negative integer n that represents the cooldown period between two same tasks (the same letter in the array), that is that there must be at least n units of time between any two same tasks.
   
   Return the least number of units of times that the CPU will take to finish all the given tasks.
   
   Example 1:
   
   Input: tasks = ["A","A","A","B","B","B"], n = 2
   Output: 8
   Explanation: 
   A -> B -> idle -> A -> B -> idle -> A -> B
   There is at least 2 units of time between any two same tasks.
   Example 2:
   
   Input: tasks = ["A","A","A","B","B","B"], n = 0
   Output: 6
   Explanation: On this case any permutation of size 6 would work since n = 0.
   ["A","A","A","B","B","B"]
   ["A","B","A","B","A","B"]
   ["B","B","B","A","A","A"]
   ...
   And so on.
   Example 3:
   
   Input: tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
   Output: 16
   Explanation: 
   One possible solution is
   A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> idle -> idle -> A -> idle -> idle -> A
*/

public class Task_Scheduler {
    public static int leastInterval(char[] tasks, int n) {        
        /*
           // Solution 1: 

           PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
           HashMap<Character, Integer> map = new HashMap<>();
           for(int i = 0; i < tasks.length; i++){
               map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);
           }
           pq.addAll(map.values());
           int result = 0;
           while(!pq.isEmpty()){
               int time = 0;
               List<Integer> temp = new ArrayList<>();
               for(int i = 0; i < n + 1; i++){
                   if(!pq.isEmpty()){
                       temp.add(pq.remove() - 1);
                       time++;
                   }
               }
               for(int t : temp){
                   if(t > 0) pq.add(t);
               }
               result += pq.isEmpty() ? time : n + 1;
           }
           return result;
         */

        // Solution 2:
        int[] counter = new int[26];
        int max = 0;
        int maxCount = 0;
        for(char task : tasks) {
            counter[task - 'A']++;
            if(max == counter[task - 'A']) {
                maxCount++;
            }
            else if(max < counter[task - 'A']) {
                max = counter[task - 'A'];
                maxCount = 1;
            }
        }
        
        int partCount = max - 1;
        int partLength = n - (maxCount - 1);
        int emptySlots = partCount * partLength;
        int availableTasks = tasks.length - max * maxCount;
        int idles = Math.max(0, emptySlots - availableTasks);
        
        return tasks.length + idles;
    }
    public static void main(String[] args) {
        char[] ch = {'A', 'B', 'C', 'D', 'E', 'A', 'B', 'C', 'D', 'E'};
        System.out.println(leastInterval(ch, 4));
    }
}
