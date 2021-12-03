import java.io.*;
import java.util.*;
public class coci16c4p2 {
    /*
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    public static void main(String[] args) throws IOException {
        node root = new node();
        for (int n = readInt(); n > 0; n--) {
            String s = readLine();
            node curr = root;
            for (int i = 0; i < s.length(); i++) {
                int c = s.charAt(i) - 'A';
                if (curr.c[c] == null) {
                    curr.c[c] = new node();
                }
                curr = curr.c[c];
            }
        }
        String s = readLine();
        node curr = root;
        for (int i = 0; i < s.length(); i++) {
            curr = curr.c[s.charAt(i) - 'A'];
        }
        StringBuilder sb = new StringBuilder();
        sb.append("***");
        for (int i = 0; i < 26; i++) {
            if (curr.c[i] == null) {
                sb.append('*');
            } else {
                sb.append((char) (i + 'A'));
            }
        }
        sb.append("***");
        System.out.println(sb.substring(0, 8));

        System.out.println(sb.substring(8, 16));

        System.out.println(sb.substring(16, 24));

        System.out.println(sb.substring(24));
    }
    
    static class node {
        node[] c;
        public node() {
            c = new node[26];
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
