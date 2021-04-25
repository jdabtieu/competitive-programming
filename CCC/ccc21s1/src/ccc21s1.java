import java.util.*;
import java.io.*;

public class ccc21s1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;

    public static void main(String[] args) throws IOException {
        int pieces = readInt();
        int[] h = new int[pieces + 1];
        for (int i = 0; i < pieces + 1; i++) h[i] = readInt();
        int area = 0;
        for (int i = 0; i < pieces; i++) {
            area += readInt() * (h[i] + h[i+1]);
        }
        if ((area & 1) == 1) System.out.printf("%.1f", area / 2.0);
        else System.out.println(area / 2);
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