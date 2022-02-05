import java.io.*;
import java.util.*;
public class ccc20s5 {
    /*
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    public static void main(String[] args) throws IOException {
        int n = readInt();
        int[] last = new int[500001];
        int[] ords = new int[n+1];
        double[] ssum = new double[n+1];
        double[] dp = new double[n+1];
        for (int i = 1; i <= n; i++) {
            ords[i] = readInt();
            last[ords[i]] = i;
        }
        if (ords[n] == ords[1]) {
            dp[n] = 1;
            ssum[n] = 1;
        }
        for (int i = n - 1; i > 0; i--) {
            if (ords[i] == ords[1]) {
                dp[i] = 1;
            } else if (i != last[ords[i]]) {
                dp[i] = dp[last[ords[i]]];
            } else {
                dp[i] = (1 + ssum[i+1]) / (n - i + 1.0);
            }
            ssum[i] = ssum[i+1] + dp[i];
        }
        System.out.println(ssum[1] / (double) n);
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
