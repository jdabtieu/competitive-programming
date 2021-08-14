import java.util.*;
import java.io.*;

public class dpg {
    /* 
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    static int[] d;
    static boolean[] v;
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        int n = readInt(), m = readInt();
        adj = new ArrayList[n+1];
        d = new int[n+1];
        v = new boolean[n+1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        
        for (int i = 0; i < m; i++) {
            int x = readInt(), y = readInt();
            adj[x].add(y);
        }
        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (!v[i]) {
                v[i] = true;
                dfs(i);
                if (d[i] > max) max = d[i];
            }
        }
        System.out.println(max);
    }
    
    public static void dfs(int start) {
        int max = -1;
        for (int node : adj[start]) {
            if (!v[node]) {
                v[node] = true;
                dfs(node);
            }
            if (d[node] > max) max = d[node];
        }
        d[start] = max + 1;
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