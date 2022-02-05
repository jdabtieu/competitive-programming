import java.io.*;
import java.util.*;
public class dpz {
    /*
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    static int[] h;
    static long[] dp;
    
    static double f(int j, int k) {
        return (dp[k] - dp[j] + (long) h[k] * h[k] - (long) h[j] * h[j]) / (2.0 * (h[k] - h[j]));
    }
    
    public static void main(String[] args) throws IOException {
        int n = readInt();
        long c = readLong();
        h = new int[n+1];
        dp = new long[n+1];
        for (int i = 1; i <= n; i++) h[i] = readInt();
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[1] = 0;
        Deque<Integer> q = new LinkedList<>();
        q.add(1);
        for (int i = 2; i <= n; i++) {
            while (q.size() > 1) {
                Iterator<Integer> it = q.iterator();
                int j = it.next();
                int k = it.next();
                if (f(j, k) <= h[i]) q.poll();
                else break;
            }
            int j = q.peek();
            dp[i] = dp[j] + ((long) h[i] - h[j]) * (h[i] - h[j]) + c;
            while (q.size() > 1) {
                Iterator<Integer> it = q.descendingIterator();
                int b = it.next();
                int a = it.next();
                if (f(a, b) >= f(b, i)) q.pollLast();
                else break;
            }
            q.add(i);
            
        }
        System.out.println(dp[n]);
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
