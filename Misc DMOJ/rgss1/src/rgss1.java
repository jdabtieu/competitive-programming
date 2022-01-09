import java.io.*;
import java.util.*;
public class Main {
    /*
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    public static void main(String[] args) throws IOException {
        int a = readInt(), b = readInt(), c = readInt();
        boolean[] dp = new boolean[c+1];
        dp[a] = true;
        dp[b] = true;
        for (int i = 0; i < c; i++) {
            if (dp[i]) {
                if (i + a <= c) dp[i+a] = true;
                if (i + b <= c) dp[i+b] = true;
            }
        }
        for (int i = c; i >= 0; i--) {
            if (dp[i]) {
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
