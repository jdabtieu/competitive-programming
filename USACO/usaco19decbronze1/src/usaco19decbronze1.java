import java.io.*;
import java.util.*;
public class usaco19decbronze1 {
    /*
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    public static void main(String[] args) throws IOException {
        int k = readInt(), n = readInt();
        int[][] p = new int[k][n+1];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                p[i][readInt()] = j;
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                boolean flag = true;
                for (int l = 0; l < k; l++) {
                    if (p[l][i] >= p[l][j]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) ans++;
            }
        }
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
