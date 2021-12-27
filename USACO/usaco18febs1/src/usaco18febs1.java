import java.io.*;
import java.util.*;
public class usaco18febs1 {
    /*
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    public static void main(String[] args) throws IOException {
        int n = readInt(), r = readInt(), f = readInt(), b = readInt();
        PriorityQueue<Stop> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < r; i++) {
            pq.add(new Stop(readInt(), readInt()));
        }
        long p = 0;
        long ans = 0;
        while (!pq.isEmpty()) {
            Stop s = pq.poll();
            if (s.loc <= p) continue;
            long tb = b * (s.loc - p);
            long tf = f * (s.loc - p);
            ans += (tf - tb) * s.score;
            p = s.loc;
        }
        System.out.println(ans);
    }
    
    static class Stop implements Comparable<Stop> {
        int score, loc;

        public Stop(int loc, int score) {
            this.score = score;
            this.loc = loc;
        }

        @Override
        public int compareTo(Stop arg0) {
            if (score != arg0.score) return Integer.compare(score, arg0.score);
            return -Integer.compare(loc, arg0.loc);
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
