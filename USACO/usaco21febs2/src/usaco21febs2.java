import java.util.*;
import java.io.*;

public class usaco21febs2 {
    /* 
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;

    static final int MMOD = 1000000007;

    public static void main(String[] args) throws IOException {
        int n = readInt(), k = readInt();
        Integer[] years = new Integer[n+1];
        years[0] = 0;
        for (int i = 1; i <= n; i++) {
            years[i] = (readInt() + 11) / 12;
        }
        Arrays.sort(years, Collections.reverseOrder());
        int last = years[0];
        
        Integer[] gaps = new Integer[n];
        for (int i = 0; i < n; i++) {
            gaps[i] = years[i] - years[i+1] - 1;
        }
        Arrays.sort(gaps, Collections.reverseOrder());
        for (int i = 0; i < k - 1 && gaps[i] > 0; i++) {
            last -= gaps[i];
        }
        System.out.println(last * 12);
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