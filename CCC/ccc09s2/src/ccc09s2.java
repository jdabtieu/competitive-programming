import java.util.*;
import java.io.*;

public class ccc09s2 {
    /* 
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;

    public static void main(String[] args) throws IOException {
        int rows = readInt(), lights = readInt();
        int[] tbl = new int[rows];
        for (int i = 0; i < rows; i++) for (int j = 0; j < lights; j++) {
            tbl[i] <<= 1;
            tbl[i] += readInt();
        }
        Set<Integer> set = new HashSet();
        for (int i = 1; i <= rows; i++) {
            int[] tmp = tbl.clone();
            for (int j = i; j < rows; j++) {
                tmp[j] ^= tmp[j - 1];
            }
            set.add(tmp[rows - 1]);
        }
        System.out.println(set.size());
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