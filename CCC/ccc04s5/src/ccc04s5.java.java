import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ccc04s5 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    public static void main(String[] args) throws Exception {
        while (true) {
            int r = readInt(), c = readInt();
            if (r == 0) break;
            char[][] g = new char[r][];
            for (int i = 0; i < r; i++) g[i] = readLine().toCharArray();
            int[][] ans = new int[r][c];
            int[][] wallcnt = new int[r][c];
            int[][] ptssum = new int[r][c];
            boolean[][] vis = new boolean[r][c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (i != 0) wallcnt[i][j] = wallcnt[i-1][j];
                    if (g[i][j] == '*') wallcnt[i][j]++;
                    
                    if (i != 0) ptssum[i][j] = ptssum[i-1][j];
                    if (g[i][j] >= '0' && g[i][j] <= '9') ptssum[i][j] += g[i][j] - '0';
                }
            }
            
            ans[r-1][0] = g[r-1][0] == '.' ? 0 : g[r-1][0] - '0';  
            vis[r-1][0] = true;
            for (int row = r-2, walled = 0; row >= 0; row--) {
                if (g[row][0] == '*') walled = 1;
                
                if (walled == 1) ans[row][0] = -1;
                else {
                    ans[row][0] = ans[row+1][0] + (g[row][0] == '.' ? 0 : g[row][0] - '0');
                    vis[row][0] = true;
                }
            }
            
            for (int col = 1; col < c; col++) {
                for (int dstrow = 0; dstrow < r; dstrow++) {
                    ans[dstrow][col] = -1;
                    if (g[dstrow][col] == '*') continue;
                    for (int srcrow = 0; srcrow < r; srcrow++) {
                        if (ans[srcrow][col-1] == -1 || !vis[srcrow][col-1]) continue;
                        if (reachable(col, srcrow, dstrow, wallcnt)) {
                            int tmp = ans[srcrow][col-1];
                            if (srcrow > dstrow) tmp += ptssum[srcrow][col] - ptssum[dstrow][col];
                            else if (dstrow > srcrow) tmp += ptssum[dstrow-1][col] - (srcrow == 0 ? 0 : ptssum[srcrow-1][col]);
                            ans[dstrow][col] = Math.max(ans[dstrow][col], tmp);
                        }
                    }
                    if (ans[dstrow][col] != -1 && g[dstrow][col] != '.') ans[dstrow][col] += g[dstrow][col] - '0';
                    if (ans[dstrow][col] != -1) vis[dstrow][col] = true;
                }
            }
            System.out.println(ans[r-1][c-1]);
        }
    }
    
    static boolean reachable(int col, int src, int dst, int[][] wallcnt) {
        if (dst > src) {
            int res = wallcnt[dst][col];
            if (src != 0) res -= wallcnt[src-1][col];
            return res == 0;            
        } else {
            int res = wallcnt[src][col];
            if (dst != 0) res -= wallcnt[dst-1][col];
            return res == 0;
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
