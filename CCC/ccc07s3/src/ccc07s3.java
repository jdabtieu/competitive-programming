import java.util.*;
import java.io.*;

public class ccc07s3 {
    /* 
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;

    public static void main(String[] args) throws IOException {
        int students = readInt();
        int[] graph = new int[10000];
        for (int i = 0; i < students; i++) {
            int src = readInt(), dest = readInt();
            graph[src] = dest;
        }
        int src = readInt(), dest = readInt();
        while (src != 0) {
            int separation = 0;
            int curr = src;
            while (true) {
                int child = graph[curr];
                if (child == dest) break;
                if (child == src || child == 0) {
                    separation = -1;
                    break;
                }
                curr = child;
                separation++;
            }
            if (separation == -1) {
                System.out.println("No");
            } else {
                System.out.println("Yes " + separation);
            }
            
            src = readInt();
            dest = readInt();
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