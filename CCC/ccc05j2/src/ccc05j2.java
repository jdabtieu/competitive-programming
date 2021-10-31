import java.io.*;
import java.util.*;

public class ccc05j2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;

    public static void main(String[] args) throws IOException {
        int a = readInt(), b = readInt();
        int ans = 0;
        for (int n = a; n <= b; n++) {
            if (((int) Math.sqrt(n)) * (int) Math.sqrt(n) == n) continue;
            int cnt = 0;
            for (int i = 1; i < Math.sqrt(n); i++) {
                if (n % i == 0) cnt++;
            }
            if (cnt == 2) ans++;
        }
        System.out.println("The number of RSA numbers between " + a + " and " + b + " is " + ans);
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
