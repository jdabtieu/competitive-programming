import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bgoi09p4 {
    /* 
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;

    public static void main(String[] args) throws IOException {
        int n = readInt();
        int[] heights = new int[n];
        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            heights[i] = readInt();
        }
        for (int i = 0; i < n; i++) {
            ans[i] = readInt();
        }
        int[] stack = new int[n];
        int ptr = -1;
        for (int i = 0; i < n; i++) {
            while (ptr >= 0 && stack[ptr] <= heights[i]) ptr--;
            
            if (ans[n-i-1] == 0) {
                ans[n-i-1] = heights[i];
            } else if (ans[n-i-1] <= (ptr+1)) {
                ans[n-i-1] = stack[ptr+1-ans[n-i-1]];
            } else {
                ans[n-i-1] = -1;
            }
            
            stack[++ptr] = heights[i];
        }
        for (int a : ans) System.out.print(a + " ");
    }

    static String next() throws IOException {
        while (in == null || !in.hasMoreTokens())
            in = new StringTokenizer(br.readLine());
        return in.nextToken();
    }

    static long readLong() throws IOException {
        return Long.parseLong(next());
    }
    
    static int readInt() throws IOException{
        int x = 0, c;
        while((c = br.read()) != ' ' && c != '\n')
            x = x * 10 + (c - '0');
        return x;
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
