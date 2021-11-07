import java.io.*;
import java.util.*;
public class dmopc18c1p0 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    public static void main(String[] args) throws IOException {
        int[] arr1 = new int[3];
        int[] arr2 = new int[3];
        for (int i = 0; i < 3; i++) {
            arr1[i] = readInt();
            arr2[i] = arr1[i];
        }
        Arrays.sort(arr2);
        for (int i = 0; i < 3; i++) {
            if (arr1[i] != arr2[i]) {
                System.out.println("Try again!");
                return;
            }
        }
        System.out.println("Good job!");
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
