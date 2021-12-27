import java.io.*;
import java.util.*;
public class usaco19decbronze2 {
    /*
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    public static void main(String[] args) throws IOException {
        int n = readInt();
        String s = readLine();
        for (int i = 1; i <= n; i++) {
            Set<String> set = new HashSet<>();
            boolean flag = true;
            for (int j = 0; j <= n - i; j++) {
                if (set.contains(s.substring(j, j+i))) {
                    flag = false;
                    break;
                }
                set.add(s.substring(j, j+i));
            }
            if (flag) {
                System.out.println(i);
                return;
            }
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
