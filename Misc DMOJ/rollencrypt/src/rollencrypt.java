import java.io.*;
import java.util.*;
public class rollencrypt {
    /*
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    public static void main(String[] args) throws IOException {
        int n = readInt();
        char[] og = readLine().toCharArray();
        char[] ans = new char[og.length];
        int[] freq = new int[26];
        for (int i = 0; i < n; i++) {
            freq[og[i] - 'a']++;
            ans[i] = og[i];
        }
        for (int i = n; i < og.length; i++) {
            int max = 0;
            for (int e : freq) max = Math.max(e, max);
            int shift = -1;
            for (int j = 0; j < 26; j++) {
                if (freq[j] == max) {
                    shift = j + 1;
                    break;
                }
            }
            ans[i] = (char) ((og[i] + shift -'a') % 26 + 'a');
            freq[og[i - n] - 'a']--;
            freq[og[i] - 'a']++;
        }
        System.out.println(ans);
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
