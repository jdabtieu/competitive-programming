import java.io.*;
import java.util.*;
public class dmopc21c3p3 {
    /*
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    public static void main(String[] args) throws IOException {
        ArrayList<Pair> a = new ArrayList<>();
        int n = readInt(), m = readInt();
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                a.add(new Pair(i, j));
            }
        }
        Collections.sort(a);;
        int p = n;
        System.out.println((n + 1) * (m + 1) - 1);
        for (int i = 1; i < a.size(); i++) {
            p += a.get(i).r - a.get(i - 1).r + a.get(i - 1).c - a.get(i).c;
            System.out.println(p);
        }
    }
    
    static class Pair implements Comparable<Pair> {
        int r, c;

        public Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public int compareTo(Pair arg0) {
            if (r + c != arg0.r + arg0.c) return Integer.compare(r + c, arg0.r + arg0.c);
            if ((r + c) % 2 != 0) return Integer.compare(r, arg0.r);
            return Integer.compare(arg0.r, r);
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
