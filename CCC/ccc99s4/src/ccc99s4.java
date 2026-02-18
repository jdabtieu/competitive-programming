import java.io.*;
import java.util.*;
public class ccc99s4 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    public static void main(String[] args) throws IOException {
    for (int cases = readInt(); cases > 0; cases--) {
        int r = readInt(), c = readInt();
        int py = readInt(), px = readInt();
        int ky = readInt(), kx = readInt();
        int[][] dist = new int[c+1][r+1];
        boolean [][] vis = new boolean[c+1][r+1];
        
        int[] dx = {1, 1, -1, -1, 2, 2, -2, -2};
        int[] dy = {2, -2, 2, -2, 1, -1, 1, -1};
        
        Queue<pii> q = new ArrayDeque<>();
        q.add(new pii(kx, ky));
        vis[kx][ky] = true;
        while (!q.isEmpty()) {
            pii cur = q.poll();
            for (int i = 0; i < 8; i++) {
                int newx = cur.x + dx[i];
                int newy = cur.y + dy[i];
                if (newx < 1 || newx > c || newy < 1 || newy > r) continue;
                if (vis[newx][newy]) continue;
                dist[newx][newy] = dist[cur.x][cur.y]+ 1;
                vis[newx][newy] = true;
                q.add(new pii(newx, newy));
            }
        }
        int movesToWin = Integer.MAX_VALUE;
        int movesToStale = Integer.MAX_VALUE;
        int moveCnt = 1;
        for (int i = py; i < r; i++, moveCnt++) {
            if (vis[px][i+1] && dist[px][i+1] <= moveCnt) {
                if (((dist[px][i+1] ^ moveCnt) & 1) == 0) {
                    if (i == r - 1) continue;
                    movesToWin = Math.min(moveCnt, movesToWin);
                }
                else movesToStale = Math.min(moveCnt - 1, movesToStale);
            }
        }
        if (movesToWin != Integer.MAX_VALUE) {
            System.out.printf("Win in %d knight move(s).\n", movesToWin);
        } else if (movesToStale != Integer.MAX_VALUE) {
            System.out.printf("Stalemate in %d knight move(s).\n", movesToStale);
        } else {
            System.out.printf("Loss in %d knight move(s).\n", r - py - 1);
        }
    }
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
