import java.io.*;
import java.util.*;

public class ccc01j1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;

    public static void main(String[] args) throws IOException {
        int size = readInt();
        for (int i = 1; i < (size+1)/2; i++) {
            for (int j = 0; j < i * 2 - 1; j++) {
                System.out.print("*");
            }
            for (int j = 0; j < 2*size-4*i+2; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i * 2 - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = (size+1)/2; i >= 1; i--) {
            for (int j = 0; j < i * 2 - 1; j++) {
                System.out.print("*");
            }
            for (int j = 0; j < 2*size-4*i+2; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i * 2 - 1; j++) {
                System.out.print("*");
            }
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
