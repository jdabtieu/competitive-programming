import java.io.*;
import java.util.*;
public class usaco19jans3 {
    /*
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    public static void main(String[] args) throws IOException {
        int n = readInt();
        TreeMap<Integer, Integer> m = new TreeMap<>();
        while (n-- > 0) {
            int x = readInt(), y = readInt();
            m.put(x - y, Math.max(m.getOrDefault(x - y, 0), x + y));
        }
        int cnt = 0, r = 0;
        for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
            if (entry.getValue() > r) {
                r = entry.getValue();
                cnt++;
            }
        }
        System.out.println(cnt);
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
