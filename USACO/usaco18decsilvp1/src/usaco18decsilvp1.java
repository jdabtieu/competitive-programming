import java.io.*;
import java.util.*;
public class usaco18decsilvp1 {
    /*
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    public static void main(String[] args) throws IOException {
        int n = readInt(), buses = readInt(), cap = readInt();
        int[] t = new int[n];
        for (int i = 0; i < n; i++) {
            t[i] = readInt();
        }
        Arrays.sort(t);
        int l = 1, r = 1000000000;
        while (l < r) {
            int m = (l + r) / 2;
            int i = 0;
            for (int bn = 0; bn < buses; bn++) {
                int x = i;
                for (; i < n && i < x + cap && t[i] - t[x] <= m; i++);
            }
            if (i == n) {
                r = m;
            } else if (l == r - 1 && m == l) {
                l = r;
            } else {
                l = m;
            }
        }
        System.out.println(l);
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
