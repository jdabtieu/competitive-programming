import java.io.*;
import java.util.*;
public class dwite08c1p3 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    static boolean[][] map = new boolean[12][21];
    static int[] px = new int[12], py = new int[12];
    static boolean[][] vis; static int[][] dis;
    
    public static void main(String[] args) throws IOException {
         for (int i = 1; i <= 10; i++) {
             char[] a = readLine().toCharArray();
             for (int j = 1; j <= 19; j++) {
                 if (a[j-1] == '#') continue;
                 map[i][j] = true;
                 if (a[j-1] != '.') {
                     px[a[j-1] - 'A'] = i;
                     py[a[j-1] - 'A'] = j;
                 }
             }
         }
         for (int i = 0; i < 5; i++) {
             char[] ins = readLine().toCharArray();
             int ans = 0;
             for (int j = 1; j < ins.length; j++) {
                 bfs(ins[j-1]);
                 ans += dis[px[ins[j] - 'A']][py[ins[j] - 'A']];
             }
             System.out.println(ans);
         }
    }
    
    static int[] ox = {1, 0, -1, 0};
    static int[] oy = {0, 1, 0, -1};
    
    static void bfs(char start) {
        start -= 'A';
        vis = new boolean[12][21];
        dis = new int[12][21];
        vis[px[start]][py[start]] = true;
        Queue<pii> q = new LinkedList<>();
        q.add(new pii(px[start], py[start]));
        while (!q.isEmpty()) {
            pii cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + ox[i];
                int ny = cur.y + oy[i];
                if (vis[nx][ny] || !map[nx][ny]) continue;
                vis[nx][ny] = true;
                dis[nx][ny] = dis[cur.x][cur.y] + 1;
                q.add(new pii(nx, ny));
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
