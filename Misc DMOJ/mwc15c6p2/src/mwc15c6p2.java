import java.io.*;
import java.util.*;

public class mwc15c6p2 {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
    static boolean[] prime = new boolean[10001];
    // 0-10000
    
    static void sieve() {
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;
        for (int i = 2; i <= Math.sqrt(10000); i++) {
            if (prime[i]) {
                for (int j = i * i; j <= 10000; j += i) {
                    prime[j] = false;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        sieve();
        
        
        int q = readInt();
        for (int i = 0; i < q; i++) {
            int right = readInt();
            boolean ans = false;
            for (int j = right - 1; j > 0; j--) {
                if (prime[j]) {
                    System.out.println(j);
                    ans = true;
                    break;
                }
            }
            if (ans == false) {
                System.out.println("no can do");
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