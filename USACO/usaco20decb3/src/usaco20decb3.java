import java.io.*;
import java.util.*;
public class usaco20decb3 {
    /*
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    static int[] ans;
    public static void main(String[] args) throws IOException {
        int n = readInt();
        ans = new int[n];
        ArrayList<pii> ec = new ArrayList<>(), nc = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char c = readChar();
            int x = readInt(), y = readInt();
            if (c == 'E') {
                ec.add(new pii(i, x, y));
            } else {
                nc.add(new pii(i, x, y));
            }
        }
        boolean flag = true;
        while (flag) {
            flag = false;
            for (pii cow : ec) {
                int dist = Integer.MAX_VALUE;
                for (pii obs : nc) {
                    if (obs.dy < cow.y || obs.y > cow.y) continue;
                    if (cow.y - obs.y < obs.x - cow.x && obs.x - cow.x < dist) {
                        dist = obs.x - cow.x;
                        cow.dx = obs.x;
                        cow.dy = cow.y;
                    }
                }
                if (dist != ans[cow.id]) {
                    flag = true;
                    ans[cow.id] = dist;
                }
            }
            for (pii cow : nc) {
                int dist = Integer.MAX_VALUE;
                for (pii obs : ec) {
                    if (obs.dx < cow.x || obs.x > cow.x) continue;
                    if (cow.x - obs.x < obs.y - cow.y && obs.y - cow.y < dist) {
                        dist = obs.y - cow.y;
                        cow.dx = cow.x;
                        cow.dy = obs.y;
                    }
                }
                if (dist != ans[cow.id]) {
                    flag = true;
                    ans[cow.id] = dist;
                }
            }
        }
        
        for (int e : ans) {
            if (e != Integer.MAX_VALUE) System.out.println(e);
            else System.out.println("Infinity");
        }
    }
    
    static class pii {
        int id, x, y, dx, dy;

        public pii(int id, int x, int y) {
            this.id = id;
            this.x = x;
            this.y = y;
            dx = Integer.MAX_VALUE;
            dy = Integer.MAX_VALUE;
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
