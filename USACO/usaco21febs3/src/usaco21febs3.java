import java.util.*;
import java.io.*;

public class usaco21febs3 {
    /* 
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;

    static final int MMOD = 1000000007;
    
    static int[][] grid;
    static int size;

    public static void main(String[] args) throws IOException {
        size = readInt();
        grid = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = readInt();
            }
        }
        System.out.println(fun(100) - fun(101));
    }
    
    static long fun(int min) {
        long ans = 0;
        int[][] g = new int[size][size];
        for (int j = 0; j < size; j++) {
            g[0][j] = grid[0][j] < min ? 0 : 1;
        }
        for (int i = 1; i < size; i++) {
            for (int j = 0; j < size; j++) {
                g[i][j] = grid[i][j] < min ? 0 : g[i-1][j] + 1;
            }
        }
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int last = Integer.MAX_VALUE;
                for (int k = j; k >= 0; k--) {
                    last = Math.min(last, g[i][k]);
                    ans += last;
                }
            }
        }
        
        return ans;
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