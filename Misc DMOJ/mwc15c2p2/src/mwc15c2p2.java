import java.util.*;
import java.io.*;

public class mwc15c2p2 {
    /* 
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;

    public static void main(String[] args) throws IOException {
        Stack<Tower> stack = new Stack();
        stack.add(new Tower(Integer.MAX_VALUE, 1));
        int count = readInt();
        for (int i = 1; i <= count; i++) {
            int curr = readInt();
            while (stack.peek().height <= curr) stack.pop();
            System.out.print((i - stack.peek().index) + " ");
            stack.push(new Tower(curr, i));
        }
    }
    
    static class Tower {
        int height, index;
        public Tower (int a, int b) {
            height = a; index = b;
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