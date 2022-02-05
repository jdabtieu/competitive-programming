import java.io.*;
import java.util.*;
public class apio10p1 {
    /*
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    static int a, b, c;
    
    public static void main(String[] args) throws IOException {
        int n = readInt();
        a = readInt(); b = readInt(); c = readInt();
        int[] be = new int[n];
        long[] ps = new long[n];
        for (int i = 0; i < n; i++) be[i] = readInt();
        ps[0] = be[0];
        for (int i = 1; i < n; i++) ps[i] = ps[i-1] + be[i];
        long[] dp = new long[n];
        Arrays.fill(dp, Long.MIN_VALUE);
        dp[0] = f(be[0]);
        int prevj = 0;
        for (int i = 1; i < n; i++) {
            if (prevj == 0) dp[i] = f(ps[i]);
            for (int j = prevj; j <= i; j++) {
                if (j == 0) {
                    dp[i] = f(ps[i]);
                    continue;
                }
                long eff = dp[j-1] + f(ps[i] - ps[j-1]);
                if (eff > dp[i]) {
                    dp[i] = eff;
                    prevj = j;
                }
            }
        }
        System.out.println(dp[n-1]);
    }
    
    static long f(long x) {
        return a * x * x + b * x + c;
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
