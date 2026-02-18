import java.util.*;
import java.io.*;
public class ccc22s2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    public static void main(String[] args) throws IOException {
        int tgtc = readInt();
        HashMap<String, ArrayList<String>> tgt = new HashMap<>();
        for (int i = 0; i < tgtc; i++) {
            String a = next(), b = next();
            if (!tgt.containsKey(a)) tgt.put(a, new ArrayList<>());
            tgt.get(a).add(b);
        }
        
        int badc = readInt();
        HashMap<String, ArrayList<String>> bad = new HashMap<>();
        for (int i = 0; i < badc; i++) {
            String a = next(), b = next();
            if (!bad.containsKey(a)) bad.put(a, new ArrayList<>());
            bad.get(a).add(b);
        }
        
        int groupc = readInt(), ans = 0;
        for (int i = 0; i < groupc; i++) {
            String a = next(), b = next(), c = next();
            if (tgt.containsKey(a)) for (String r : tgt.get(a)) {
                if (!b.equals(r) && !c.equals(r)) {
                    ans++;
                }
            }
            if (tgt.containsKey(b)) for (String r : tgt.get(b)) {
                if (!a.equals(r) && !c.equals(r)) {
                    ans++;
                }
            }
            if (tgt.containsKey(c)) for (String r : tgt.get(c)) {
                if (!b.equals(r) && !a.equals(r)) {
                    ans++;
                }
            }
            if (bad.containsKey(a)) for (String r : bad.get(a)) {
                if (b.equals(r) || c.equals(r)) {
                    ans++;
                }
            }
            if (bad.containsKey(b)) for (String r : bad.get(b)) {
                if (a.equals(r) || c.equals(r)) {
                    ans++;
                }
            }
            if (bad.containsKey(c)) for (String r : bad.get(c)) {
                if (b.equals(r) || a.equals(r)) {
                    ans++;
                }
            }
        }
        System.out.println(ans);
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
