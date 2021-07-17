import java.util.*;
import java.io.*;

public class oly21practice50 {
    /* 
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;

    public static void main(String[] args) throws IOException {
        int n = readInt();
        int[] sieve = new int[1000001];
        int[] nums = new int[n];
        HashMap<Integer, Integer> map = new HashMap();
        
        for (int i = 0; i < n; i++) {
            int k = readInt();
            nums[i] = k;
            map.put(k, map.getOrDefault(k, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            for (int i = entry.getKey(); i <= 1000000; i += entry.getKey()) {
                sieve[i] += entry.getValue();
            }
        }
        for (int num : nums) {
            System.out.println(sieve[num] - 1);
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