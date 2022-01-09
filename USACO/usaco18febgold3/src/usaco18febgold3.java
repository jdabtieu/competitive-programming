import java.io.*;
import java.util.*;
public class usaco18febgold3 {
    /*
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    public static void main(String[] args) throws IOException {
        int n = readInt();
        int[] a = new int[n+1];
        for (int i = 1; i <= n; i++) a[i] = readInt();
        
        int[][] wrong = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            wrong[i][i] = a[i] == 0 ? 0 : 1;
            for (int j = i + 1; j <= n; j++) {
                wrong[i][j] = wrong[i][j-1];
                wrong[i][j] += a[j] == j - i ? 0 : 1;
            }
        }
        
        int[][] dp = new int[n+1][n+1];
        for (int i = 0; i <= n; i++) Arrays.fill(dp[i], 1000);
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int k = 1; k <= i; k++) {
                for (int j = 0; j < i; j++) {
                    dp[i][k] = Math.min(dp[i][k], dp[j][k-1] + wrong[j+1][i]);
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            System.out.println(dp[n][i]);
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
