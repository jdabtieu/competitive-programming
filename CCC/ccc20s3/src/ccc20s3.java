import java.util.*;
import java.io.*;

public class ccc20s3 {
    /* 
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;

    static final long MMOD = 100000000183L;
    static final int PRIME = 101;
    static int ll;
    static long hash = 0;

    static int[] cnt = new int[26];
    static int[] cnt2 = new int[26];
    
    static String small, big;

    public static void main(String[] args) throws IOException {
        small = readLine();
        big = readLine();
        ll = small.length();
        if (ll > big.length()) {
            System.out.println(0);
            return;
        }
        long power = 1;
        for (int i = 0; i < ll; i++) power = power * PRIME % MMOD;
        Set<Long> found = new HashSet<>();
        for (int i = 0; i < ll; i++) {
            cnt[small.charAt(i) - 'a']++;
            cnt2[big.charAt(i) - 'a']++;
            hash = (hash * PRIME + big.charAt(i) - 'a') % MMOD;
        }
        if (check()) {
            found.add(hash);
        }
        for (int i = ll; i < big.length(); i++) {
            cnt2[big.charAt(i - ll) - 'a']--;
            cnt2[big.charAt(i) - 'a']++;
            hash = (hash * PRIME + big.charAt(i) - 'a') % MMOD;
            hash -= (big.charAt(i - ll) - 'a') * power % MMOD;
            if (hash < 0) hash += MMOD;
            if (check()) {
                found.add(hash);
            }
        }
        System.out.println(found.size());
    }
    
    static boolean check() {
        for (int i = 0; i < 26; i++) if (cnt[i] != cnt2[i]) return false;
        return true;
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