import java.util.*;
import java.io.*;

public class ecoo20p4 {
    /* 
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;

    static final int MMOD = 1000000007;
    
    static Stack<Pair> stack = new Stack<>();
    static Stack<String> stack2 = new Stack<>();
    static HashMap<String, Pair> fun = new HashMap();

    public static void main(String[] args) throws IOException {
        for (int cases = readInt(); cases > 0; cases--) {
            int n = readInt();
            String funcName = "?";
            long m = 1, b = 0;
            for (int i = 0; i < n; i++) {
                String[] inst = readLine().split(" ");
                switch(inst[0]) {
                case "ADD":
                    b = (b + Long.parseLong(inst[1]) + MMOD) % MMOD;
                    break;
                case "SUB":
                    b = (b - Long.parseLong(inst[1]) + MMOD) % MMOD;
                    break;
                case "MULT":
                    b = (b * Long.parseLong(inst[1])) % MMOD;
                    m = (m * Long.parseLong(inst[1])) % MMOD;
                    break;
                case "FUN":
                    stack.push(new Pair(m, b));
                    stack2.push(funcName);
                    m = 1;
                    b = 0;
                    funcName = inst[1];
                    break;
                case "END":
                    fun.put(funcName, new Pair(m, b));
                    funcName = stack2.pop();
                    {
                        Pair tmp = stack.pop();
                        m = tmp.m;
                        b = tmp.b;
                    }
                    break;
                case "CALL":
                    {
                        Pair tmp = fun.get(inst[1]);
                        m = (m * tmp.m) % MMOD;
                        b = ((b * tmp.m) % MMOD + tmp.b) % MMOD; 
                    }
                    break;
                }
            }
            System.out.println(b % MMOD);
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

class Pair {
    long m, b;
    public Pair(long m, long b) {
        this.m = m;
        this.b = b;
    }
    
    public String toString() {
        return String.format("(m=%d, b=%d)", m, b);
    }
}