import java.io.*;
import java.util.*;
public class dmopc17c3p0 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    public static void main(String[] args) throws IOException {
        //double money = readInt() / 2.0;
        //System.out.printf("$%.2f $%.2f\n", money, money);
        
        int money = readInt();
        if (money % 2 == 0) {
            System.out.println("$" + (money / 2) + ".00 $" + (money / 2) + ".00");
        } else {
            System.out.println("$" + (money / 2) + ".50 $" + (money / 2) + ".50");
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
