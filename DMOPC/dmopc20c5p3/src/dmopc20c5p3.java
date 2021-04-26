import java.util.*;
import java.io.*;

public class dmopc20c5p3 {
    /* 
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    static int size;
    static int[] bpos;
    static int[] rpos;
    static Pair[] rposrange;

    public static void main(String[] args) throws IOException {
        size = readInt();
        int blocks = readInt();
        bpos = new int[size+1];
        rpos = new int[size+1];
        rposrange = new Pair[size+1];
        for (int i = 0; i < blocks; i++) {
            int r = readInt(), c = readInt();
            bpos[r] = c;
            rpos[c] = r;
            rposrange[c] = new Pair(r, r);
        }
        clean();
        if (rposrange[1] != null && rposrange[1].x == 1) {
            System.out.println("IMPOSSIBLE");
            return;
        }
        dfs(new Pair(1, 1));
        
        System.out.println("IMPOSSIBLE");
        // DLRU
        
    }
    
    static void clean() {
        int startx = 0, starty = 0, endx = 0, endy = 0;
        for (int i = 2; i <= size; i++) {
            if (bpos[i] - bpos[i - 1] == -1) {
                if (startx == 0) {
                    startx = i - 1;
                    endx = i;
                    endy = bpos[i-1];
                    starty = endy - 1;
                } else {
                    endx++;
                    starty--;
                }
            } else if (startx != 0) {
                // fill
                for (int j = starty; j <= endy; j++) {
                    rposrange[j] = new Pair(startx, endx);
                }
                startx = 0; starty = 0; endx = 0; endy = 0;
            }
        }
        if (startx != 0) {
            // fill
            for (int j = starty; j <= endy; j++) {
                rposrange[j] = new Pair(startx, endx);
            }
        }
        int ptr = rpos[size], i = size;
        if (rposrange[size] == null) return;
        rposrange[size] = new Pair(1, rposrange[size].y);
        while (i > 0) {
            i--;
            ptr = rpos[i];
            if (ptr == 0 || rposrange[i] == null) break;
            // block it off
            if (!rposrange[i+1].in(ptr)) {
                break;
            }
            rposrange[i] = new Pair(1, rposrange[i].y);
        }
        return;
    }
    
    static void dfs(Pair p) {
        StringBuilder path = new StringBuilder();
        while (true) {
            if (p.x == size && p.y == size) {
                System.out.println(path);
                System.exit(0);
            }
            if (p.y < size && (rposrange[p.y+1] == null || !rposrange[p.y+1].in(p.x))) {
                path.append('R');
                p = new Pair(p.x, p.y+1);
            } else if (p.x < size && (rposrange[p.y] == null || !rposrange[p.y].in(p.x))) {
                path.append('U');
                p = new Pair(p.x+1, p.y);
            } else {
                return;
            }
        }
    }
    
    static class Pair {
        int x, y;
        Pair(int a, int b) {
            x = a; y = b;
        }
        
        public String toString() {
            return x + " " + y;
        }
        
        public boolean in(int q) {
            return q <= y && q >= x;
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