import java.io.*;
import java.util.*;
public class coci18c5p3 {
    /*
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    public static void main(String[] args) throws IOException {
        int n = readInt(), k = readInt();
        String[] str = new String[n];
        counter[] cnt = new counter[n];
        for (int i = 0; i < n; i++) {
            str[i] = readLine();
            cnt[i] = new counter();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                cnt[i].cnt[str[i].charAt(j) - 'a']++;
                cnt[i].sig = str[i].substring(k, n);
            }
        }
        {
            Set<counter> s = new HashSet<>();
            for (int i = 0; i < n; i++) {
                s.add(cnt[i]);
            }
            if (s.size() != n) {
                System.out.println("DA");
                return;
            }
        }
        for (int i = 1; i <= n - k; i++) {
            for (int j = 0; j < n; j++) {
                cnt[j].cnt[str[j].charAt(i - 1) - 'a']--;
                cnt[j].cnt[str[j].charAt(i - 1 + k) - 'a']++;
                cnt[j].sig = str[j].substring(0, i) + str[j].substring(i + k, n);
            }
            Set<counter> s = new HashSet<>();
            for (int j = 0; j < n; j++) {
                s.add(cnt[j]);
            }
            if (s.size() != n) {
                System.out.println("DA");
                return;
            }
        }
        System.out.println("NE");
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
    
    static class counter {
        int[] cnt;
        String sig = "";
        public counter() {
            cnt = new int[26];
        }
        @Override
        public int hashCode() {
            return Arrays.hashCode(cnt) * 31 + sig.hashCode();
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            counter other = (counter) obj;
            return Arrays.equals(cnt, other.cnt) && sig.equals(other.sig);
        }
    }
}
