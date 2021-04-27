import java.util.*;
import java.io.*;

public class wc96p5 {
    /* 
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;

    public static void main(String[] args) throws IOException {
        int width = readInt(), height = readInt();
        int[][] path = new int[width+1][height+1];
        while (true) {
            int x = readInt(), y = readInt();
            if (x == 0) break;
            path[x][y] = 1;
        }
        for (int i = 1; i <= width; i++) {
            for (int j = 1; j <= height; j++) {
                path[i][j] = Math.max(path[i-1][j], path[i][j-1]) + path[i][j];
            }
        }
        System.out.println(path[width][height]);
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