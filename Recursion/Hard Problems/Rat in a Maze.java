/*
    Rat in a Maze
    Rat in a Maze
    
    Consider a rat placed at (0, 0) in a square matrix of order N * N. It has to reach the destination at (N – 1, N – 1). Find all possible paths that the rat can take to reach from source to destination. The directions in which the rat can move are ‘U'(up), ‘D'(down), ‘L’ (left), ‘R’ (right). Value 0 at a cell in the matrix represents that it is blocked and the rat cannot move to it while value 1 at a cell in the matrix represents that rat can travel through it.
    
    Note: In a path, no cell can be visited more than one time.
    
    Print the answer in lexicographical(sorted) order
    
    Examples:
    
    Example 1:
    
    Input:
    N = 4
    m[][] = {{1, 0, 0, 0},
            {1, 1, 0, 1}, 
            {1, 1, 0, 0},
            {0, 1, 1, 1}}
    
    Output: DDRDRR DRDDRR
    
    Explanation:      
    The rat can reach the destination at (3, 3) from (0, 0) by two paths - DRDDRR and DDRDRR, when printed in sorted order we get DDRDRR DRDDRR.
    
    Example 2:
    
    Input: N = 2
           m[][] = {{1, 0},
                    {1, 0}}
    
    Output:
    No path exists and the destination cell is blocked.
*/


import java.util.ArrayList;

public class Rat_in_a_Maze {
    public static void solve(int[][] maze, int row, int col, int n, String path, ArrayList<String> res){
        if(row < 0 || col < 0 || row == n || col == n || maze[row][col] == 0) return;
        if(row == n - 1 && col == n - 1){
            res.add(path);
            return;
        }
        
        maze[row][col] = 0;
        
        // Downward
        solve(maze, row + 1, col, n, path + 'D', res);
        
        // Leftward
        solve(maze, row, col - 1, n, path + 'L', res);
        
        // Rightward
        solve(maze, row, col + 1, n, path + 'R', res);
        
        //Upward
        solve(maze, row - 1, col, n, path + 'U', res);
        
        maze[row][col] = 1;
    }
    public static ArrayList<String> findPath(int[][] maze, int n) {
        ArrayList<String> res = new ArrayList<>();
        if(maze[0][0] == 1) solve(maze, 0, 0, n, "", res);
        return res;
    }
    public static void main(String[] args) {
        int N = 4;
        int[][] m = {{1, 0, 0, 0}, {1, 1, 0, 1}, {1, 1, 0, 0}, {0, 1, 1, 1}};
        System.out.println(findPath(m, N));
    }
}
