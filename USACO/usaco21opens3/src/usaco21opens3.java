import java.io.*;
import java.util.*;
public class usaco21opens3 {
    /*
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    public static void main(String[] args) throws IOException {
        int n = readInt(), surveys = readInt(), lim = readInt();
        int[] papers = new int[n];
        for (int i = 0; i < n; i++) papers[i] = readInt();
        Arrays.sort(papers);
        int lo = 0, hi = 100000;
        while (lo < hi) {
            int ss = surveys;
            int mid = (lo + hi + 1) / 2;
            long sum = 0;
            for (int i = n - 1; i >= Math.max(0, n - mid); i--) {
                sum += Math.min(mid, papers[i]);
            }
            if (sum + (long) surveys * lim < (long) mid * mid) {
                hi = mid - 1;
                continue;
            }
            boolean flag = false;
            for (int i = n - 1; i >= Math.max(0, n - mid); i--) {
                if (papers[i] + surveys < mid) {
                    hi = mid - 1;
                    flag = true;
                    break;
                }
            }
            
            if (flag) hi = mid - 1;
            else lo = mid;
        }
        System.out.println(lo);
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
