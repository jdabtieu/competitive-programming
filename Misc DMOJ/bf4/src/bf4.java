import java.util.*;
import java.io.*;

public class bf4 {
	/*
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;

    static final long MMOD = 1125899839733759L;
    static final int PRIME = 7507;
    static int ll;
    static long hash = 0;

    static long hash1 = 0;
    
    static String small, big;

    public static void main(String[] args) throws IOException {
        big = readLine();
        small = readLine();
        ll = small.length();
        long power = 1;
        for (int i = 0; i < ll; i++) power = power * PRIME % MMOD;
        for (int i = 0; i < ll; i++) {
            hash1 = (hash1 * PRIME + small.charAt(i) - 'a') % MMOD;
            hash = (hash * PRIME + big.charAt(i) - 'a') % MMOD;
        }
        if (hash == hash1) {
            System.out.println(0);
            return;
        }
        for (int i = ll; i < big.length(); i++) {
            hash = (hash * PRIME + big.charAt(i) - 'a') % MMOD;
            hash -= (big.charAt(i - ll) - 'a') * power % MMOD;
            if (hash < 0) hash += MMOD;
            if (hash == hash1) {
                System.out.println(i - ll + 1);
                return;
            }
        }
        System.out.println(-1);
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