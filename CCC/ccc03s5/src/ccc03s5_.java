import java.io.*;
import java.util.*;
public class ccc03s5_ {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    static ArrayList<edge>[] g;
    static boolean vis[];
    
    public static void main(String[] args) throws IOException {
        int n = readInt(), m = readInt(), tgtc = readInt();
        g = new ArrayList[n+1];
        vis = new boolean[n+1];
        for (int i = 1; i <= n; i++) g[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int src = readInt(), dst = readInt(), w = readInt();
            g[src].add(new edge(src, dst, w));
            g[dst].add(new edge(dst, src, w));
        }
        int[] dsts = new int[tgtc];
        for (int i = 0; i < tgtc; i++) dsts[i] = readInt();
        
        int lo = 0, hi = 100000;
        while (lo < hi) {
            int mid = (lo + hi + 1) / 2;
            if (bs(mid, dsts)) lo = mid;
            else hi = mid - 1;
        }
        System.out.println(lo);
    }
    
    static boolean bs(int minw, int[] dsts) {
        Arrays.fill(vis, false);
        Queue<edge> q = new ArrayDeque<>();
        q.add(new edge(0, 1, 1));
        vis[1] = true;
        while (!q.isEmpty()) {
            edge cur = q.poll();
            for (edge e : g[cur.dst]) {
                if (vis[e.dst] || e.w < minw) continue;
                vis[e.dst] = true;
                q.add(e);
            }
        }
        for (int d : dsts) if (!vis[d]) return false;
        return true;
    }
    
    static class edge implements Comparable<edge> {
        int src, dst, w;

        public edge(int src, int dst, int w) {
            this.src = src;
            this.dst = dst;
            this.w = w;
        }

        @Override
        public int compareTo(edge arg0) {
            return Integer.compare(w, arg0.w);
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
