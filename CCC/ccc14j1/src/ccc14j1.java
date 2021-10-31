import java.io.*;
import java.util.*;

public class ccc14j1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;

    public static void main(String[] args) throws IOException {
        int a = readInt(), b = readInt(), c = readInt();
        if (a + b + c != 180) {
            // how can we check if they don't add to 180
            System.out.println("Error");
        } else if (a != b && a != c && b != c) {
            System.out.println("Scalene");
        } else if (a == 60 && b == 60 && c == 60) {
            System.out.println("Equilateral");
        } else {
            System.out.println("Isosceles");
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
