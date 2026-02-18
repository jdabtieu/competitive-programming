import java.io.*;
import java.util.*;
public class ccoprep3p2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    public static void main(String[] args) throws IOException {
        int n = readInt(), L = readInt();
        int[] len = new int[n];
        for (int i = 0; i < n; i++) len[i] = readInt();
        long[] dp = new long[n];
        Arrays.fill(dp, Long.MAX_VALUE);
        long[] lsum = new long[n];
        lsum[0] = len[0];
        for (int i = 1; i < n; i++) lsum[i] = lsum[i-1] + len[i];
        
        dp[0] = (lsum[0] - L) * (lsum[0] - L);
        int prevj = 0;
        for (int i = 1; i < n; i++) {
            for (int j = prevj; j <= i; j++) {
                if (j == 0) {
                    long leng = i + lsum[i];
                    dp[i] = (leng - L) * (leng - L);
                    continue;
                }
                long leng = i - j + lsum[i] - lsum[j-1];
                long ans = dp[j-1] + (leng - L) * (leng - L);
                if (ans < dp[i]) {
                    dp[i] = ans;
                    prevj = j;
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
