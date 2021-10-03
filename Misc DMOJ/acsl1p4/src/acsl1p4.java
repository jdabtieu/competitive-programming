import java.io.*;
import java.util.*;
public class acsl1p4 {
    /*
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
 
    static int n, k, nxt = 1;
    static ArrayList<Integer>[] adj;
    static int[] d, l;
    static boolean[] instk;
    static Stack<Integer> s;
    static int ans = 0;
 
    public static void main(String[] args) throws IOException {
        n = readInt();
        k = readInt();
        adj = new ArrayList[n+1];
        d = new int[n+1];
        l = new int[n+1];
        s = new Stack<>();
        instk = new boolean[n+1];
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<Integer>();
        while (k-- > 0) {
            int a = readInt(), b = readInt(), sa = readInt(), sb = readInt();
            if (sa > sb) adj[a].add(b);
            else adj[b].add(a);
        }
 
        for (int i = 1; i <= n; i++) {
            if (d[i] == 0) f(i);
        }
        System.out.println(ans);
    }
 
    static void f(int curr) {
        d[curr] = nxt;
        l[curr] = nxt++;
        s.push(curr); instk[curr] = true;
        for (int node : adj[curr]) {
            if (d[node] == 0) {
                f(node);
                l[curr] = Math.min(l[curr], l[node]);
            }else if (instk[node]) {
                l[curr] = Math.min(l[curr], d[node]);
            }
        }
        int cnt = 0;
        if (d[curr] == l[curr]) {
            while(instk[curr]) {
                int x = s.pop(); instk[x] = false;
                cnt++;
            }
        }
        if(cnt > 1) ans += cnt;
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