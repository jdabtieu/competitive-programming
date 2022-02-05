import java.io.*;
import java.util.*;
public class ccc06s5 {
    /*
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    public static void main(String[] args) throws IOException {
        int m = readInt(), n = readInt(), a = readInt(), b = readInt(), c = readInt();
        int[][] arr = new int[m+2][n+2];
        boolean[] eden = new boolean[1 << (m * n)];
        Arrays.fill(eden, true);
        for (int i = 0; i < (1 << (m * n)); i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    arr[j+1][k+1] = (i >> (j * n + k)) & 1;
                }
            }
            int key = 0;
            for (int j = 1; j <= m; j++) {
                for (int k = 1; k <= n; k++) {
                    int sum = 0;
                    sum += arr[j-1][k-1];
                    sum += arr[j][k-1];
                    sum += arr[j+1][k-1];
                    sum += arr[j-1][k];
                    sum += arr[j+1][k];
                    sum += arr[j-1][k+1];
                    sum += arr[j][k+1];
                    sum += arr[j+1][k+1];
                    if (arr[j][k] > 0 && sum >= a && sum <= b) key |= (1 << ((j - 1) * n + k - 1));
                    if (arr[j][k] == 0 && sum > c) key |= (1 << ((j - 1) * n + k - 1));
                }
            }
            eden[key] = false;
        }
        int[] dist = new int[1 << (m*n)];
        Arrays.fill(dist, 0x3f3f3f3f);
        for (int i = 0; i < (1 << (m*n)); i++) {
            if (!eden[i]) continue;
            dist[i] = 0;
            int f = i;
            while (true) {
                for (int j = 0; j < m; j++) {
                    for (int k = 0; k < n; k++) {
                        arr[j+1][k+1] = (f >> (j * n + k)) & 1;
                    }
                }
                int key = 0;
                for (int j = 1; j <= m; j++) {
                    for (int k = 1; k <= n; k++) {
                        int sum = 0;
                        sum += arr[j-1][k-1];
                        sum += arr[j][k-1];
                        sum += arr[j+1][k-1];
                        sum += arr[j-1][k];
                        sum += arr[j+1][k];
                        sum += arr[j-1][k+1];
                        sum += arr[j][k+1];
                        sum += arr[j+1][k+1];
                        if (arr[j][k] > 0 && sum >= a && sum <= b) key |= (1 << ((j - 1) * n + k - 1));
                        if (arr[j][k] == 0 && sum > c) key |= (1 << ((j - 1) * n + k - 1));
                    }
                }
                if (dist[key] <= dist[f] + 1) break;
                dist[key] = dist[f] + 1;
                f = key;
            }
            
        }
        int key = 0;
        for (int i = 0; i < m; i++) {
            char[] s = readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                if (s[j] == '*') key |= (1 << (i * n + j));
            }
        }
        if (dist[key] != 0x3f3f3f3f) System.out.println(dist[key]);
        else System.out.println(-1);
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
