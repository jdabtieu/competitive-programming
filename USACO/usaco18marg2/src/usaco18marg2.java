import java.io.*;
import java.util.*;
public class usaco18marg2 {
    /*
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    public static void main(String[] args) throws IOException {
        int cows = readInt(), obs = readInt();
        int[][] obsa = new int[obs][];
        for (int i = 0; i < obs; i++) {
            obsa[i] = new int[readInt()];
            for (int j = 0; j < obsa[i].length; j++) obsa[i][j] = readInt();
        }
        
        int lo = 0, hi = obs, mid;
        while (lo < hi) {
            mid = (lo + hi + 1) / 2;
            ArrayList<Integer>[] out = new ArrayList[cows+1];
            HashSet<Integer>[] in = new HashSet[cows+1];
            for (int i = 0; i <= cows; i++) {
                out[i] = new ArrayList<>();
                in[i] = new HashSet<>();
            }
            for (int i = 0; i < mid; i++) {
                for (int j = 1; j < obsa[i].length; j++) {
                    in[obsa[i][j]].add(obsa[i][j-1]);
                    out[obsa[i][j-1]].add(obsa[i][j]);
                }
            }
            
            PriorityQueue<Integer> q = new PriorityQueue<>();
            for (int i = 1; i <= cows; i++) {
                if (in[i].size() == 0 && out[i].size() != 0) {
                    q.add(i);
                }
            }
            while (!q.isEmpty()) {
                int curr = q.poll();
                for (int e : out[curr]) {
                    in[e].remove(curr);
                    if (in[e].size() == 0) q.add(e);
                }
                out[curr].clear();
            }
            boolean flag = false;
            for (HashSet<Integer> s : in) {
                if (!s.isEmpty()) {
                    hi = mid - 1;
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                lo = mid;
            }
        }
        ArrayList<Integer>[] out = new ArrayList[cows+1];
        HashSet<Integer>[] in = new HashSet[cows+1];
        for (int i = 0; i <= cows; i++) {
            out[i] = new ArrayList<>();
            in[i] = new HashSet<>();
        }
        for (int i = 0; i < lo; i++) {
            for (int j = 1; j < obsa[i].length; j++) {
                in[obsa[i][j]].add(obsa[i][j-1]);
                out[obsa[i][j-1]].add(obsa[i][j]);
            }
        }
        
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 1; i <= cows; i++) {
            if (in[i].size() == 0 && out[i].size() != 0) {
                q.add(i);
            }
        }
        StringBuilder o = new StringBuilder();
        while (!q.isEmpty()) {
            int curr = q.poll();
            o.append(curr);
            o.append(' ');
            for (int e : out[curr]) {
                in[e].remove(curr);
                if (in[e].size() == 0) q.add(e);
            }
            out[curr].clear();
        }
        System.out.println(o.substring(0, o.length() - 1));
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
