import java.util.*;
import java.io.*;

public class ccc21s1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;

    public static void main(String[] args) throws IOException {
        int rows = readInt(), cols = readInt();
        boolean[] rowL = new boolean[rows + 1];
        boolean[] colL = new boolean[cols + 1];
        for (int cases = readInt(); cases > 0; cases--) {
            char inst = readChar();
            int n = readInt();
            if (inst == 'R') rowL[n] = !rowL[n];
            else colL[n] = !colL[n];
        }
        // 1 0 or 0 1
        int count = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (rowL[i] ^ colL[j]) count++;
            }
        }
        System.out.println(count);
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
