import java.io.*;
import java.util.*;
public class ccc03s5 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    static ArrayList<edge>[] g;
    static boolean vis[];
    static int ans[];
    
    public static void main(String[] args) throws IOException {
        int n = readInt(), m = readInt(), tgtc = readInt();
        g = new ArrayList[n+1];
        ans = new int[n+1];
        vis = new boolean[n+1];
        for (int i = 1; i <= n; i++) g[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int src = readInt(), dst = readInt(), w = readInt();
            g[src].add(new edge(src, dst, w));
            g[dst].add(new edge(dst, src, w));
        }
        int[] dsts = new int[tgtc];
        for (int i = 0; i < tgtc; i++) dsts[i] = readInt();
        
        PriorityQueue<edge> pq = new PriorityQueue<>(Comparator.reverseOrder());
        ans[1] = Integer.MAX_VALUE;
        ans[0] = Integer.MAX_VALUE;
        pq.add(new edge(0, 1, Integer.MAX_VALUE));
        while (!pq.isEmpty()) {
            edge cur = pq.poll();
            if (Math.min(ans[cur.src], cur.w) < ans[cur.dst]) continue;
            ans[cur.dst] = Math.min(ans[cur.src], cur.w);
            vis[cur.dst] = true; 
            for (edge e : g[cur.dst]) {
                if (vis[e.dst]) continue;
                pq.add(e);
            }
        }
        int out = Integer.MAX_VALUE;
        for (int d : dsts) out = Math.min(out, ans[d]);
        System.out.println(out);
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
