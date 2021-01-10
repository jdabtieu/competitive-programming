import java.util.*;
import java.io.*;

public class ccc10s2 {
    /* 
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;

    public static void main(String[] args) throws IOException {
        int letters = readInt();
        Map<String, Character> map = new TreeMap<String, Character>();
        for (int i = 0; i < letters; i++) {
            char val = readChar();
            map.put(next(), val);
        }
        String res = "";
        String toDecode = readLine();
        while (!toDecode.equals("")) {
            for (int i = 1; i <= toDecode.length(); i++) {
                if (map.containsKey(toDecode.substring(0, i))) {
                    res += map.get(toDecode.substring(0, i));
                    toDecode = toDecode.substring(i);
                    break;
                }
            }
        }
        System.out.println(res);
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