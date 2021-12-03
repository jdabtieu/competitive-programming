import java.io.*;
import java.util.*;
public class globexcup18j3 {
  	/* 
	   * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
	   * github.com/jdabtieu/competitive-programming
	   */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    public static void main(String[] args) throws IOException {
        int n = readInt(), cnt = 0;
        for (int i = 0; i < n; i++) {
            int num = readInt();
            int digitSum = 0, copy = num;
            while (copy > 0) {
                digitSum += copy % 10;
                copy /= 10;
            }
            if (check(num) && check(digitSum)) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
    
    static boolean check(int num) {
        if (num < 2) return false;
        for (int j = 2; j <= Math.sqrt(num); j++) {
            if (num % j == 0) {
                return false;
            }
        }
        return true;
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