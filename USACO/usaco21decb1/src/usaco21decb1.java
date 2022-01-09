import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class usaco21decb1 {
    /*
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    public static void main(String[] args) throws Exception {
        int n = readInt();
        int[] g = new int[n], h = new int[n];
        char[] inp = br.readLine().toCharArray();
        long ans = 0;
        for (int i = 0; i < n; i++) {
            if (inp[i] == 'H') {
                int j = 1;
                for (; i - j >= 0; j++) {
                    if (inp[i-j] == 'H') break;
                }
                j--;
                int k = 1;
                for (; i + k < n; k++) {
                    if (inp[i+k] == 'H') break;
                }
                k--;
                i += k;
                // L X R
                if (j != 0 && k != 0) ans += (long) j * k;
                // 0 X R
                if (k >= 2) ans += k - 1;
                // L X 0
                if (j >= 2) ans += j - 1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (inp[i] == 'G') {
                int j = 1;
                for (; i - j >= 0; j++) {
                    if (inp[i-j] == 'G') break;
                }
                j--;
                int k = 1;
                for (; i + k < n; k++) {
                    if (inp[i+k] == 'G') break;
                }
                k--;
                i += k;
                // L X R
                if (j != 0 && k != 0) ans += (long) j * k;
                // 0 X R
                if (k >= 2) ans += k - 1;
                // L X 0
                if (j >= 2) ans += j - 1;
            }
        }
        System.out.println(ans);
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