import java.util.*;

class Solution {

    public ArrayList<String> ratInMaze(int[][] maze) {
        ArrayList<String> ans = new ArrayList<>();
        int n = maze.length;

        // If starting or ending cell is blocked
        if (maze[0][0] == 0 || maze[n - 1][n - 1] == 0) {
            return ans;
        }

        boolean[][] visited = new boolean[n][n];
        dfs(0, 0, maze, n, visited, new StringBuilder(), ans);

        return ans;
    }

    // Directions in lexicographical order: D, L, R, U
    private void dfs(int row, int col, int[][] maze, int n,
                     boolean[][] visited, StringBuilder path,
                     ArrayList<String> ans) {

        // Destination reached
        if (row == n - 1 && col == n - 1) {
            ans.add(path.toString());
            return;
        }

        visited[row][col] = true;

        // Down
        if (isSafe(row + 1, col, maze, visited, n)) {
            path.append('D');
            dfs(row + 1, col, maze, n, visited, path, ans);
            path.deleteCharAt(path.length() - 1);
        }

        // Left
        if (isSafe(row, col - 1, maze, visited, n)) {
            path.append('L');
            dfs(row, col - 1, maze, n, visited, path, ans);
            path.deleteCharAt(path.length() - 1);
        }

        // Right
        if (isSafe(row, col + 1, maze, visited, n)) {
            path.append('R');
            dfs(row, col + 1, maze, n, visited, path, ans);
            path.deleteCharAt(path.length() - 1);
        }

        // Up
        if (isSafe(row - 1, col, maze, visited, n)) {
            path.append('U');
            dfs(row - 1, col, maze, n, visited, path, ans);
            path.deleteCharAt(path.length() - 1);
        }

        visited[row][col] = false; // backtrack
    }

    private boolean isSafe(int r, int c, int[][] maze,
                           boolean[][] visited, int n) {
        return r >= 0 && c >= 0 && r < n && c < n &&
               maze[r][c] == 1 && !visited[r][c];
    }
}
