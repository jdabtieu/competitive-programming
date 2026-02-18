import java.io.*;
import java.util.*;
public class ccc11s4 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    static int ans = 0;
    static int[] aval, need;
    
    public static void main(String[] args) throws IOException {
        int on = 0, op = 1, an = 2, ap = 3, bn = 4, bp = 5, abn = 6, abp = 7;
        
        // o- o+ a- a+ b- b+ ab- ab+
        aval = new int[] {readInt(), readInt(), readInt(), readInt(), readInt(), readInt(), readInt(), readInt()};
        need = new int[] {readInt(), readInt(), readInt(), readInt(), readInt(), readInt(), readInt(), readInt()};
        
        for (int i = 0; i < 8; i++) {
            give(i, i);
        }
        give(abn, abp);
        give(ap, abp);
        give(bp, abp);
        give(op, ap);
        give(op, bp);
        give(op, abp);
        give(an, ap);
        give(an, abn);
        give(an, abp);
        give(bn, bp);
        give(bn, abn);
        give(bn, abp);
        for (int i = 1; i < 8; i++) give(on, i);
        System.out.println(ans);
    }
    
    static void give(int send, int recp) {
        if (aval[send] > 0 && need[recp] > 0) {
            if (aval[send] >= need[recp]) {
                ans += need[recp];
                aval[send] -= need[recp];
                need[recp] = 0;
            } else {
                ans += aval[send];
                need[recp] -= aval[send];
                aval[send] = 0;
            }
        }
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