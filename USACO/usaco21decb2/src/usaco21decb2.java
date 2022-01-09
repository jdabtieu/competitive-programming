import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class usaco21decb2 {
    /*
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    static int ans = 0;
    static int[] t;
    public static void main(String[] args) throws Exception {
        int n = readInt();
        int[] p = new int[n];
        t = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = readInt();
        }
        for (int i = 0; i < n; i++) {
            t[i] = p[i] - readInt();
        }
        int i = 0;
        for (int j = 1; j < n; j++) {
            if (t[i] * t[j] < 0) {
                if (t[i] < 0) {
                    for (int k = i; k < j; k++) {
                        t[k] = -t[k];
                    }
                }
                dq(i, j-1);
                i = j;
            }
        }
        if (t[i] < 0) {
            for (int k = i; k < n; k++) {
                t[k] = -t[k];
            }
        }
        dq(i, n-1);
        System.out.println(ans);
    }
    
    static void dq(int l, int r) {
        if (l == r) {
            ans += t[l];
            t[l] = 0;
            return;
        }
        int min = Integer.MAX_VALUE;
        for (int i = l; i <= r; i++) {
            min = Math.min(min, t[i]);
        }
        ans += min;
        int i = l;
        for (int j = i; j <= r; j++) {
            t[j] -= min;
            if (t[j] == 0) {
                if (i == j) {
                    i++;
                    continue;
                }
                dq(i, j-1);
                i = j+1;
            }
        }
        if (i <= r) dq(i, r);
    }
    
    static String next() throws Exception {
        while (in == null || !in.hasMoreTokens()) {
            in = new StringTokenizer(br.readLine());
        }
        return in.nextToken();
    }
    
    static int readInt() throws Exception {
        return Integer.parseInt(next());
    }
}