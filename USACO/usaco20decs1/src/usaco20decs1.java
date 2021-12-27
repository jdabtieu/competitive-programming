import java.io.*;
import java.util.*;
public class usaco20decs1 {
    /*
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    static int n;
    static int ans = 0;
    static ArrayList<Integer>[] adj;
    
    public static void main(String[] args) throws IOException {
        n = readInt();
        adj = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            int x = readInt(), y = readInt();
            adj[x].add(y);
            adj[y].add(x);
        }
        dfs(1, 0);
        System.out.println(ans);
    }
    
    static void dfs(int curr, int pa) {
        int size = adj[curr].size();
        if (pa == 0) size++;
        int p2 = 0;
        while ((1<<p2) < size) p2++;
        ans += p2;
        for (int node : adj[curr]) {
            if (node == pa) continue;
            ans++;
            dfs(node, curr);
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
