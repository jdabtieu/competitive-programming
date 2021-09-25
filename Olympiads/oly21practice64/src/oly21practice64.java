import java.io.*;
import java.util.*;
public class oly21practice64 {
    /*
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    final static long MOD = (int) 1e9 + 7;
    static long ans = 0;
    
    public static void main(String[] args) throws IOException {
        int n = readInt();
        stacki stack = new stacki(n);
        int[] heights = new int[n], widths = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = readInt(); 
        }
        for (int i = 0; i < n; i++) {
            widths[i] = readInt(); 
        }
        stack.push(new pair(heights[0], widths[0]));
        for (int i = 1; i < n; i++) {
            long tmp = 0;
            while (!stack.empty() && stack.peek().h >= heights[i]) {
                pair prev = stack.pop();
                tmp = (tmp + prev.w) % MOD;
                ans += calc(tmp, prev.h) - calc(tmp, stack.empty() ? heights[i] : Math.max(stack.peek().h, heights[i])) + MOD;
                ans %= MOD;
            }
            stack.push(new pair(heights[i], (tmp + widths[i]) % MOD));
        }
        while (stack.size() > 1) {
            pair curr = stack.pop();
            ans += calc(curr.w, curr.h) - calc(curr.w, stack.peek().h) + MOD;
            ans %= MOD;
            stack.peek().w += curr.w;
            stack.peek().w %= MOD;
        }
        ans += calc(stack.peek().w, stack.peek().h);
        System.out.println(ans % MOD);
    }
    
    static long calc(long w, long h) {
        return ((w * (w + 1) / 2 % MOD) * (h * (h + 1) / 2 % MOD)) % MOD;
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

class stacki {
    pair[] stack;
    int ptr;

    public stacki(int maxSize) {
        stack = new pair[maxSize];
        ptr = -1;
    }

    public boolean empty() {
        return ptr == -1;
    }

    public int size() {
        return ptr + 1;
    }

    public void push(pair x) {
        stack[++ptr] = x;
    }

    public pair peek() {
        return stack[ptr];
    }

    public pair pop() {
        return stack[ptr--];
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("[");
        for (int i = 0; i < ptr; i++) {
            res.append(stack[i]);
            res.append(", ");
        }
        if (ptr >= 0) {
            res.append(stack[ptr]);
        }
        return res.append("]").toString();
    }
}

class pair {
    long w, h;
    public pair(long h, long w) {
        this.w = w;
        this.h = h;
    }
    public String toString() {
        return String.format("(%d, %d)", w, h);
    }
}