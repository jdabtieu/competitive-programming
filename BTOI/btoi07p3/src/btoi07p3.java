import java.io.*;
import java.util.*;
public class btoi07p3 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    public static void main(String[] args) throws IOException {
        int n = readInt(), m = readInt(), c = readInt();
        Deque<pii> minq = new LinkedList<>(), maxq = new LinkedList<>();
        for (int i = 1; i < m; i++) {
            pii cur = new pii(readInt(), i);
            while (!minq.isEmpty() && minq.peekLast().first >= cur.first) minq.pollLast();
            minq.addLast(cur);
            while (!maxq.isEmpty() && maxq.peekLast().first <= cur.first) maxq.pollLast();
            maxq.addLast(cur);
        }
        boolean found = false;
        for (int i = m; i <= n; i++) {
            pii cur = new pii(readInt(), i);
            while (!minq.isEmpty() && minq.peekLast().first >= cur.first) minq.pollLast();
            minq.addLast(cur);
            while (!maxq.isEmpty() && maxq.peekLast().first <= cur.first) maxq.pollLast();
            maxq.addLast(cur);
            while (minq.peekFirst().second <= i - m) minq.pollFirst();
            int mv = minq.peekFirst().first;
            while (maxq.peekFirst().second <= i - m) maxq.pollFirst();
            int mv2 = maxq.peekFirst().first;
            if (mv2 - mv <= c) {
                System.out.println(i - m + 1);
                found = true;
            }
        }

        if (!found) System.out.println("NONE");
    }
    
    static class pii {
        int first, second;

        public pii(int val, int idx) {
            this.first = val;
            this.second = idx;
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
        int x = 0, c;
        while((c = br.read()) != ' ' && c != '\n')
            x = x * 10 + (c - '0');
        return x;
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
