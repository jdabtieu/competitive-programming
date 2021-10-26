import java.io.*;
import java.util.*;
public class usaco20febg3 {
    /*
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    static int n, root;
    static boolean ans;
    static int head[], nxt[], edge[], cnt;
    
    public static void main(String[] args) throws IOException {
        n = readInt();
        head = new int[n+1];
        edge = new int[2*(n+1)];
        nxt = new int[2*(n+1)];
        Arrays.fill(head, -1);
        for (int i = 1; i < n; i++) {
            int x = readInt(), y = readInt();
            edge[cnt] = y; nxt[cnt] = head[x]; head[x] = cnt++;
            edge[cnt] = x; nxt[cnt] = head[y]; head[y] = cnt++;
        }
        for (int i = 1; i < n; i++) {
            if ((n - 1) % i != 0) {
                System.out.print(0);
                continue;
            }
            ans = true;
            f(1, 0, i);
            System.out.print(ans ? 1 : 0);
        }
        System.out.println();
    }
    
    static int f(int curr, int pa, int len) {
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = head[curr]; i != -1; i = nxt[i]) {
            int node = edge[i];
            if (node == pa) continue;
            int n = f(node, curr, len);
            if (n == -1) return -1;
            if (n + 1 != len) a.add(n+1);
        }
        Collections.sort(a);
        int ptrl = 0, ptrr = a.size() - 1;
        boolean pass = true;
        int passthru = -1;
        while (ptrl < ptrr) {
            if (a.get(ptrl) + a.get(ptrr) == len) {
                ptrl++;
                ptrr--;
            } else if (a.get(ptrl) + a.get(ptrr) > len) {
                if (!pass) {
                    ans = false;
                    return -1;
                }
                passthru = a.get(ptrr);
                pass = false; 
                ptrr--;
            } else if (a.get(ptrl) + a.get(ptrr) < len) {
                if (!pass) {
                    ans = false;
                    return -1;
                }
                passthru = a.get(ptrl);
                pass = false;
                ptrl++;
            }
        }
        if (ptrl == ptrr) {
            if (pass) return a.get(ptrl);
            else {
                ans=false;
                return -1;
            }
        }
        if (pass) return 0;
        return passthru;
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