import java.io.*;
import java.util.*;
public class ccc10s3 {
    /*
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    public static void main(String[] args) throws IOException {
        int h = readInt();
        int[] pos = new int[2*h];
        for (int i = 0; i < h; i++) pos[i] = readInt();
        Arrays.sort(pos);
        for (int i = h; i < 2*h; i++) {
            pos[i-h] = pos[i];
            pos[i] += 1000000;
        }
        int f = readInt();
        
        int lo = 0, hi = 1000000;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            int ans = 5000;
            for (int start = 0; start < h; start++) {
                int cnt = 1, sp = pos[start], clen = 0;
                for (int i = start + 1; i < start + h; i++) {
                    if (clen + pos[i] - pos[i - 1] <= mid) clen = clen + pos[i] - pos[i - 1];
                    else {
                        sp = pos[i];
                        clen = 0;
                        cnt++;
                    }
                }
                ans = Math.min(ans, cnt);
            }
            if (ans > f) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        System.out.println((lo + 1) / 2);
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
