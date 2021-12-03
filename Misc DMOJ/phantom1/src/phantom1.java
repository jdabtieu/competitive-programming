import java.io.*;
import java.util.*;
public class phantom1 {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    public static void main(String[] args) throws IOException {
        boolean[] primes = sieve(500);
        for (int n = readInt(); n > 0; n--) {
            int l = readInt(), r = readInt(), cnt = 0;
            for (int i = l; i < r; i++) {
                if (primes[i]) cnt++;
            }
            System.out.println(cnt);
        }
    }
    
    static boolean[] sieve(int lim) {
        boolean[] prime = new boolean[lim + 1];
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;
        for (int i = 2; i <= Math.sqrt(lim); i++) {
            if (prime[i]) {
                for (int j = i * i; j <= lim; j += i) {
                    prime[j] = false;
                }
            }
        }
        return prime;
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