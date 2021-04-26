import java.util.*;
import java.io.*;

public class dmopc20c5p2 {
    /* 
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;

    public static void main(String[] args) throws IOException {
        int y = readInt(), x = readInt();
        int reps = gcf(x, y);
        y /= reps; x /= reps;
        
        ArrayList<Pair> arr = new ArrayList<Pair>();
        for (int i = 0; i < x; i++) {
            double left = (double) i * y / x + 1;
            double right = (double) (i + 1) * y / x + 1;
            for (int j = (int) left; j < right; j++) {
                arr.add(new Pair(j, (i + 1)));
            }
        }
        System.out.println((x + y - 1) * reps);
        for (int i = 0; i < reps; i++) {
            for (Pair p : arr) {
                System.out.println((i * y + p.y) + " " + (i * x + p.x));
            }
        }
    }
    
    static class Pair {
        int x, y;
        public Pair(int b, int a) {
            x = a; y = b;
        }
    }
    
    static int gcf(int x, int y) {
        int p = 1;
        for (int i = 2; i <= Math.min(x, y); i++) {
            if (x % i == 0 && y % i == 0) p = i;
        }
        return p;
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