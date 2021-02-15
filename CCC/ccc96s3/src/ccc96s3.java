import java.util.*;
import java.io.*;

public class ccc96s3 {
    /* 
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;

    public static void main(String[] args) throws IOException {
        for (int cases = readInt(); cases > 0; cases--) {
            int n = readInt(), k = readInt();
            System.out.println("The bit patterns are");
            for (String e : recurse(n, k)) {
                System.out.println(e);
            }
            System.out.println();
        }
    }
    
    static ArrayList<String> recurse(int n, int k) {
        if (n == 1 && k == 0) {
            ArrayList<String> tmp = new ArrayList<String>();
            tmp.add("0");
            return tmp;
        }
        if (n == 1 && k == 1) {
            ArrayList<String> tmp = new ArrayList<String>();
            tmp.add("1");
            return tmp;
        }
        ArrayList<String> nums = new ArrayList<String>();
        if (k > 0) {
            ArrayList<String> tmp = recurse(n-1,k-1);
            for (String e : tmp) {
                nums.add("1" + e);
            }
        }
        if (n > k) {
            ArrayList<String> tmp = recurse(n-1, k);
            for (String e : tmp) {
                nums.add("0" + e);
            }         
        }

        return nums;
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