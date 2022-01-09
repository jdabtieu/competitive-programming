import java.io.*;
import java.util.*;
public class dpe {
    /*
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    public static void main(String[] args) throws IOException {
        int n = readInt(), w = readInt();
        int[] ws = new int[n], vs = new int[n];
        int vsum = 0;
        for (int i = 0; i < n; i++) {
            ws[i] = readInt();
            vs[i] = readInt();
            vsum += vs[i];
        }
        
        // min weight for first i items with min value j
        long[][] dp = new long[n][vsum+1];
        for (long[] a : dp) Arrays.fill(a, Integer.MAX_VALUE);
        for (int i = 0; i <= vs[0]; i++) {
            dp[0][i] = ws[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= vsum; j++) {
                dp[i][j] = Math.min(dp[i-1][j], (j - vs[i] > 0 ? dp[i-1][j - vs[i]] : 0) + ws[i]);
            }
        }
        for (int i = vsum; i >= 0; i--) {
            if (dp[n-1][i] <= w) {
                System.out.println(i);
                return;
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
