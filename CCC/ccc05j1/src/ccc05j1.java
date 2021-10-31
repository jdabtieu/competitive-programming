import java.io.*;
import java.util.*;

public class ccc05j1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;

    public static void main(String[] args) throws IOException {
        int d = readInt(), e = readInt(), w = readInt();
        int planA = 0, planB = 0;
        
        if (d > 100) {
            planA += (d - 100) * 25;
        }
        planA += 15 * e;
        planA += 20 * w;
        
        if (d > 250) {
            planB += (d - 250) * 45;
        }
        planB += 35 * e;
        planB += 25 * w;
        
        System.out.println("Plan A costs " + planA/100.0);
        System.out.println("Plan B costs " + planB/100.0);
        if (planA < planB) {
            System.out.println("Plan A is cheapest.");
        } else if (planA == planB) {
            System.out.println("Plan A and B are the same price.");
        } else {
            System.out.println("Plan B is cheapest.");
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
