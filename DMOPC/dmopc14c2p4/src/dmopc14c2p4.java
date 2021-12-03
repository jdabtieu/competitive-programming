import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class dmopc14c2p4 {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    public static void main(String[] args) throws IOException {
        int n = readInt();
        int[] psa = new int[n];
        for (int i = 0; i < n; i++) {
            psa[i] = readInt();
        }
        for (int i = 1; i < n; i++) {
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