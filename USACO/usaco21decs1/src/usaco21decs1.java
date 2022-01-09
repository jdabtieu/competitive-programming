import java.io.*;
import java.util.*;

public class usaco21decs1 {
    /*
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    public static void main(String[] args) throws Exception {
        int ng = readInt(), cr = readInt(), c = readInt();
        ArrayList<pii> patch = new ArrayList<pii>();
        for (int i = 0; i < ng; i++) {
            patch.add(new pii(readInt(), readInt()));
        }
        Collections.sort(patch);
        int[] bounds = new int[cr+1];
        for (int i = 0; i < cr; i++) {
            bounds[i] = readInt();
        }
        bounds[cr] = Integer.MAX_VALUE;
        Arrays.sort(bounds);
        ArrayList<pii>[] sections = new ArrayList[cr+1];
        for (int i = 0, j = 0; i <= cr; i++) {
            sections[i] = new ArrayList<>();
            int bound = bounds[i];
            for (; j < patch.size(); j++) {
                if (patch.get(j).loc < bound) sections[i].add(patch.get(j));
                else break;
            }
        }

        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        long[] ans = new long[cr+1];
        long[] doub = new long[cr+1];
        for (pii e : sections[0]) ans[0] += e.taste;
        for (pii e : sections[cr]) ans[cr] += e.taste;
        for (int i = 1; i < cr; i++) {
            for (pii e : sections[i]) doub[i] += e.taste;
            Queue<pii> q = new LinkedList<>();
            ArrayList<pii> sec = sections[i];
            long len = (bounds[i] -  bounds[i - 1]) / 2;
            long sum = 0, fsum = 0;
            for (int j = 0; j < sec.size(); j++) {
                while (!q.isEmpty() && sec.get(j).loc - q.peek().loc >= len) {
                    sum -= q.poll().taste;
                }
                q.add(sec.get(j));
                sum += sec.get(j).taste;
                fsum = Math.max(fsum, sum);
            }
            ans[i] = fsum;
            doub[i] -= fsum;
        }
        
        long fans = 0;
        for (long e : ans) pq.add(e);
        for (long e : doub) pq.add(e);
        for (int i = 0; i < c && !pq.isEmpty(); i++) {
            fans += pq.poll();
        }
        System.out.println(fans);
    }
    
    static class pii implements Comparable<pii> {
        int loc, taste;
        public pii(int a, int b) {
            loc = a;
            taste = b;
        }
        @Override
        public String toString() {
            return "pii[l=" + loc + ", t=" + taste + "]";
        }
        
        public int compareTo(pii other) {
            return Integer.compare(loc, other.loc);
        }
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