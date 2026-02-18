import java.util.*;
import java.io.*;
public class ccc22s1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    public static void main(String[] args) throws IOException {
        int n = readInt();
        if (n < 20) {
            if (n < 4 || n == 6 || n == 7 || n == 11) {
                System.out.println(0);
                return;
            }
            System.out.println(1);
            return;
        }
        if (n % 20 == 0) {
            System.out.println(n / 20 + 1);
            return;
        }
        int cnt = n / 20 + 1;
        n %= 20;
        if (n < 4 || n == 6 || n == 7 || n == 11) cnt--;
        System.out.println(cnt);
    }
    
    static String next() throws IOException {
        while (in == null || !in.hasMoreTokens()) {
            in = new StringTokenizer(br.readLine());
        }
        return in.nextToken();
    }
    
    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }
}
