import java.io.*;
import java.util.*;
public class dmopc18c5p0 {
    /*
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    public static void main(String[] args) throws IOException {
        String mode = readLine();
        double[][] v = new double[2][3];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                v[i][j] = readDouble();
            }
        }
        if (mode.equals("Multiply")) {
            for (int i = 0; i < 3; i++) {
                v[0][i] *= v[1][i];
            }
        } else if (mode.equals("Screen")) {
            for (int i = 0; i < 3; i++) {
                v[0][i] = 1 - (1 - v[0][i])*(1 - v[1][i]);
            }
        } else {
            for (int i = 0; i < 3; i++) {
                if (v[0][i] < 0.5) {
                    v[0][i] *= 2 * v[1][i];
                } else {
                    v[0][i] = 1 - 2*(1 - v[0][i])*(1 - v[1][i]);
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            System.out.print(v[0][i] + " ");
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
