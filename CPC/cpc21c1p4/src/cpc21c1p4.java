import java.util.*;
import java.io.*;

public class cpc21c1p4 {
    /* 
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    public static class IO {
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

    static final int MMOD = 1000000007;
    
    static int[] head;
    static int[] nxt;
    static int[] adj;
    static int ptr = 0;
    
    static boolean[] vis;
    static int[] ans;

    public static void main(String[] args) throws IOException {
        int n = IO.readInt(), m = IO.readInt();
        nxt = new int[m];
        head = new int[n+1];
        adj = new int[m];
        vis = new boolean[n + 1];
        ans = new int[n + 1];
        Arrays.fill(head, -1);
        for (int i = 0; i < m; i++) {
            int x = IO.readInt();
            int y = IO.readInt();
            nxt[ptr] = head[y];
            adj[ptr] = x;
            head[y] = ptr++;
        }
        
        for (int i = n; i > 0; i--) {
            if (!vis[i]) {
                vis[i] = true;
                dfs(i, i, i);
            }
        }
        for (int i = n; i > 0; i--) {
            if (ans[i] != 0) {
                System.out.println(i + " " + ans[i]);
                return;
            }
        }
        System.out.println(-1);
    }
    
    static void dfs(int curr, int start, int val) {
        for (int i = head[curr]; i != -1; i = nxt[i]) {
            int node = adj[i];
            if (!vis[node]) {
                vis[node] = true;
                dfs(node, start, val);
            }
        }
        if (curr == start) return;
        ans[curr] = val;
    }
}

