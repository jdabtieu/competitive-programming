import java.io.*;
import java.util.*;
public class ccc06s2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    public static void main(String[] args) throws IOException {
        char[] pl = readLine().toCharArray();
        char[] ct = readLine().toCharArray();
        HashMap<Character, Character> m = new HashMap<>();
        for (int i = 0; i < pl.length; i++) {
            m.put(ct[i], pl[i]);
        }
        if (m.size() == 26) {
            char[] set = "QWERTYUIOPASDFGHJKLZXCVBNM ".toCharArray();
            Set<Character> inct = new HashSet<>();
            Set<Character> inpl = new HashSet<>();
            for (char e : set) {
                inct.add(e);
                inpl.add(e);
            }
            for (Map.Entry<Character, Character> e : m.entrySet()) {
                inct.remove(e.getKey());
                inpl.remove(e.getValue());
            }
            m.put(inct.toArray(new Character[0])[0], inpl.toArray(new Character[0])[0]);
        }
        String s = readLine();
        for (char c : s.toCharArray()) {
            if (m.containsKey(c)) {
                System.out.print(m.get(c));
            } else {
                System.out.print('.');
            }
        }
        System.out.println();
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
