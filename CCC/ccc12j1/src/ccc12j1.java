import java.io.*;
import java.util.*;

public class ccc12j1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;

    public static void main(String[] args) throws IOException {
        int limit = readInt(), speed = readInt();
        
        // how to check driver is within speed limit
        if (speed <= limit) {
            System.out.println("Congratulations, you are within the speed limit!");
        } else if (speed <= limit + 20) {
            System.out.println("You are speeding and your fine is $100.");
        } else if (speed <= limit + 30) {
            System.out.println("You are speeding and your fine is $270.");
        } else {
            System.out.println("You are speeding and your fine is $500.");
        }
        
        // how to check if driver is <=20km/h over the limit?
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
