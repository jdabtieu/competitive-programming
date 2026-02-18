import java.io.*;
import java.util.*;

public class ccc13s4 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    static int n, m;
    static ArrayList<Integer> adj[];
    
    public static void main(String[] args) throws IOException {
        n = readInt();
        m = readInt();
        adj = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();
        while (m-- > 0) {
            int x = readInt(), y = readInt();
            adj[x].add(y);
        }
        int p = readInt(), q = readInt();
        if (dfs(p, 0, q)) {
            System.out.println("yes");
        } else if (dfs(q, 0, p)) {
            System.out.println("no");
        } else {
            System.out.println("unknown");
        }
    }
    
    static boolean dfs(int curr, int pa, int target) {
        boolean[] vis = new boolean[n+1];
        vis[curr] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(curr);
        while (!q.isEmpty()) {
            int x = q.poll();
            for (int e : adj[x]) {
                if (vis[e]) continue;
                vis[e] = true;
                q.add(e);
            }
        }
        return vis[target];
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
