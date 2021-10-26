import java.io.*;
import java.util.*;
public class ecoo18r2p2 {
    /*
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    public static void main(String[] args) throws IOException {
        for (int cases = 10; cases > 0; cases--) {
            int n = readInt();
            Map<Integer, ArrayList<Double>> m = new TreeMap<>(Collections.reverseOrder());
            for (int i = 0; i < n; i++) {
                int k = readInt();
                if (!m.containsKey(k)) m.put(k, new ArrayList<>());
                m.get(k).add(readDouble());
            }
            PriorityQueue<Double> pq = new PriorityQueue<>(Comparator.reverseOrder());
            double ans = 0;
            int lastDay = m.keySet().iterator().next();
            int allowance = 0;
            for (Map.Entry<Integer, ArrayList<Double>> entry : m.entrySet()) {
                allowance = lastDay - entry.getKey();
                while (!pq.isEmpty() && allowance-- > 0) {
                    ans += pq.poll();
                }
                lastDay = entry.getKey();
                for (double d : entry.getValue()) {
                    pq.add(d);
                }
            }
            while (!pq.isEmpty() && lastDay-- > 0)
                ans += pq.poll();
            System.out.printf("%.4f\n", ans);
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
