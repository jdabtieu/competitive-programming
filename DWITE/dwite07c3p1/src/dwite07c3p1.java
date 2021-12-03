import java.io.*;
import java.util.*;
public class dwite07c3p1 {
    /*
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 5; i++) {
            int cnt = 0, num = readInt(), prev = 0;
            for (int j = 2; j <= num; j++) {
                if (num % j == 0) {
                    if (prev != j) {
                        cnt++;
                        prev = j;
                    }
                    num /= j;
                    j--;
                }
            }
            System.out.println(cnt == 3 ? "valid" : "not");
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
