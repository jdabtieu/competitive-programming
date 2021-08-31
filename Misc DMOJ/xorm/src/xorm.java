import java.io.*;
import java.util.*;
public class xorm {
    /*
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    public static void main(String[] args) throws IOException {
        int n = readInt(), queries = readInt();
        layer root = new layer();
        for (int i = 0; i < n; i++) {
            int num = readInt();
            layer curr = root;
            for (int j = 31; j >= 0; j--) {
                int cb = (num >> j) & 1;
                if (curr.child[cb] == null) curr.child[cb] = new layer();
                curr = curr.child[cb];
            }
            curr.idx = Math.min(i, curr.idx);
        }
        int num = 0;
        while (queries-- > 0) {
            num ^= readInt();
            layer curr = root;
            for (int j = 31; j >= 0; j--) {
                int cb = (num >> j) & 1;
                if (curr.child[cb] != null) curr = curr.child[cb];
                else curr = curr.child[(~cb) & 1];
                if (curr.idx < 2000000000) {
                    System.out.println(curr.idx);
                    break;
                }
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

class layer {
    int idx;
    layer[] child;
    public layer() {
        idx = 2000000000;
        child = new layer[2];
    }
}