/*
    126. Word Ladder II
    A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
    
    Every adjacent pair of words differs by a single letter.
    Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
    sk == endWord
    Given two words, beginWord and endWord, and a dictionary wordList, return all the shortest transformation sequences from beginWord to endWord, or an empty list if no such sequence exists. Each sequence should be returned as a list of the words [beginWord, s1, s2, ..., sk].
            
    Example 1:
    
    Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
    Output: [["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
    Explanation: There are 2 shortest transformation sequences:
    "hit" -> "hot" -> "dot" -> "dog" -> "cog"
    "hit" -> "hot" -> "lot" -> "log" -> "cog"
    Example 2:
    
    Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
    Output: []
    Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
*/

import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;


public class Word_Ladder_II {
    public static ArrayList<ArrayList<String>> findSequences(String startWord, String targetWord, String[] wordList) {
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        for(String word : wordList) set.add(word);

        Queue<ArrayList<String>> q = new LinkedList<>();   
        ArrayList<String> tempList = new ArrayList<>();  
        tempList.add(startWord);   
        q.add(tempList);
        ArrayList<String> usedOnLevel = new ArrayList<>();
        usedOnLevel.add(startWord);
        int level = 0;  
        
        while(!q.isEmpty()){
            ArrayList<String> curr = q.remove();
            if(curr.size() > level){
                level++;
                for(String it : usedOnLevel){
                    set.remove(it);
                }
                usedOnLevel.removeAll(usedOnLevel);
            }
            String word = curr.get(curr.size() - 1);
            if(word.equals(targetWord)) {
                if(ans.size() == 0) ans.add(curr);
                else if(ans.get(0).size() == curr.size()) ans.add(curr);
            }
            for(int i = 0; i < word.length(); i++){
                for(char ch = 'a'; ch <= 'z'; ch++){
                    char[] temp = word.toCharArray();
                    temp[i] = ch;
                    String replacedWord = String.valueOf(temp);                    
                    if(set.contains(replacedWord)){  
                        curr.add(replacedWord);                  
                        q.add(new ArrayList<>(curr));
                        curr.remove(curr.size() - 1);
                    }
                }
                set.remove(word);
            }            
        }
        return ans;
    }
    public static void main(String[] args) {
        String startWord = "hit", targetWord = "cog";
        String[] wordList = {"hot","dot","dog","lot","log","cog"};
        System.out.println(findSequences(startWord, targetWord, wordList));
    }
}
