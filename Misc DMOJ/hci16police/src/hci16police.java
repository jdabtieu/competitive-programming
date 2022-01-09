import java.io.*;
import java.util.*;
public class hci16police {
    /*
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    public static void main(String[] args) throws IOException {
        int n = readInt(), cost = readInt();
        int[] pos = new int[n];
        for (int i = 0; i < n; i++) {
            pos[i] = readInt();
        }
        long[] dp = new long[n];
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[0] = cost;
        int prevj = 0;
        for (int i = 1; i < n; i++) {
            for (int j = prevj; j <= i; j++) {
                long d = pos[i] - pos[j];
                long ans = (j == 0 ? 0 : dp[j-1]) + cost + d * d;
                if (ans < dp[i]) {
                    prevj = j;
                    dp[i] = ans;
                }
            }
        }
        System.out.println(dp[n-1]);
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
