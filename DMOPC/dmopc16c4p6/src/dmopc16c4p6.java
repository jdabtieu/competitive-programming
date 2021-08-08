import java.util.*;
import java.io.*;

public class dmopc16c4p6 {
    /* 
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;

    static final int MMOD = 1000001;

    public static void main(String[] args) throws IOException {
        int build = readInt(), drone = readInt();
        long[] ans = new long[MMOD];
        int[] h = new int[MMOD];
        h[0] = -1;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i <= build; i++) {
            h[i] = readInt();
            while (h[stack.peek()] > h[i]) {
                int idx = stack.pop();
                ans[h[idx]] += (long) (idx - stack.peek()) * (i - idx);
            }
            stack.push(i);
        }
        
        while (stack.size() > 1) {
            int idx = stack.pop();
            ans[h[idx]] += (long) (idx - stack.peek()) * (build + 1 - idx);
        }
        
        for (int i = 1; i < MMOD; i++) {
            ans[i] += ans[i - 1];
        }
        
        for (int i = 0; i < drone; i++) {
            System.out.println(-ans[readInt() - 1] + ans[readInt()]);
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