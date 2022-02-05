import java.io.*;
import java.util.*;
public class _ccc20s3 {
    /*
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    public static void main(String[] args) throws IOException {
        int m = readInt(), n = readInt();
        HashMap<Integer, ArrayList<pii>> map = new HashMap<>();
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int k = readInt();
                if (!map.containsKey(k)) map.put(k, new ArrayList<>());
                map.get(k).add(new pii(i, j));
            }
        }
        
        boolean[] vis = new boolean[m*n+1];
        if (!map.containsKey(m*n)) {
            System.out.println("no");
            return;
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(m*n);
        while (!q.isEmpty()) {
            int x = q.poll();
            for (pii pair : map.get(x)) {
                int p = pair.x * pair.y;
                if (!vis[p]) {
                    if (p == 1) {
                        System.out.println("yes");
                        return;
                    }
                    vis[p] = true;
                    if (map.containsKey(p)) q.add(p);
                }
            }
        }
        System.out.println("no");
    }
    
    static class pii {
        int x, y;

        public pii(int x, int y) {
            this.x = x;
            this.y = y;
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
