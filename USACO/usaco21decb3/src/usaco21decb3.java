import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class usaco21decb3 {
    /*
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    static int n, k;
    static boolean[][] g;
    public static void main(String[] args) throws Exception {
        for (int cases = readInt(); cases > 0; cases--) {
            n = readInt();
            k = readInt();
            g = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                char[] c = br.readLine().toCharArray();
                for (int j = 0; j < n; j++) {
                    if (c[j] != 'H') g[i][j] = true;
                }
            }
            System.out.println(f(0, 0, k, true) + f(0, 0, k, false));
        }
    }
    
    static int f(int x, int y, int k, boolean d) {
        if (x == n-1 && y == x) return 1;
        int ans = 0;
        if (d) {
            if (y != n-1 && g[x][y+1]) ans += f(x, y+1, k, d);
            if (x != n-1 && g[x+1][y] && k != 0 && !(x == 0 && y == 0)) ans += f(x+1, y, k-1, !d);
        } else {
            if (y != n-1 && g[x][y+1] && k != 0 && !(x == 0 && y == 0)) ans += f(x, y+1, k-1, !d);
            if (x != n-1 && g[x+1][y]) ans += f(x+1, y, k, d);
        }
        return ans;
    }
    
    static String next() throws Exception {
        while (in == null || !in.hasMoreTokens()) {
            in = new StringTokenizer(br.readLine());
        }
        return in.nextToken();
    }
    
    static int readInt() throws Exception {
        return Integer.parseInt(next());
    }
}