import java.util.*;
import java.io.*;

public class usaco21openb2 {
    /* 
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;

    static final int MMOD = 1000000007;

    public static void main(String[] args) throws IOException {
        int papers = readInt(), n = readInt();
        HashMap<String, Integer> ppl = new HashMap();
        char[][] ans = new char[n][n];
        for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) ans[i][j] = '?';
        for (int i = 0; i < n; i++) ans[i][i] = 'B';
        for (int i = 0; i < n; i++) {
            ppl.put(next(), i);
        }
        while (papers-- > 0) {
            String[] tokens = br.readLine().split(" ");
            for (int i = 0; i < tokens.length; i++) {
                boolean bad = false;
                int pi = ppl.get(tokens[i]);
                for (int j = i + 1; j < tokens.length; j++) {
                    if (tokens[j-1].compareTo(tokens[j]) > 0) bad = true;
                    if (bad) {
                        int pj = ppl.get(tokens[j]);
                        ans[pi][pj] = '0';
                        ans[pj][pi] = '1';
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) System.out.println(ans[i]);
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