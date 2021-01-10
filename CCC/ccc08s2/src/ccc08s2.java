import java.util.*;
import java.io.*;

public class ccc08s2 {
    /* 
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;

    public static void main(String[] args) throws IOException {
        int r = readInt();
        while (r != 0) {
            int r2 = r * r;
            int total = 4 * r + 1;
            for (int i = 1; i < r; i++) {
                total += 4 * ((int) Math.sqrt(r2 - i * i));
            }
            System.out.println(total);
            r = readInt();
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