import java.io.*;
import java.util.*;
public class fhc15c1p2 {
    /*
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    public static void main(String[] args) throws IOException {
        int _cases = readInt();
        for (int cases = 1; cases <= _cases; cases++) {
            int words = readInt();
            layer root = new layer(0);
            long ans = 0;
            for (int i = 0; i < words; i++) {
                int cans = 0;
                layer curr = root;
                String word = readLine();
                for (int depth = 0; depth < word.length(); depth++) {
                    if (curr.child[word.charAt(depth) - 'a'] == null) {
                        curr.child[word.charAt(depth) - 'a'] = new layer(0);
                        if (cans == 0) cans = depth + 1;
                    }
                    curr = curr.child[word.charAt(depth) - 'a'];
                    if (depth == word.length() - 1) {
                        curr.cnt++;
                    }
                }
                if (cans == 0) cans = word.length();
                ans += cans;
            }
            System.out.printf("Case #%d: %d\n", cases, ans);
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
    int cnt;
    layer[] child;
    public layer(int cnt) {
        this.cnt = cnt;
        child = new layer[26];
    }
}