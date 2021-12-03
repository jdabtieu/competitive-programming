import java.io.*;
import java.util.*;
public class coci18c4p1 {
	/* 
	 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	 * github.com/jdabtieu/competitive-programming
	 */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    public static void main(String[] args) throws IOException {
        char owner = readChar();
        int n = readInt();
        // how do we create an arraylist of chars?
        ArrayList<Character> list = new ArrayList<>();
        list.add(owner);
        for (int i = 0; i < n; i++) {
            char winner = readChar(), loser = readChar();
            if (loser == owner) {
                owner = winner;
                // how can we check if list contains winner?
                if (!list.contains(winner)) {
                    list.add(winner);
                }
            }
        }
        System.out.println(owner);
        // array: list.length
        // how can we print the size of the list?
        System.out.println(list.size());
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