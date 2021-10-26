import java.io.*;
import java.util.*;
public class coci16c2p2 {
    /*
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    public static void main(String[] args) throws IOException {
        int l = readInt(), m = readInt(), l2 = readInt(), c = readInt();
        char[] s = readLine().toCharArray();
        char[][] mis = new char[m][l2];
        for (int i = 0; i < m; i++) {
            mis[i] = readLine().toCharArray();
            Arrays.sort(mis[i]);
        }
        for (int i = l - 1; i >= 0; i--) {
            if (s[i] != '#') continue;
            int tmp = c % l2 - 1;
            if (tmp == -1) tmp += l2;
            s[i] = mis[m-1][tmp];
            c = (int) Math.ceil((double) c / l2);
            m--;
        }
        System.out.println(s);
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
