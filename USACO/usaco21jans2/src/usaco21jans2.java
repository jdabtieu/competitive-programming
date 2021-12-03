import java.io.*;
import java.util.*;

public class usaco21jans2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;

    static int[] front, back;
    
    public static void main(String[] args) throws IOException {
        int n = readInt(), q = readInt();
        front = new int[n];
        back = new int[n];
        String s = readLine();
        Stack<Character> stk = new Stack<>();
        stk.push(s.charAt(0));
        front[0] = 1;
        for (int i = 1; i < n; i++) {
             if (stk.empty() || s.charAt(i) > stk.peek()) {
                front[i] = front[i-1] + 1;
                stk.push(s.charAt(i));
            } else if (s.charAt(i) == stk.peek()) {
                front[i] = front[i-1];
            } else if (s.charAt(i) < stk.peek()) {
                while (!stk.isEmpty() && s.charAt(i) < stk.peek()) stk.pop();
                if (stk.isEmpty() || stk.peek() < s.charAt(i)) {
                    stk.push(s.charAt(i));
                    front[i] = front[i-1] + 1;
                } else {
                    front[i] = front[i-1];
                }
            }
        }
        
        stk = new Stack<>();
        stk.push(s.charAt(n-1));
        back[n-1] = 1;
        for (int i = n-2; i >= 0; i--) {
             if (stk.empty() || s.charAt(i) > stk.peek()) {
                 back[i] = back[i+1] + 1;
                stk.push(s.charAt(i));
            } else if (s.charAt(i) == stk.peek()) {
                back[i] = back[i+1];
            } else if (s.charAt(i) < stk.peek()) {
                while (!stk.isEmpty() && s.charAt(i) < stk.peek()) stk.pop();
                if (stk.isEmpty() || stk.peek() < s.charAt(i)) {
                    stk.push(s.charAt(i));
                    back[i] = back[i+1] + 1;
                } else {
                    back[i] = back[i+1];
                }
            }
        }
        
        for (int i = 0; i < q; i++) {
            int a = readInt() - 2, b = readInt();
            if (a == -1 && b == n) System.out.println(0);
            else if (a == -1) System.out.println(back[b]);
            else if (b == n) System.out.println(front[a]);
            else System.out.println(back[b] + front[a]);
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
