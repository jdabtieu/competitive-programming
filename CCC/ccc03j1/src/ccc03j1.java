import java.io.*;
import java.util.*;

public class ccc03j1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;

    public static void main(String[] args) throws IOException {
        int t = readInt(), s = readInt(), h = readInt();
        for (int i = 0; i < t; i++) {
            System.out.print("*");
            for (int j = 0; j < s; j++) {
                System.out.print(" ");
            }
            System.out.print("*");
            for (int j = 0; j < s; j++) {
                System.out.print(" ");
            }
            System.out.print("*");
            System.out.println();
        }
        for (int i = 0; i < 2*s+3; i++) {
            System.out.print("*");
        }
        System.out.println();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < s+1; j++) {
                System.out.print(" ");
            }
            System.out.print("*");
            System.out.println();
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
