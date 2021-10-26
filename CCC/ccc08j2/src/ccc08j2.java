import java.io.*;
import java.util.*;
public class ccc08j2 {
    /*
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    public static void main(String[] args) throws IOException {
        Deque<Character> d = new LinkedList<>();
        d.add('A');
        d.add('B');
        d.add('C');
        d.add('D');
        d.add('E');
        while (true) {
            int b = readInt(), o = readInt();
            for (int i = 0; i < o; i++) {
                switch(b) {
                case 1:
                    d.addLast(d.pollFirst());
                    break;
                case 2:
                    d.addFirst(d.pollLast());
                    break;
                case 3:
                    char f = d.pollFirst();
                    char c = d.pollFirst();
                    d.addFirst(f);
                    d.addFirst(c);
                    break;
                case 4:
                    for (char e : d) {
                        System.out.print(e + " ");
                    }
                    return;
                }
            }
            
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
