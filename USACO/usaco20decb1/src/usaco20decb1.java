import java.io.*;
import java.util.*;
public class usaco20decb1 {
    /*
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    public static void main(String[] args) throws IOException {
        List<Integer> p = Arrays.asList(new Integer[]{readInt(), readInt(), readInt(), readInt(), readInt(), readInt(), readInt()});
        Collections.sort(p);
        int a = p.get(6) - p.get(5);
        int bc = p.get(5);
        for (int i = 0; i < 7; i++) {
            int b = bc - p.get(i);
            int c = bc - b;
            if (b < 1 || c < 1 || b > c || b < a) continue;
            if (p.contains(a) && p.contains(b) && p.contains(c) && p.contains(a + b) && p.contains(a + c) && p.contains(b + c)) {
                System.out.println(a + " " + b + " " + c);
                return;
            }
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
