import java.util.*;
import java.io.*;

public class ccc21s3 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;

    public static void main(String[] args) throws IOException {
        int n = readInt();
        int[] pos = new int[n], speed = new int[n], range = new int[n];
        int maxP = 0;
        for (int i = 0; i < n; i++) {
            pos[i] = readInt();
            speed[i] = readInt();
            range[i] = readInt();
            if (pos[i] > maxP) maxP = pos[i];
        }
        long least = Long.MAX_VALUE;
        int LBOUND = 0, RBOUND = maxP;
        
        while (RBOUND - LBOUND > 50) {
            long mid = ((long) RBOUND + LBOUND) / 2;
            
            long tmp = 0;
            for (int j = 0; j < n; j++) {
                if (pos[j] > mid) {
                    long t = pos[j] - range[j];
                    if (t > mid) tmp += (t - mid) * speed[j];
                } else {
                    long t = pos[j] + range[j];
                    if (t < mid) tmp += (mid - t) * speed[j];
                }
            }
            
            long midR = mid + 1, tmpR = 0;
            for (int j = 0; j < n; j++) {
                if (pos[j] > midR) {
                    long t = pos[j] - range[j];
                    if (t > midR) tmpR += (t - midR) * speed[j];
                } else {
                    long t = pos[j] + range[j];
                    if (t < midR) tmpR += (midR - t) * speed[j];
                }
            }
            
            if (tmp < tmpR) RBOUND = (int) mid;
            else LBOUND = (int) midR;
        }
        
        
        
        for (int i = LBOUND; i <= RBOUND; i++) {
            long tmp = 0;
            for (int j = 0; j < n; j++) {
                if (pos[j] > i) {
                    long t = pos[j] - range[j];
                    if (t > i) tmp += (t - i) * speed[j];
                } else {
                    long t = pos[j] + range[j];
                    if (t < i) tmp += (i - t) * speed[j];
                }
            }
            if (tmp < least) least = tmp;
        }
        System.out.println(least);
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