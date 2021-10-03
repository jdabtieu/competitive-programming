import java.io.*;
import java.util.*;
public class graph2p1 {
    /*
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    static HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    
    public static void main(String[] args) throws IOException {
        int n = readInt();
        for (int i = 1; i <= n; i++) {
            boolean found = false;
            int j = 1;
            for (; j < i; j++) {
                if (readInt() == 1) {
                    if (!found) {
                        map.get(j).add(i);
                        map.put(i, map.get(j));
                        found = true;
                    } else {
                        ArrayList<Integer> proper = map.get(i);
                        ArrayList<Integer> other = map.get(j);
                        if (proper == other) continue;
                        while (other.size() != 0) {
                            int o = other.remove(other.size() - 1);
                            map.put(o, proper);
                            proper.add(o);
                        }
                    }
                }
            }
            if (!found) {
                ArrayList<Integer> l = new ArrayList<>();
                l.add(i);
                map.put(i, l);
            }
            for (; j <= n; j++) readInt();
        }
        boolean[] vis = new boolean[n+1];
        for (int i = 1; i <= n; i++) {
            if (vis[i]) continue;
            ArrayList<Integer> e = map.get(i);
            Collections.sort(e);
            System.out.print(e.get(0));
            for (int j = 1; j < e.size(); j++) {
                System.out.print(" " + e.get(j));
                vis[e.get(j)] = true;
            }
            System.out.println();
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
