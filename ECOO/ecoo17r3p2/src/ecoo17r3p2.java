import java.io.*;
import java.util.*;
public class ecoo17r3p2 {
    /*
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    public static void main(String[] args) throws IOException {
        for (int cases = 0; cases < 10; cases++) {
            int n = Integer.parseInt(readLine());
            if (n < 1) {
                System.out.println(0);
                continue;
            }
            TreeLayer top = new TreeLayer();
            for (int i = 0; i < n; i++) {
                String[] tok = readLine().split("\\.");
                TreeLayer curr = top;
                for (int j = 1; j < tok.length; j++) {
                    int c = Integer.parseInt(tok[j]);
                    curr.count = Math.max(curr.count, c);
                    if (!curr.children.containsKey(c)) curr.children.put(c, new TreeLayer());
                    curr = curr.children.get(c);
                }
            }
            
            System.out.println(dfs(top) + 1);            
        }
    }
    static long mod = (long) 1e9 + 7;
    
    static long dfs(TreeLayer curr) {
        long ans = curr.count;
        for (Map.Entry<Integer, TreeLayer> entry : curr.children.entrySet()) {
            ans = (ans + dfs(entry.getValue())) % mod;
        }
        return ans;
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

class TreeLayer {
    long count;
    HashMap<Integer, TreeLayer> children;
    public TreeLayer() {
        count = 0;
        children = new HashMap<Integer, TreeLayer>();
    }
}
