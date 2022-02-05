import java.io.*;
import java.util.*;
public class wac4p2 {
    /*
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    public static void main(String[] args) throws IOException {
        int n = readInt(), psum = 0;
        int[] voters = new int[n+1];
        int[] points = new int[n+1];
        for (int i = 1; i <= n; i++) {
            voters[i] = readInt();
            points[i] = readInt();
            psum += points[i];
        }
        // dp[province #][points] = # of voters needed to get at least points
        long[][] dp = new long[n+1][psum / 2 + 2];
        for (int j = 1; j < dp[0].length; j++) {
            dp[0][j] = Long.MAX_VALUE / 4;
        }
        for (int i = 1; i <= n; i++) {
            int v = voters[i] / 2 + 1;
            int p = points[i];
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i-1][Math.max(0, j-p)] + v);
            }
        }
        System.out.println(dp[n][dp[n].length - 1]);
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
