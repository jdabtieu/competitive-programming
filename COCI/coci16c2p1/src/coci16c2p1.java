import java.io.*;
import java.util.*;
public class coci16c2p1 {
    /*
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    public static void main(String[] args) throws IOException {
        int n = readInt();
        int ans1 = 0;
        Map<String, Integer> m = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String name = readLine();
            int cost = readInt(), money = readInt();
            int cnt = 0;
            while (money >= cost) {
                cnt++;
                money -= cost - 2;
            }
            ans1 += cnt;
            m.put(name, cnt);
        }
        System.out.println(ans1);
        int max = -1;
        String ans = null;
        for (Map.Entry<String, Integer> entry : m.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                ans = entry.getKey();
            }
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
