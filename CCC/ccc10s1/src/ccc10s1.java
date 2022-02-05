import java.io.*;
import java.util.*;
public class ccc10s1 {
    /*
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    public static void main(String[] args) throws IOException {
        int n = readInt();
        if (n == 0) return;
        pis[] a = new pis[n];
        for (int i = 0; i < n; i++) {
            a[i] = new pis(next(), 2 * readInt() + 3 * readInt() + readInt());
        }
        Arrays.sort(a);
        System.out.println(a[n-1].b);
        if (n >= 2) System.out.println(a[n-2].b);
    }
    
    static class pis implements Comparable<pis> {
        int a;
        String b;
        public pis(String b, int a) {
            this.a = a;
            this.b = b;
        }
        
        public int compareTo(pis other) {
            if (Integer.compare(a, other.a) != 0) return Integer.compare(a, other.a);
            return -b.compareTo(other.b);
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
