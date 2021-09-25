import java.io.*;
import java.util.*;
public class oly21practice65 {
    /*
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    public static void main(String[] args) throws IOException {
        int q = readInt(), s = 0;
        int[] p = new int[q];
        for (int i = 0; i < q; i++) {
            p[i] = readInt();
            s += p[i];
        }
        boolean[][] dp = new boolean[q][s+1];
        dp[0][0] = true;
        dp[0][p[0]] = true;
        for (int i = 1; i < q; i++) {
            for (int j = s; j >= 0; j--) {
                dp[i][j] = dp[i-1][j];
                if (dp[i][j] && j + p[i] <= s) {
                    dp[i][j+p[i]] = true;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i <= s; i++) if (dp[q-1][i]) ans++;
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
