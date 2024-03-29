import java.io.*;
import java.util.*;
public class phantom2 {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;

    static int[] psa = new int[1000001];
    public static void main(String[] args) throws IOException {
        sieve(1000000);
        for (int n = readInt(); n > 0; n--) {
            int l = readInt(), r = readInt();
            System.out.println(psa[r - 1] - psa[l - 1]);
        }
    }
    
    static void sieve(int lim) {
        Arrays.fill(psa, 1);
        psa[0] = 0;
        psa[1] = 0;
        for (int i = 2; i <= Math.sqrt(lim); i++) {
            if (psa[i] == 1) {
                for (int j = i * i; j <= lim; j += i) {
                    psa[j] = 0;
                }
            }
        }
        for (int i = 3; i <= 1000000; i++) {
            psa[i] += psa[i - 1];
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