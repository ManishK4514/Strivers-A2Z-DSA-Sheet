/*
    127. 	Word ladder – 1
    A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
    
    Every adjacent pair of words differs by a single letter.
    Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
    sk == endWord
    Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.
        
    Example 1:
    
    Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
    Output: 5
    Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
    Example 2:
    
    Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
    Output: 0
    Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
*/

import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;

class Pair{
    String word;
    int level;
    Pair(String word, int level){
        this.word = word;
        this.level = level;
    }
}


public class Word_ladder_1 {
    public static int wordLadderLength(String startWord, String targetWord, String[] wordList){
        HashSet<String> set = new HashSet<>();
        for(String word : wordList) set.add(word);

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(startWord, 1));
        
        while(!q.isEmpty()){
            String word = q.peek().word;
            int level = q.peek().level;
            q.remove();
            if(word.equals(targetWord)) return level;
            for(int i = 0; i < word.length(); i++){
                for(char ch = 'a'; ch <= 'z'; ch++){
                    char[] temp = word.toCharArray();
                    temp[i] = ch;
                    String replacedWord = String.valueOf(temp);                    
                    if(set.contains(replacedWord)){                        
                        q.add(new Pair(replacedWord, level + 1));
                        set.remove(replacedWord);
                    }
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        String[] wordList = {"des","der","dfr","dgt","dfs"};
        String startWord = "der", targetWord= "dfs";
        System.out.println(wordLadderLength(startWord, targetWord, wordList));
    }
}
