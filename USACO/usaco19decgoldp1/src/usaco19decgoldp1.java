import java.io.*;
import java.util.*;
public class usaco19decgoldp1 {
    /*
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    static ArrayList<Edge>[] adj;
    static int n;
    
    public static void main(String[] args) throws IOException {
        n = readInt();
        int m = readInt();
        adj = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int a = readInt(), b = readInt(), c = readInt(), f = readInt();
            adj[a].add(new Edge(b, c, f));
            adj[b].add(new Edge(a, c, f));
        }
        double maxEff = 0;
        for (int i = 1; i <= 1000; i++) {
            int res = f(i);
            if (res == -1) break;
            maxEff = Math.max(maxEff, (double) i / res);
        }
        System.out.println((long) (maxEff * 1000000));
    }
    
    static int f(int min) {
        boolean[] vis = new boolean[n+1];
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
        pq.add(new Pair(0, 1));
        vis[1] = true;
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            vis[p.dst] = true;
            if (p.dst == n) return p.cost;
            for (Edge e : adj[p.dst]) {
                if (e.fr < min || vis[e.dst]) continue;
                pq.add(new Pair(p.cost + e.cost, e.dst));
            }
        }
        return -1;
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

class Edge {
    int dst, cost, fr;
    Edge(int a, int b, int c) {
        dst = a;
        cost = b;
        fr = c;
    }
}

class Pair implements Comparable<Pair> {
    int cost, dst;
    Pair(int a, int b) {
        cost = a;
        dst = b;
    }
    @Override
    public int compareTo(Pair arg0) {
        return Integer.compare(cost, arg0.cost);
    }
    
    
}