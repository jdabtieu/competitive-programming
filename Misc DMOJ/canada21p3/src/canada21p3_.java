import java.util.*;
import java.io.*;

public class canada21p3_ {
    /* 
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;

    public static void main(String[] args) throws IOException {
        stacki num = new stacki(100000);
        for (int cases = readInt(); cases > 0; cases--) {
            num.ptr = -1;
            String s = readLine();
            
            int keys = readInt();
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int i = 0; i < s.length(); i++) {
                int curr = s.charAt(i) - '0';
                while (keys > 0 && !num.empty() && curr < num.peek()) {
                    pq.add(num.pop());
                    keys--;
                }
                num.push(curr);
            }
            
            while (keys-- > 0 && !num.empty()) {
                pq.add(num.pop());
            }
            
            StringBuilder res = new StringBuilder();
            for (int i = 0; i <= num.ptr; i++) res.append(num.stack[i]);
            while (!pq.isEmpty()) res.append(pq.poll());
            
            System.out.println(res);
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

class stacki {
    int[] stack;
    int ptr;

    public stacki(int maxSize) {
        stack = new int[maxSize];
        ptr = -1;
    }

    public boolean empty() {
        return ptr == -1;
    }

    public int size() {
        return ptr + 1;
    }

    public void push(int x) {
        stack[++ptr] = x;
    }

    public int peek() {
        return stack[ptr];
    }

    public int pop() {
        return stack[ptr--];
    }

    public int get(int index) {
        return stack[ptr - index];
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