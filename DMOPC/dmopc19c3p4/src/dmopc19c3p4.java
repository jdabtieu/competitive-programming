import java.util.*;
import java.io.*;
public class dmopc19c3p4 {
    /* 
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    static final int MMOD = 1000000007;
    static boolean[] red;
    static long ans = 0;
    static long dp[];
    static int [] head, nxt, adj;
    static int tot;
 
        public static void main(String[] args) throws IOException {
            int n = readInt();
            red = new boolean[n+1];
            dp = new long[n+1];
            head = new int[2*n+1];
            nxt = new int[3*n+1];
            adj = new int[3*n+1];
            Arrays.fill(head, -1);
 
            String s = readLine();
            for (int i = 0; i < n; i++) {
                red[i+1] = s.charAt(i) == 'R';
            }
 
            for (int i = 1; i < n; i++) {
                int x = readInt(), y = readInt();
                nxt[tot] = head[x]; adj[tot] = y; head[x] = tot++;
                nxt[tot] = head[y]; adj[tot] = x; head[y] = tot++;
            }
            dfs1(1, 0);
            dfs2(1, 0);
            System.out.println(ans % MMOD);
 
        }
 
        static void dfs1(int curr, int pa) {
            long sum = 0;
            long c = 0;
            for (int i = head[curr]; i != -1; i = nxt[i]) {
                int node = adj[i];
                if (node == pa) continue;
                dfs1(node, curr);
                c = (c + (sum * dp[node] % MMOD) + (c * dp[node]) % MMOD) % MMOD;
                sum = (sum + dp[node]) % MMOD;
            }
            dp[curr] = red[curr] ? (sum + c + 1) % MMOD : (sum + c) % MMOD;
            ans = (ans + (red[curr] ? (sum + c + 1) % MMOD : c)) % MMOD;
        }
 
        static void dfs2(int curr, int pa) {
            long sum = 0;
            long c = 0;
            for (int i = head[curr]; i != -1; i = nxt[i]) {
                int node = adj[i];
                if (node == pa) continue;
                dfs2(node, curr);
                c = (c + (sum * dp[node] % MMOD) + (c * dp[node]) % MMOD) % MMOD;
                sum = (sum + dp[node]) % MMOD;
            }
            dp[curr] = !red[curr] ? (sum + c + 1) % MMOD : (sum + c) % MMOD;
            ans = (ans + (!red[curr] ? (sum + c + 1) % MMOD : c)) % MMOD;
        }
 
 
    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
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
 
    static char readCharacter() throws IOException {
        return next().charAt(0);
    }
 
    static String readLine() throws IOException {
        return br.readLine().trim();
    }
}