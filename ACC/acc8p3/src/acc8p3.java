import java.io.*;
import java.util.*;
public class acc8p3 {
    /*
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> fib = new ArrayList<>();
        fib.add(1);
        fib.add(1);
        int m = readInt(), q = readInt();
        while (true) {
            fib.add((fib.get(fib.size() - 1) + fib.get(fib.size() - 2)) % m);
            if (fib.get(fib.size() - 1) == 1 && fib.get(fib.size() - 2) == 1) {
                fib.remove(fib.size() - 1);
                fib.remove(fib.size() - 1);
                break;
            }
        }
        StringBuilder s = new StringBuilder();
        for (int e : fib) s.append(e);
        while (q-- > 0) {
            System.out.println(s.charAt((int) ((readLong() - 1 + s.length()) % s.length())));
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
