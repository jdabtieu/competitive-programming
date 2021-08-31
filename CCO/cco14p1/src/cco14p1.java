import java.io.*;
import java.util.*;
public class cco14p1 {
    /*
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    static int n;
    static boolean[][] arr;
    static int[][] dp;
    
    public static void main(String[] args) throws IOException {
        n = readInt();
        arr = new boolean[n][n];
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            String s = readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = s.charAt(j) == '#';
            }
        }
        long ans = 0;
        for (int j = 0; j < n; j++) {
            dp[n-1][j] = arr[n-1][j] ? 1 : 0;
        }
        for (int i = 0; i < n; i++) {
            dp[i][0] = arr[i][0] ? 1 : 0;
            dp[i][n-1] = arr[i][n-1] ? 1 : 0;
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 1; j < n - 1; j++) {
                if (arr[i][j]) dp[i][j] = Math.min(dp[i+1][j-1], Math.min(dp[i+1][j], dp[i+1][j+1])) + 1;
            }
        }
        for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) ans += dp[i][j];
        System.out.println(ans);
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
