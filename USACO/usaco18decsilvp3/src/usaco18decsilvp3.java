import java.io.*;
import java.util.*;
public class usaco18decsilvp3 {
    /*
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    static int[][] grid;
    static int n, k;
    static boolean ip = true;
    static ArrayList<pair> clear = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        n = readInt();
        k = readInt();
        grid = new int[n][10];
        for (int i = 0; i < n; i++) {
            String s = readLine();
            for (int j = 0; j < 10; j++) {
                grid[i][j] = s.charAt(j) - '0';
            }
        }
        while (ip) {
            ip = false;
            destroy();
            gravity();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }
    
    static void destroy() {
        boolean[][] vis = new boolean[n][10];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                if (vis[i][j] || grid[i][j] == 0) continue;
                vis[i][j] = true;
                int cnt = dfs(i, j, vis, grid[i][j]);
                if (cnt >= k) {
                    ip = true;
                    for (pair e : clear) {
                        grid[e.x][e.y] = 0;
                    }
                }
                clear.clear();
            }
        }
    }
    
    static void gravity() {
        for (int j = 0; j < 10; j++) {
            ArrayList<Integer> nums = new ArrayList<>();
            for (int i = n-1; i >= 0; i--) {
                if (grid[i][j] != 0) nums.add(grid[i][j]);
            }
            for (int i = 0; i < nums.size(); i++) {
                grid[n-i-1][j] = nums.get(i);
            }
            for (int i = nums.size(); i < n; i++) {
                grid[n-i-1][j] = 0;
            }
        }
    }
    
    static int dfs(int x, int y, boolean[][] vis, int c) {
        clear.add(new pair(x, y));
        int cnt = 1;
        if (x != 0 && grid[x-1][y] == c && !vis[x-1][y]) {
            vis[x-1][y] = true;
            cnt += dfs(x-1, y, vis, c);
        }
        if (x != n-1 && grid[x+1][y] == c && !vis[x+1][y]) {
            vis[x+1][y] = true;
            cnt += dfs(x+1, y, vis, c);
        }
        if (y != 0 && grid[x][y-1] == c && !vis[x][y-1]) {
            vis[x][y-1] = true;
            cnt += dfs(x, y-1, vis, c);
        }
        if (y != 9 && grid[x][y+1] == c && !vis[x][y+1]) {
            vis[x][y+1] = true;
            cnt += dfs(x, y+1, vis, c);
        }
        return cnt;
    }
    
    static class pair {
        int x, y;

        public pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
    }
    
    static String next() throws IOException {
        while (in == null || !in.hasMoreTokens())
            in = new StringTokenizer(br.readLine());
        return in.nextToken();
    }
    
    static long readLong() throws IOException {
        return Long.parseLong(next());
    }
    
    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }
    
    static double readDouble() throws IOException {
        return Double.parseDouble(next());
    }
    
    static char readChar() throws IOException {
        return next().charAt(0);
    }
    
    static String readLine() throws IOException {
        return br.readLine();
    }
}
