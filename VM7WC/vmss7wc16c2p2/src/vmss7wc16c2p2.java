import java.io.*;
import java.util.*;
public class vmss7wc16c2p2 {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    public static void main(String[] args) throws IOException {
        String s = readLine();
        int[] psa = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'G') psa[i] = 1;
        }
        for (int i = 1; i < s.length(); i++) {
            psa[i] += psa[i-1];
        }
        int q = readInt();
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