import java.io.*;
import java.util.*;
public class ccc14j3 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    public static void main(String[] args) throws IOException {
        String x = readLine();
        int[] map2 = new int[127];
        for (int i = 0; i < 127; i++) map2[i] = i+1;
        map2['d'] = 'f';
        map2['h'] = 'j';
        map2['n'] = 'p';
        map2['t'] = 'v';
        map2['z'] = 'z';
        String out = "";
        for (char c : x.toCharArray()) {
            out += c;
            if ("aeiou".indexOf(c) != -1) continue;
            if (c <= ('a' + 'e') / 2) {
                out += 'a';
            } else if (c <= ('e' + 'i') / 2) {
                out += 'e';
            } else if (c <= ('i' + 'o') / 2) {
                out += 'i';
            } else if (c <= ('o' + 'u') / 2) {
                out += 'o';
            } else {
                out += 'u';
            }
            out += (char)map2[c];
        }
        System.out.println(out);
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
