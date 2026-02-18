import java.io.*;
import java.util.*;
public class ccc02s2 {
    /*
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    public static void main(String[] args) throws IOException {
        int num = readInt();
        int den = readInt();
        if (num % den == 0) {
            System.out.println(num/den);
        } else if (num < den) {
            int gcf = gcf(num, den);
            System.out.println(num / gcf + "/" + den / gcf);
        } else {
            System.out.print(num / den + " ");
            num = num % den;
            int gcf = gcf(num, den);
            System.out.println(num / gcf + "/" + den / gcf);
        }
    }
    
    static int gcf(int a, int b) {
        if (b == 0) return a;
        return gcf(b, a % b);
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
