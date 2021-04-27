import java.util.*;
import java.io.*;

public class vmss7wc15c2p3 {
    /* 
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;

    public static void main(String[] args) throws IOException {
        Stack<Tower> s = new Stack();
        int num = readInt();
        long count = 0;
        for (int i = 0; i < num; i++) {
            long curr = readLong();
            Tower prev;
            Tower cur = new Tower(curr, 1);
            while (true) {
                if (s.isEmpty()) break;
                prev = s.peek();
                if (curr > prev.height) {
                    s.pop();
                    count += prev.occur;
                } else if (curr == prev.height) {
                    while (!s.isEmpty() && s.peek().height == curr) {
                        prev = s.pop();
                        cur.occur += prev.occur;
                        count += prev.occur;
                    }
                } else {
                    count++;
                    break;
                }
            }
            s.push(cur);
        }
        System.out.println(count);
    }
    
    static class Tower {
        long height, occur;
        public Tower (long a, long b) {
            height = a; occur = b;
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