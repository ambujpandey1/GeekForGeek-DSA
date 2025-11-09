
class Solution {
   static class tuple {
        int first, second, third; // distance, row, col
        tuple(int f, int s, int t) {
            this.first = f;
            this.second = s;
            this.third = t;
        }
    }

   public static  int shortestPath(int[][] grid, int[] source, int[] destination) {

        int n = grid.length;
        int m = grid[0].length;
        
      

        // If source or destination is blocked
        // if (grid[source[0]][source[1]] == 1 || grid[destination[0]][destination[1]] == 1)
        //     return -1;
        
        if(source[0]==destination[0] && source[1]==destination[1]) return  0;

        int[][] dist = new int[n][m];
        for (int[] row : dist)
            Arrays.fill(row, (int) 1e9);

        PriorityQueue<tuple> q = new PriorityQueue<>((x,y)->x.first-y.first);
        q.add(new tuple(0, source[0], source[1]));
        dist[source[0]][source[1]] = 0;

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            int diff = q.peek().first;
            int r = q.peek().second;
            int c = q.peek().third;
            q.remove();
            if(r==n-1 && c==m-1) return diff;
            for (int i = 0; i < 4; i++) {
                int newr = r + dr[i];
                int newc = c + dc[i];


               

                if (newr >= 0 && newr < n && newc >= 0 && newc < m ) {

                 int newEffort=Math.max(Math.abs(grid[r][c]-grid[newr][newc]),diff);
 
                    // ✅ Safe to check destination *after* validation
                  if(newEffort<dist[newr][newc]){
                    dist[newr][newc]=newEffort;
                    q.add(new tuple(newEffort, newr, newc));
                  }

                    
                }
            }
        }

        return 0;
    }
    public static int MinimumEffort(int rows, int columns, int[][] heights) {
        // code here
        int n = rows;
        int m = columns;
        int[] source={0,0};
        int[] distination={n-1,m-1};
       return shortestPath(heights,source,distination); 
    }
}
