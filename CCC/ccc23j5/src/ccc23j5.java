import java.io.*;
import java.util.*;
public class ccc23j5 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    static String word;
    static int rows, cols;
    static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
    static char[][] g;
    
    public static void main(String[] args) throws IOException {
        word = readLine();
        rows = readInt();
        cols = readInt();
        g = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                g[i][j] = readChar();
            }
        }
        int ans = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (g[i][j] != word.charAt(0)) continue;
                for (int k = 0; k < 8; k++) {
                    int newx = i + dx[k], newy = j + dy[k];
                    if (!boundcheck(newx, newy) || g[newx][newy] != word.charAt(1)) continue;
                    ans += recurse(newx, newy, 1, dx[k], dy[k], false);
                }
            }
        }
        ans = (ans & ((1 << 12) - 1)) + (ans >> 12);
        System.out.println(ans);
    }
    
    static boolean palindrome(String s) {
        for (int i = 0; i < s.length()/2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) return false;
        }
        return true;
    }
    
    static boolean recursepalindrome(String s) {
        if (s.length() <= 1) return true;
        if (s.charAt(0) != s.charAt(s.length() - 1)) return false;
        return recursepalindrome(s.substring(1, s.length() - 1));
    }
    
    static boolean boundcheck(int r, int c) {
        return !(r < 0 || c < 0 || r >= rows || c >= cols);
    }
    // if turn is false:
    // ans[no turn] = ans[next step, no turn]
    // ans[turn] = ans[all the turns]
    // if turn is true:
    // ans[no turn] = 0
    // ans[turn] = ans[next step no turn]
    // final:
    // ans[no turn] + ans[turn]
    static int recurse(int r, int c, int idx, int dirx, int diry, boolean turn) {
        if (!boundcheck(r, c) || g[r][c] != word.charAt(idx)) return 0;
        if (idx == word.length() - 1) {
            return turn ? 1 : (1 << 12);
        }
        int ans = 0;
        ans += recurse(r + dirx, c + diry, idx + 1, dirx, diry, false) << (turn ? 0 : (1 << 12));
        if (turn) {
            ans >>= 12;
            return ans;
        }
        if (dirx == 0) {
            ans += recurse(r + 1, c, idx + 1, 1, 0, true);
            ans += recurse(r - 1, c, idx + 1, -1, 0, true);
        }
        // if dx = 0, dy->0, dx->{1, -1}
        else if (diry == 0) {
            ans += recurse(r, c + 1, idx + 1, 0, 1, true);
            ans += recurse(r, c - 1, idx + 1, 0, -1, true);
        }
        // if dy = 0, dx->0, dy={1, -1}
        else {
            dirx = -dirx;
            ans += recurse(r + dirx, c + diry, idx + 1, dirx, diry, true);
            dirx = -dirx;
            diry = -diry;
            ans += recurse(r + dirx, c + diry, idx + 1, dirx, diry, true);
        }
        // if {1, 1}, --> for all these, turn = flip x or y
        return ans;
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
