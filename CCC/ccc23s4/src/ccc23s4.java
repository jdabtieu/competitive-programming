import java.util.*;
import java.io.*;
public class ccc23s4 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //public static BufferedReader br;
    public static StringTokenizer in;
    
    static ArrayList<edge>[] g;
    static int n, m;
    static int[] head;
    // start with empty graph
    // sort edges by len then cost
    // dsu, if not connected, connect them
    // if connected, check if len constraint works with dijkstra, connect if invalid
    public static void main(String[] args) throws IOException {
        //br = new BufferedReader(new FileReader("E:\Downloads\s4.2-24.in"));
        n = readInt();
        m = readInt();
        g = new ArrayList[n+1];
        head = new int[n+1];
        for (int i = 1; i <= n; i++) {
            g[i] = new ArrayList<>();
            head[i] = i;
        }
        PriorityQueue<edge> edges = new PriorityQueue<>();
        for (int i = 0; i < m; i++) {
            int a = readInt(), b = readInt(), l = readInt(), c = readInt();
            edges.add(new edge(a, b, l, c));
        }
        
        long ans = 0;
        while (!edges.isEmpty()) {
            edge cur = edges.poll();
            if (lead(cur.src) == lead(cur.dst)) {
                long cd = f(cur.src, cur.dst);
                if (cd > cur.len) {
                    g[cur.src].add(cur);
                    g[cur.dst].add(new edge(cur.dst, cur.src, cur.len, cur.cost));
                    ans += cur.cost;
                }
            } else {
                ans += cur.cost;
                head[lead(cur.dst)] = lead(cur.src);
                g[cur.src].add(cur);
                g[cur.dst].add(new edge(cur.dst, cur.src, cur.len, cur.cost));
            }
        }
        System.out.println(ans);
    }
    
    static int lead(int node) {
        if (head[node] == node) return node;
        head[node] = lead(head[node]);
        return head[node];
    }
    
    static long f(int root, int dst) {
        boolean[] vis = new boolean[2001];
        PriorityQueue<edge> q = new PriorityQueue<>();
        q.add(new edge(0, root, 0, 0));
        while (!q.isEmpty()) {
            edge cur = q.poll();
            if (vis[cur.dst]) continue;
            if (cur.dst == dst) return cur.len;
            vis[cur.dst] = true;
            for (edge e : g[cur.dst]) {
                if (vis[e.dst]) continue;
                edge t = new edge(e.src, e.dst, e.len + cur.len, e.cost);
                q.add(t);
            }
        }
        throw new IllegalStateException();
    }
    
    static class edge implements Comparable<edge> {
        int src, dst, cost;
        long len;
        public edge(int src, int dst, long len, int cost) {
            this.src = src;
            this.dst = dst;
            this.len = len;
            this.cost = cost;
        }
        @Override
        public int compareTo(edge arg0) {
            if (this.len != arg0.len) return Long.compare(this.len, arg0.len);
            return Integer.compare(this.cost, arg0.cost);
        }
        
    }
    
    static String next() throws IOException {
        while (in == null || !in.hasMoreTokens()) {
            in = new StringTokenizer(br.readLine());
        }
        return in.nextToken();
    }
    
    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }
}
