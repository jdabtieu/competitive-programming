import java.io.*;
import java.util.*;
public class usaco18decsilvp2 {
    /*
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    public static void main(String[] args) throws IOException {
        int n = readInt();
        PriorityQueue<cow> pq = new PriorityQueue<>();
        PriorityQueue<cow> line = new PriorityQueue<>(11, (a, b) -> Integer.compare(a.sen, b.sen));
        for (int i = 0; i < n; i++) {
            pq.add(new cow(i, readInt(), readInt()));
        }
        int time = 0;
        int max = 0;
        while (!pq.isEmpty() || !line.isEmpty()) {
            if (line.isEmpty()) {
                time = Math.max(time, pq.peek().arr);
            }
            while (!pq.isEmpty() && pq.peek().arr <= time) {
                line.add(pq.poll());
            }
            cow curr = line.poll();
            max = Math.max(max, time - curr.arr);
            time += curr.tim;
        }
        System.out.println(max);
    }
    
    static class cow implements Comparable<cow> {
        int sen, arr, tim;

        public cow(int sen, int arr, int tim) {
            this.sen = sen;
            this.arr = arr;
            this.tim = tim;
        }
        
        public int compareTo(cow other) {
            if (arr != other.arr) return Integer.compare(arr, other.arr);
            return Integer.compare(sen, other.sen);
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
