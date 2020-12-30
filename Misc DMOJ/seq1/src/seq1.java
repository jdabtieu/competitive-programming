import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class seq1 {
    /* 
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;

    public static void main(String[] args) throws IOException {
        BigInteger n = new BigInteger("2");
        n = n.modPow(new BigInteger(next()).add(new BigInteger("3")), new BigInteger("1000000007"));
        n = n.subtract(new BigInteger("5"));
        if (n.compareTo(BigInteger.ZERO) < 0) n = n.add(new BigInteger("1000000007"));
        System.out.println(n);
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