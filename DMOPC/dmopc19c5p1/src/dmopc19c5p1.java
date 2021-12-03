import java.io.*;
import java.util.*;
public class dmopc19c5p1 {
  	/* 
	   * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	   * github.com/jdabtieu/competitive-programming
	   */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    public static void main(String[] args) throws IOException {
        int items = readInt(), tasks = readInt();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < items; i++) {
            list.add(readLine());
        }
        int cnt = 0;
        for (int i = 0; i < tasks; i++) {
            int required = readInt();
            boolean found = true;
            for (int j = 0; j < required; j++) {
                if (!list.contains(readLine())) {
                    found = false;
                }
            }
            if (found) cnt++;
        }
        System.out.println(cnt);
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