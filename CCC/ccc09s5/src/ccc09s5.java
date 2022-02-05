import java.io.*;
import java.util.*;
public class ccc09s5 {
    /*
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    public static void main(String[] args) throws IOException {
        int m = readInt(), n = readInt(), k = readInt();
        int[][] arr = new int[n+2][m+2];
        for (int i = 0; i < k; i++) {
            int x = readInt(), y = readInt(), r = readInt(), b = readInt();
            for (int j = Math.max(1, x - r); j <= Math.min(n, x + r); j++) {
                double dy = Math.sqrt(r * r - (x - j) * (x - j));
                int staY = (int) Math.ceil(y - dy);
                int endY = (int) (Math.floor(y + dy) + 1);
                arr[j][Math.max(0, staY)] += b;
                arr[j][Math.min(m + 1, endY)] -= b;
            }
        }
        int maxbr = -1, cnt = 0;
        for (int i = 1; i <= n; i++) {
            int tot = 0;
            for (int j = 0; j <= m; j++) {
                tot += arr[i][j];
                if (j != 0 && tot > maxbr) {
                    maxbr = tot;
                    cnt = 1;
                } else if (j != 0 && tot == maxbr) {
                    cnt++;
                }
            }
        }
        System.out.println(maxbr);
        System.out.println(cnt);
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
