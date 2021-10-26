import java.io.*;
import java.util.*;
public class dmopc21c1p2 {
    /*
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> out = new ArrayList<>();
        int n = readInt();
        int[] f = new int[n], s = new int[n];
        int pf = n, ps = 0;
        
        for (int i = n - 1; i >= 0; i--) {
            f[i] = readInt();
        }
        s[ps++] = f[--pf];
        out.add(1);
        for (int i = 1; i < n; i++) {
            int cache = 0;
            for (int j = 0; j < ps; j++) {
                if (s[j] < f[pf-1]) {
                    out.add(-(ps - j));
                    cache = ps - j;
                    break;
                }
            }
            out.add(cache + 1);
            cache = -cache + ps;
            for (int j = ps; j > cache; j--) {
                s[j] = s[j-1];
            }
            s[cache] = f[--pf];
            ps++;
        }
        out.add(-n);
        System.out.println(out.size());
        for (Integer e : out) System.out.println(e);
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
