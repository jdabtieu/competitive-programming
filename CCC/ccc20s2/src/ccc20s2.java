import java.io.*;
import java.util.*;
public class ccc20s2 {
    /*
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    public static void main(String[] args) throws IOException {
        int m = readInt(), n = readInt();
        int[][] g = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                g[i][j] = readInt();
            }
        }
        HashSet<Integer> vis = new HashSet<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(1, 1));
        while (!q.isEmpty()) {
            Pair p = q.poll();
            if (p.x == m && p.y == n) {
                System.out.println("yes");
                return;
            }
            int val = g[p.x][p.y];
            if (vis.contains(val)) continue;
            vis.add(val);
            for (int i = 1; i <= Math.sqrt(val); i++) {
                if (val % i == 0) {
                    if (i <= m && val / i <= n) q.add(new Pair(i, val / i));
                    if (i <= n && val / i <= m) q.add(new Pair(val / i, i));
                }
            }
            
        }
        System.out.println("no");
    }
    
    static class Pair {
        int x, y;

        public Pair(int x, int y) {
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
