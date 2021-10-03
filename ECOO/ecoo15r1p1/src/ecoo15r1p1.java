import java.io.*;
import java.util.*;
public class ecoo15r1p1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    public static void main(String[] args) throws IOException {
        for (int cases = 10; cases > 0; cases--) {
            Map<String, Integer> m = new HashMap<>();
            while (true) {
                String s = readLine();
                if (s.equals("end of box")) {
                    int t = 0;
                    for (Map.Entry<String, Integer> entry : m.entrySet()) {
                        if (entry.getKey().equals("red")) {
                            t += 16 * entry.getValue();
                        } else {
                            t += 13 * Math.ceil(entry.getValue() / 7.0);
                        }
                    }
                    System.out.println(t);
                    break;
                }
                m.put(s, m.getOrDefault(s, 0) + 1);
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
