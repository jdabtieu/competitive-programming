import java.io.*;
import java.util.*;
public class dmopc21c2p3 {
    /*
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    public static void main(String[] args) throws Exception {
        for (int cases = readInt(); cases > 0; cases--) {
            print(0);
            int ops = readInt(), len = ops - 1;
            if (ops == 0) continue;
            long guess = (1L << len) + (new Random().nextLong() & ((1L << len) - 1));
            while (true) {
                print(guess);
                ops = readInt() / 2;
                if (ops == 0) break;
                guess ^= 1L << (ops - 1);
            }
        }
    }
    
    static void print(long e) {
        System.out.println(e);
        System.out.flush();
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
