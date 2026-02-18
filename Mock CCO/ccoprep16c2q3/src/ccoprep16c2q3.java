import java.io.*;
import java.util.*;
public class ccoprep16c2q3 {
    /*
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    public static void main(String[] args) throws IOException {
        int n = readInt();
        int[] pv = new int[n];
        int[] ans = new int[n];
        int[] nxt = new int[n];
        for (int i = 0; i < n; i++) pv[i] = readInt();
        final int bsz = (int) Math.sqrt(n);
        for (int i = n - 1; i >= 0; i--) {
            if (i + pv[i] >= n) { // end
                nxt[i] = n;
                ans[i] = 1;
            } else {
                if (i+pv[i] >= bsz * (i / bsz + 1)) { // next block
                    nxt[i] = i+pv[i];
                    ans[i] = 1;
                } else {
                    nxt[i] = nxt[i+pv[i]];
                    ans[i] = ans[i+pv[i]] + 1;
                }
            }
        }
        for (int queries = readInt(); queries > 0; queries--) {
            int type = readInt();
            if (type == 1) {
                int sqr = readInt();
                int a = 0;
                while (sqr != n) {
                    a += ans[sqr];
                    sqr = nxt[sqr];
                }
                System.out.println(a);
            } else {
                int sqr = readInt();
                pv[sqr] = readInt();
                for (int i = sqr; i >= (i / bsz) * bsz; i--) {
                    if (i + pv[i] >= n) { // end
                        nxt[i] = n;
                        ans[i] = 1;
                    } else {
                        if (i+pv[i] >= bsz * (i / bsz + 1)) { // next block
                            nxt[i] = i+pv[i];
                            ans[i] = 1;
                        } else {
                            nxt[i] = nxt[i+pv[i]];
                            ans[i] = ans[i+pv[i]] + 1;
                        }
                    }
                }
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