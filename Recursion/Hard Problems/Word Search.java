/*
   Word Search – Leetcode
   Given an m x n grid of characters board and a string word, return true if the word exists in the grid. The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
   
   Examples:
   
   Example 1:
   Input: 
   [
   ["A", "B", "C", "E"], 
   ["S", "F", "C", "S"],
   ["A", "D", "E", "E"]
   ] 
   word = "ABCCED"
   Output: true
   Explanation: We can easily find the given word in the matrix.
   
   Example 2:
   Input:
   [
   ["A", "B", "C", "E"],
   ["S", "F", "C", "S"],
   ["A", "D", "E", "E"]
   ]
   word = "ABCB"
   Output: false
   Explanation:  There is no such word in the given matrix.
*/


public class Word_Search {
    public static boolean search(int i, int j, int k, char[][] board, String word, int m, int n){
        if(k == word.length()) return true;
        if(i < 0 || j < 0|| i == m || j == n || board[i][j] != word.charAt(k)) return false;
        char ch = board[i][j];
        board[i][j] = '#';
        boolean opt1 = search(i + 1, j, k + 1, board, word, m, n);
        boolean opt2 = search(i - 1, j, k + 1, board, word, m, n);
        boolean opt3 = search(i, j + 1, k + 1, board, word, m, n);
        boolean opt4 = search(i, j - 1, k + 1, board, word, m, n);
        board[i][j] = ch;
        return opt1 || opt2 || opt3 || opt4;
    }
    public static boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == word.charAt(0)){
                    if(search(i, j, 0, board, word, m, n)) return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        System.out.println(exist(board, word));
    }
}
