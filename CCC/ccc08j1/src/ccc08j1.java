import java.io.*;
import java.util.*;

public class ccc08j1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;

    public static void main(String[] args) throws IOException {
        double w = readDouble(), h = readDouble();
        double bmi = w/(h*h);
        // w/Math.pow(h, 2);
        if (bmi > 25) {
            System.out.println("Overweight");
        } else if (bmi < 18.5) {
            System.out.println("Underweight");
        } else {
            System.out.println("Normal weight");
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
