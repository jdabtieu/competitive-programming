import java.util.*;
import java.io.*;

public class dwite06c5p5 {
    /* 
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static boolean[] prime = new boolean[1000001];
    // 0-10000
    
    static void sieve() {
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;
        for (int i = 2; i <= Math.sqrt(1000000); i++) {
            if (prime[i]) {
                for (int j = i * i; j <= 1000000; j += i) {
                    prime[j] = false;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        sieve();
        
        
        int[] psa = new int[1000001];
        for (int i = 0; i < 1000001; i++) {
            String num = Integer.toString(i);
            String reversed = new StringBuilder(num).reverse().toString();
            if (prime[i] && num.equals(reversed)) psa[i] = 1;
        }
        for (int i = 1; i < 1000001; i++) {
            psa[i] += psa[i-1];
        }
        
        int q = 5;
        for (int i = 0; i < q; i++) {
            int left = readInt() - 1, right = readInt();
            if (left == -1) System.out.println(psa[right]);
            else System.out.println(psa[right] - psa[left]);
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