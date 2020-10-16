import java.util.*;
import java.io.*;

public class ioi05p2 {
    /* 
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;

    public static void main(String[] args) throws IOException {
        int nums = readInt();
        int a = readInt(), b;
        int upperBound = a, lowerBound = Integer.MIN_VALUE;
        
        int co = 0;
        
        for (int i = 1; i < nums; i++) {
            b = readInt();
            /*
             * a + a - co (i % 2 == 0 ? + x : - x) <= b
             * if i % 2 == 0:
             *     int tmp = b - (a + a - co)
             *     if tmp < upperBound -> upperBound = tmp
             * else:
             *     int tmp = a + a - co - b
             *     if tmp > lowerBound -> lowerBound = tmp
             * if upperBound < lowerBound:
             *     print 0 and return
             * co = a + a - co
             */
            if (i % 2 == 0) {
                int tmp = b - a - a + co;
                if (tmp < upperBound) upperBound = tmp;
            } else {
                int tmp = a + a - co - b;
                if (tmp > lowerBound) lowerBound = tmp;
            }
            if (upperBound < lowerBound) {
                System.out.println(0);
                System.exit(0);
            }
            co = a + a - co;
            a = b;
        }
        System.out.println(upperBound - lowerBound + 1);
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
}