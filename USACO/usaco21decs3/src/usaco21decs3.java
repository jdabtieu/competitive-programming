import java.io.*;
import java.util.*;
public class usaco21decs3 {
    /*
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    public static void main(String[] args) throws IOException {
        int n = readInt(), m = readInt();
        long[] s = new long[m+1];
        long[] f = new long[m+1];
        for (int i = 0; i < n; i++) {
            s[readInt()]++;
            f[readInt()]++;
        }
        long[] l = new long[2*m+1];
        long[] r = new long[2*m+1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= m; j++) {
                l[i+j] += s[i] * s[j];
                r[i+j] += f[i] * f[j];
            }
        }
        long ans1 = l[0], ans2 = n * n;
        System.out.println(l[0]);
        for (int i = 1; i <= 2 * m; i++) {
            ans1 += l[i];
            ans2 -= r[i-1];
            System.out.println(ans1 + ans2 - n * n);
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
