import java.io.*;
import java.util.*;
public class usaco19opensilver3 {
    /*
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    public static void main(String[] args) throws IOException {
        int n = readInt(), m = readInt();
        pii[] cows = new pii[n+1];
        for (int i = 1; i <= n; i++) cows[i] = new pii(readInt(), readInt());
        ArrayList<Integer> adj[] = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int x = readInt(), y = readInt();
            adj[x].add(y);
            adj[y].add(x);
        }
        boolean[] vis = new boolean[n+1];
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            if (vis[i]) continue;
            Queue<Integer> q = new LinkedList<>();
            int sx = cows[i].x, sy = cows[i].y, lx = sx, ly = sy;
            q.add(i);
            while (!q.isEmpty()) {
                int idx = q.poll();
                for (int node : adj[idx]) {
                    if (vis[node]) continue;
                    sx = Math.min(sx, cows[node].x);
                    sy = Math.min(sy, cows[node].y);
                    lx = Math.max(lx, cows[node].x);
                    ly = Math.max(ly, cows[node].y);
                    vis[node] = true;
                    q.add(node);
                }
            }
            ans = Math.min(ans, 2 * (lx - sx) + 2 * (ly - sy));
        }
        System.out.println(ans);
    }
    
    static class pii {
        int x, y;

        public pii(int x, int y) {
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
