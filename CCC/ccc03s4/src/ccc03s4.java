import java.io.*;
import java.util.*;
public class ccc03s4 {
    /*
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    static long m1 = 1125899839733759L, p1 = 7507, m2 = 625768578977L, p2 = 1573927;
    
    public static void main(String[] args) throws IOException {
        for (int cases = readInt(); cases > 0; cases--) {
            String lin = readLine();
            ArrayList<String> suff = new ArrayList<>();
            for (int i = 0; i < lin.length(); i++) suff.add(lin.substring(i));
            Collections.sort(suff);
            int ans = suff.get(0).length();
            for (int i = 1; i < suff.size(); i++) {
                int j = 0;
                for (; j < Math.min(suff.get(i).length(), suff.get(i-1).length()) && suff.get(i).charAt(j) == suff.get(i-1).charAt(j); j++);
                ans += suff.get(i).length() - j;
            }
            System.out.println(ans + 1);
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
