import java.util.*;
import java.io.*;

public class canada21p1 {
    /* 
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    static int[] red = new int[750005];
    static int[] whi = new int[750005];
    static int[] ansa = new int[750005];

    public static void main(String[] args) throws IOException {
        ansa[0] = Integer.MAX_VALUE;
        int cases = readInt();
        while (cases-- > 0) {
            int len = readInt(); String str = readLine();
            for (int i = 0; i < len; i++) {
                red[i+1] = red[i];
                whi[i+1] = whi[i];
                if (str.charAt(i) == 'R') red[i+1]++;
                else whi[i+1]++;
            }
            
            for (int i = 1; i < len; i++) {
                ansa[i] = Math.min(ansa[i-1], whi[i] - red[i]);
            }

            int ansb = 100000;
            int b = 10000;
            for (int i = 2; i < len; i++) {
                int mb = red[i] - whi[i];
                if (ansa[i-1] + mb <= ansa[b-1] + ansb) {
                    b = i;
                    ansb = mb;
                }
            }
            System.out.println(whi[len] + ansa[b-1] + ansb);
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