import java.io.*;
import java.util.*;
public class ccc20j4hard {
    /*
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    static HashSet<Long> db = new HashSet<>();
    static final long MMOD = 1125899839733759L;
    static final int PRIME = 7507;
    static long hash = 0;
    
    public static void main(String[] args) throws IOException {
        char[] hay = readLine().toCharArray();
        char[] needle = readLine().toCharArray();
        if (needle.length > hay.length) {
            System.out.println("no");
            return;
        }
        long power = 1;
        for (int i = 0; i < needle.length; i++) power = power * PRIME % MMOD;
        for (int i = 0; i < needle.length; i++) {
            hash = (hash * PRIME + hay[i] - 'A') % MMOD;
        }
        db.add(hash);
        for (int i = needle.length; i < hay.length; i++) {
            hash = (hash * PRIME + hay[i] - 'A') % MMOD;
            hash -= (hay[i - needle.length] - 'A') * power % MMOD;
            if (hash < 0) hash += MMOD;
            db.add(hash);
        }
        hash = 0;
        for (int i = 0; i < needle.length; i++) {
            hash = (hash * PRIME + needle[i] - 'A') % MMOD;
        }
        if (db.contains(hash)) {
            System.out.println("yes");
            return;
        }
        for (int i = 0; i < needle.length; i++) {
            hash = (hash * PRIME + needle[i] - 'A') % MMOD;
            hash -= (needle[i] - 'A') * power % MMOD;
            if (hash < 0) hash += MMOD;
            if (db.contains(hash)) {
                System.out.println("yes");
                return;
            }
        }
        System.out.println("no");
        
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
