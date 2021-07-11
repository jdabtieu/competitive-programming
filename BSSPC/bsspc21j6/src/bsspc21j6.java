import java.util.*;
import java.io.*;

public class bsspc21j6 {
    /* 
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    static int n;
    static ArrayList<Integer>[] adj;
    static long[] cost;
    static long[] weight;

    public static void main(String[] args) throws IOException {
        n = readInt();
        adj = new ArrayList[n+1];
        cost = new long[n+1];
        weight = new long[n+1];
        for (int i = 0; i <= n; i++) adj[i] = new ArrayList<Integer>();
        for (int i = 2; i <= n; i++) {
            weight[i] = readLong();
        }
        for (int i = 1; i < n; i++) {
            int x = readInt(), y = readInt();
            adj[x].add(y);
            adj[y].add(x);
        }
        dfs(1, 0);
        System.out.println(screwOrzTreesTheySuck() - cost[1]);
    }
    
    static long screwOrzTreesTheySuck() {
        return Arrays.stream(weight).reduce(Long::sum).getAsLong();
    }
    // cost = cost of most expensive i.e. the ones we keep
    static void dfs(int curr, int pa) {
        for (int node : adj[curr]) {
            if (node == pa) continue;
            dfs(node, curr);
            cost[curr] += cost[node] + weight[node];
        }
        ArrayList<Long> rem = new ArrayList();
        if ((pa != 0 && adj[curr].size() > 2) || adj[curr].size() > 3) {
            for (int node : adj[curr]) {
                if (node == pa) continue;
                rem.add(cost[node] + weight[node]);
            }
            Collections.sort(rem, Collections.reverseOrder());
            for (int i = pa == 0 ? 3 : 2; i < rem.size(); i++) {
                cost[curr] -= rem.get(i);
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