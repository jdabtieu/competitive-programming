import java.util.*;
import java.io.*;

public class usaco21openb1 {
    /* 
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;

    static final int MMOD = 1000000007;

    public static void main(String[] args) throws IOException {
        int n = readInt(), l = readInt();
        int[] cnt = new int[100001];
        for (int i = 0; i < n; i++) cnt[readInt()]++;
        for (int i = 100000, s = 0; i > 0; i--) {
            s += cnt[i];
            if (s + Math.min(l, cnt[i-1]) >= i) {
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
