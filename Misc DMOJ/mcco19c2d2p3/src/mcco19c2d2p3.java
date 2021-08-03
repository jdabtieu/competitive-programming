import java.util.*;
import java.io.*;

public class mcco19c2d2p3 {
    /* 
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;

    static final int MMOD = 1000000007;
    
    static int n;
    static int[] hate, money;
    static long[][] dp;
    static boolean[] vis;
    static int s;
    
    static int ptr = 0;
    static int[] head;
    static int[] hated;
    static int[] nxt;

    public static void main(String[] args) throws IOException {
        n = IO.readInt();
        hate = new int[n+1];
        money = new int[n+1];
        dp = new long[2][n+1];
        vis = new boolean[n+1];
        
        head = new int[n+1];
        Arrays.fill(head, -1);
        hated = new int[n+1];
        nxt = new int[n+1];
        for (int i = 1; i <= n; i++) {
            money[i] = IO.readInt();
            hate[i] = IO.readInt();
            
            hated[ptr] = i;
            nxt[ptr] = head[hate[i]];
            head[hate[i]] = ptr++;
        }
        long ans = 0;
        
        for (int i = 1; i <= n; i++) {
            if (vis[i]) continue;
            for (s = i; !vis[s]; s = hate[s]) vis[s] = true;
            fun(s, true);
            long ftrue = dp[1][s];
            fun(s, false);
            ans += Math.max(ftrue, dp[0][s]);
        }
        System.out.println(ans);
    }
    
    static void fun(int curr, boolean take) {
        dp[0][curr] = 0;
        if (take && hate[s] == curr) {
            dp[1][curr] = Long.MIN_VALUE;
        } else {
            dp[1][curr] = money[curr];
        }
        
        vis[curr] = true;
        
        for (int idx = head[curr]; idx != -1; idx = nxt[idx]) {
            int node = hated[idx];
            if (curr == hate[s] && node == s) continue;
            fun(node, take);
            dp[0][curr] += Math.max(dp[0][node], dp[1][node]);
            dp[1][curr] += dp[0][node];
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

class IO {
    static InputStreamReader br = new InputStreamReader(System.in);
    static char[] ibuf = new char[65536];
    static int iptr = 0;
    static int imax = 0;

    static int readInt() throws IOException {
        int x = 0;
        char c;
        while ((c = getChar()) <= ' ');
        do {
            x = x * 10 + (c - '0');
        } while ((c = getChar()) > ' ');
        return x;
    }

    static char getChar() throws IOException {
        if (iptr >= imax) {
            imax = br.read(ibuf, 0, 65536);
            iptr = 0;
        }
        return ibuf[iptr++];
    }
}