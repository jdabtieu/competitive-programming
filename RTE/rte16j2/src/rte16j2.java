import java.io.*;
import java.util.*;
public class rte16j2 {
    /*
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    public static void main(String[] args) throws IOException {
        Map<String, PriorityQueue<Integer>> q = new HashMap();
        q.put("BLUE", new PriorityQueue<>());
        q.put("PINK", new PriorityQueue<>());
        q.put("GREEN", new PriorityQueue<>());
        for (int n = readInt(); n > 0; n--) {
            String inst = next();
            if (inst.equals("ADD")) {
                q.get(next()).add(readInt());
            } else {
                if (!q.get("BLUE").isEmpty()) {
                    System.out.println("BLUE " + q.get("BLUE").poll());
                } else if (!q.get("PINK").isEmpty()) {
                    System.out.println("PINK " + q.get("PINK").poll());
                } else if (!q.get("GREEN").isEmpty()) {
                    System.out.println("GREEN " + q.get("GREEN").poll());
                } else {
                    System.out.println("NONE");
                }
            }
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
