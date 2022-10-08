/*
    N Queen Problem | Return all Distinct Solutions to the N-Queens Puzzle
    Problem Statement: The n-queens is the problem of placing n queens on n × n chessboard such that no two queens can attack each other. Given an integer n, return all distinct solutions to the n -queens puzzle. Each solution contains a distinct boards configuration of the queen’s placement, where ‘Q’ and ‘.’ indicate queen and empty space respectively.
    
    Examples:
    
    Input: n = 4
    
    Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
    
    Explanation: There exist two distinct solutions to the 4-queens puzzle as shown below

*/


import java.util.*;

public class N_Queens {
    public static boolean isSafe(int row, int col, char[][] board){
        int duprow = row;
        int dupcol = col;

        // check upper diagonal
        while(row >= 0 && col >= 0){
            if(board[row][col] == 'Q') return false;
            row--;
            col--;
        }
        
        row = duprow;
        col = dupcol;

        // check left side
        while(col >= 0){
            if(board[row][col] == 'Q') return false;
            col--;
        }

        row = duprow;
        col = dupcol;

        // check lower digaonal
        while(row < board.length && col >= 0){
            if(board[row][col] == 'Q') return false;
            row++;
            col--;
        }
        return true;
    }
    public static void saveBoard(char[][] board, List<List<String>> allBoards){
        StringBuilder row = new StringBuilder();
        List<String> newBoard = new ArrayList<>();
        for(int i = 0; i < board.length; i++){
            row.delete(0, row.length());
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'Q'){
                    row.append('Q');
                }
                else{
                    row.append('.');
                }
            }
          newBoard.add(row.toString());
        }
        allBoards.add(newBoard);
    }
    public static void helper(char[][] board, List<List<String>> allBoards, int col){
        if(col == board.length){
            saveBoard(board, allBoards);
            return;
        }
        for(int row = 0; row < board.length; row++){
            if(isSafe(row, col, board)){
                board[row][col] = 'Q';
                helper(board, allBoards, col + 1);
                board[row][col] = '.';
            }
        }
    }
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> allBoards = new ArrayList<>();
        char[][] board = new char[n][n];
        helper(board, allBoards, 0);
        return allBoards;
    }
    public static void main(String[] args) {
        int n = 4;
        System.out.println(solveNQueens(n));
    }
}
