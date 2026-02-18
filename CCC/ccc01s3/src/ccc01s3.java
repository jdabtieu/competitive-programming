import java.io.*;
import java.util.*;
public class _ccc01s3 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    static HashSet<Integer>[] adj = new HashSet[26];
    static boolean[] vis;
    
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 26; i++) adj[i] = new HashSet<>();
        ArrayList<String> paths = new ArrayList<>();
        while (true) {
            String s = readLine();
            if (s.equals("**")) break;
            int one = s.charAt(0) - 'A';
            int two = s.charAt(1) - 'A';
            adj[one].add(two);
            adj[two].add(one);
            paths.add(s);
        }
        
        ArrayList<String> ans = new ArrayList<>();
        for (String s : paths) {
            int one = s.charAt(0) - 'A';
            int two = s.charAt(1) - 'A';
            adj[one].remove(two);
            adj[two].remove(one);
            vis = new boolean[26];
            f(0);
            if (!vis[1]) ans.add(s);
            adj[one].add(two);
            adj[two].add(one);
        }
        for (String s : ans) {
            System.out.println(s);
        }
        System.out.println("There are " + ans.size() + " disconnecting roads.");
    }
    
    static void f(int curr) {
        for (int node : adj[curr]) {
            if (vis[node]) continue;
            vis[node] = true;
            f(node);
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
