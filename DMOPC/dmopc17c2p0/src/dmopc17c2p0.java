import java.io.*;
import java.util.*;
public class dmopc17c2p0 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    public static void main(String[] args) throws IOException {
        int x1 = readInt(), y1 = readInt();
        int x2 = readInt(), y2 = readInt();
        int xs = readInt(), ys = readInt();
        int dist = readInt();
        dist = dist * dist;
        
        if (Math.pow(xs - x1, 2) + Math.pow(ys - y1, 2) <= dist) {
            System.out.println("Yes");
            return;
        }
        
        if (Math.pow(xs - x2, 2) + Math.pow(ys - y2, 2) <= dist) {
            System.out.println("Yes");
            return;
        }
        System.out.println("No");
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
