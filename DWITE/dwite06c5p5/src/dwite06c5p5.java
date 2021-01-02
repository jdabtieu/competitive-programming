import java.util.*;
import java.io.*;

public class dwite06c5p5 {
    /* 
     * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
     * github.com/jdabtieu/competitive-programming
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    static int[] count = new int[1000000];
    
    static void sieve(int ceiling) {
        boolean[] primality = new boolean[1000000];
        
        //Set initial primality
        primality[0] = true;
        primality[1] = true;
        
        //Only need to check up to sqrt(int)
        int sr = (int) Math.sqrt(ceiling);
        //Populate primeNumbers and factors if i is prime
        for (int i = 2; i <= sr; i++) {
            count[i] = count[i - 1];
            if (!primality[i]) {
                if (palindrome(i)) count[i]++;
                for (int j = i * i; j < ceiling; j += i) primality[j] = true;
            }
        }
        //Add remaining primes
        for (int i = sr + 1; i < ceiling; i++) {
            count[i] = count[i - 1];
            if (!primality[i] && palindrome(i)) {
                count[i]++;
            }
        }
        
        //System.out.println(primeNumbers.size());
    }
    
    static boolean palindrome(int num) {
        int x = 0;
        int y = num;
        while (y > 0) {
            x *= 10;
            x += y % 10;
            y /= 10;
        }
        return x == num;
    }

    public static void main(String[] args) throws IOException {
        sieve(1000000);
        for (int cases = 5; cases > 0; cases--) {
            int floor = readInt(), ceil = readInt();
            System.out.println(count[ceil] - count[floor - 1]);
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