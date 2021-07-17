import java.util.*;
import java.io.*;

public class tss17b {
    /* 
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    static int[] fun = new int[1414215];

    public static void main(String[] args) throws IOException {
        int n = readInt(), queries = readInt();
        for (int i = 0; i < n; i++) {
            long x = readLong(), y = readLong();
            int res = (int) Math.ceil(Math.sqrt(x * x + y * y));
            fun[res]++;
        }
        for (int i = 1; i < 1414215; i++) {
            fun[i] += fun[i-1];
        }
        
        for (int i = 0; i < queries; i++) {
            System.out.println(fun[readInt()]);
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