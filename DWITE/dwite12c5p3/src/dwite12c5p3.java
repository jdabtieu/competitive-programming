import java.io.*;
import java.util.*;
public class dwite12c5p3 {
    /*
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    static int n;
    static int[][] psa;
    
    public static void main(String[] args) throws IOException {
    for (int cases = 0; cases < 5; cases++) {
        n = readInt();
        psa = new int[n][n];
        for (int i = 0; i < n; i++) {
            String s = readLine();
            for (int j = 0; j < n; j++) {
                psa[i][j] = s.charAt(j) == '#' ? 1 : 0;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                psa[i][j] += psa[i][j-1];
            }
        }
        
        long ans = 0;
        for (int i = 0; i < n; i++) {
            if (psa[i][0] == 1) ans++;
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (psa[i][j] - psa[i][j-1] == 1) ans += cnt(i, j, 0);
            }
        }
        System.out.println(ans);
    }
    }
    
    static long cnt(int centeri, int centerj, int width) {
        int ret = 1;
        int newWidth = width + 1;
        if (centeri == n - 1) return ret;
        if (centerj + newWidth < n && centerj - newWidth >= 0) {
            int tmp = centerj - newWidth == 0 ? 0 : psa[centeri + 1][centerj - newWidth - 1];
            if (psa[centeri + 1][centerj + newWidth] - tmp == newWidth * 2 + 1) ret += cnt(centeri + 1, centerj, newWidth);
        }
        return ret;
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
