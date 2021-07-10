import java.util.*;
import java.io.*;

public class dpp {
    /* 
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    final static long MOD = 1000000007;
    static ArrayList<Integer>[] adj;
    static long[] white, black;
    static int n;
    
    public static void main(String[] args) throws IOException {
        n = readInt();
        adj = new ArrayList[n+1];
        white = new long[n+1];
        black = new long[n+1];
        for (int i = 0; i <= n; i++) adj[i] = new ArrayList<Integer>();
        
        for (int i = 1; i < n; i++) {
            int x = readInt(), y = readInt();
            adj[x].add(y);
            adj[y].add(x);
        }
        
        dfs(1, 0);
        System.out.println((white[1] + black[1]) % MOD);
    }
    
    static void dfs(int curr, int pa) {
        long w = 1, b = 1;
        for (int node : adj[curr]) {
            if (node == pa) continue;
            dfs(node, curr);
            w = w * (white[node] + black[node]) % MOD;
            b = b * white[node] % MOD;
        }
        white[curr] = w;
        black[curr] = b;
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