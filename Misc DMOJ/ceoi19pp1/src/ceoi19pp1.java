import java.io.*;
import java.util.*;
public class ceoi19pp1 {
    /*
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    public static void main(String[] args) throws IOException {
        int h = readInt(), v = readInt();
        int[] ah = new int[h], av = new int[v];
        for (int i = 0; i < h; i++) ah[i] = readInt();
        for (int j = 0; j < v; j++) av[j] = readInt();
        Map<Integer, Integer> mh = new HashMap<>();
        Map<Integer, Integer> mv = new HashMap<>();
        for (int i = 1; i < h; i++) {
            for (int j = 0; j < i; j++) {
                mh.put(ah[i] - ah[j], mh.getOrDefault(ah[i] - ah[j], 0) + 1);
            }
        }
        for (int i = 1; i < v; i++) {
            for (int j = 0; j < i; j++) {
                mv.put(av[i] - av[j], mv.getOrDefault(av[i] - av[j], 0) + 1);
            }
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : mh.entrySet()) {
            ans += entry.getValue() * mv.getOrDefault(entry.getKey(), 0);
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
