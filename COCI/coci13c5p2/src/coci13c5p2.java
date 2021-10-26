import java.io.*;
import java.util.*;
public class coci13c5p2 {
    /*
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    static int n;
    static HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        n = readInt();
        for (int i = 1; i <= n; i++) map.put(i, new ArrayList<>());
        node root = new node(1);
        f(root);
        f2(root);
        for (int i = 1; i <= n; i++) {
            for (int e : map.get(i)) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
    
    static void f(node curr) throws IOException {
        if (curr.l == null) {
            curr.val = readInt();
            return;
        }
        f(curr.l);
        curr.val = readInt();
        f(curr.r);
    }
    
    static void f2(node curr) throws IOException {
        map.get(curr.depth).add(curr.val);
        if (curr.l == null) {
            return;
        }
        f2(curr.l);
        f2(curr.r);
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
    
    static class node {
        int depth, val;
        node l, r;
        public node(int depth) {
            if (depth < n) {
                l = new node(depth + 1);
                r = new node(depth + 1);
            }
            this.depth = depth;
        }
    }
}
