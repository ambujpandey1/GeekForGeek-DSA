// User function Template for Java
import java.util.*;

class Solution {
    class tuple {
        int first, second, third; // distance, row, col
        tuple(int f, int s, int t) {
            this.first = f;
            this.second = s;
            this.third = t;
        }
    }

    int shortestPath(int[][] grid, int[] source, int[] destination) {

        int n = grid.length;
        int m = grid[0].length;
        
        if(source[0]==destination[0] && source[1]==destination[1]) return 0;

        // If source or destination is blocked
        if (grid[source[0]][source[1]] == 0 || grid[destination[0]][destination[1]] == 0)
            return -1;

        int[][] dist = new int[n][m];
        for (int[] row : dist)
            Arrays.fill(row, (int) 1e9);

        Queue<tuple> q = new LinkedList<>();
        q.add(new tuple(0, source[0], source[1]));
        dist[source[0]][source[1]] = 0;

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            int dis = q.peek().first;
            int r = q.peek().second;
            int c = q.peek().third;
            q.remove();

            for (int i = 0; i < 4; i++) {
                int newr = r + dr[i];
                int newc = c + dc[i];

                if (newr >= 0 && newr < n && newc >= 0 && newc < m &&
                    grid[newr][newc] == 1 && dis + 1 < dist[newr][newc]) {

                    dist[newr][newc] = dis + 1;

                    // ✅ Safe to check destination *after* validation
                    if (newr == destination[0] && newc == destination[1])
                        return dis + 1;

                    q.add(new tuple(dis + 1, newr, newc));
                }
            }
        }

        return -1;
    }
}
