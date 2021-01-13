import java.util.*;
import java.io.*;

public class ccc14s3 {
    /* 
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;

    public static void main(String[] args) throws IOException {
        for (int cases = readInt(); cases > 0; cases--) {
            boolean flag = true;
            int cars = readInt();
            Stack<Integer> top = new Stack<Integer>(), side = new Stack<Integer>();
            for (int i = 0; i < cars; i++) top.push(readInt());
            int i = 1;
            while (!top.empty() || !side.empty()) {
                if (!side.empty() && side.peek() == i) {
                    side.pop();
                    i++;
                } else {
                    while (!top.empty() && top.peek() != i) {
                        side.add(top.pop());
                    }
                    if (top.empty()) {
                        flag = false;
                        break;
                    } else {
                        top.pop();
                        i++;
                    }
                }
            }
            System.out.println(flag ? "Y" : "N");
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
