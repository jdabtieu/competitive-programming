import java.util.*;
import java.io.*;

public class coci14c1p4 {
    /* 
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;

    static final int MMOD = 1000000007;

    static int[] idg;
    static int[] acc;
    static boolean[] vis;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        int n = readInt();
        idg = new int[n+1];
        acc = new int[n+1];
        vis = new boolean[n+1];
        for (int i = 1; i <= n; i++) {
            int s = readInt();
            acc[i] = s;
            idg[s]++;
        }
        
        for (int i = 1; i <= n; i++) {
            if (!vis[i] && idg[i] == 0) {
                dfs(i, true);
            }
        }
        
        // look for cycles
        for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
                dfs(i, false);
            }
        }
        
        System.out.println(ans);
    }
    
    static void dfs(int n, boolean bad) {
        vis[n] = true;
        if (bad) ans++;
        idg[acc[n]]--;
        if ((idg[acc[n]] == 0 || bad) && !vis[acc[n]]) {
            dfs(acc[n], !bad);
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