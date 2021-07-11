import java.util.*;
import java.io.*;

public class cco13p3 {
    /* 
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    static int n = 0, dia = 0;
    static int[] d, f;
    static long freq = 0;
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        n = readInt();
        d = new int[n+1];
        f = new int[n+1];
        Arrays.fill(f, 1);
        adj = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) adj[i] = new ArrayList<Integer>();
        
        for (int i = 1; i < n; i++) {
            int x = readInt(), y = readInt();
            adj[x].add(y);
            adj[y].add(x);
        }
        
        dfs(1, 0);
        System.out.println(++dia + " " + freq);
    }
    
    static void dfs(int curr, int pa) {
        for (int node : adj[curr]) {
            if (node == pa) continue;
            dfs(node, curr);
            if (d[node] + d[curr] >= dia) {
                dia = d[node] + d[curr] + 1;
                freq = (long) f[node] * f[curr];
            } else if (d[node] + d[curr] == dia - 1) {
                freq += (long) f[node] * f[curr];
            }
            if (d[node] >= d[curr]) {
                d[curr] = d[node] + 1;
                f[curr] = f[node];
            } else if (d[node] == d[curr] - 1) {
                f[curr] += f[node];
            }
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